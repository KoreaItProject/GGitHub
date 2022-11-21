<template lang="">
    <div class="code_top_container">
        <div class="code_middle_container_right">
           
            <div class="code_navigator">
                <div class="branch_btn">
                    <select name="barnch_select" class="branch_select_btn">
                        <option value="main" selected>main</option> 

                    </select>
                </div>
                <div class="code_btn">
                    
                     <button class="code_btn">code</button>
                    

                </div>
            </div>
            <div class="repo_box">
                <div class="repo_information" >
                    <a class="owner_href" :href='hrefNick'>{{push.member_nick}}</a> 
                    <a class="repo_last_commit_content" href="#">{{push.push_message}}</a> 
                    <a class="repo_commit_count" href="#">
                        <svg text="gray" aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-history">
                            <path fill-rule="evenodd" d="M1.643 3.143L.427 1.927A.25.25 0 000 2.104V5.75c0 .138.112.25.25.25h3.646a.25.25 0 00.177-.427L2.715 4.215a6.5 6.5 0 11-1.18 4.458.75.75 0 10-1.493.154 8.001 8.001 0 101.6-5.684zM7.75 4a.75.75 0 01.75.75v2.992l2.028.812a.75.75 0 01-.557 1.392l-2.5-1A.75.75 0 017 8.25v-3.5A.75.75 0 017.75 4z"></path>
                        </svg>
                        <strong class="commit_count_strong">{{push.commits}}</strong>
                        <span class="commit_count_sapn">commits</span>
                    </a> <!-- 커밋횟수 불러오기 -->
                    <a class="repo_last_commit_time" href="#">{{push.push_date}}</a>
                    <a class="repo_last_commit_token" href="#">{{push.push_token}}</a>
                

                </div>
                <div class="repo_list" v-for="data in file_list"  >
                    <a :href="thisURL+'/'+data.name" v-if="data.state!='file'">
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
                      {{data.name}}
                    </div>
                    <textarea v-if="data.state=='file'"  class="repo_file_content scrollBar" readonly="true">{{data.content}}</textarea>
                    
                </div>
            </div>
            <div class="readme_container"  v-for="data in file_list" v-if="data.state=='readme'" >
                <div class="readme_title">
                    <a class="readme.md" href="#">README.md</a>
                    <a class="readme edit" href="#">
                        <svg v-show="" aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-pencil">
                            <path fill-rule="evenodd" d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"></path>
                        </svg>
                    </a>
                </div>

                <div class="readme_content markdown-body"  v-html="readmeContent">
                    
                </div>

            </div>

        </div>
        <div class="code_middle_container_left"  >
            <div class="about_box">
                <h2 class="about_string">About</h2>
                <p class="about_setting_message">협업, 형상 관리 프로그램</p>
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
                <div class="fork_link">
                    <a href="#" class="fork_link_href">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-repo-forked mr-2">
                            <path fill-rule="evenodd" d="M5 3.25a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm0 2.122a2.25 2.25 0 10-1.5 0v.878A2.25 2.25 0 005.75 8.5h1.5v2.128a2.251 2.251 0 101.5 0V8.5h1.5a2.25 2.25 0 002.25-2.25v-.878a2.25 2.25 0 10-1.5 0v.878a.75.75 0 01-.75.75h-4.5A.75.75 0 015 6.25v-.878zm3.75 7.378a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm3-8.75a.75.75 0 100-1.5.75.75 0 000 1.5z"></path>
                        </svg>
                         {{push.repo_fork}} fork
                    </a>
                </div>

            </div>
            <div class="contributors_box">
                <h2 class="contributor_h2">
                    Contributor
                    <span class="contributor_member_count">{{contributors.length}}</span>
                </h2>
                
                <ul>
                    <div v-for="contributor in contributors">
                    <span><li class="contributor_member_img">{{contributor.member_img}}</li></span>
                    <span><li class="contributor_member_list">{{contributor.member_nick}}</li></span>
                    </div>
                </ul>
            </div>

        </div>
    </div>

    
</template>
<script>
import axios from "axios";
import marked from "marked";
export default {
  data() {
    return {
      file_list: [],
      push: [],
      contributors: [],
      star: [],
      thisURL: window.location.href.split("?")[0],
      repoIdx: 0,
      readmeContent: "",
    };
  },

  methods: {
    getFile() {
      axios
        .get("/api/getFile", {
          params: {
            repoIdx: this.repoIdx,
            token: "asda231",
            path: this.$route.params.path,
          },
        })
        .then((response) => {
          this.file_list = response.data;
          console.log(this.file_list);

          if (this.file_list[0].state == "file") {
            //현재 위치가 파일인경우
          } else {
            //현재 위치가 폴더인경우
            for (var i = 0; i < this.file_list.length; i++) {
              if (this.file_list[i].state == "readme") {
                //리드미가 있을경우 리드미를 md파일 형태로 화면에 출력한다
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
                let changedText = marked(this.file_list[i].content);
                changedText = changedText.replaceAll("&lt;", "<");
                changedText = changedText.replaceAll("&gt;", ">");
                changedText = changedText.replaceAll("&quot;", '"');
                this.readmeContent = changedText;
              }
            }
          }

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
        .get("/api/selectRepositorycode", {
          params: {
            repoIdx: this.repoIdx,
          },
        })
        .then((response) => {
          this.push = response.data;
          console.log(this.push);
          this.selectRepositorycontributors();
        });
    },
    repoIdxByNickName() {
      axios
        .get("/api/repoIdxByNickName", {
          params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          this.repoIdx = response.data;
          if (this.repoIdx == 0) {
            window.location.href = "/pagenotfound";
          }
          this.selectRepositorycode();

          //
        });
    },
  },
  mounted() {
    this.repoIdxByNickName();
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/code"
@import "src/assets/sass/reset/markdown"
</style>