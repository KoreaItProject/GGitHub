<template>
  <header>
    <div id="header" class="header">
        <a  href="/">
          <img class="logo" src="static/imgs/logo/logo.png" />
          <span class="project">GGIT</span>
        </a>
    </div>
  </header>
</template>

<script>

export default {


}
</script>

<style lang="scss">

    .header {

    z-index: 32;
    display: flex;
    padding: 9px;
    padding-left:30px;
    padding-right: 30px;
    font-size: 14px;
    line-height: 1.2;

    background-color:#24292f;
    align-items: center;
    flex-wrap: nowrap;

    }
    .logo{
        width: 35px;
        height: 35px;
        
    }
    .project{
      color: white;
      font-size: 18px;
      margin-left: 0px;
  

    }
   
</style>
