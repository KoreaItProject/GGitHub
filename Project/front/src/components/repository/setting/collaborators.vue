</template><template lang="">
      <div class="collaborators_main_layout" >
        <div class="Add_collaborators_box" v-if="isStatusOn">
          <a class="close_btn" @click="[toggleOnOff(),searchInfo=false,n=-1]"><font-awesome-icon icon="fa-regular fa-circle-xmark" /></a>
              <div class="book_svg">
                <svg height="32" aria-hidden="true" viewBox="0 0 24 24" version="1.1" width="32" data-view-component="true" class="octicon octicon-repo color-fg-muted">
                  <path fill-rule="evenodd" d="M3 2.75A2.75 2.75 0 015.75 0h14.5a.75.75 0 01.75.75v20.5a.75.75 0 01-.75.75h-6a.75.75 0 010-1.5h5.25v-4H6A1.5 1.5 0 004.5 18v.75c0 .716.43 1.334 1.05 1.605a.75.75 0 01-.6 1.374A3.25 3.25 0 013 18.75v-16zM19.5 1.5V15H6c-.546 0-1.059.146-1.5.401V2.75c0-.69.56-1.25 1.25-1.25H19.5z"></path><path d="M7 18.25a.25.25 0 01.25-.25h5a.25.25 0 01.25.25v5.01a.25.25 0 01-.397.201l-2.206-1.604a.25.25 0 00-.294 0L7.397 23.46a.25.25 0 01-.397-.2v-5.01z"></path>
                </svg>
              </div>
              <div class="ADD_collaborators_text"><strong>{{repo_name}}</strong> 에 추가할 공동 작업자를 선택하세요</div>
              
              <div class="Add_collaborators_search_box" v-if="n==-1">
                  <div>
                    <font-awesome-icon icon="fa-solid fa-magnifying-glass" class="search" />  
                    <input 
                      class="Add_collaborators_input" 
                      type="search"
                      :value="searchText"
                      placeholder="유저닉네임, 이름 또는 이메일로 검색하세요"
                      @input="searchInput"
                      ref="search"
                      name="keyword"
                      autocompletze="off"
                      
                    />
                    <input type="submit" hidden />
                    
                  </div>  
              </div>
              <div class="collaborators_select_member" v-if="n!=-1">
                  <div style="width: 40px; height: 40px; padding: 1px 0px"><img :src="profileImg[n]" style="width:32px; height:32px;"></div>
                  <div style="width: 500px; height:40px; text-align:left; padding-left:5px;">{{searchInfoList[n].member_nick}}</div>
                  <a @click="n=-1"><font-awesome-icon icon="fa-solid fa-xmark"  style="float:right; padding: 5px 0px;"/></a>
              </div>
              <div class="collaborators_search_info" v-if="searchInfo && n==-1">
                <div v-for="(list,idx) in searchInfoList" @click="n=idx">
                      <div class="collaborators_search_info_img">
                        <img :src="profileImg[idx]" style="width:32px; height:32px;">
                      </div>
                      <div class="collaborators_search_info_nick">
                        {{list.member_nick}}
                      </div> 
                </div>
               

              </div>
            
              <div class="Add_collaborators_btn_div"><button class="Add_collaborators_btn" @click="">공동 작업자를 선택하세요</button></div>
            </div>
            
          <div class="general_string">구성원</div>

          <div class="collaborators_invite">
            
              <div class="invite_string">
                  구성원 초대
              </div>
              
              

              <div class="collaborators_invite_box">
                        <img class="collaborators_img" src="@/assets/imgs/repository/setting/collaborators/permissions.png"/>
                  
                  <div class="collaborators_invite_message">
                      아직 공동 작업자를 초대하지 않았습니다.
                  </div>
                  <button class="collaborators_invite_btn" @click="toggleOnOff">
                      사용자 추가
                  </button>
              </div>
          </div>

          
              <div class="collaborators_list_body" >
                    <div class="manage_string">
                      구성원 관리
                    </div>
                    <div style="display:inline; float:right; margin-right:100px;">
                        <button class="collaborators_add_btn" @click="toggleOnOff">
                            사용자 추가
                        </button>
                    </div>
                  <div class="collaborators_list_box"> <!--list_box-->
                    <div class="collaborators_list_box_header">구성원 목록</div><!-- 구성원목록 -->
                    <div class="collaborators_list_box_body" v-for="name,idx in repo_mem">
                      <!-- <div class="collaborators_list_box_checkbox"><input type="checkbox" class="collabo_body_chekbox"></input></div>checkbox -->

                      <div class="collaborators_list_box_img">
                        <img :src=profileImg2[idx]
                          style="width:32px; height:32px;"
                          class="collabo_member_img"/>
                      </div><!--img-->

                      <div class="collaborators_list_box_userinfo"><!--userinfo-->
                        <div class="collaborators_list_box_user_href"><a href="#" style="color:#0969DA; font-size: 14px; padding-top:0px"><strong>{{name.member_nick}}</strong></a></div><!--user_href-->
                        <div class="collaborators_list_box_usernick"> {{name.member_nick}} • collaborator</div><!--usernick-->
                      </div>

                      <div class="collaborators_list_box_removebtn"><button class="collaborator_remove_btn" @click="deleterepomem(name.member_nick)">삭제</button></div><!--remove_btn-->

                    </div><!-- list_box_body-->
                    
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
      collaborators_list_body: "display:none;",
      collaborators_invite:"display:none;",
      repo_name: this.$route.params.repository,
      repo_mem: [],
      test1: false,
      isStatusOn:false,
      searchText:"",
      searchInfo:false,
      searchInfoList:{member_nick:"", member_img:""},
      n:-1,
      profileImg:[],
      profileImg2:[],
      i:0,
      k:0,


    };
  },
  mounted() {
    this.test();
    this.selectrepomem();
    
  },
  methods: {
    
    getContriImg() {
      axios
        .get("/api/getProfileImg", {
          responseType: "blob",
          params: {
            img: this.searchInfoList[this.i].member_img,
          },
        })
        .then((response) => {
          // handle success

          this.profileImg.push(
            window.URL.createObjectURL(new Blob([response.data]))
          );
          this.i++;
          if (this.i < this.searchInfoList.length) {
            this.getContriImg();
          
          }
          
        });
    },
    getContriImg2() {
      axios
        .get("/api/getProfileImg", {
          responseType: "blob",
          params: {
            img: this.repo_mem[this.k].member_img,
          },
        })
        .then((response) => {
          // handle success
          
          this.profileImg2.push(
            window.URL.createObjectURL(new Blob([response.data]))
          );
          this.k++;
          if (this.k < this.repo_mem.length) {
            this.getContriImg2();
          }
          
        });
    },
    toggleOnOff: function () {
      this.isStatusOn = !this.isStatusOn;
    },
    test() {
      if (this.repo_mem.length == 0) {
        this.collaborators_list_body = "display:none;";
        this.collaborators_invite = "display:inline;";
      } else {
        this.collaborators_list_body = "display:inline;";
        this.collaborators_invite = "display:none;";
      }
    },
    selectrepomem() {
      axios
        .get("/api/selectrepomem", {
          params: {
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          this.repo_mem = response.data;
          this.getContriImg2();
          // console.log(this.clone);
          //alert(this.clone);
        });
    },
    deleterepomem(nick) {
      axios
        .get("/api/deleterepomem", {
          params: {
            reponame: this.$route.params.repository,
            nick: nick,
          },
        })
        .then((response) => {
          this.profileImg2.splice(0);
          this.selectrepomem();

          // console.log(this.clone);
          //alert(this.clone);
        });
    },
    searchInput(e){
      this.searchText = e.target.value;
      
      axios
        .get("/api/searchMembernick", {
            params: {
              search: this.searchText,
            },
          })
          .then((response) => {
            this.searchInfoList = response.data;
            if (response.data == "") {
              this.searchInfo = false;
            } else {
              this.searchInfo = true;
            }
            // console.log(this.searchInfoList);
            // console.log(this.profileImg)
            
            this.profileImg.splice(0);
            this.getContriImg();
          });
          
    },
    

    
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/collaborators'
</style>