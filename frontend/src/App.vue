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
        <v-btn text v-ripple="false" :to="{ name: 'Home' }" id = "logo">
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

      <v-btn text>
        <span class="px-3">Sign-In</span>
      </v-btn>
    </v-app-bar>

    <v-main>
      <v-container>
        <!-- <Home/> -->
        <router-view />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
// import Home from './views/Home.vue';

export default {
  name: 'App',

  components: {
    // Home,
  },

  data: () => ({
    //
  }),
};
</script>

<style scoped>
#logo::before {
  display: none !important;
}

</style>
