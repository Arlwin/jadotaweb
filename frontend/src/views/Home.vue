<template>
  <v-card 
    class="pa-5"
  >
    <v-skeleton-loader
      v-if="feed_data_loading"
      type="list-item-avatar-two-line, image, article"
    ></v-skeleton-loader>
    <div v-else>
      <SubmissionSummary
        class="mb-12"
        v-for="data in feed_data"
        :key="data['id']"
        :name="data['name']"
        :cover_image_url="data['cover_image_url']"
        :description="data['description']"
        :skills="data['skills']"
        :likes="data['likes']"
      />
    </div>
  </v-card>
</template>

<script>
import SubmissionSummary from '@/components/feed/SubmissionSummary.vue';

export default {
  name: 'Home',
  components: {
    SubmissionSummary,
  },
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
      feed_data: [
        { 
          id: "test-id",
          name: "Strong Man",
          cover_image_url: "https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-preview.jpg",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue. Donec cursus nulla id semper efficitur. Integer sed dapibus sem. Fusce dictum vulputate erat, vitae aliquam arcu iaculis vel. Suspendisse faucibus tellus nisi, id facilisis ex pulvinar in. Pellentesque augue magna, pellentesque a sodales ut, aliquam at sapien. Nunc at viverra leo. Sed sollicitudin euismod ligula sed accumsan. Maecenas laoreet convallis metus ut tristique. Nullam quis turpis dignissim, laoreet ligula sit amet, finibus neque. Curabitur auctor ipsum in metus efficitur dignissim. Cras aliquam pretium eleifend. In hac habitasse platea dictumst.",
          likes: 129012,
          skills: [
            {
              number: 1,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Crusher",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 2,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Kill",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 3,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Armor Time",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 4,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Now that you're gone",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
          ]
        },
        { 
          id: "test-id",
          name: "Strong Man",
          cover_image_url: "https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-preview.jpg",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue. Donec cursus nulla id semper efficitur. Integer sed dapibus sem. Fusce dictum vulputate erat, vitae aliquam arcu iaculis vel. Suspendisse faucibus tellus nisi, id facilisis ex pulvinar in. Pellentesque augue magna, pellentesque a sodales ut, aliquam at sapien. Nunc at viverra leo. Sed sollicitudin euismod ligula sed accumsan. Maecenas laoreet convallis metus ut tristique. Nullam quis turpis dignissim, laoreet ligula sit amet, finibus neque. Curabitur auctor ipsum in metus efficitur dignissim. Cras aliquam pretium eleifend. In hac habitasse platea dictumst.",
          likes: 129012,
          skills: [
            {
              number: 1,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Crusher",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 2,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Kill",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 3,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Armor Time",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 4,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Now that you're gone",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
          ]
        },
        { 
          id: "test-id",
          name: "Strong Man",
          cover_image_url: "https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-preview.jpg",
          description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue. Donec cursus nulla id semper efficitur. Integer sed dapibus sem. Fusce dictum vulputate erat, vitae aliquam arcu iaculis vel. Suspendisse faucibus tellus nisi, id facilisis ex pulvinar in. Pellentesque augue magna, pellentesque a sodales ut, aliquam at sapien. Nunc at viverra leo. Sed sollicitudin euismod ligula sed accumsan. Maecenas laoreet convallis metus ut tristique. Nullam quis turpis dignissim, laoreet ligula sit amet, finibus neque. Curabitur auctor ipsum in metus efficitur dignissim. Cras aliquam pretium eleifend. In hac habitasse platea dictumst.",
          likes: 129012,
          skills: [
            {
              number: 1,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Crusher",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 2,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Kill",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 3,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Armor Time",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
            {
              number: 4,
              icon: "https://pbs.twimg.com/profile_images/1385640508710604802/jFJpq7Wu_400x400.jpg",
              name: "Now that you're gone",
              description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin luctus, sem non facilisis venenatis, mi nisi rutrum lacus, vitae rhoncus ex velit quis augue."
            },
          ]
        },
      ]
    }
  },
  computed: {
    feed_posts: function () {
     return this.feed_data;
    }
  },
  methods: {
    // fetch_feed_data() {

    //   this.feed_data_loading = true;

    //   this.$http
    //     .get('/posts')
    //     .then((response) => {

    //       this.feed_data_loading = false;
    //       this.feed_data = response.data;
    //     });
    // }
  },
  created () {
    // this.fetch_feed_data();
  }
}
</script>

<style scoped>
.v-ripple__container {
    display:none !important;
}
</style>