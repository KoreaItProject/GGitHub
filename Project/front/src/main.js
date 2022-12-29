// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import router from "./router";
import axios from "axios";
import VueCookies from "vue-cookies"; // npm install --save js-cookie
import store from "./vuex/store"; //1. store 추가
import VuejsHeatmap from 'vuejs-heatmap' // npm install --save vuejs-heatmap
import "@/assets/js/fontAwesomeIcon.js"

export default VuejsHeatmap


Vue.use(VueCookies);

Vue.prototype.$store = store;
Vue.prototype.$axios = axios;
Vue.config.productionTip = false;




import '@fortawesome/fontawesome-free/js/all.js'

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  components: { App,},
  template: "<App/>"
});
