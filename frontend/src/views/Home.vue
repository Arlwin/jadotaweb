<template>
  <v-container class="pa-7">
    <v-col 
      cols="8"
    >
      <v-text-field
        clearable
        solo
        prepend-inner-icon="mdi-magnify"
        label="Search..."
      />
      <v-tabs
        v-model="tab_model"
      >
        <v-tab 
          v-for='tab in tabs'
          :key='tab.name'
          :href='`#${tab.name}`'
        >{{ tab.label }}</v-tab>
      </v-tabs>

      <v-card
        class="mt-5"
      >
        <v-tabs-items
          v-model="tab_model"
        >
          <v-tab-item
            v-for='tab in tabs'
            :key='tab.name'
            :value='tab.name'
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
          </v-tab-item>
        </v-tabs-items>
      </v-card>
    </v-col>
    <v-col cols="4"></v-col>
    
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