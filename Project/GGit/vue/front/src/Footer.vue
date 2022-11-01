<template>

<footer class="footer width-full container-xl p-responsive">


  <div class="position-relative d-flex flex-items-center pb-2 f6 color-fg-muted border-top color-border-muted flex-column-reverse flex-lg-row flex-wrap flex-lg-nowrap mt-6 pt-6">
    <div class="list-style-none d-flex flex-wrap col-0 col-lg-2 flex-justify-start flex-lg-justify-between mb-2 mb-lg-0">
      <div class="mt-2 mt-lg-0 d-flex flex-items-center">
        <a aria-label="Homepage" title="GitHub" class="footer-octicon mr-2" href="http://ggit.me" style="position:absolute;margin-top: 3px;margin-left: 3px;">
          <img class="logo" src="static/imgs/logo/logoblack.png" />
        </a> 
     
        <span style="margin-left: 40px;">
        © 2022 GGIT, Inc.
        </span>
        <h3 class="sr-only" id="sr-footer-heading" style="margin-left: 15px;">웹프로젝트</h3>
  
      </div>
    </div>
    <nav aria-label="footer" class="col-12 col-lg-8">

      
      <ul class="list-style-none d-flex flex-wrap col-12 flex-justify-center flex-lg-justify-between mb-2 mb-lg-0" aria-labelledby="sr-footer-heading" style="color: blue;">
          <li class="mr-3 mr-lg-0"><a href="https://github.com/eak00700" >민준성</a></li>
          <li class="mr-3 mr-lg-0"><a href="https://github.com/leetaehyeon123" >이태현</a></li>
          <li class="mr-3 mr-lg-0"><a  href="https://github.com/JIN-RYEOL">김진렬</a></li>
          <li class="mr-3 mr-lg-0"></li>
      </ul>
      본 웹페이지는 신촌 <a style="color:blue " href="https://koreaisacademy.com/">코리아IT아카데미</a> 팀프로젝로 학습용 사이트입니다.
    </nav>
   
  </div>

  <div class="d-flex flex-justify-center pb-6">
    <span class="f6 color-fg-muted"></span>
  </div>
</footer>



  
</template>

<script>

export default {


}
</script>

<style lang="scss">


@media (min-width: 1012px){
.p-responsive {
    padding-right: 16px !important;
    padding-left: 16px !important;
}}
@media (min-width: 544px){
.p-responsive {
    padding-right: 40px !important;
    padding-left: 40px !important;
}}
.p-responsive {
    padding-right: 16px !important;
    padding-left: 16px !important;
}
.width-full {
    width: 100% !important;
}
.container-xl {
    max-width: 1280px;
    margin-right: auto;
    margin-left: auto;
}
.list-style-none{
  list-style: none;
}
.mr-2{

}
.mr-3{

  margin:10px;
}
.footer {

  width:50%;
  border-top: 2px solid rgb(219, 207, 207);
  text-align: center;
  word-wrap: break-word;
  padding:20px;
  margin: auto;
  margin-top: 40px;


}




</style>