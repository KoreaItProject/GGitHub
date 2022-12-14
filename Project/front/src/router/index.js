import Vue from "vue";
import Router from "vue-router";
import store from "../vuex/store";
import login_router from "./login_router";

import test_router from "./test_router";

Vue.use(Router);

export default new Router({
  routes: [
    ...test_router,
    ...login_router,
    {
      path: "/",
      name: "main",
      beforeEnter: function(to, from, next) {
        const u_idx = store.getters.getUserIdx;
        const u_nick = store.getters.getUserNick;

        if (u_idx != null) {
          // 로그인 된 상태라면
          next("/" + u_nick);
        } else if (u_idx == null) {
          // 로그인 안된 상태라면
          next();
        }
      },
      component: () => import("@/components/main/main")
    },
   
    {
      path: "/create",
      name: "create",
      component: () => import("@/components/repository/create")
    },
    {
      path: "/pagenotfound",
      name: "pagenotfound",
      component: () => import("@/components/main/pagenotfound")
    },
    {
      path: "/setting/:tab",
      name: "setting",
      component: () => import("@/components/setting/setting")
    },
    {
      path: "/search",
      name: "search",
      component: () => import("@/components/search/search")
    },
    {
      path: "/:nick",
      name: "profile",
      component: () => import("@/components/profile/profile")
    },
    {
      path: "/token/:nick/:repository/:token/:path*",
      name: "token",
      component: () => import("@/components/repository/repository"),

    },
    {
      path: "/:nick/:repository/:path*",
      name: "reopsitory",
      component: () => import("@/components/repository/repository"),

    }
  ],
  mode: "history"
});
