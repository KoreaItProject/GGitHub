
  
</template><template lang="">
      <div class="collaborators_main_layout">
        <div class="general_string">구성원</div>

        <div class="collaborators_invite">
            <div class="invite_string">
                구성원 초대
            </div>
            <div class="collaborators_invite_box">
                       <img class="collaborators_img" src="@/assets/imgs/repository/setting/collaborators/permissions.png"/>
                
                <div class="collaborators_invite_message">
                    아직 공동작업자를 초대하지 않았습니다.
                </div>
                <button class="collaborators_invite_btn">
                    사용자 추가
                </button>
            </div>
            <div class="Add_collaborators_box">
              <div class="book_svg">
                <svg height="32" aria-hidden="true" viewBox="0 0 24 24" version="1.1" width="32" data-view-component="true" class="octicon octicon-repo color-fg-muted">
                  <path fill-rule="evenodd" d="M3 2.75A2.75 2.75 0 015.75 0h14.5a.75.75 0 01.75.75v20.5a.75.75 0 01-.75.75h-6a.75.75 0 010-1.5h5.25v-4H6A1.5 1.5 0 004.5 18v.75c0 .716.43 1.334 1.05 1.605a.75.75 0 01-.6 1.374A3.25 3.25 0 013 18.75v-16zM19.5 1.5V15H6c-.546 0-1.059.146-1.5.401V2.75c0-.69.56-1.25 1.25-1.25H19.5z"></path><path d="M7 18.25a.25.25 0 01.25-.25h5a.25.25 0 01.25.25v5.01a.25.25 0 01-.397.201l-2.206-1.604a.25.25 0 00-.294 0L7.397 23.46a.25.25 0 01-.397-.2v-5.01z"></path>
                </svg>
              </div>
              <div class="ADD_collaborators_text">Add a collaborator to {repo_name}</div>
              <div> 
                      <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-search">
                          <path fill-rule="evenodd" d="M11.5 7a4.499 4.499 0 11-8.998 0A4.499 4.499 0 0111.5 7zm-.82 4.74a6 6 0 111.06-1.06l3.04 3.04a.75.75 0 11-1.06 1.06l-3.04-3.04z"></path>
                      </svg>
                  <input type="text" class="Add_collaborators_input" placeholder="Search by username, full name, or email" />
                      
              </div>
              <div class="Add_collaborators_btn_div"><button class="Add_collaborators_btn">Select a collaborators above</button></div>
            </div>

            <div class="" v-bind:style="collaborators_list">
                <div class="manage_string">
                    구성원 관리
                </div>
                <div>
                    <button class="collaborators_add_btn">
                        사용자 추가
                    </button>
                </div>
                <div class="collaborators_list_box" >
                    <div class="collaborators_list">
                        구성원 목록 
                    </div>
                    <div class="collaborators_list_box_body" v-for="name in repo_mem">
                        <span><input type="checkbox" class="collabo_body_chekbox"></input></span>
                        <img src="@/assets/imgs/repository/setting/collaborators/lee_profile.jpg"
                        style="position: absolute; width:32px; height:32px;"
                        class="collabo_member_img"/>
                        <a href="#" style="margin-left:40px; color:#0969DA; font-size: 14px;"><strong>{{name}}</strong></a>
                        <span><button class="collaborator_remove_btn">Remove</button></span>
                        <div style="margin-left:58px">
                            {{name}} . collaborator
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>

    </div>
</template>
<script>
export default {
  data() {
    return {
      collaborators_list: "display:none;",
      repo_name: "",
      repo_mem: ["a"],
      test1: false,
    };
  },
  mounted() {
    this.test();
  },
  methods: {
    test() {
      if (this.repo_mem.length == 0) {
        this.collaborators_list = "display:none;";
      } else {
        this.collaborators_list = "display:inline;";
      }
    },
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/collaborators'
</style>