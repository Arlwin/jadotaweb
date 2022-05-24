<template>
  <v-container>
    <v-row>
      <v-col cols="8">

        <v-card
          class = "my-5 pa-2 d-flex align-center"
        >
          <v-btn
            text
          >
          New Post
          </v-btn>
          <v-text-field
            hide-details
            outlined
            clearable
            solo
            prepend-inner-icon="mdi-magnify"
            label="Search..."
          />
        </v-card>
        
        <v-card
          class="pa-2"
        >
          <v-skeleton-loader
            v-if="feed_data_loading"
            class="mx-auto"
            type="list-item-avatar-two-line, image, article"
          ></v-skeleton-loader>

          <v-card
            class="pa-2 ma-2"
            flat
            tile
            outlined
            v-for="data in feed_posts"
            :key="data.id"
            :ripple="false"
            :to="{ name: 'ViewPost', params: { post_id: data.id } }" 
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-list-item-title class="text-h5">{{ data.title }}</v-list-item-title>
                <v-spacer/><v-spacer/>
                <v-list-item-subtitle class="text-caption">{{ data.submitDate }}</v-list-item-subtitle>
                <v-spacer/>
                <v-list-item-subtitle class="text-caption">{{ data.posted_by }}</v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-action>
                <v-col> 
                  <v-row>
                    <v-btn icon>
                      <v-icon color="grey lighten-1">mdi-thumb-up-outline</v-icon>
                    </v-btn>
                  </v-row>
                  <v-row justify="center">
                    <span class="text-caption">{{ data.likes }}</span>
                  </v-row>
                </v-col>
              </v-list-item-action>
            </v-list-item>

            <v-img 
              class="mx-4"
              :src="data.coverImgUrl"
              v-if="data.coverImgUrl"
            ></v-img>

            <v-card-text v-html="data.text" />
          </v-card>
        </v-card>
      </v-col>

      <v-col>
        <v-row>
          <v-col>
            <v-skeleton-loader
              type="list-item-two-line, image, article"
            ></v-skeleton-loader>
          </v-col>
        </v-row>
        <v-row>
          <v-col>
            <v-skeleton-loader
              type="list-item-three-line, list-item, article"
            ></v-skeleton-loader>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
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