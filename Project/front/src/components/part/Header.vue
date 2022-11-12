<template>
  <header>
    <div class="header_container">
      <a href="/">
        <img class="logo" src="@/assets/imgs/logo/logo.png" />
        <span class="header_logo_text">GGIT</span>
      </a>

      <div class="header_right_div" v-if="islogin">
        <img
          src="@/assets/imgs/profile/profileImg.jpg"
          class="header_profile_img"
        />
        <div class="header_tab_div">
          <a class="header_tab"><span>로그아웃</span></a>
          <a class="header_tab" href="/setting/profile"><span>설정</span></a>
          <a class="header_tab"><span>새 저장소</span></a>
          <a class="header_tab" href="/진렬킴"><span>프로필</span></a>
        </div>
      </div>
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
export default {
  data() {
    return {
      islogin: false,
    };
  },
};
</script>

<style lang="sass">
@import 'src/assets/sass/part/header'
</style>
