<template>
    <v-container
        class="d-flex flex-column pa-5"
    >
        <v-card
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

<script>
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
        }
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