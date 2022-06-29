<template>
    <v-app>
        <NavBar/>

    <!-- <v-app-bar
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

      <v-btn v-if="isUserLoggedIn" 
        text 
        v-ripple="false" 
        class="no-hover" 
        @click.stop="logout"
      >
        <span class="px-3">{{ currentUser['username'] }}</span>
      </v-btn>
      <v-btn v-else 
        text 
        @click.stop="signInDialog = true" 
        v-ripple="false" 
        class="no-hover" 
      >
        <span class="px-3">Sign-In</span>
      </v-btn>
    </v-app-bar> -->

            <v-main>
                <v-container
                    class="mx-2 px-16 my-6 py-12"
                    fluid
                >
                    <v-row>
                        <v-col 
                            class="d-flex justify-center"
                            cols = 3
                        >
                            <SideBar/>
                        </v-col>
                        <v-col cols = 9>
                            <!-- <router-view /> -->
                            <v-card
                            >
                                <v-skeleton-loader
                                    v-if="feed_data_loading"
                                    class="mx-auto"
                                    type="list-item-avatar-two-line, image, article"
                                ></v-skeleton-loader>
                            </v-card>  
                        </v-col>
                    </v-row>
                </v-container>
            </v-main>
        <SignInDialog v-model="signInDialog" @refresh="refresh"/>
    </v-app>
</template>

<script>
import { mapState } from 'pinia'

import { userStore } from '@/stores/UserStore'
import SignInDialog from './components/auth/SignInDialog.vue';
import NavBar from './components/NavBar.vue';
import SideBar from './components/SideBar.vue';

export default {
  name: 'App',
  components: {
    SignInDialog,
    NavBar,
    SideBar,
  },
  data: () => ({
    signInDialog: false,
  }),
  computed: {
    ...mapState(userStore, ['currentUser', 'isUserLoggedIn']),
  },
  methods: {
    refresh() {

      location.reload();
    },
    logout() { // TEMP

      localStorage.clear();
      location.reload();
    },
  },
};
</script>

<style scoped>
.no-hover::before {
  display: none !important;
}

</style>
