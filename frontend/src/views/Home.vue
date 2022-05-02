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
            <v-card
              class="pa-2 ma-2"
              flat
              tile
              outlined
              v-for="data in feed_data"
              :key="data.title"
              :ripple="false"
              :to="`/posts/${data.name}`" 
            >
              <v-list-item three-line>
                <v-list-item-content>
                  <v-list-item-title class="text-h5">{{ data.title }}</v-list-item-title>
                  <v-spacer/><v-spacer/>
                  <v-list-item-subtitle class="text-caption">{{ data.date }}</v-list-item-subtitle>
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
                :src="data.cover"
                v-if="data.cover"
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
      feed_data: [
        { 
          name: 'how-to-be-a-pro-dota-gamer',
          title: 'How to be a Pro Dota Gamer',
          date: 'May 2, 2022',
          posted_by: 'ArlwinF',
          likes: 231,
          cover: 'https://cdn.cloudflare.steamstatic.com/steam/apps/570/ss_f9ebafedaf2d5cfb80ef1f74baa18eb08cad6494.1920x1080.jpg?t=1650611880',
          text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tortor sapien, lacinia ut ullamcorper sit amet, aliquet eget arcu.<br><br> Nullam malesuada massa enim, sit amet rutrum erat semper quis. Quisque in sapien mauris. Nam tempus orci ac justo aliquet, in ullamcorper quam ultricies. <br><br>  Vivamus posuere ac elit ut tristique. Praesent semper odio imperdiet nunc tempus, pharetra dapibus tortor blandit. Nulla porttitor convallis sapien. In eget nibh sapien. Donec commodo ex at aliquet fermentum. Maecenas in magna in purus facilisis lobortis ultricies id nisl. Cras consequat laoreet felis, ut auctor lectus pellentesque id. Nulla ut velit mi. Duis id nisi condimentum, efficitur leo sed, tempor augue. Fusce ante ex, vestibulum ut nisl eu, sollicitudin mollis turpis. Etiam fermentum dignissim arcu, ac euismod libero sollicitudin ut. Nulla semper quam arcu, eu vulputate velit vestibulum eget. Aliquam non condimentum nisl, ac efficitur orci. Donec porta, velit quis interdum mollis, sem odio egestas enim, sed bibendum libero odio ac metus. Cras ut semper odio. Ut quis fringilla purus.'
        },
        {
          name: 'how-to-git-gud',
          title: 'How to git gud',
          date: 'May 1, 2022',
          posted_by: 'Fwinrla',
          likes: 3212,
          text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tortor sapien, lacinia ut ullamcorper sit amet, aliquet eget arcu. Nullam malesuada massa enim, sit amet rutrum erat semper quis. Quisque in sapien mauris. <br><br> Nam tempus orci ac justo aliquet, in ullamcorper quam ultricies. Vivamus posuere ac elit ut tristique. <br><br> Praesent semper odio imperdiet nunc tempus, pharetra dapibus tortor blandit. Nulla porttitor convallis sapien. In eget nibh sapien. Donec commodo ex at aliquet fermentum. Maecenas in magna in purus facilisis lobortis ultricies id nisl. Cras consequat laoreet felis, ut auctor lectus pellentesque id. Nulla ut velit mi. Duis id nisi condimentum, efficitur leo sed, tempor augue. Fusce ante ex, vestibulum ut nisl eu, sollicitudin mollis turpis. Etiam fermentum dignissim arcu, ac euismod libero sollicitudin ut. Nulla semper quam arcu, eu vulputate velit vestibulum eget. Aliquam non condimentum nisl, ac efficitur orci. Donec porta, velit quis interdum mollis, sem odio egestas enim, sed bibendum libero odio ac metus. Cras ut semper odio. Ut quis fringilla purus.'
        }
      ]
    }
  },
}
</script>

<style scoped>
.v-ripple__container {
    display:none !important;
}
</style>