<template>
  <v-container class="pa-7" fluid>
    <div v-if="data_loading">
      <v-skeleton-loader
        class="mx-auto"
        type="list-item-avatar-two-line, image, article"
      ></v-skeleton-loader>
    </div>

    <div v-if="!data_loading && post">
      <h1>{{ this.$route.params.post_id }}</h1>
      <h2>{{ this.post.data }} </h2>
    </div>
  </v-container>
</template>

<script>
export default {
  name: 'ViewPost',
  data() {
    return {
        data_loading: false,
        post_data: null,
    }
  },
  computed: {
    post: function () {
     return this.post_data;
    }
  },
  methods: {
    fetch_data() {

      this.data_loading = true;

      this.$http
        .get('/posts/K03mIPWsPTABOf7vvnuY')
        .then((response) => {

          this.data_loading = false;
          this.post_data = response.data;
        });
    }
  },
  created () {
    this.fetch_data();
  }
}
</script>