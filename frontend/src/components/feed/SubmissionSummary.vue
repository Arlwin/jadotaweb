<template>
    <v-card
        class="pa-3"
        outlined
    >
        <v-card-title class="text-h4">{{ name }}</v-card-title>
        <v-card-text>

            <v-container class="pa-0">
                <v-row>
                    <v-col>
                        <v-img
                        class="rounded-lg"
                        :src="cover_image_url"
                        />
                    </v-col>
                    <v-col>
                        <v-list
                            three-line
                        >   
                            <v-subheader
                                class="text-h6"
                            >
                                SKILLS
                            </v-subheader>
                            
                            <v-list-item
                                v-for="skill in skills"
                                :key="skill['name']"
                            >   
                                <v-list-item-avatar 
                                    rounded="lg"
                                >
                                    <v-img :src="skill['icon']" />
                                </v-list-item-avatar>

                                <v-list-item-content>
                                    <v-list-item-title v-html="skill['name']"></v-list-item-title>
                                    <v-list-item-subtitle v-html="skill['description']"></v-list-item-subtitle>
                                </v-list-item-content>
                            </v-list-item>
                        </v-list>
                    </v-col>
                </v-row>
                <v-row class="my-7 px-3">
                    {{description}}
                </v-row>
                <v-row class="mt-12 px-3 justify-space-between align-end">
                    <div class="d-flex flex-column">
                        <v-icon class="my-2"> mdi-thumb-up-outline </v-icon>
                        {{ getLikes }}
                    </div>
                    <div>
                        <a href=""> More Info </a>
                    </div>
                </v-row>
            </v-container>
        </v-card-text>
    </v-card>
</template>

<script>
export default {
    name: 'SubmissionSummary',
    props: {
        name: String,
        cover_image_url: String,
        description: String,
        skills: Array,
        likes: Number,
    },
    data () {
        return {

        }
    },
    computed: {
        getLikes () {

            if (this.likes < 1000) return this.likes

            return `${(this.likes / 1000).toFixed(1)} K`;
        },
    },
}
</script>

<style>

</style>