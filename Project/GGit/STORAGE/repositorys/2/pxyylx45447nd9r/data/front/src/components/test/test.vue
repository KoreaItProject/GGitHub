
<template>
  <div>
    <h1>테스트중</h1>
    <v-btn @click="get">버튼</v-btn>
    <img :src="img" />
  </div>
</template>

<script>
import { useListeners } from "vue";
import axios from "axios";
export default {
  data() {
    return {
      profileImg: "",
    };
  },

  methods: {
    getProfile() {
      axios
        .get("api/getProfileImg", {
          responseType: "blob",
          img: "",
        })
        .then((response) => {
          // handle success
          this.profileImg = window.URL.createObjectURL(
            new Blob([response.data])
          );
          console.log(response.data);
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
  },
};
</script>