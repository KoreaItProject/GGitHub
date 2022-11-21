import Vue from "vue";
import Vuex from "vuex";
import getters from "./getters";
import mutations from "./mutations";
import actions from "./actions";
import Cookies from "js-cookie";
import CryptoJS from "crypto-js";

const Crypto = require("crypto");

Vue.use(Vuex);
import { createVuexPersistedState } from "vue-persistedstate";
import SecureLS from "secure-ls";
const ls = new SecureLS({ isCompression: false });

var s_key = "aksjdhfusjdmfksj"; // 시크릿 키

var nick = Cookies.get("nick");
var isLogin = Cookies.get("isLogin");
var idx = Cookies.get("idx");

// 닉네임 수정 메소드
// function nick_update_cookie(String nick) {
//   Cookies.set
// }

// 암호화
function enCrypt(plainText) {
  plainText = Buffer.from(plainText);
  let cipher = Crypto.createCipheriv("AES-128-ECB", s_key, "");
  let encrypted = cipher.update(plainText, "", "");
  return Buffer.concat([encrypted, cipher.final()]).toString("base64");
}

//복호화
function deCrypt(encryptText) {
  if (encryptText == "undefined") {
    return null;
  }
  encryptText = Buffer.from(encryptText, "base64");
  let cipher = Crypto.createDecipheriv("AES-128-ECB", s_key, "");
  let decrypted = cipher.update(encryptText);

  return Buffer.concat([decrypted, cipher.final()]).toString("utf-8");
}

export default new Vuex.Store({
  //   modules: {},
  //   plugins: [
  //     createVuexPersistedState({
  //       paths: ["idx"]
  //     })
  //   ],

  state: {
    email: null,
    idx: deCrypt(idx + "", s_key),
    isLogin: deCrypt(isLogin + "", s_key),
    nick: deCrypt(nick + "", s_key),
  },
  mutations,
  getters,
  actions,
});
