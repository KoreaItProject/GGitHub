<template lang="">
    <div class="download_templeate">
        <div class = "download_container1">

          <div class="download_container1_left">
            <div>

              <h2 class="typing"></h2> 
             
            </div>
          
            <button
              type="submit"
              data-view-component="true"
              class="btn_download_ggitsource"
              @click="ggitsourcDownload"
            >
              낏소스 다운로드 Click!
            </button>
             <p>GGit 페이지는</p>
             <p>GGIT SOURCE 프로그램을 사용하여</p><p>작업 저장소에 파일을 업로드합니다.</p>
          </div>
          <div class="download_container1_right">
              <img class="img1" src="@/assets/imgs/main/download/img1.png"></img>
          </div>
           

        </div>
        
    </div>
</template>
<script>
import axios from "axios";
import $ from "jquery";
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
  mounted() {
    var typingBool = false;
    var typingIdx = 0;

    // 타이핑될 텍스트를 가져온다
    var typingTxt = "직관적인 UI와 높은 작동성  !  !    GGIT SOURCE";

    typingTxt = typingTxt.split(""); // 한글자씩 자른다.

    if (typingBool == false) {
      // 타이핑이 진행되지 않았다면
      typingBool = true;
      var tyInt = setInterval(typing1, 100); // 반복동작
    }

    function typing1() {
      if (typingIdx < typingTxt.length) {
        // 타이핑될 텍스트 길이만큼 반복
        $(".typing").append(typingTxt[typingIdx]);
        // 한글자씩 이어준다.
        typingIdx++;
      } else {
        //끝나면 반복종료
        clearInterval(tyInt);
      }
    }
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/main/download"
</style>