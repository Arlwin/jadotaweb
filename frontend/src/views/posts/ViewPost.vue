<template>
  <v-container class="pa-7 mx-auto" fluid>

    <v-btn 
      text 
      plain
      @click="$router.go(-1)"
    >
      <v-icon>mdi-arrow-left-thin</v-icon> 
      Back to Home
    </v-btn><br>

    <div v-if="data_loading">
      <v-skeleton-loader
        class="mx-auto"
        type="list-item-avatar-two-line, image, article"
      ></v-skeleton-loader>
    </div>

    <div
      v-if="!data_loading && post"
    > 
      <!-- Post -->
      <v-card>
        <v-list-item three-line>
          <v-list-item-content>
            <v-list-item-title class="text-h4">{{ this.post.title }}</v-list-item-title>
            <v-list-item-subtitle class="text-subtitle-2">{{ this.post.user.username }}</v-list-item-subtitle>
            <v-list-item-subtitle class="text-overline">{{ this.format_date(this.post.submitDate) }}</v-list-item-subtitle>
          </v-list-item-content>

          <v-list-item-action>
            <v-col> 
              <v-row>
                <v-btn icon>
                  <v-icon color="grey lighten-1">mdi-thumb-up-outline</v-icon>
                </v-btn>
              </v-row>
              <v-row justify="center">
                <span class="text-caption">{{ this.post.likes }}</span>
              </v-row>
            </v-col>
          </v-list-item-action>
        </v-list-item>

        <v-img :src="this.post.coverImgUrl" class="mx-4"></v-img>
        
        <v-card-text>
          <span v-html="this.post.text"></span>
        </v-card-text>
      </v-card>

      <v-card height="100px" flat color="transparent"></v-card>

      <!-- Comments -->
      <v-card
        class = "pa-3"
      >

        <v-card-title>Comments ({{ this.post_comments.length }})</v-card-title>

        <v-card
          v-for="comment in post_comments"
          :key="comment.id"
          class = "px-2 my-3"
          outlined
        >
          <v-list-item two-line>
            <v-list-item-content>
              <v-list-item-title class="text-subtitle-2">{{ comment.username }}</v-list-item-title>
              <v-list-item-subtitle class="text-overline">{{ comment.submitDate }}</v-list-item-subtitle>
            </v-list-item-content>
            <v-list-item-action>
              <v-col> 
                <v-row>
                  <v-btn icon>
                    <v-icon color="grey lighten-1">mdi-thumb-up-outline</v-icon>
                  </v-btn>
                </v-row>
                <v-row justify="center">
                  <span class="text-caption">{{ comment.likes }}</span>
                </v-row>
              </v-col>
            </v-list-item-action>
          </v-list-item>

          <v-card-text>
            {{ comment.comment }}
          </v-card-text>

        </v-card>
      </v-card>
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
        post_comments: [ // TEMP
          {
            id: "commentid",
            username: "test_user",
            submitDate: "May 04, 2022",
            likes: 5,
            comment: "b;ah blach dask djlsad"
          },
          {
            id: "commentids",
            username: "test_user",
            submitDate: "May 04, 2022",
            likes: 5,
            comment: "b;ah blach dask djlsad"
          },
        ]
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
        .get(`/posts/${this.$route.params.post_id}`)
        .then((response) => {

          this.data_loading = false;
          this.post_data = response.data;

          console.log(this.post_data);
        });
    }
  },
  created () {
    this.fetch_data();
  }
}
</script>

<style scoped>

#spacing {

  height: 100px !important;
}

</style>