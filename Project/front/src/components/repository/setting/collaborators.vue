
  
</template><template lang="">
      <div class="collaborators_main_layout">
        <h1>구성원</h1>
        <hr class="collabo_hr">
        <div class="collaborators_invite">
            <div class="invite_string">
                구성원 초대
            </div>
            <div class="collaborators_invite_box">
                       <img class="collaborators_img" src="@/assets/imgs/repository/setting/collaborators/permissions.png"/>
                
                <div class="collaborators_invite_message">
                    You haven't invited any collaborators yet
                </div>
                <button class="collaborators_invite_btn">
                    Add people
                </button>
            </div>
            <div class="manage_string">
                구성원 관리

            </div>
        <div class="collaborators_list_box">
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
</template>
<script>
export default {
    data(){
        return{
            repo_mem:["leetahhyeon123","Jin-Ryeol"]
        };
    }
}
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/collaborators'
</style>