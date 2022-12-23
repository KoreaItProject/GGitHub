<template lang="">
  <div class="repository_container">
      <div class="repository_top_container">
          <div class="repository_top_div">
              <div class="repository_name_div">
                  <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-repo color-fg-muted mr-2">
                      <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
                  </svg>
                  <a class="repository_nick" :href='hrefNick'>{{$route.params.nick}}</a>/
                  <a class="repository_name" :href="hrefRepository"> {{$route.params.repository}}</a>
                  <div class="repository_public" v-if="publ"> public </div>
                  <div class="repository_public" v-if="!publ"> private </div>
              </div>
              <div class="repository_btn_div">
                <div v-if="idx != null"> <!-- idx가 null이 아닐때만! 즉, 로그인이 됐으면 보여주고 아니면 안보여주고 -->
                  <span v-if="pin_btn_state == true"> <!-- 내가 속한 저장소이면 보이고 아니면 안보이고 -->
                    <span v-if="pin_Check == false">
                      <button class="repository_btn_pin repository_btn" @click="pin_btn_click()">
                          <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-pin mr-2">
                              <path fill-rule="evenodd" d="M4.456.734a1.75 1.75 0 012.826.504l.613 1.327a3.081 3.081 0 002.084 1.707l2.454.584c1.332.317 1.8 1.972.832 2.94L11.06 10l3.72 3.72a.75.75 0 11-1.061 1.06L10 11.06l-2.204 2.205c-.968.968-2.623.5-2.94-.832l-.584-2.454a3.081 3.081 0 00-1.707-2.084l-1.327-.613a1.75 1.75 0 01-.504-2.826L4.456.734zM5.92 1.866a.25.25 0 00-.404-.072L1.794 5.516a.25.25 0 00.072.404l1.328.613A4.582 4.582 0 015.73 9.63l.584 2.454a.25.25 0 00.42.12l5.47-5.47a.25.25 0 00-.12-.42L9.63 5.73a4.581 4.581 0 01-3.098-2.537L5.92 1.866z"></path>
                          </svg>
                          고정
                      </button>
                    </span>
                    <span v-if="pin_Check == true">
                      <button class="repository_btn_pin repositoryOff_btn" @click="pin_off_btn_click()">
                          <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-pin mr-2">
                              <path fill-rule="evenodd" d="M4.456.734a1.75 1.75 0 012.826.504l.613 1.327a3.081 3.081 0 002.084 1.707l2.454.584c1.332.317 1.8 1.972.832 2.94L11.06 10l3.72 3.72a.75.75 0 11-1.061 1.06L10 11.06l-2.204 2.205c-.968.968-2.623.5-2.94-.832l-.584-2.454a3.081 3.081 0 00-1.707-2.084l-1.327-.613a1.75 1.75 0 01-.504-2.826L4.456.734zM5.92 1.866a.25.25 0 00-.404-.072L1.794 5.516a.25.25 0 00.072.404l1.328.613A4.582 4.582 0 015.73 9.63l.584 2.454a.25.25 0 00.42.12l5.47-5.47a.25.25 0 00-.12-.42L9.63 5.73a4.581 4.581 0 01-3.098-2.537L5.92 1.866z"></path>
                          </svg>
                          고정해제
                      </button>
                    </span>
                  </span>
            
                  <button class="repository_btn_star repository_btn">
                      <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-star d-inline-block mr-2">
                          <path fill-rule="evenodd" d="M8 .25a.75.75 0 01.673.418l1.882 3.815 4.21.612a.75.75 0 01.416 1.279l-3.046 2.97.719 4.192a.75.75 0 01-1.088.791L8 12.347l-3.766 1.98a.75.75 0 01-1.088-.79l.72-4.194L.818 6.374a.75.75 0 01.416-1.28l4.21-.611L7.327.668A.75.75 0 018 .25zm0 2.445L6.615 5.5a.75.75 0 01-.564.41l-3.097.45 2.24 2.184a.75.75 0 01.216.664l-.528 3.084 2.769-1.456a.75.75 0 01.698 0l2.77 1.456-.53-3.084a.75.75 0 01.216-.664l2.24-2.183-3.096-.45a.75.75 0 01-.564-.41L8 2.694v.001z"></path>
                      </svg>
                      즐겨찾기
                  </button>
                </div>
              </div>
          </div>
          <div class="repository_tab_div" :style="cssVariable" >
              <a :href="'/'+nick+'/'+repository+'?tab=code'">
                 <span class="repository_tab repository_tab1">
                <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-code UnderlineNav-octicon d-none d-sm-inline">
                      <path fill-rule="evenodd" d="M4.72 3.22a.75.75 0 011.06 1.06L2.06 8l3.72 3.72a.75.75 0 11-1.06 1.06L.47 8.53a.75.75 0 010-1.06l4.25-4.25zm6.56 0a.75.75 0 10-1.06 1.06L13.94 8l-3.72 3.72a.75.75 0 101.06 1.06l4.25-4.25a.75.75 0 000-1.06l-4.25-4.25z"></path>
                  </svg>
                  저장소
                  </span>
              </a>
              
              <a :href="'/'+nick+'/'+repository+'?tab=myCode'">
                  <span class="repository_tab repository_tab5">
                  <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-code UnderlineNav-octicon d-none d-sm-inline">
                      <path fill-rule="evenodd" d="M4.72 3.22a.75.75 0 011.06 1.06L2.06 8l3.72 3.72a.75.75 0 11-1.06 1.06L.47 8.53a.75.75 0 010-1.06l4.25-4.25zm6.56 0a.75.75 0 10-1.06 1.06L13.94 8l-3.72 3.72a.75.75 0 101.06 1.06l4.25-4.25a.75.75 0 000-1.06l-4.25-4.25z"></path>
                  </svg>
                  작업 저장소
                  </span>
              </a>
              <a :href="'/'+nick+'/'+repository+'?tab=history'" >
                  <span class="repository_tab repository_tab2">
                  <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-git-branch">
                      <path fill-rule="evenodd" d="M11.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122V6A2.5 2.5 0 0110 8.5H6a1 1 0 00-1 1v1.128a2.251 2.251 0 11-1.5 0V5.372a2.25 2.25 0 111.5 0v1.836A2.492 2.492 0 016 7h4a1 1 0 001-1v-.628A2.25 2.25 0 019.5 3.25zM4.25 12a.75.75 0 100 1.5.75.75 0 000-1.5zM3.5 3.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0z"></path>
                  </svg>
                  히스토리
                  </span>
              </a>
              <a :href="'/'+nick+'/'+repository+'?tab=pullrequest'" v-if="isLogin&&pin_btn_state" >
                  <span class="repository_tab repository_tab3">
                  <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-git-pull-request UnderlineNav-octicon d-none d-sm-inline">
                      <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                  </svg>
                  병합 요청
                  </span>
              </a>
                <a :href="'/'+nick+'/'+repository+'?tab=setting'" v-if="isLogin&&pin_btn_state">
                  <span class="repository_tab repository_tab4">
                  <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-gear UnderlineNav-octicon d-none d-sm-inline">
                      <path fill-rule="evenodd" d="M7.429 1.525a6.593 6.593 0 011.142 0c.036.003.108.036.137.146l.289 1.105c.147.56.55.967.997 1.189.174.086.341.183.501.29.417.278.97.423 1.53.27l1.102-.303c.11-.03.175.016.195.046.219.31.41.641.573.989.014.031.022.11-.059.19l-.815.806c-.411.406-.562.957-.53 1.456a4.588 4.588 0 010 .582c-.032.499.119 1.05.53 1.456l.815.806c.08.08.073.159.059.19a6.494 6.494 0 01-.573.99c-.02.029-.086.074-.195.045l-1.103-.303c-.559-.153-1.112-.008-1.529.27-.16.107-.327.204-.5.29-.449.222-.851.628-.998 1.189l-.289 1.105c-.029.11-.101.143-.137.146a6.613 6.613 0 01-1.142 0c-.036-.003-.108-.037-.137-.146l-.289-1.105c-.147-.56-.55-.967-.997-1.189a4.502 4.502 0 01-.501-.29c-.417-.278-.97-.423-1.53-.27l-1.102.303c-.11.03-.175-.016-.195-.046a6.492 6.492 0 01-.573-.989c-.014-.031-.022-.11.059-.19l.815-.806c.411-.406.562-.957.53-1.456a4.587 4.587 0 010-.582c.032-.499-.119-1.05-.53-1.456l-.815-.806c-.08-.08-.073-.159-.059-.19a6.44 6.44 0 01.573-.99c.02-.029.086-.075.195-.045l1.103.303c.559.153 1.112.008 1.529-.27.16-.107.327-.204.5-.29.449-.222.851-.628.998-1.189l.289-1.105c.029-.11.101-.143.137-.146zM8 0c-.236 0-.47.01-.701.03-.743.065-1.29.615-1.458 1.261l-.29 1.106c-.017.066-.078.158-.211.224a5.994 5.994 0 00-.668.386c-.123.082-.233.09-.3.071L3.27 2.776c-.644-.177-1.392.02-1.82.63a7.977 7.977 0 00-.704 1.217c-.315.675-.111 1.422.363 1.891l.815.806c.05.048.098.147.088.294a6.084 6.084 0 000 .772c.01.147-.038.246-.088.294l-.815.806c-.474.469-.678 1.216-.363 1.891.2.428.436.835.704 1.218.428.609 1.176.806 1.82.63l1.103-.303c.066-.019.176-.011.299.071.213.143.436.272.668.386.133.066.194.158.212.224l.289 1.106c.169.646.715 1.196 1.458 1.26a8.094 8.094 0 001.402 0c.743-.064 1.29-.614 1.458-1.26l.29-1.106c.017-.066.078-.158.211-.224a5.98 5.98 0 00.668-.386c.123-.082.233-.09.3-.071l1.102.302c.644.177 1.392-.02 1.82-.63.268-.382.505-.789.704-1.217.315-.675.111-1.422-.364-1.891l-.814-.806c-.05-.048-.098-.147-.088-.294a6.1 6.1 0 000-.772c-.01-.147.039-.246.088-.294l.814-.806c.475-.469.679-1.216.364-1.891a7.992 7.992 0 00-.704-1.218c-.428-.609-1.176-.806-1.82-.63l-1.103.303c-.066.019-.176.011-.299-.071a5.991 5.991 0 00-.668-.386c-.133-.066-.194-.158-.212-.224L10.16 1.29C9.99.645 9.444.095 8.701.031A8.094 8.094 0 008 0zm1.5 8a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM11 8a3 3 0 11-6 0 3 3 0 016 0z"></path>
                  </svg>
                    설정
                  </span>
              </a>
          </div>

      </div>
      <div class="repository_content_container">
          <code-view v-if="isCode"/>
          <myCode-view v-if="isMyCode"/>
          <history-view v-if="isHistory"/>
          <pullrequest-view v-if="isPullrequest"/>
          <setting-view v-if="isSetting"/>
      </div>
  </div>
</template>

<script>
import code from "@/components/repository/code.vue";
import myCode from "@/components/repository/myCode.vue";

import history from "@/components/repository/history/history.vue";
import pullrequest from "@/components/repository/pullrequest.vue";
import setting from "@/components/repository/setting/setting.vue";
import axios from "axios";
import store from "../../vuex/store";

export default {
  data() {
    return {
      idx: store.getters.getUserIdx,
      nick: this.$route.params.nick,
      hrefNick: "/" + this.$route.params.nick,
      repository: this.$route.params.repository,
      hrefRepository:
        "/" + this.$route.params.nick + "/" + this.$route.params.repository,
      isCode: false,
      isMyCode: false,
      isHistory: false,
      isPullrequest: false,
      isSetting: false,
      tab1_color: "0px",
      tab2_color: "0px",
      tab3_color: "0px",
      tab4_color: "0px",
      tab5_color: "0px",

      pin_btn_state: false, //  pin 버튼 보일지 말지 여부 true/false
      repo_idx: 0,
      pin_Check: false,
      isLogin: store.getters.getIsLogin,
      publ: true,
    };
  },
  computed: {
    cssVariable() {
      return {
        "--tab1_color": this.tab1_color,
        "--tab2_color": this.tab2_color,
        "--tab3_color": this.tab3_color,
        "--tab4_color": this.tab4_color,
        "--tab5_color": this.tab5_color,
      };
    },
  },
  components: {
    "code-view": code,
    "myCode-view": myCode,
    "history-view": history,
    "pullrequest-view": pullrequest,
    "setting-view": setting,
  },
  mounted() {
    let tab = this.$route.query.tab;
    if (tab == "history") {
      if (!this.isLogin) {
        window.location.href = "/login";
      }
      this.isHistory = true;
      this.tab2_color = "4px";
    } else if (tab == "pullrequest" && !this.isLogin && pin_btn_state) {
      this.isPullrequest = true;
      this.tab3_color = "4px";
    } else if (tab == "setting" && !this.isLogin && pin_btn_state) {
      this.isSetting = true;
      this.tab4_color = "4px";
    } else if (tab == "myCode") {
      if (!this.isLogin) {
        window.location.href = "/login";
      }
      this.isMyCode = true;
      this.tab5_color = "4px";
    } else {
      this.isCode = true;
      this.tab1_color = "4px";
    }

    this.getRepoIdx_RepoMemCheck(); // 저장소 idx 가져온 후 내가 속해있는 저장소인지 확인하자
  },
  methods: {
    getPublic() {
      axios
        .get("/api/getPublic", {
          params: {
            nick: this.$route.params.nick,
            repoName: this.$route.params.repository,
          },
        })
        .then((response) => {
          // 내가 속한 저장소인지 확인하자

          if (response.data == 0 && !this.pin_btn_state) {
            window.location.href = "/pagenotfound";
          } else {
            if (response.data == 0) {
              this.publ = false;
            } else {
              this.publ = true;
            }
          }
        });
    },
    pin_btn_click() {
      axios
        .post("/api/pinClick", {
          // DB(pin 테이블)에 해당 저장소정보를 저장
          u_idx: this.idx, // 로그인한 유저의 idx
          repo_idx: this.repo_idx, // 현재 저장소 idx
          sort_idx: 0,
        })
        .then((response) => {
          if (
            response.data != "" ||
            response.data != null ||
            response.data != undefined
          ) {
            this.pin_Check = true;
          }
        });
    },
    getRepoIdx_RepoMemCheck() {
      // 저장소 idx 가져오기
      axios
        .get("/api/repoIdxByNickName", {
          params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          // 내가 속한 저장소인지 확인하자
          if (response.data == 0) {
            window.location.href = "/pagenotfound";
          }
          this.repo_idx = response.data; // 저장소 idx 할당
          this.pinCheck(); // 고정이 되어있는 저장소라면 고정(pin)버튼을 고정해제로 바꿔주자
          //if (this.idx != null) {
          // 로그인이 돼있는 상태라면
          //로그인이 안돼있는 상태에서도 public 인지 아닌지 판단할때 필요한 정보라 if문 뺐음 - 이태현
          axios
            .post("/api/repoMemCheck", {
              // pin버튼 보일지 말지
              repo_idx: response.data, // response.data => 저장소 idx
              u_idx: this.idx,
            })
            .then((response) => {
              if (response.data.idx != undefined) {
                this.pin_btn_state = true;
              } else {
                this.pin_btn_state = false;
              }

              this.getPublic();
            });
          //}
        });
    },
    pinCheck() {
      // 고정이 되어있는 저장소라면 고정(pin)버튼을 바꿔주자
      axios
        .post("/api/pinCheck", {
          repo_idx: this.repo_idx,
          u_idx: this.idx,
        })
        .then((response) => {
          // 조회된 데이터가 없을때
          if (
            response.data == "" ||
            response.data == null ||
            response.data == undefined
          ) {
            this.pin_Check = false; // 고정
          } else if (
            response.data != "" ||
            response.data != null ||
            response.data != undefined
          ) {
            // 조회된 데이터가 있을때
            this.pin_Check = true; // 고정 해제
          }
        });
    },
    pin_off_btn_click() {
      // 고정해제 버튼 클릭시 pin 테이블에서 해당 데이터 삭제
      axios
        .post("/api/pinClickOff", {
          repo_idx: this.repo_idx,
          u_idx: this.idx,
        })
        .then((response) => {
          if (response.data > 0) {
            this.pin_Check = false;
          }
        });
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/repository"
</style>