<template>
    <v-app-bar
        app
        color="primary"
        dense
        flat
        dark
        class="px-7"
    >

        <v-container>
            <v-row
                no-gutters
                align-center
            >   
                <v-col 
                    class="d-flex justify-center align-center"
                    cols="3"
                >
                    <v-btn 
                        text 
                        v-ripple="false" 
                        :to="{ name: 'Home' }" 
                        class="no-hover"
                    >
                        HeroTime
                    </v-btn>
                </v-col>

                <v-col 
                    class="d-flex justify-space-around align-center pr-16 pl-5"
                    cols="9"
                >   
                    <v-select
                        class="flex-grow-0 flex-shrink-1 mx-6"
                        v-model="default_channel"
                        :items="channels"
                        :item-text="default_channel"
                        dense
                        outlined
                        hide-details
                    ></v-select>

                    <v-text-field
                        class="mx-6 py-4"
                        solo
                        dense
                        hide-details                        
                    ></v-text-field>
                    <!-- <v-spacer/> -->

                    <v-icon
                        class="mx-6"
                        large    
                    >
                        mdi-plus
                    </v-icon>
                </v-col>
            </v-row>
        </v-container>
    </v-app-bar>
</template>

<script>
export default {
    name: 'NavBar',
    data: () => ({

        default_channel: 'ALL',
        channels: [
            'ALL', 
            'FOLLOWING'
        ],
    }),
}
</script>

<style>

</style>