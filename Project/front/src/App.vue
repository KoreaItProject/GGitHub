<template>
  <div id="app">
    <header-view />
    <div id="app_content">
      <router-view />
    </div>
    <footer-view />
  </div>
</template>

<script>
import Header from "./components/part/Header.vue";
import Footer from "./components/part/Footer.vue";
export default {
  name: "App",
  components: {
    "header-view": Header,
    "footer-view": Footer,
  },
};
</script>


<style lang="scss">
@import "./assets/reset/reset.css";
</style>
