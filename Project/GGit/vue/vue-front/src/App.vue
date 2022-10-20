<template>
  <div class="about">
    <h1>{{ connectData }}</h1>
  </div>
</template>
<script>
export default {
  name: "About",
  components: [],
  data() {
    return {
      connectData: "",
    };
  },
  methods: {
    get() {
      this.axios.get("/connectTest").then((response) => {
        this.connectData = response.data;
      });
    },
  },
  mounted() {
    this.get();
  },
};
</script>