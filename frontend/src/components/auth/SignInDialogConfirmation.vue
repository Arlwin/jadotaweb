<template>
    <v-dialog 
      v-model="show"
      max-width="25vw"
    >
    <v-card
      class="d-flex flex-column pa-3"
    >
      <v-card-title class="text-h5">
        Sign Up Successful
      </v-card-title>

      <v-card-text class="py-2">
        Your account was successfully created. Click OK to login with your current account details.
      </v-card-text>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn text @click="close">OK</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'SignInDialogConfirmation',
  props: {
    value: Boolean,
  },
  computed: {
    show: {
      get () {
        return this.value
      },
      set (value) {
        this.$emit('input', value)
      }
    }
  },
  methods: {
    close() {

      this.show = false;
      this.$emit('close');
    },
  }
}
</script>

<style>

</style>