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
        >
          <v-text-field 
            v-for="field in showFormFields"
            :key="field.name"
            dense 
            outlined 
            :label="field.label"
            v-model="field.value"
            :type="field.type"
            required
          />
          
          <v-row class="d-flex flex-row justify-space-between align-center mb-3 px-4">
            <span class="text-caption">{{ dialogText.subtext1 }} <a @click="() => {this.signUpState = !this.signUpState}">{{ dialogText.subtext2 }}</a></span>
            <v-btn text v-ripple="false" @click="signUpUser">{{ dialogText.header }}</v-btn>
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
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'SignInDialog',
  props: {
    value: Boolean,
  },
  data: () => ({

    signUpState: false,
    signUp: {

      header: "Sign Up",
      subtext1: "Already have an account? ",
      subtext2: "Sign in instead "
    },
    signIn: {

      header: "Sign In",
      subtext1: "Don't have an account yet? ",
      subtext2: "Sign up instead "
    },
    form: {
      valid: true,
      fields: [
        {
          type: 'email',
          name: 'email',
          value: '',
          label: 'Email',
          signUpOnly: false,
        },
        {
          type: 'text',
          name: 'username',
          value: '',
          label: 'Username',
          signUpOnly: true,
        },
        {
          type: 'password',
          name: 'password',
          value: '',
          label: 'Password',
          signUpOnly: false,
        },
        {
          type: 'password',
          name: 'confirmPassword',
          value: '',
          label: 'Confirm Password',
          signUpOnly: true,
        },
      ],
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
    ]
  }),
  computed: {
    show: {
      get () {
        return this.value
      },
      set (value) {
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
    showFormFields: function () {

      return this.form.fields.filter(
        (field) => {

          if (field.signUpOnly) return this.showSignUp;
          return true;
        }
      );
    }
  },
  methods: {
    signUpUser() {

      // console.log(this.$refs.form.validate());

      
    },
  },
}
</script>

<style>
.no-hover::before {
  display: none !important;
}

</style>