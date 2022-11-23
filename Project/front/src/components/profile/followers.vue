<template lang="">
    <div class="followers_main_div">
        <div class="followers_box" v-for="follower in followers">
            <div class="follower_profile_img">
                img~
            </div>
            <a class="follower_profile_go" href="#">
                <span class="follower_nick">
                    {{follower.nick}}
                </span>
                
            </a>
            <div class="unfollow">
                <button class="unfollow_btn">
                    Unfollow
                </button>

            </div>
        </div>
        
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data(){
        return{
            followers:[],
        };
    },
    methods:{
        selectfollowlist(){
            axios
            .get("/api/selectfollowlist",{
                params:{
                    nick:this.$route.params.nick,
                },
            })
            .then((response) => {
                this.followers = response.data;
                // alert(this.followers)
            })
        }
    },
    mounted(){
        this.selectfollowlist();
    }

    
}
</script>
<style lang="sass">
@import "src/assets/sass/profile/followers"
</style>