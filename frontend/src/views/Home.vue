<template>
  <v-card
    class="red"
  >

  </v-card>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      tab_model: 'feed',
      tabs: [
        {
          name: 'feed',
          label: 'Feed'
        },
        {
          name: 'friends',
          label: 'Friends'
        },
      ],

      // Feed
      feed_data_loading: false,
      feed_data: []
    }
  },
  computed: {
    feed_posts: function () {
     return this.feed_data;
    }
  },
  methods: {
    fetch_feed_data() {

      this.feed_data_loading = true;

      this.$http
        .get('/posts')
        .then((response) => {

          this.feed_data_loading = false;
          this.feed_data = response.data;
        });
    }
  },
  created () {
    this.fetch_feed_data();
  }
}
</script>

<style scoped>
.v-ripple__container {
    display:none !important;
}
</style>