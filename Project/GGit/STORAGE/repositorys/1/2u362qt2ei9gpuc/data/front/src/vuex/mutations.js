import * as types from "./mutation_types";

export default {
  //   [types.USER_ID](state, userId) {
  //     state.userId = userId;
  //   },
  [types.USER_EMAIL](state, email) {
    state.email = email;
  },
  [types.USER_IDX](state, userIdx) {
    state.idx = userIdx;
  },
  [types.ERROR_STATE](state, errorState) {
    state.errorState = errorState;
  },
  [types.IS_AUTH](state, isAuth) {
    state.isAuth = isAuth;
  },
  [types.IS_LOGIN](state, isLogin) {
    state.isLogin = isLogin;
  }
};
