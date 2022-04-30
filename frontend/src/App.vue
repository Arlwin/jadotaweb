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

      <v-app-bar-title >
        <span class="text-h5">J</span>
        <span class="text-overline">ust </span>
        <span class="text-h5">A</span>
        <span class="text-overline">nother </span>
        <span class="text-h5 font-weight-bold red--text text--lighten-2">DOTA </span>
        <span class="text-h5">W</span>
        <span class="text-overline">ebsite</span>
      </v-app-bar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon class="px-3">mdi-magnify</v-icon>
      </v-btn>
      <v-btn text>
        <span class="px-3">Sign-In</span>
      </v-btn>
    </v-app-bar>

    <v-main class="px-7">
      <HomeView/>
      <!-- <span class="text-h1">J</span> -->
    </v-main>
  </v-app>
</template>

<script>
import HomeView from './components/views/HomeView.vue';

export default {
  name: 'App',

  components: {
    HomeView,
  },

  data: () => ({
    //
  }),
};
</script>
