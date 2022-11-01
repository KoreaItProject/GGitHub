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
/* #app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
@import '../src/styles/reset/reset';
</style>
