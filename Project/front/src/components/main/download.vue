<template lang="">
    <div class="download_templeate" style=" background: url('./static/imgs/download/back.jpg');
        background-repeat: no-repeat, round;
        background-size: cover;
        background-position: center;
        background-attachment: fixed;    
           ">
        <div class = "download_container1" >

          <div class="download_container1_left">
            <div>

              <h1 class="typing"></h1> 
             
            </div>
          
           
             <p>GGit 페이지는</p>
             <p>GGIT SOURCE 프로그램을 사용하여</p><p>작업 저장소에 파일을 업로드합니다.</p>
             <br>
             
              <button
              type="submit"
              data-view-component="true"
              class="btn_download_ggitsource"
              @click="ggitsourcDownload"
            >
              낏소스 다운로드 <span style="font-size:13px"> for window</span>
            </button>
            <button
              type="submit"
              data-view-component="true"
              class="btn_download_ggitsource"
              @click="ggitsourcDownload"
            >
              낏소스 다운로드 <span style="font-size:13px"> for mac</span>
            </button>
          </div>
          <div class="download_container1_right">
              <img class="img1" src="@/assets/imgs/main/download/img1.png"></img>
          </div>
        

        </div>
        

        <div style="width:100%;text-align:center;height:250px;background-color: #f4f5f7;">
          <img class="img2" src="@/assets/imgs/main/download/img2.png" style="width:1000px; "></img>
        </div>

        <div class="back" ></div>
        <div class="flex" >
          <img src="@/assets/imgs/main/download/gif1.gif" style="width:350px;"></img>
          <div style="margin:100px 0 0 100px ">
            <h2>파일의 변화 실시간 추적</h2>
            <br>
            <h3>
              추가,수정,삭제,파일명,경로 화면에 표시
            </h3>
           <br>
            <p>IDE에서 코드를 수정하면 실시간으로 작동합니다</p>
          </div>
        </div>

        <div class="flex" style="text-align:center">
          <h2>1.저장소 메뉴에서 접속코드를 복사합니다.</h2>
          <div style="width:340px"></div>
        </div>



    </div>
</template>
<script>
import axios from "axios";
import $ from "jquery";
export default {
  data() {
    return {
      bgImg: "src/assets/imgs/main/download/img2.png",
    };
  },
  methods: {
    ggitsourcDownload: function () {
      axios
        .get("/api/ggitsourceDownload", {
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
    var typingTxt = "직관적인 UI와 높은  작동성      GGIT SOURCE!!";

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