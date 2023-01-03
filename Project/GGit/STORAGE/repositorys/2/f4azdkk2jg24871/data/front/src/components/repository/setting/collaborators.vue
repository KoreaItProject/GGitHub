
  
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