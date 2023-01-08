<template lang="">
    <div class="stars_container" >
      <div>
        <template v-for="(star,idx) in stars">
          
          <div class="stars_div" >
              <div>
                
                  <button type="button" class="star_btn"v-if="star.isMy==0" @click="[insertStar(star.repo_name),refreshAll()]">
                    <font-awesome-icon icon="fa-regular fa-star" />
                    즐겨찾기
                  </button>
                
                <button type="button" class="starred_btn" v-if="star.isMy==1" @click="[deleteStar(star.repo_name),refreshAll()]">
                  <font-awesome-icon icon="fa-solid fa-star" />
                  즐겨찾기 해제
                </button>
              </div>
              <div class="stars_repository">
                    <svg aria-hidden="true" height="15px" viewBox="0 0 16 16" version="1.1" width="15px" data-view-component="true" class="octicon octicon-repo color-fg-muted mr-2">
                        <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
                    </svg>
                  <a :href="'/'+star.repo_owner+'/'+star.repo_name" class="repo_txt">{{star.repo_owner}} / {{star.repo_name}}</a>
              </div>

            

              <div class="stars_repository_detail">
                  {{star.repo_description}}
              </div>

              
              <div>
                <span class="repo_star_div">
                    <font-awesome-icon icon="fa-regular fa-star" />
                    {{star.star_count}}
                </span>
                <span class="repo_down_div">
                    <font-awesome-icon icon="fa-regular fa-circle-down" />
                    {{star.repo_down}}
                </span>
               

                <span class="repo_update_div">
                  <font-awesome-icon icon="fa-solid fa-arrows-rotate" />
                  <time-ago local="en" :datetime="star.push_date" refresh tooltip long />
                </span>
              </div>
              
          </div>
        </template>
      </div>  
        
    </div>

</template>
<script>
import axios from 'axios';
import store from '../../vuex/store';
import { TimeAgo } from "vue2-timeago";

export default {
  data() {
    return {
      stars: [],
      
      
    };
  },
  components:{
    TimeAgo,

  },
  methods:{
   
    refreshAll() {
            // 새로고침
            this.$router.go();
        },
    selectStarlist(){
      axios
      .get("/api/selectStarlist",{
        params:{
          nick: this.$route.params.nick,
          idx: store.getters.getUserIdx,
         
         
        },
      })
      .then((response) => {
        this.stars = response.data;
        console.log(this.stars)
        

      })
      
      
    },
      insertStar(reponame){
        
            axios
            .get("/api/insertStar", {
                params: {
                    reponame:reponame,
                    idx:store.getters.getUserIdx,
                },
                })
                .then((response) => {
                // handle success
                this.selectstarcount(reponame)
                
                })
                .catch((error) => {
                // handle error
                console.log(error);
                })
                .finally(() => {
                // always executed
                });
                
            },
        deleteStar(reponame){
          
            axios
            .get("/api/deleteStar", {
                params: {
                    reponame:reponame,
                    idx:store.getters.getUserIdx,
                },
                })
                .then((response) => {
                // handle success
                this.selectstarcount(reponame)
                
                })
                .catch((error) => {
                // handle error
                console.log(error);
                })
                .finally(() => {
                // always executed
                });
                
            },
            selectstarcount(reponame){
              axios
              .get("/api/selectstarcount",{
                params:{
                  reponame: reponame,
                  idx: store.getters.getUserIdx,
                
                
                },
              })
              .then((response) => {
                this.starcount = response.data;
                alert(this.starcount)
                
                if (
                    response.data == 0
                  ) {
                    this.starcount = false; // 즐겨찾기
                  } else if (
                    
                    response.data == 1
                  
                  ) {
                    // 조회된 데이터가 있을때
                    this.starcount = true; // 즐겨찾기 해제
                  }

              })
              
              
            },
      
            
  

   
  },
  mounted(){
    this.selectStarlist();
    
    
  }
}
</script>

<style lang="sass">
@import 'src/assets/sass/profile/stars'
</style>       