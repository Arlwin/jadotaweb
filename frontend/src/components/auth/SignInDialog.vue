<template>
  <v-dialog 
    v-model="show"
    max-width="25vw"
  >
    <v-card
      class="d-flex flex-column"
    >
      <v-card-title class="text-h5">
        {{ dialogText.header }}
      </v-card-title>

      <v-card-text class="py-3">
        <v-form 
          v-model="form.valid"
          ref="form"
          lazy-validation
        >
          <v-text-field
            :key="form.fields.email.name"
            dense 
            outlined 
            :label="form.fields.email.label"
            v-model="form.fields.email.value"
            :type="form.fields.email.type"
            :rules="form.fields.email.rules"
          />

          <v-text-field 
            v-if="showSignUp"
            :key="form.fields.username.name"
            dense 
            outlined 
            :label="form.fields.username.label"
            v-model="form.fields.username.value"
            :type="form.fields.username.type"
            :rules="form.fields.username.rules"
            :counter="form.fields.username.max"
          />
          
          <v-text-field 
            :key="form.fields.password.name"
            dense 
            outlined 
            :label="form.fields.password.label"
            v-model="form.fields.password.value"
            :type="form.fields.password.show ? 'text' : 'password'"
            :rules="form.fields.password.rules"
            :append-icon="form.fields.password.show ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="form.fields.password.show = !form.fields.password.show"
          />
          
          <v-text-field 
            v-if="showSignUp"
            :key="form.fields.confirmPassword.name"
            dense 
            outlined 
            :label="form.fields.confirmPassword.label"
            v-model="form.fields.confirmPassword.value"
            :type="form.fields.confirmPassword.show ? 'text' : 'password'"
            :rules="form.fields.confirmPassword.rules"
            :append-icon="form.fields.confirmPassword.show ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="form.fields.confirmPassword.show = !form.fields.confirmPassword.show"
          />

          <v-row v-if="!showSignUp && signInIncorrect" class="d-flex flex-row justify-center align-center px-4">
            <span class="red--text text--darken-3">{{ signIn.incorrect }}</span>
          </v-row>

          <v-row v-if="showSignUp && signUpInvalid" class="d-flex flex-row justify-center align-center px-4">
            <span class="red--text text--darken-3">{{ signUp.invalid }}</span>
          </v-row>
          
          <v-row class="d-flex flex-row justify-space-between align-center mb-3 px-4">
            <span class="text-caption">{{ dialogText.subtext1 }} <a @click="() => {this.signUpState = !this.signUpState}">{{ dialogText.subtext2 }}</a></span>
            <v-btn text v-ripple="false" @click="formSubmit" :disabled="!formValid">{{ dialogText.header }}</v-btn>
          </v-row>
        </v-form>

        <v-row class="align-center my-3">
          <v-divider />
          <span class="mx-2"> or </span>
          <v-divider />
        </v-row>
        
        <div class="d-flex flex-column align-center">
          <v-card
            outlined
            class = "my-3"
            width = "70%"
            v-for="provider in providers"
            :key="provider.text"
            :to="provider.target"
          >
            <v-list-item>
              <v-list-item-icon>
                <v-icon>{{ provider.icon }}</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>{{ provider.text }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-card>
        </div>
      </v-card-text>
      <v-progress-linear indeterminate v-if="loading"/>
    </v-card>

    <SignInDialogConfirmation v-model="signInDialogConfirmation" @close="confirmClose" />
  </v-dialog>
</template>

<script>
import {getAuth, signInWithEmailAndPassword} from 'firebase/auth';
import { mapActions } from 'pinia'

import { userStore } from '@/stores/UserStore'

import SignInDialogConfirmation from './SignInDialogConfirmation.vue';

export default {
  name: 'SignInDialog',
  components: {
    SignInDialogConfirmation,
  },
  props: {
    value: Boolean,
    signUpState:  {
      type: Boolean,
      default: false
    },
  },
  data: function() {

    var maxUsernameCount = 16;
  
    return {

      signUp: {

        header: "Sign Up",
        subtext1: "Already have an account? ",
        subtext2: "Sign in instead ",
        isInvalid: false,
        invalid: "",
      },
      signIn: {

        header: "Sign In",
        subtext1: "Don't have an account yet? ",
        subtext2: "Sign up instead ",
        incorrect: "Email / Password is incorrect",
        isIncorrect: false,
      },
      form: {
        valid: true,
        fields: {
          email: {
            type: 'email',
            name: 'email',
            value: '',
            label: 'Email',
            rules: [
              v => !!v || 'E-mail is required',
              v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
            ]
          },
          username: {
            type: 'text',
            name: 'username',
            value: '',
            label: 'Username',
            max: maxUsernameCount,
            rules: [
              v => !!v || 'Username is required',
              v => (v && v.length <= maxUsernameCount) || 'Username must be less than 16 characters',
            ]
          },
          password: {
            type: 'password',
            name: 'password',
            value: '',
            label: 'Password',
            show: false,
            rules: [
              v => !!v || 'Password is required',
              v => (v && v.length >= 8) || 'Password must be at least 8 characters',
            ]
          },
          confirmPassword: {
            type: 'password',
            name: 'confirmPassword',
            value: '',
            label: 'Confirm Password',
            show: false,
            rules: [
              v => !!v || 'Please re-enter your Password',
              this.passwordsMatch,
            ]
          },
        },
      },
      providers: [
        {
          icon: "mdi-steam",
          text: "Sign In with Steam",
          target: "test",
        },
        {
          icon: "mdi-google",
          text: "Sign In with Google",
          target: "test",
        },
      ],
      signInDialogConfirmation: false,
      loading: false,
    }
  },
  computed: {
    show: {
      get () {
        return this.value
      },
      set (value) {
        this.signIn.isIncorrect = false;
        this.$emit('input', value)
      }
    },
    showSignUp: function () {

      return this.signUpState;
    },
    dialogText: function () {

      if (this.signUpState) return this.signUp;
      return this.signIn;
    },
    getPassword: function () {

      if (!this.form.fields.password) return ""
      return this.form.fields.password.value;
    },
    formValid: function () {

      return this.form.valid;
    },
    signInIncorrect: function () {

      return this.signIn.isIncorrect;
    },
    signUpInvalid: function () {

      return this.signUp.isInvalid;
    },
    signUpInvalidMessage: function () {

      return this.signUp.invalid;
    },
  },
  methods: {
    ...mapActions(userStore, { saveUserState: 'login' }),
    formSubmit() {

      if (!this.form.valid) return;

      this.loading = true;

      if (this.signUpState) this.signUpUser();
      else this.signInUser();

    },
    async signUpUser() {

      var user = {

        'email': this.form.fields['email'].value,
        'username': this.form.fields['username'].value,
        'password': this.form.fields['password'].value
      }

      try {

        await this.$http
          .post(
            '/users/signup', 
            user
          )
          .then(response => response);
      } catch (e) {

        if (e['code'] == "ERR_BAD_REQUEST") {

          this.signUp.isInvalid = true;
          this.signUp.invalid = e['response']['data']['message'];
          this.loading = false;
        }
        
        return;
      }

      await this.authenticateUser(user.email, user.password);
      this.$emit('refresh');

      return;
    },
    async signInUser() {

      if (await this.authenticateUser(this.form.fields['email'].value, this.form.fields['password'].value)) {
        
        this.show = false;
        this.signIn.isIncorrect = false;
        this.$emit('refresh');
      } else {

        this.signIn.isIncorrect = true;
      }

      this.loading = false;
    },
    async authenticateUser(email, password) {

      try {

        var token = await signInWithEmailAndPassword(
          getAuth(),
          email, 
          password
          )
          .then(
            userResult => {
              return userResult.user.getIdToken()
            }
          )
          .then(idToken => idToken)

        // Send JWT to Spring
        var userRes = await this.$http
          .get(
            '/users/login',
            {
              headers: {
                'Authorization': `Bearer ${token}` 
              }
            }
          );

        var userDetails = userRes['data']['user'];
        this.saveUserState(userDetails['id'], userDetails['username']);

        return true;
      } catch (e) {

        return false;
      }
    },
    passwordsMatch(v) {

      if (v && v == this.getPassword) return true;
      return "Password does not match";
    },
    confirmClose(){

      this.show = false;
      this.$emit('refresh');
    },
  },
}
</script>

<style>
.no-hover::before {
  display: none !important;
}

</style>