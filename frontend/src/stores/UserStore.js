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
            
            return state.loggedIn || localStorage['userId'];
        },
        currentUser(state) {
            
            return {
                userId: state.user.userId ?? localStorage['userId'],
                username: state.user.username ?? localStorage['username']
            };
        },
    },
    actions: {
        login(userId, username) {

            this.user.userId = userId;
            this.user.username = username;
            this.user.loggedIn = true;

            localStorage.setItem('userId', this.user.userId);
            localStorage.setItem('username', this.user.username);
        },
    },
})