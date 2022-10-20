// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from "axios";

Vue.config.productionTip = false
axios.defaults.baseURL = "http://localhost:4520";
/* eslint-disable no-new */
const app = createApp(App);
app.config.globalProperties.axios = axios;
app.use(store).use(router).mount("#app");
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
