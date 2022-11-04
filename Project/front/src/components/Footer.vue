<template>
  <div class="footer_container">
    <div class="">
      <div class="mt-2 mt-lg-0 d-flex flex-items-center">
        <a
          aria-label="Homepage"
          title="GitHub"
          class="footer-octicon mr-2"
          href="http://ggit.me"
          style="position: absolute; margin-top: 3px; margin-left: 3px"
        >
          <img class="logo" src="static/imgs/logo/logoblack.png" />
        </a>

        <span style="margin-left: 40px"> © 2022 GGIT, Inc. </span>
        <h3 class="sr-only" id="sr-footer-heading" style="margin-left: 15px">
          웹프로젝트
        </h3>
      </div>
    </div>
    <nav aria-label="footer" class="col-12 col-lg-8">
      <ul
        class="
          list-style-none
          d-flex
          flex-wrap
          col-12
          flex-justify-center flex-lg-justify-between
          mb-2 mb-lg-0
        "
        aria-labelledby="sr-footer-heading"
        style="color: blue"
      >
        <li class="mr-3 mr-lg-0">
          <a href="https://github.com/eak00700">민준성</a>
        </li>
        <li class="mr-3 mr-lg-0">
          <a href="https://github.com/leetaehyeon123">이태현</a>
        </li>
        <li class="mr-3 mr-lg-0">
          <a href="https://github.com/JIN-RYEOL">김진렬</a>
        </li>
        <li class="mr-3 mr-lg-0"></li>
      </ul>
      본 웹페이지는 신촌
      <a style="color: blue" href="https://koreaisacademy.com/"
        >코리아IT아카데미</a
      >
      팀프로젝로 학습용 사이트입니다.
    </nav>
  </div>
</template>

<script>
export default {};
</script>

<style lang="sass">
@import 'src/assets/footer'
</style>  