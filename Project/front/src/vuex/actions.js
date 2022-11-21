import {
  USER_EMAIL,
  USER_IDX,
  IS_AUTH,
  ERROR_STATE,
  IS_LOGIN,
  IS_NICK
} from "./mutation_types";

import SecureLS from "secure-ls";
const ls = new SecureLS({ isCompression: false });
import axios from "axios";
import Cookies from "js-cookie"; // npm install --save js-cookie
import CryptoJS from "crypto-js";

const Crypto = require("crypto");

var s_key = "aksjdhfusjdmfksj"; // 시크릿 키

// 암호화
function enCrypt(plainText, key) {
  plainText = Buffer.from(plainText);
  let cipher = Crypto.createCipheriv("AES-128-ECB", key, "");
  let encrypted = cipher.update(plainText, "", "");
  return Buffer.concat([encrypted, cipher.final()]).toString("base64");
}

// 복호화
function deCrypt(encryptText, key) {
  encryptText = Buffer.from(encryptText, "base64");
  let cipher = Crypto.createDecipheriv("AES-128-ECB", key, "");
  let decrypted = cipher.update(encryptText);

  return Buffer.concat([decrypted, cipher.final()]).toString("utf-8");
}

let setUserNick = ({ commit }, data) => {
  commit(USER_ID, data);
};

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
let setIsNick = ({ commit }, data) => {
  commit(IS_NICK, data);
};

// 시크릿키 생성()
// function secretkey() {
//   const characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//   let result = "";
//   const charactersLength = characters.length;
//   for (let i = 0; i < 16; i++) {
//     result += characters.charAt(Math.floor(Math.random() * charactersLength));
//   }
//   key = result;
//   return result;
// }

// 백엔드에서 반환한 결과값을 가지고 로그인 성공 실패 여부를 vuex에 넣어줌
let processResponse = (store, loginResponse) => {
  if (loginResponse == null) {
    setErrorState(store, "Wrong ID or Password");
    setIsAuth(store, false);
  } else {
    Cookies.set("idx", enCrypt(loginResponse.data.idx + "", s_key));
    Cookies.set("isLogin", enCrypt("true", s_key));
    Cookies.set("nick", enCrypt(loginResponse.data.nick, s_key));

    setUserEmail(store, loginResponse.data.email);
    // setUserNick(store, loginResponse.data.nick);
    setUserIdx(store, loginResponse.data.idx);
    setErrorState(store, "");
    // setIsLogin(store, true);
    setIsAuth(store, true);
  }
};

export default {
  async login(store, { user_email, user_pw }) {
    console.log("123123");
    const loginResponse = await axios.post("/api/login", {
      email: user_email,
      pw: user_pw
    });
    processResponse(store, loginResponse);
    return loginResponse; // 로그인 결과를 리턴한다
  },

  nick_cookie_update(store, plainText) {
    plainText = Buffer.from(plainText);
    let cipher = Crypto.createCipheriv("AES-128-ECB", s_key, "");
    let encrypted = cipher.update(plainText, "", "");

    Cookies.set(
      "nick",
      Buffer.concat([encrypted, cipher.final()]).toString("base64")
    );
    return;
    // return Buffer.concat([encrypted, cipher.final()]).toString("base64");
  }
};
