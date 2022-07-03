<template>
    <v-container
        class="d-flex flex-column pa-5"
    >   
        <v-card
            v-if="isUserLoggedIn"
            class="d-flex flex-column rounded-lg"
            width="100%"
            outlined
        >
            <v-container>
                <v-row class="flex-column align-center">   
                    <v-img
                        class="red darken-3 rounded-t-lg"
                        width="100%"
                        height="130"
                    >
                    </v-img>
                    <v-avatar
                        class="mt-n9 avatar-class"
                        size="75"
                        color="primary"
                    >
                        AJ
                    </v-avatar>
                    <span class="my-4 text-h5">
                        {{ currentUser['username'] }}
                    </span>
                </v-row>
                <v-row 
                    v-for="details in account_details"
                    :key="details.label"
                    class="px-5 my-4 justify-space-between"
                >
                    <span>{{ details.label }}</span>
                    <a href>{{ details.value }}</a>
                </v-row>
                
            </v-container>
        </v-card>
        <v-card
            v-else
            class="d-flex flex-column pa-5"
            width="100%"
            outlined
        >
            <v-btn 
                class="my-2"
                block
                x-large
                @click.stop="signIn" 
            >
                SIGN IN
            </v-btn>
            <v-btn 
                class="my-2"
                block
                x-large
                @click.stop="signUp" 
            >
                SIGN UP
            </v-btn>
        </v-card>

        <!-- Filters -->
        <v-card
            class="d-flex flex-column my-16 rounded-lg"
            width="100%"
            outlined
        >   
            <v-btn-toggle
                v-model="main_filter"
                mandatory
                tile
            >   
                <v-btn
                    class="flex-grow-1"
                    v-for="filter in main_filter_items" 
                    :key="filter.name"
                >
                    {{ filter.name }}
                </v-btn>
            </v-btn-toggle>
            <v-btn-toggle
                v-if="main_filter == 1"
                v-model="time_filter"
                mandatory
                tile
            >
                <v-btn 
                    class="flex-grow-1"
                    v-for="filter in time_filter_items" 
                    :key="filter.name"
                >
                    {{ filter.name }}
                </v-btn>
            </v-btn-toggle>
        </v-card>

        <SignInDialog v-model="signInDialog" :signUpState="signUpState" @refresh="refresh"/>
    </v-container>
</template>

<style scoped>
.avatar-class {

    border: 2px #3A3238 solid !important;
}
</style>

<script>
import { mapState } from 'pinia'
import { userStore } from '@/stores/UserStore'

import SignInDialog from './auth/SignInDialog.vue';

export default {
    name: 'NavBar',
    components: {
        SignInDialog,
    },
    data () {
        return {
            signInDialog: false,
            signUpState: false,
            main_filter: undefined,
            main_filter_items: [
                {
                    name: 'MOST RECENT'
                },
                {
                    name: 'MOST LIKED'
                },
            ],
            time_filter: undefined,
            time_filter_items: [
                {
                    name: 'TODAY'
                },
                {
                    name: 'WEEK'
                },
                {
                    name: 'MONTH'
                },
                {
                    name: 'ALL TIME'
                },
            ],
            account_details: [
                {
                    label: 'Following',
                    value: '1.2K',
                },
                {
                    label: 'Followers',
                    value: '1.1K',
                },
                {
                    label: 'Heroes Submitted',
                    value: '12',
                },
                {
                    label: 'Hero Liked',
                    value: '1.5K',
                },
            ]
        }
    },
    computed: {
        ...mapState(userStore, ['currentUser', 'isUserLoggedIn']),
    },
    methods: {
        signIn () {
            this.signUpState = false;
            this.signInDialog = true;
        },
        signUp () {
            this.signUpState = true;
            this.signInDialog = true;
        },
    }
}
</script>

<style>

</style>