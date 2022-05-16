<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dense
      flat
      dark
      class="px-7"
    >

      <v-app-bar-title>
        <v-btn text v-ripple="false" :to="{ name: 'Home' }" class="no-hover">
          <span class="text-h5">J</span>
          <span class="text-overline">ust </span>
          <span class="text-h5">A</span>
          <span class="text-overline">nother </span>
          <span class="text-h5 font-weight-bold red--text text--lighten-2">DOTA </span>
          <span class="text-h5">W</span>
          <span class="text-overline">ebsite</span>
        </v-btn>
      </v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn v-if="isUserLoggedIn" text >{{ currentUser.username }}</v-btn>
      <v-btn v-else text @click.stop="signInDialog = true" v-ripple="false" class="no-hover">
        <span class="px-3">Sign-In</span>
      </v-btn>
    </v-app-bar>

    <v-main>
      <v-container>
        <router-view />
      </v-container>
    </v-main>

    <SignInDialog v-model="signInDialog" />
  </v-app>
</template>

<script>
import { mapState } from 'pinia'

import { userStore } from '@/stores/UserStore'
import SignInDialog from './components/auth/SignInDialog.vue';

export default {
  name: 'App',
  components: {
    SignInDialog,
  },
  data: () => ({
    signInDialog: false,
  }),
  computed: {
    ...mapState(userStore, ['currentUser', 'isUserLoggedIn']),
  },
};
</script>

<style scoped>
.no-hover::before {
  display: none !important;
}

</style>
