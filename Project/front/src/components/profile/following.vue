<template lang="">
    <div class="following_main_div">
        <div class="following_box" v-for="following in followings">
            <div class="following_profile_img">
                img~
            </div>
            <a class="following_profile_go" href="#">
                <span class="following_nick">
                    {{following.nick}}
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
        followings:[],

    };
},
    methods:{
        selectfollowinglist(){
        axios
            .get("/api/selectfollowinglist",{
                params:{
                    nick:this.$route.params.nick,
                },
            })
            .then((response) => {
                this.followings = response.data;
                // alert(this.followings)
            })
        }
        },
    mounted(){
        this.selectfollowinglist();
    }


    
}
</script>
<style lang="sass">
@import "src/assets/sass/profile/following"
</style>