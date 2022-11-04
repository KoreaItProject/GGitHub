<template lang="">

    <div class="profile_container" :style="cssVariable">
        <div class="profile_bar_top">
        
            

        <div class="profile_bar_top_block"></div>

            <div class="profile_tab_container">

                <a id ="profile_tab1" class="profile_tab" href="?tab=overview">
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-book UnderlineNav-octicon hide-sm">
                    <path fill-rule="evenodd" d="M0 1.75A.75.75 0 01.75 1h4.253c1.227 0 2.317.59 3 1.501A3.744 3.744 0 0111.006 1h4.245a.75.75 0 01.75.75v10.5a.75.75 0 01-.75.75h-4.507a2.25 2.25 0 00-1.591.659l-.622.621a.75.75 0 01-1.06 0l-.622-.621A2.25 2.25 0 005.258 13H.75a.75.75 0 01-.75-.75V1.75zm8.755 3a2.25 2.25 0 012.25-2.25H14.5v9h-3.757c-.71 0-1.4.201-1.992.572l.004-7.322zm-1.504 7.324l.004-5.073-.002-2.253A2.25 2.25 0 005.003 2.5H1.5v9h3.757a3.75 3.75 0 011.994.574z"></path>
                </svg>
                    Overview
                </a>
                <a id ="profile_tab2" class="profile_tab" href="?tab=repositories" >
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-repo UnderlineNav-octicon hide-sm">
                    <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
                </svg>
                    Repositories
                    <span title="13" data-view-component="true" class="Counter">13</span>
                </a>
                <a id ="profile_tab3" class="profile_tab" href="?tab=stars" >
                    <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-star UnderlineNav-octicon hide-sm">
                    <path fill-rule="evenodd" d="M8 .25a.75.75 0 01.673.418l1.882 3.815 4.21.612a.75.75 0 01.416 1.279l-3.046 2.97.719 4.192a.75.75 0 01-1.088.791L8 12.347l-3.766 1.98a.75.75 0 01-1.088-.79l.72-4.194L.818 6.374a.75.75 0 01.416-1.28l4.21-.611L7.327.668A.75.75 0 018 .25zm0 2.445L6.615 5.5a.75.75 0 01-.564.41l-3.097.45 2.24 2.184a.75.75 0 01.216.664l-.528 3.084 2.769-1.456a.75.75 0 01.698 0l2.77 1.456-.53-3.084a.75.75 0 01.216-.664l2.24-2.183-3.096-.45a.75.75 0 01-.564-.41L8 2.694v.001z"></path>
                </svg>
                    Stars
                    <span title="5" data-view-component="true" class="Counter">5</span>
                </a>

            </div>
        
        </div>

        <div class="profile_bar_left">
            <div class="profile_img_div">
                <img class="profile_img" src='static/imgs/profile/profileImg.jpg'/>
            </div>
            <div class="profile_nick_div">
              <span class="profile_nick" >JavaMaster이태현123</span>
            </div>
            <div class="profile_edit_btn_div">
              <button class="profile_edit_btn"  >프로필 편집</button>
              
            </div>
            
            <div class="profile_folloew_div">
              <a class="" href="?tap=followers">
                <svg text="muted" aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-people">
                  <path fill-rule="evenodd" d="M5.5 3.5a2 2 0 100 4 2 2 0 000-4zM2 5.5a3.5 3.5 0 115.898 2.549 5.507 5.507 0 013.034 4.084.75.75 0 11-1.482.235 4.001 4.001 0 00-7.9 0 .75.75 0 01-1.482-.236A5.507 5.507 0 013.102 8.05 3.49 3.49 0 012 5.5zM11 4a.75.75 0 100 1.5 1.5 1.5 0 01.666 2.844.75.75 0 00-.416.672v.352a.75.75 0 00.574.73c1.2.289 2.162 1.2 2.522 2.372a.75.75 0 101.434-.44 5.01 5.01 0 00-2.56-3.012A3 3 0 0011 4z"></path>
                </svg> 
                <span class="text-bold color-fg-default">6</span>
                followers
              </a>        
              · 
              <a class="" href="?tap=following">
                <span class="text-bold color-fg-default">15</span>
                following
              </a>     
            </div>

            <div class="profile_post_info_div">
              <ul class="profile_post_info_ul">

                <li class="profile_post_info_li" itemprop="homeLocation" show_title="false" aria-label="Home location: Korea">
                  <svg class="octicon octicon-location" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M11.536 3.464a5 5 0 010 7.072L8 14.07l-3.536-3.535a5 5 0 117.072-7.072v.001zm1.06 8.132a6.5 6.5 0 10-9.192 0l3.535 3.536a1.5 1.5 0 002.122 0l3.535-3.536zM8 9a2 2 0 100-4 2 2 0 000 4z"></path></svg>
                  <span class="p-label">Korea</span>
                </li>
                <li class="profile_post_info_li" itemprop="email" aria-label="Email: harry7141@gmail.com" >
                  <svg class="octicon octicon-mail" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M1.75 2A1.75 1.75 0 000 3.75v.736a.75.75 0 000 .027v7.737C0 13.216.784 14 1.75 14h12.5A1.75 1.75 0 0016 12.25v-8.5A1.75 1.75 0 0014.25 2H1.75zM14.5 4.07v-.32a.25.25 0 00-.25-.25H1.75a.25.25 0 00-.25.25v.32L8 7.88l6.5-3.81zm-13 1.74v6.441c0 .138.112.25.25.25h12.5a.25.25 0 00.25-.25V5.809L8.38 9.397a.75.75 0 01-.76 0L1.5 5.809z"></path></svg>
                  <a class="Link--primary" href="mailto:harry7141@gmail.com">harry7141@gmail.com</a>
                </li>
              </ul>

            </div>

        </div>



         <div id="main_div">
        
            <overview v-if='isOverview'/>
            <repositories v-if='isRepositories'/>
            <stars v-if='isStars'/>

        </div>
       
    </div>
   
</template>

<script>
import axios from "axios";
import overview from "@/components/profile/overView.vue";
import repositories from "@/components/profile/repositories.vue";
import stars from "@/components/profile/stars.vue";
import test2 from "@/components/test/test2.vue";

export default {
  computed: {
    cssVariable() {
      return {
        "--tab1_color": this.tab1_color,
        "--tab2_color": this.tab2_color,
        "--tab3_color": this.tab3_color,
      };
    },
  },
  data() {
    return {
      isOverview: false,
      isRepositories: false,
      isStars: false,
      tab1_color: "4px",
      tab2_color: "4px",
      tab3_color: "4px",
    };
  },
  components: {
    overview: overview,
    repositories: repositories,
    stars: test2,
  },

  mounted() {
    let tab = this.$route.query.tab;
    if (tab == "repositories") {
      this.isOverview = false;
      this.isRepositories = true;
      this.isStars = false;
      this.tab1_color = "0px";
      this.tab2_color = "4px";
      this.tab3_color = "0px";
    } else if (tab == "stars") {
      this.isOverview = false;
      this.isRepositories = false;
      this.isStars = true;
      this.tab1_color = "0px";
      this.tab2_color = "0px";
      this.tab3_color = "4px";
    } else {
      this.isOverview = true;
      this.isRepositories = false;
      this.isStars = false;
      this.tab1_color = "4px";
      this.tab2_color = "0px";
      this.tab3_color = "0px";
    }
  },
};
</script>
<style lang="sass">
@import "@/assets/profile/profile_kit.sass"
</style>