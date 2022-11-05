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
          <a class="header_tab"><span>Sign out</span></a>
          <a class="header_tab"><span>Setting</span></a>
          <a class="header_tab"><span>Help</span></a>
          <a class="header_tab"><span>New repository</span></a>
          <a class="header_tab" href="/진렬킴"><span>Your profile</span></a>
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
