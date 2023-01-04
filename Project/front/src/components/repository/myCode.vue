<template lang="">
    <div class="code_top_container">
        <div class="code_middle_container_right">
           
            <div class="code_navigator">
              <div class="branch_btn">
                <h3>작업 저장소</h3>
              </div>
                <div class="code_btn">
                  <button class="code_btn" @click="toggleOnOff">code </button>
                  <div class="code_menu_top_div"> <!--  -->
                    <div class="code_menu" v-if="isStatusOn">
                        <div class="code_clone">
                          <svg aria-hidden="true" height="14" viewBox="0 -1 16 16" version="1.1" width="14" data-view-component="true" class="octicon octicon-terminal mr-2">
                              <path fill-rule="evenodd" d="M0 2.75C0 1.784.784 1 1.75 1h12.5c.966 0 1.75.784 1.75 1.75v10.5A1.75 1.75 0 0114.25 15H1.75A1.75 1.75 0 010 13.25V2.75zm1.75-.25a.25.25 0 00-.25.25v10.5c0 .138.112.25.25.25h12.5a.25.25 0 00.25-.25V2.75a.25.25 0 00-.25-.25H1.75zM7.25 8a.75.75 0 01-.22.53l-2.25 2.25a.75.75 0 11-1.06-1.06L5.44 8 3.72 6.28a.75.75 0 111.06-1.06l2.25 2.25c.141.14.22.331.22.53zm1.5 1.5a.75.75 0 000 1.5h3a.75.75 0 000-1.5h-3z"></path>
                          </svg> 
                          <div class="clone_string">접속 코드</div>
                        </div>

                        <br>
                        
                          <div class="code_input"><input type="text" id="codeclone" class="code_input_box" data-autoselect :value="clone" readonly/>
                            <button class="code_copy_btn" id="clonebutton" v-on:click="copy"> 
                              <svg aria-hidden="true" height="15" viewBox="0 0 16 16" version="1.1" width="15" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon d-inline-block">
                                  <path fill-rule="evenodd" d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 010 1.5h-1.5a.25.25 0 00-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 00.25-.25v-1.5a.75.75 0 011.5 0v1.5A1.75 1.75 0 019.25 16h-7.5A1.75 1.75 0 010 14.25v-7.5z"></path><path fill-rule="evenodd" d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0114.25 11h-7.5A1.75 1.75 0 015 9.25v-7.5zm1.75-.25a.25.25 0 00-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 00.25-.25v-7.5a.25.25 0 00-.25-.25h-7.5z"></path>
                              </svg>
                            </button>
                          </div>
                          
                      
                        <br>
                        <div class="code_download_div">
                          <div class="code_download" @click="fileDown">
                            <a>
                                <font-awesome-icon icon="fa-regular fa-circle-down" />
                              다운로드
                            </a>
                        </div>
                      </div>  
                    </div>
                  </div>  <!-- -->
                </div>
                  
                <div class="pullreq_div">
                  <button class="merge_btn" @click="pullreqToggleOnOff">
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-git-pull-request UnderlineNav-octicon d-none d-sm-inline">
                      <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                    </svg>
                    병합 요청
                  </button>
                  <div class="pullreq_menu" v-if="isStatusOn2">
                    <div class="pullreq_menu_2">
                      <div class="pullreq_menu_2_1">
                        <svg height="16" width="16" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                          <path d="M64 112c-8.8 0-16 7.2-16 16v22.1L220.5 291.7c20.7 17 50.4 17 71.1 0L464 150.1V128c0-8.8-7.2-16-16-16H64zM48 212.2V384c0 8.8 7.2 16 16 16H448c8.8 0 16-7.2 16-16V212.2L322 328.8c-38.4 31.5-93.7 31.5-132 0L48 212.2zM0 128C0 92.7 28.7 64 64 64H448c35.3 0 64 28.7 64 64V384c0 35.3-28.7 64-64 64H64c-35.3 0-64-28.7-64-64V128z"/>
                        </svg>
                        메시지
                      </div>
                      <div class="pullreq_menu_2_2">
                        <input class="pullreq_menu_input" ref="pullreq_menu_input" type="text" @input="pullreq_menu_input" placeholder="메시지를 입력해주세요">
                      </div>
                    </div>
                    <div class="pullreq_menu_3">
                      <button class="pullreq_menu_3_no" @click="pullreqToggleOnOff">취소</button>
                      <button class="pullreq_menu_3_ok" @click="merge_request()">요청</button>
                    </div>
                  </div>
                </div>
            </div>
            
            <div class="repo_box">
                <div class="repo_information" >
                    <a class="owner_href" >{{push.member_nick}}</a> 
                    <a class="repo_last_commit_content" href="#">{{push.push_message}}</a> 
                    <a class="repo_commit_count" href="#">
                        <svg text="gray" aria-hidden="true" height="15px" viewBox="0 0 16 16" version="1.1" width="15px" data-view-component="true" class="octicon octicon-history">
                            <path fill-rule="evenodd" d="M1.643 3.143L.427 1.927A.25.25 0 000 2.104V5.75c0 .138.112.25.25.25h3.646a.25.25 0 00.177-.427L2.715 4.215a6.5 6.5 0 11-1.18 4.458.75.75 0 10-1.493.154 8.001 8.001 0 101.6-5.684zM7.75 4a.75.75 0 01.75.75v2.992l2.028.812a.75.75 0 01-.557 1.392l-2.5-1A.75.75 0 017 8.25v-3.5A.75.75 0 017.75 4z"></path>
                        </svg>
                        <strong class="commit_count_strong">{{push.commits}}</strong>
                        <span class="commit_count_sapn">commits</span>
                    </a> <!-- 커밋횟수 불러오기 -->
                    <a class="repo_last_commit_time" href="#"><time-ago local="en" :datetime="push.push_date" refresh tooltip long  /></a>
                    <a class="repo_last_commit_token" href="#">{{push.push_token}}</a>
                

                </div>
                <a :href="backURL"><div class="repo_list" style="display:block" v-show="!(path==undefined)">  . . </div></a>
                <div class="repo_list" v-show="loading" style="display:block" v-if="!isEmpty">데이터 불러오는 중...</div>
                <div class="repo_list" v-for="data in file_list"  v-if="!isEmpty">
                  
                  <div class="repo_list_part1" >
                    <a :href="thisURL+'/'+data.name+'?tab=myCode'" v-if="data.state!='file'">
                     <svg v-show="data.directory"  height="16" viewBox="0 0 16 16" version="1.1" width="16"  class="" style="fill:#3db9db">
                        <path d="M1.75 1A1.75 1.75 0 000 2.75v10.5C0 14.216.784 15 1.75 15h12.5A1.75 1.75 0 0016 13.25v-8.5A1.75 1.75 0 0014.25 3H7.5a.25.25 0 01-.2-.1l-.9-1.2C6.07 1.26 5.55 1 5 1H1.75z"></path>
                      </svg>
                      <svg v-show="!data.directory" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" >
                        <path fill-rule="evenodd" d="M3.75 1.5a.25.25 0 00-.25.25v12.5c0 .138.112.25.25.25h9.5a.25.25 0 00.25-.25V6h-2.75A1.75 1.75 0 019 4.25V1.5H3.75zm6.75.062V4.25c0 .138.112.25.25.25h2.688a.252.252 0 00-.011-.013l-2.914-2.914a.272.272 0 00-.013-.011zM2 1.75C2 .784 2.784 0 3.75 0h6.586c.464 0 .909.184 1.237.513l2.914 2.914c.329.328.513.773.513 1.237v9.586A1.75 1.75 0 0113.25 16h-9.5A1.75 1.75 0 012 14.25V1.75z"></path>
                      </svg>
                      {{data.name}}
                    </a>
                    <div class="repo_file_name" v-if="data.state=='file'"  >
                       <svg v-show="!data.directory" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" >
                        <path fill-rule="evenodd" d="M3.75 1.5a.25.25 0 00-.25.25v12.5c0 .138.112.25.25.25h9.5a.25.25 0 00.25-.25V6h-2.75A1.75 1.75 0 019 4.25V1.5H3.75zm6.75.062V4.25c0 .138.112.25.25.25h2.688a.252.252 0 00-.011-.013l-2.914-2.914a.272.272 0 00-.013-.011zM2 1.75C2 .784 2.784 0 3.75 0h6.586c.464 0 .909.184 1.237.513l2.914 2.914c.329.328.513.773.513 1.237v9.586A1.75 1.75 0 0113.25 16h-9.5A1.75 1.75 0 012 14.25V1.75z"></path>
                      </svg>
                      {{data.name}} / {{data.totalLine}}줄
                    </div>
                       <textarea v-if="data.state=='file'"  class="repo_file_content scrollBar" readonly="true">{{data.content}}</textarea>
                  </div>
                    <div class="repo_list_part2" v-if="data.state!='file'">{{data.push_message}}</div>
                    <div class="repo_list_part3" v-if="data.state!='file'"><time-ago  :datetime="data.push_date" refresh tooltip long></time-ago> </div>
                 
                    
                </div>
              
                
            </div>
            
            <div class="readme_container"  v-for="data in file_list" v-if="data.state=='readme'||(data.state=='file'&&data.name=='README.md')" >
                <div class="readme_title">
                    <a class="readme.md">README.md</a>
                </div>

                <div class="readme_content markdown-body"  v-html="readmeContent">
                    
                </div>

            </div>

        </div>
        <div class="code_middle_container_left"  >
            <div class="about_box">
                <h2 class="about_string">About</h2>
                <p class="about_setting_message">{{push.push_message}}</p>
                <div class="readme_link">
                    <a href="#" class="readme_link_href">
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-book mr-2">
                        <path fill-rule="evenodd" d="M0 1.75A.75.75 0 01.75 1h4.253c1.227 0 2.317.59 3 1.501A3.744 3.744 0 0111.006 1h4.245a.75.75 0 01.75.75v10.5a.75.75 0 01-.75.75h-4.507a2.25 2.25 0 00-1.591.659l-.622.621a.75.75 0 01-1.06 0l-.622-.621A2.25 2.25 0 005.258 13H.75a.75.75 0 01-.75-.75V1.75zm8.755 3a2.25 2.25 0 012.25-2.25H14.5v9h-3.757c-.71 0-1.4.201-1.992.572l.004-7.322zm-1.504 7.324l.004-5.073-.002-2.253A2.25 2.25 0 005.003 2.5H1.5v9h3.757a3.75 3.75 0 011.994.574z"></path>
                    </svg>
                    Readme</a>
                </div>
                <div class="stars_link">
                    <a href="#" class="stars_link_href">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-star mr-2">
                            <path fill-rule="evenodd" d="M8 .25a.75.75 0 01.673.418l1.882 3.815 4.21.612a.75.75 0 01.416 1.279l-3.046 2.97.719 4.192a.75.75 0 01-1.088.791L8 12.347l-3.766 1.98a.75.75 0 01-1.088-.79l.72-4.194L.818 6.374a.75.75 0 01.416-1.28l4.21-.611L7.327.668A.75.75 0 018 .25zm0 2.445L6.615 5.5a.75.75 0 01-.564.41l-3.097.45 2.24 2.184a.75.75 0 01.216.664l-.528 3.084 2.769-1.456a.75.75 0 01.698 0l2.77 1.456-.53-3.084a.75.75 0 01.216-.664l2.24-2.183-3.096-.45a.75.75 0 01-.564-.41L8 2.694v.001z"></path>
                        </svg> {{star.length}} stars
                    </a>    
                </div>
         

            </div>
           <div class="contributors_box">
                <h2 class="contributor_h2">
                    Contributor
                    <span class="contributor_member_count">{{contributors.length}}</span>
                </h2>
                
                <ul>
                    <div v-for="contributor,idx in contributors" class="contributors_div">
             
                      <div><a :href="'/'+contributor.member_nick"><img :src="profileImg[idx]"  class="contributor_member_img"/>   </a></div>
                      <div class="contributor_member_list"><a :href="'/'+contributor.member_nick">{{contributor.member_nick}}  </a></div>
                   
                    </div>
                </ul>
            </div>

        </div>
    </div>

    
</template>
<script>
import axios from "axios";
import marked from "marked";
import store from "../../vuex/store";
import { TimeAgo } from "vue2-timeago";

export default {
  data() {
    return {
      file_list: [],
      push: [],
      contributors: [],
      star: [],
      clone: "",
      thisURL: window.location.href.split("?")[0],
      backURL:
        window.location.href.replace(
          "/" +
            window.location.href.split("/")[
              window.location.href.split("/").length - 1
            ],
          ""
        ) + "?tab=myCode",
      repoIdx: 0,
      readmeContent: "",
      loading: true,
      isStatusOn: false,
      isStatusOn2: false,
      path: this.$route.params.path,
      profileImg: [],
      i: 0,
      isEmpty: false,
      pullreq_menu_input_keyword: "",
    };
  },
  components: {
    TimeAgo,
  },
  methods: {
    toggleOnOff: function () {
      this.isStatusOn = !this.isStatusOn;
      if (this.isStatusOn2 == true) {
        this.isStatusOn2 = !this.isStatusOn2;
      }
    },
    pullreqToggleOnOff: function () {
      this.isStatusOn2 = !this.isStatusOn2;
      if (this.isStatusOn == true) {
        this.isStatusOn = !this.isStatusOn;
      }
    },
    fileDown: function () {
      axios
        .get("/api/download", {
          responseType: "blob",
          params: {
            repo: this.repoIdx,
            token: this.push.push_token,
          },
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

    copy: function (val) {
      const copyText = document.getElementById("codeclone");
      copyText.select();
      document.execCommand("copy");
      alert("코드가 복사 되었습니다.");
    },
    selectRepoClone() {
      axios
        .get("/api/selectRepoClone", {
          params: {
            repoIdx: this.repoIdx,
          },
        })
        .then((response) => {
          this.clone = response.data;

          // console.log(this.clone);
          //alert(this.clone);
        });
    },
    changeMD(content) {
      marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        headerIds: false,
        tables: true,
        breaks: true,
        pedantic: false,
        sanitize: true,
        smartLists: true,
        smartypants: false,
      });
      let changedText = marked(content);
      changedText = changedText.replaceAll("&lt;", "<");
      changedText = changedText.replaceAll("&gt;", ">");
      changedText = changedText.replaceAll("&quot;", '"');
      this.readmeContent = changedText;
    },
    getFile() {
      axios
        .get("/api/getFile", {
          params: {
            repoIdx: this.repoIdx,
            token: this.push.push_token,
            path: this.$route.params.path,
          },
        })
        .then((response) => {
          this.file_list = response.data;
          console.log(this.file_list);

          if (this.file_list[0].state == "file") {
            //현재 위치가 파일인경우
            if (this.file_list[0].name == "README.md") {
              this.changeMD(this.file_list[0].content);
            }
          } else if (this.file_list[0].state == "notPath") {
            window.location.href = "/pagenotfound";
          } else if (this.file_list[0].state == "empty") {
            this.isEmpty = true;
          } else {
            //현재 위치가 폴더인경우
            for (var i = 0; i < this.file_list.length; i++) {
              if (this.file_list[i].state == "readme") {
                //리드미가 있을경우 리드미를 md파일 형태로 화면에 출력한다
                this.changeMD(this.file_list[i].content);
              }
            }
          }
          this.loading = false;
          this.getContriImg();
          // alert(this.star)
        });
    },

    selectRepositorystar() {
      axios
        .get("/api/selectRepositorystar", {
          params: {
            repoIdx: this.repoIdx,
          },
        })
        .then((response) => {
          this.star = response.data;
          this.getFile();
          // console.log(this.star)
          // alert(this.star)
        });
    },
    selectRepositorycontributors() {
      axios
        .get("/api/selectRepositorycontributors", {
          params: {
            repoIdx: this.repoIdx,
          },
        })
        .then((response) => {
          this.contributors = response.data;
          // console.log(this.contributors)
          // alert(this.contributors)
          this.selectRepositorystar();
        });
    },
    selectRepositorycode() {
      axios
        .get("/api/selectRepositoryMyCode", {
          params: {
            repoIdx: this.repoIdx,
            member: store.getters.getUserIdx,
          },
        })
        .then((response) => {
          this.push = response.data;

          // console.log(this.push);
          this.selectRepositorycontributors();
        });
    },
    repoIdxByNickName() {
      // 저장소 idx 조회하기
      axios
        .get("/api/repoIdxByNickName", {
          params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          this.repoIdx = response.data;
          // this.selectByRepoMem(); // 저장소에 속해있는 유저인지 조회하는 메소드
          this.selectRepositorycode();
          this.selectRepoClone();
          //
        });
    },
    getContriImg() {
      axios
        .get("/api/getProfileImg", {
          responseType: "blob",
          params: {
            img: this.contributors[this.i].member_img,
          },
        })
        .then((response) => {
          // handle success
          this.profileImg.push(
            window.URL.createObjectURL(new Blob([response.data]))
          );
          this.i++;
          if (this.i < this.contributors.length) {
            this.getContriImg();
          }
        });
    },
    selectByRepoMem() {
      axios
        .post("/api/repoMemCheck", {
          repo_idx: this.repoIdx,
          u_idx: store.getters.getUserIdx,
        })
        .then((response) => {
          if (response.data.idx == undefined) {
            this.noMem = "display:inline"; // 저장소에 멤버가 아닌 경우
          } else {
            this.inMem = "display:inline"; // 저장소 멤버인 경우
          }
        });
    },
    merge_request() {
      if (this.pullreq_menu_input_keyword.trim() == "") {
        alert("메시지를 작성해주세요");
        this.$refs.pullreq_menu_input.focus();
      } else {
        axios
          .post("/api/merge_request", {
            u_idx: store.getters.getUserIdx,
            repo_idx: this.repoIdx,
            token: this.push.push_token,
            message: this.pullreq_menu_input_keyword,
          })
          .then((response) => {
            console.log(response.data);
            if (response.data >= 1) {
              alert("요청 완료");
              this.isStatusOn2 = false;
            } else {
              alert("요청 에러");
            }
          });
      }
    },
    pullreq_menu_input(e) {
      this.pullreq_menu_input_keyword = e.target.value;
    },
  }, // method

  mounted() {
    this.repoIdxByNickName();
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/code"
@import "src/assets/sass/reset/markdown"
</style>