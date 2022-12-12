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

Vue.config.productionTip = false;


import { library } from '@fortawesome/fontawesome-svg-core'

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

// 설치했던 fontawesome-svg-core와 vue-fontawesome

 

import { fas } from '@fortawesome/free-solid-svg-icons'

import { far } from '@fortawesome/free-regular-svg-icons'

import { fab } from '@fortawesome/free-brands-svg-icons'

// 이렇게하면 모든 아이콘들을 불러올 수 있다.

 

 

library.add(

fas,

far,

fab

)
Vue.component('font-awesome-icon', FontAwesomeIcon)
/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  components: { App },
  template: "<App/>"
});
