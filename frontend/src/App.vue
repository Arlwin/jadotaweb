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
                            <SideBar class="fixed"/>
                        </v-col>
                        <v-col
                            class="overflow" 
                            cols = 9
                        >
                            <router-view />
                        </v-col>
                    </v-row>
                </v-container>
            </v-main>
    </v-app>
</template>

<script>
import NavBar from './components/NavBar.vue';
import SideBar from './components/SideBar.vue';

export default {
  name: 'App',
  components: {
    NavBar,
    SideBar,
  },
  data: () => ({
    signInDialog: false,
  }),
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

.fixed {

    position: fixed !important;
    left: 75px;
    width: 22vw;
}

.no-hover::before {
  display: none !important;
}
</style>
