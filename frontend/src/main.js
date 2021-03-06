import Vue from 'vue'
import App from './App.vue'

import client from './services/api'
import format_date from './mixins/date'

import vuetify from './plugins/vuetify'
import pinia from './plugins/pinia'
import router from './router'

import { initializeApp } from "firebase/app";
import firebaseConfig from './config/firebase'

Vue.config.productionTip = false
Vue.prototype.$http = client;

Vue.mixin({
  methods: {
    format_date: format_date
  }
})

initializeApp(firebaseConfig);

new Vue({
  vuetify,
  router,
  render: h => h(App),
  pinia
}).$mount('#app')
