import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router'
import client from './services/api'
import format_date from './mixins/date'

Vue.config.productionTip = false
Vue.prototype.$http = client;

Vue.mixin({
  methods: {
    format_date: format_date
  }
})

new Vue({
  vuetify,
  router,
  render: h => h(App)

}).$mount('#app')
