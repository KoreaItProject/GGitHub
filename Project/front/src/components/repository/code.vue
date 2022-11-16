<template lang="">
    <div class="code_top_container">
        <div class="code_middle_container_right">
           
            <div class="code_navigator">
                <div class="branch_btn">
                    <select name="barnch_select" class="branch_select_btn">
                        <option value="main" selected>main</option> <!--나중에 v-for문 으로 브랜치 목록 불러오기-->

                    </select>
                </div>
                <div class="code_btn">
                    
                     <button class="code_btn">code</button>
                    

                </div>
            </div>
            <div class="repo_box">
                <div class="repo_information" >
                    <a class="owner_href" href="#">{{push.member_nick}}</a> <!-- v-for문으로 레포 소유자 불러오기 -->
                    <a class="repo_last_commit_content" href="#">{{push.push_message}}</a> <!-- v-for문으로 마지막 커밋 내용 불러오기  -->
                    <a class="repo_commit_count" href="#">
                        <svg text="gray" aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-history">
                            <path fill-rule="evenodd" d="M1.643 3.143L.427 1.927A.25.25 0 000 2.104V5.75c0 .138.112.25.25.25h3.646a.25.25 0 00.177-.427L2.715 4.215a6.5 6.5 0 11-1.18 4.458.75.75 0 10-1.493.154 8.001 8.001 0 101.6-5.684zM7.75 4a.75.75 0 01.75.75v2.992l2.028.812a.75.75 0 01-.557 1.392l-2.5-1A.75.75 0 017 8.25v-3.5A.75.75 0 017.75 4z"></path>
                        </svg>
                        <strong class="commit_count_strong">42</strong>
                        <span class="commit_count_sapn">commits</span>
                    </a> <!-- 커밋횟수 불러오기 -->
                    <a class="repo_last_commit_time" href="#">{{push.push_date}}</a> <!-- v-for 문으로 마지막으로 커밋한날 불러오기 -->
                    <a class="repo_last_commit_token" href="#">{{push.push_token}}</a> <!-- v-for 토큰값 불러오기 -->
                

                </div>
                <div class="repo_list" v-for="name in file_list">
                    <a href="#">{{name}}</a>
                    
                </div>
            </div>
            <div class="readme_container">
                <div class="readme_title">
                    <a class="readme.md" href="#">Readme.md</a>
                    <a class="readme edit" href="#">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-pencil">
                            <path fill-rule="evenodd" d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"></path>
                        </svg>
                    </a>
                </div>

                <div class="readme_content">
                     <h1 class="readme_h1_title">GGitHub</h1>
                     
                     협업, 형상관리 사이트
                     
                     프로젝트 기간 : 2022-10-10~
                     
                     웹 프로젝트 : Project
                     
                     소스관리 프로그램 : GGitSource
                </div>

            </div>

        </div>
        <div class="code_middle_container_left">
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
                        </svg> 4 stars
                    </a>    
                </div>
                <div class="fork_link">
                    <a href="#" class="fork_link_href">
                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-repo-forked mr-2">
                            <path fill-rule="evenodd" d="M5 3.25a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm0 2.122a2.25 2.25 0 10-1.5 0v.878A2.25 2.25 0 005.75 8.5h1.5v2.128a2.251 2.251 0 101.5 0V8.5h1.5a2.25 2.25 0 002.25-2.25v-.878a2.25 2.25 0 10-1.5 0v.878a.75.75 0 01-.75.75h-4.5A.75.75 0 015 6.25v-.878zm3.75 7.378a.75.75 0 11-1.5 0 .75.75 0 011.5 0zm3-8.75a.75.75 0 100-1.5.75.75 0 000 1.5z"></path>
                        </svg>
                         1 fork
                    </a>
                </div>

            </div>
            <div class="contributors_box">
                <h2 class="contributor_h2">
                    Contributor
                    <span class="contributor_member_count"> 3 </span>
                </h2>
                
                <ul>
                    <li class="contributor_member_list">gddd</li>
                </ul>
            </div>

        </div>
    </div>

    
</template>
<script>
import axios from 'axios';
export default {
  data() {
    return {
     file_list: ["ddd", "aaa", "asd", "lkj213"],member: ["leetahhyeon123", "eak00700", "JIN-RYEOL"],
     push: [],
     repoIdx:0,
    };
  },
  methods: {},
  mounted() {
    axios
    .get("/api/repoIdxByNickName",{
        params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository

        },
    })
    .then((response) => {
        this.repoIdx = response.data;
        
                axios
            .get("/api/selectRepositorycode",{
                params: {
                    repoIdx: this.repoIdx
                

                },
            })
            .then((response) => {
                
                this.push = response.data;
                // console.log(this.push)
                
            }) 
            .catch((error) => {
                // handle error
                
                console.log(error);
            })
            .finally(() => {
                // always executed
            });

            // axios
            // .get("/api/selectRepositorycontributors",{
            //     params: {
            //         repoIdx: this.repoIdx
                

            //     },
            // })
            // .then((response) => {
                
            //     this.contri = response.data;
            //     // console.log(this.push)
            //     alert(this.contri)
            // }) 
            // .catch((error) => {
            //     // handle error
                
            //     console.log(error);
            // })
            // .finally(() => {
            //     // always executed
            // });
        
    }) 
    .catch((error) => {
        // handle error
        
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
      //
  
    
  },
};

</script>
<style lang="sass">
@import "src/assets/sass/repository/code"
</style>