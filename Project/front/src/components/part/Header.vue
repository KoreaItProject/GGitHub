<template>
  <header>
    <div class="header_margin">
      <div class="header_container">
        <a href="/" class="header_logo">
          <img class="logo" src="@/assets/imgs/logo/logo.png" />
          <span class="header_logo_text">GGit</span>
        </a>

        <!-- 로그인 됐을때 -->
        <div class="header_right_div" v-if="islogin">
          <img :src="profileImg" class="header_profile_img" />
          <div class="header_tab_div">
            <a class="header_tab" @click="Logout"><span>로그아웃</span></a>
            <a class="header_tab" href="/setting/profile"><span>설정</span></a>
            <a class="header_tab" href="/download"><span>다운로드</span></a>
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
            <a class="header_tab" href="/download"><span>다운로드</span></a>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
import axios from "axios";
import store from "../../vuex/store";

export default {
  data() {
    return {
      islogin: false,
      nick: "",
      profileImg: null,
    };
  },
  methods: {
    Logout: function () {
      this.$cookies.remove("idx");
      this.$cookies.remove("isLogin");
      this.$cookies.remove("nick");
      window.location.href = "";
    },

    getNick() {
      axios
        .get("/api/nickFromIdx", {
          params: {
            idx: store.getters.getUserIdx,
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
            idx: store.getters.getUserIdx,
          },
        })
        .then((response) => {
          // handle success
          axios
            .get("/api/getProfileImg", {
              responseType: "blob",
              params: {
                img: response.data,
              },
            })
            .then((response) => {
              // handle success
              this.profileImg = window.URL.createObjectURL(
                new Blob([response.data])
              );
              console.log(response.data);
            });
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
    this.islogin = store.getters.getIsLogin;
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
