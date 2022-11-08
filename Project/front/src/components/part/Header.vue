<template>
  <header>
    <div class="header_container">
      <a href="/">
        <img class="logo" src="@/assets/imgs/logo/logo.png" />
        <span class="header_logo_text">GGIT</span>
      </a>

      <div class="header_inlogin">
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
    </div>
  </header>
</template>

<script>
export default {};
</script>

<style lang="sass">
@import 'src/assets/sass/part/header'
</style>
