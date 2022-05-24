import { defineStore } from 'pinia'

export const userStore = defineStore('userStore', {
    state: () => {
        return {

            user: {
                loggedIn: false,
                userId: null,
                username: null,
            }
        }
    },
    getters: {
        isUserLoggedIn(state) {
            return state.loggedIn || (localStorage['user'] && JSON.parse(localStorage['user'])['loggedIn']);
        },
        currentUser(state) {

            if (state.user && state.user.userId && state.user.username) return state.user
            return JSON.parse(localStorage['user']);
        },
    },
    actions: {
        login(userId, username) {

            this.user.userId = userId;
            this.user.username = username;
            this.user.loggedIn = true;

            localStorage.setItem('user', JSON.stringify(this.user));
        },
    },
})