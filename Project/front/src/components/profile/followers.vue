<template lang="">
    <div class="followers_main_div">
        <template v-for="follower,idx in followers">
            <div class="followers_box"> 
                <div class="follower_profile_img">
                    img~
                </div>
                <a class="follower_profile_go" href="#">
                    <span class="follower_nick">
                        {{follower.nick}}
                        
                    </span>
                    
                </a>
                <div class="unfollow">
                    <button class="unfollow_btn" v-if="follower.count==1" @click="[deletefollowlist(follower.nick),refreshAll()]">
                        Unfollow
                    </button>

                    <button class="follow_btn" v-if="follower.count==0" @click="[insertFollow(follower.nick),refreshAll()]">
                        follow
                    </button>

                </div>
            </div>
        </template>
        
    </div>
</template>
<script>
import axios from 'axios';
import store from '../../vuex/store';
export default {
    data(){
        return{
            followers:[],
            
        };
    },
    methods:{
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
        
        selectfollowerlist(){
            
            axios
            .get("/api/selectfollowerlist",{
                params:{
                    nick:this.$route.params.nick,
                    idx:store.getters.getUserIdx,
                },
            })
            .then((response) => {
                this.followers = response.data;
                console.log(this.followers)
            })
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
        this.selectfollowerlist();
        
    }

    
}
</script>
<style lang="sass">
@import "src/assets/sass/profile/followers"
</style>