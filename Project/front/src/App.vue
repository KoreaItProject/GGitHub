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
import Vue from "vue";
import VueCalendarHeatmap from "vue-calendar-heatmap";

Vue.use(VueCalendarHeatmap);

export default {
  name: "App",
  components: {
    "header-view": Header,
    "footer-view": Footer,
  },
};
</script>


<style lang="scss">
@import "src/assets/sass/reset/reset";
</style>
<style lang="css">
html {
  zoom: 0.9;
}
</style>
