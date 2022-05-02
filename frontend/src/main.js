import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import client from './services/api'

Vue.config.productionTip = false
Vue.prototype.$http = client;

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
