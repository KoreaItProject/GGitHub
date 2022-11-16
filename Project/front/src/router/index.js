import Vue from "vue";
import Router from "vue-router";

import test_router from "./test_router";

Vue.use(Router);

export default new Router({
  routes: [
    ...test_router,
    {

      path: "/",
      name: "main",
      beforeEnter: function (to, from, next) {
        const u_idx = localStorage.getItem("idx");
        const u_nick = localStorage.getItem("nick");
        if (u_idx != null) {
          // 로그인 된 상태라면
          next("/" + u_nick);
        } else if (u_idx == null) {
          // 로그인 안된 상태라면
          next();
        }
      },
      component: () => import("@/components/main/main"),
    },
    {
      path: "/login",
      name: "login",
      component: () => import("@/components/login/login"),
    },
    {
      path: "/create",
      name: "create",
      component: () => import("@/components/repository/create"),
    },
    {
      path: "/pagenotfound",
      name: "pagenotfound",
      component: () => import("@/components/main/pagenotfound"),
    },
    {
      path: "/setting/:tab",
      name: "setting",
      component: () => import("@/components/setting/setting"),
    },
    {
      path: "/:nick",
      name: "profile",
      component: () => import("@/components/profile/profile"),
    },
    {
      path: "/:nick/:repository",
      name: "reopsitory",
      component: () => import("@/components/repository/repository"),
    },

  ],
  mode: "history",
});
