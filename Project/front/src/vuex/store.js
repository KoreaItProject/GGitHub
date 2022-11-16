import Vue from "vue";
import Vuex from "vuex";
import getters from "./getters";
import mutations from "./mutations";
import actions from "./actions";

Vue.use(Vuex);
import { createVuexPersistedState } from "vue-persistedstate";
import SecureLS from "secure-ls";
const ls = new SecureLS({ isCompression: false });

export default new Vuex.Store({
  //   modules: {},
  //   plugins: [
  //     createVuexPersistedState({
  //       paths: ["idx"]
  //     })
  //   ],

  state: {
    email: null,
    idx: null,
    isLogin: false,
    isNick: null
  },
  mutations,
  getters,
  actions
});
