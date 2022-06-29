<template>
    <v-app>
        <NavBar/>
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
