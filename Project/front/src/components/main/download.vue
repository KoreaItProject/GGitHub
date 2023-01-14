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
             <p>GGIT SOURCE 프로그램을 사용하여</p><p>작업저장소에 파일을 업로드합니다.</p>
             <br>
             
              <button
              type="submit"
              data-view-component="true"
              class="btn_download_ggitsource"
              @click="ggitsourcDownload"
            >
              낏소스 다운로드 <span style="font-size:15px">for window</span>
            </button>
            <button
              type="submit"
              data-view-component="true"
              class="btn_download_ggitsource"
              @click="ggitsourcDownload"
            >
              낏소스 다운로드 <span style="font-size:15px"> for mac</span>
            </button>
          </div>
          <div class="download_container1_right">
              <img class="img1" src="@/assets/imgs/main/download/img1.png"></img>
          </div>
        

        </div>
        

        <div style="width:100%;text-align:center;background-color:white;padding:90px 0 10px 0;margin-top:-20px">
          <img class="img2" src="@/assets/imgs/main/download/img2.png" style="width:1200px; "></img>
        </div>

       

        <div class="flex" >
          <img src="@/assets/imgs/main/download/gif1.gif" style="width:350px;border:1px solid black"></img>
          <div style="margin:100px 0 0 80px ">
            <h2>파일의 변화 실시간 추적</h2>
            <br>
            <h3>
              추가,수정,삭제,파일명,경로 화면에 표시
            </h3>
           <br>
            <p>IDE에서 코드를 수정하면 실시간으로 동작합니다. </p>
          </div>
        </div>

        <div class="back" ></div>


        <div class="flex" style="text-align:center;">
          <div><h2>저장소 메뉴에서 접속코드를 복사합니다.</h2></div>
          <div style="width:340px"><img src="@/assets/imgs/main/download/1.png" style="position:absolute; transform: translate(-100px,-200px)"></img></div>
        </div>
        <div class="flex" style="height:700px;padding:60px">
          <img src="@/assets/imgs/main/download/gif2.gif" class="gifimg">
        </div>

        

         <div class="flex" style="text-align:left">
           <div style="width:340px"><img src="@/assets/imgs/main/download/2.png" style="position:absolute; transform: translate(-100px,-100px)"></img></div>
          <div>
          <h2>프로젝트를 작업할 폴더를 선택하고</h2>
          <h2>로그인 후 저장소 접속코드를 입력합니다.</h2>
            <br>
          <p>폴더와 저장소를 연결하는 작업입니다. </p>
          </div>     
        </div>
        <div class="flex" style="height:800px;"><img src="@/assets/imgs/main/download/gif3.gif" class="gifimg"></img></div>




        <div class="flex" style="text-align:left;">
          <div>
            <h2>생성된 project 폴더를 IDE로 열어줍니다.</h2>
            <br>
            <h2>변경된 부분을 확인하고</h2>
            <h2>메시지와 함께 push 버튼을 눌러</h2>
            <h2>작업저장소에 저장합니다.</h2>
              <br>
            <p>push는 연견된 저장소의 내 작업저장소에 저장합니다.</p>
          </div>
          <div style="width:340px"><img src="@/assets/imgs/main/download/3.png" style="position:absolute; transform: translate(50px,-100px)"></img></div>
        </div>
        <div class="flex" style="height:750px;padding:60px">
          <img src="@/assets/imgs/main/download/gif4.gif" class="gifimg">
        </div>

        <div class="flex" style="text-align:left">
           <div style="width:340px"><img src="@/assets/imgs/main/download/4.png" style="position:absolute; transform: translate(-100px,-130px)"></img></div>
          <div>
          <h2>프로젝트를 작업할 폴더를 선택하고</h2>
          <h2>로그인 후 저장소 접속코드를 입력합니다.</h2>
           <br></br>
          <p>폴더와 저장소를 연결하는 작업입니다. </p>
          </div>     
        </div>
        <div class="flex" style="height:850px;"><img src="@/assets/imgs/main/download/gif5.gif" class="gifimg"></img></div>


        <div class="flex" style="text-align:left;">
          <div>
            <h2>히스토리에서 가져오고 싶은 </h2>
            <h2>이전 작업내역을 현재 상태로 변경합니다.</h2>
            <br>
            <h2>pull 버튼을 눌러 작업저장소에서 </h2>
            <h2>해당 작업내역을 즉시 가져옵니다.</h2>
             <br></br>
            <p>pull 할 때 현재 작업중인 내역은 소멸됨으로</p>
            <p>push버튼을 눌러 작업저장소 저장후 사용하세요.</p>
          </div>
          <div style="width:340px"><img src="@/assets/imgs/main/download/5.png" style="position:absolute; transform: translate(20px,-100px)"></img></div>
        </div>
        <div class="flex" style="height:800px;padding:60px">
          <img src="@/assets/imgs/main/download/gif6.gif" class="gifimg">
        </div>
        
        
        <div class="flex"></div>

        <div class="flex"><p>GGitSource Made in Taehyeon</p></div>

        <div class="back" ></div>
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