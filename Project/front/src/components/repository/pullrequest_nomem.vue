<template lang="">
    <div class="pullrequest_nomem_container">
        <div class="pullrequest_nomem_name">
            병합 요청 (외부)
        </div>
        <div class="pullreq_main_list">
            <div class="pullreq_main_header">
                <div class="pullreq_main_body_icon">
                    <span class="pullreq_main_body_icon_span">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="color-fg-color">
                            <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                        </svg>
                    </span>
                </div>
                <div class="repository_history_tit_left">
                      {{pullreqData.length}}개의 병합 요청
                  </div>
             

                <div class="repository_history_tit_right">
                  <span class="green_point">  <i class="fa-solid fa-arrows-turn-to-dots "></i></span> 비교병합  <span class="orange_point">  <i class="fa fa-bolt"></i></span>빠른병합
                </div>
            </div>

            <div class="pullreq_main_body" v-for="(Data,index) in pullreqData">    
                <div class="pullreq_main_body_flex" @click="pullreqUserData(Data.token)">
                    <div class="pullreq_main_body_icon">
                        <span class="pullreq_main_body_icon_span">
                            <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="color-fg-color">
                                <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                            </svg>
                        </span>
                    </div>
                    <div class="pullreq_main_body_innerdiv">
                     
                      <a class="pullreq_main_body_nick blue_point":href="'/'+Data.nick">
                        {{Data.nick}}
                      </a>

                      <span class="pullreq_main_body_a"  ><h4>{{Data.message}}</h4></span>
                    </div>
                    <div class="pullreq_main_body_btn_div">
                      <div class="btn" @click="pullreqUserData(Data.token, Data.repo)">  
                        
                        <span class="green_point"> <i class="fa-solid fa-arrows-turn-to-dots " v-if="Data.nowToken!=Data.mainToken"></i> </span>
                          <span class="orange_point"> <i class="fa fa-bolt"  v-if="Data.nowToken==Data.mainToken"></i>
                        </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      pullreqData_length: "",
      pullreqData: [],
    };
  },
  mounted() {
    this.find_repo();
    // this.mergeRequest()
  },
  methods: {
    pullreqUserData(token, repo_idx) {
      this.$emit("merge_func", token, repo_idx);
      //this.$emit("merge_func2", repo_idx);
    },
    find_repo() {
      // 존재하는 저장소인지 확인하자
      axios
        .get("/api/repoIdxByNickName", {
          params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          if (response.data == "") {
            location.href = "/pagenotfound";
          } else {
            axios
              .post("/api/pullreq_select", {
                idx: response.data,
              })
              .then((response) => {
                this.pullreqData = response.data;
              });
          }
        });
    },
    mergeRequest() {},
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/pullrequest"
</style>