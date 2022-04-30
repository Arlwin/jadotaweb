import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({

    theme: { 
        dark: true,
        themes: {
            light: {
                primary: '#3f51b5',
                secondary: '#b0bec5',
                accent: '#8c9eff',
                error: '#b71c1c',
            },
            dark: {
                primary: '#4A7B9D',
                secondary: '#3A3238',
                accent: '#D62828',
                error: '#b71c1c',
            }
        }
    },
});
