<template lang="">
    <div class="following_main_div">
         <div v-if="islogin">
            <template v-for="following,idx in followings">
                <div class="following_box"> 
                    <div class="following_profile_img">
                        img~
                    </div>
                    <a class="following_profile_go" :href="'/'+following.nick">
                        <span class="following_nick">
                            {{following.nick}}
                            
                        </span>
                        
                    </a>
                     <div class="unfollow" v-if="!isMy(following.nick)">
                        <button class="unfollow_btn" v-if="following.count==1" @click="[deletefollowlist(following.nick),refreshAll()]">
                            Unfollow
                        </button>

                        <button class="follow_btn" v-if="following.count==0" @click="[insertFollow(following.nick),refreshAll()]">
                            follow
                        </button>


                        <button class="follow_btn" v-if="!islogin" @click="location.href='login'">
                                follow
                        </button>

                    </div>
                </div>
            </template>
        </div>
        <div v-if="!islogin">
            <template v-for="Lfollowing,idx in Lfollowings">
                <div class="following_box"> 
                    <div class="following_profile_img">
                        img~
                    </div>
                    <a class="following_profile_go" href="#">
                        <span class="following_nick">
                            {{Lfollowing.nick}}
                        </span>
                        
                    </a>
                    <div class="unfollow">
                        <a href='login'><button class="follow_btn" >
                            follow
                        </button></a>
                    </div>
                </div>
            </template>
        </div>
      
        
    </div>
</template>
<script>
import axios from 'axios';
import store from '../../vuex/store';
export default {
    data(){
        return{
        followings:[],
        Lfollowings:[],
        islogin:false,

    };
},
    methods:{
        isMy(nick){
          
          return store.getters.getUserNick==nick
          
      },
        selectfollowinglist(){
            axios
                .get("/api/selectfollowinglist",{
                    params:{
                        nick:this.$route.params.nick,
                        idx: store.getters.getUserIdx,
                    },
                })
                .then((response) => {
                    this.followings = response.data;
                    // alert(this.followings)
                })
        },
        followinglist(){
            axios
                .get("/api/followinglist",{
                    params:{
                        nick:this.$route.params.nick,
                       
                    },
                })
                .then((response) => {
                    this.Lfollowings = response.data;
                    // alert(this.Lfollowings)
                })
                
        },
        
        refreshAll() {
            // 새로고침
            this.$router.go();
        },
        insertFollow(nick){
            axios
            .get("/api/insertFollow", {
                params: {
                    nick:nick,
                    idx:store.getters.getUserIdx,
                },
                })
                .then((response) => {
                // handle success
                
                
                })
                .catch((error) => {
                // handle error
                console.log(error);
                })
                .finally(() => {
                // always executed
                });
            
            },  
        
       
        deletefollowlist(nick){
            axios
            .get("/api/deletefollowlist", {
                params: {
                    nick:nick,
                    idx:store.getters.getUserIdx,
                },
                })
                .then((response) => {
                // handle success
                
                
                })
                .catch((error) => {
                // handle error
                console.log(error);
                })
                .finally(() => {
                // always executed
                });
            
    }
        },
    mounted(){
        this.islogin = store.getters.getIsLogin;
        if(this.islogin){
            this.selectfollowinglist();
        }
        this.followinglist();
    }


    
}
</script>
<style lang="sass">
@import "src/assets/sass/profile/following"
</style>