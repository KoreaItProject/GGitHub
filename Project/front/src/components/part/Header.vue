<template>
  <header>
    <div class="header_container">
      <a href="/" class="header_logo">
        <img class="logo" src="@/assets/imgs/logo/logo.png" />
        <span class="header_logo_text">GGIT</span>
      </a>

      <!-- 로그인 됐을때 -->
      <div class="header_right_div" v-if="islogin">
        <img :src="img" class="header_profile_img" />
        <div class="header_tab_div">
          <a class="header_tab" @click="Logout"><span>로그아웃</span></a>
          <a class="header_tab" href="/setting/profile"><span>설정</span></a>
          <a class="header_tab" href="/create"><span>새 저장소</span></a>
          <a class="header_tab" :href="'/' + nick + '?tab=repositories'"
            ><span>내 저장소</span></a
          >
          <a class="header_tab" :href="'/' + nick"><span>프로필</span></a>
        </div>
      </div>

      <!-- 로그인 안됐을 때 -->
      <div class="header_right_div" v-if="!islogin">
        <div class="header_tab_div">
          <a class="header_tab"><span>회원가입</span></a>
          <a class="header_tab" href="/login"><span>로그인</span></a>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      islogin: false,
      nick: "",
      img: null,
    };
  },
  methods: {
    Logout: function () {
      localStorage.removeItem("idx");
      localStorage.removeItem("isLogin");
      window.location.href = "";
    },
    getNick() {
      axios
        .get("/api/nickFromIdx", {
          params: {
            idx: localStorage.getItem("idx"),
          },
        })
        .then((response) => {
          // handle success

          this.nick = response.data;
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    getImg() {
      axios
        .get("/api/imgFromIdx", {
          params: {
            idx: localStorage.getItem("idx"),
          },
        })
        .then((response) => {
          // handle success
          let imgPath = response.data;
          this.img = require("@/assets/imgs/" + imgPath);
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
  },
  mounted() {
    this.islogin = localStorage.getItem("isLogin");
    if (this.islogin) {
      this.getNick();
      this.getImg();
    }
  },
};
</script>

<style lang="sass">
@import 'src/assets/sass/part/header'
</style>
