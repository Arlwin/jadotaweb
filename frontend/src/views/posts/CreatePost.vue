<template>
    <v-container class="pa-7 mx-auto" fluid>

    <v-btn 
      class="no-hover px-0"
      v-ripple="false" 
      text 
      plain
      @click="$router.go(-1)"
    >
      <v-icon>mdi-arrow-left-thin</v-icon> 
      Back to Home
    </v-btn><br>

    <!-- Create Post -->
    <v-row>
      <v-col cols=8>
        <v-card
          class="px-4 py-2 d-flex flex-column"
          height=70vh
        > 
          <v-card-title>Create Post</v-card-title>
          <v-form
            class="px-4 flex-grow-1 d-flex flex-column"
            v-model="form.valid"
            ref="form"
            lazy-validation
          > 
            <v-text-field 
              class="flex-grow-0"
              label="Title"
              outlined
              counter=100
              clearable
              dense
            />
            <!-- <v-file-input
              label="Cover Image (Optional)"
              dense
              outlined
              prepend-icon="mdi-image"
            /> -->
            <v-textarea 
              class="flex-grow-1"
              label="Post"
              outlined
              no-resize
              height="50vh"
            />
          </v-form>
        </v-card>
      </v-col>
      <v-col>
        <v-card
          flat
        >
          <v-list class="px-4 py-2">
            <span class="text-h6">Rules</span><br>
            <v-divider></v-divider>
            <v-list-item
              v-for="rule in rules"
              :key="rule"
              class="px-0"
              dense
            >
              <v-list-item-icon class="mx-1">
                <v-icon>mdi-circle-small</v-icon>
              </v-list-item-icon>
              <v-list-item-content>
                <v-list-item-title>{{ rule }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'CreatePost',
  data () {

    return {

      form: {
        valid: true,
      },
      rules: [
        'Remember the human',
        'Behave like you would in real life',
        'Look for the original source of content',
        'Search for duplicates before posting',
      ]
    }
  },
}
</script>

<style>

.no-hover::before {
  display: none !important;
}


</style>