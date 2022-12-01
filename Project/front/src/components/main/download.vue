<template lang="">
    <div class="download_templeate">
        <div class = "download_container1">
            <button
          type="submit"
          data-view-component="true"
          class="btn_download_ggitsource"
          @click="ggitsourcDownload"
        >
          낏소스 다운로드
        </button>

        </div>
        
    </div>
</template>
<script>
import axios from "axios";
export default {
  methods: {
    ggitsourcDownload: function () {
      axios
        .get("/api/download", {
          responseType: "blob",
        })
        .then((response) => {
          const url = window.URL.createObjectURL(new Blob([response.data]));
          const link = document.createElement("a");
          link.href = url;
          link.setAttribute("download", response.headers.filename); //or any other extension
          console.log(response.headers.filename);
          document.body.appendChild(link);
          link.click();
        })
        .catch((exception) => {
          alert("파일 다운로드 실패");
        });
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/main/download"
</style>