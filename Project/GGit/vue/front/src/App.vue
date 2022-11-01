<template>
  <div id="app" >
    <header-view/>
    <router-view/>
    <footer-view/>
  </div>
</template>

<script>
import Header from './Header.vue'
import Footer from './Footer.vue'
export default {
  name: 'App',
  components:{
    "header-view":Header,
    "footer-view":Footer,
  }
}
</script>

<style>

@import '../src/styles/reset/reset';
</style>
