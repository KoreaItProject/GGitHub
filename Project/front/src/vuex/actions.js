import {
  USER_EMAIL,
  USER_IDX,
  IS_AUTH,
  ERROR_STATE,
  IS_LOGIN
} from "./mutation_types";

import SecureLS from "secure-ls";
const ls = new SecureLS({ isCompression: false });
import axios from "axios";

// let setUserId = ({ commit }, data) => {
//   commit(USER_ID, data);
// };

let setUserEmail = ({ commit }, data) => {
  commit(USER_EMAIL, data);
};

let setUserIdx = ({ commit }, data) => {
  commit(USER_IDX, data);
};

let setErrorState = ({ commit }, data) => {
  commit(ERROR_STATE, data);
};

let setIsAuth = ({ commit }, data) => {
  commit(IS_AUTH, data);
};
let setIsLogin = ({ commit }, data) => {
  commit(IS_LOGIN, data);
};

// 백엔드에서 반환한 결과값을 가지고 로그인 성공 실패 여부를 vuex에 넣어줌
let processResponse = (store, loginResponse) => {
  if (loginResponse == null) {
    setErrorState(store, "Wrong ID or Password");
    setIsAuth(store, false);
  } else {
    console.log(loginResponse.data);
    localStorage.setItem("idx", loginResponse.data.idx);
    localStorage.setItem("isLogin", true);
    setUserEmail(store, loginResponse.data.email);
    setUserIdx(store, loginResponse.data.idx);
    setErrorState(store, "");
    setIsLogin(store, true);
    setIsAuth(store, true);
  }
};

export default {
  async login(store, { user_email, user_pw }) {
    const loginResponse = await axios.post("/api/login", {
      email: user_email,
      pw: user_pw
    });
    processResponse(store, loginResponse);
    return loginResponse; // 로그인 결과를 리턴한다
  }
};
