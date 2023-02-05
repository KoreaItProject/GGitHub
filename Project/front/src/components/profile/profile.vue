<template lang="">
  <div class="profile_container" :style="cssVariable">
    <div class="profile_bar_top">


   <div class="profile_bar_top_center" >
      <div class="profile_bar_top_block"></div>

      <div class="profile_tab_container">
        <a id="profile_tab1" class="profile_tab" href="?tab=overview">
          <span class="tabs">
          <svg
            aria-hidden="true"
            height="16"
            viewBox="0 -2 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon octicon-book UnderlineNav-octicon hide-sm"
          >
            <path
              fill-rule="evenodd"
              d="M0 1.75A.75.75 0 01.75 1h4.253c1.227 0 2.317.59 3 1.501A3.744 3.744 0 0111.006 1h4.245a.75.75 0 01.75.75v10.5a.75.75 0 01-.75.75h-4.507a2.25 2.25 0 00-1.591.659l-.622.621a.75.75 0 01-1.06 0l-.622-.621A2.25 2.25 0 005.258 13H.75a.75.75 0 01-.75-.75V1.75zm8.755 3a2.25 2.25 0 012.25-2.25H14.5v9h-3.757c-.71 0-1.4.201-1.992.572l.004-7.322zm-1.504 7.324l.004-5.073-.002-2.253A2.25 2.25 0 005.003 2.5H1.5v9h3.757a3.75 3.75 0 011.994.574z"
            ></path>
          </svg>
          오버뷰
          </span>
        </a>
        <a id="profile_tab2" class="profile_tab" href="?tab=repositories">
          <span class="tabs">
          <svg
            aria-hidden="true"
            height="16"
            viewBox="0 -2 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon octicon-repo UnderlineNav-octicon hide-sm"
          >
            <path
              fill-rule="evenodd"
              d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"
            ></path>
          </svg>
          저장소
          <span title="13" data-view-component="true" class="r_count">{{repocount}}</span>
          </span>
        </a>
        <a id="profile_tab3" class="profile_tab" href="?tab=stars">
          <span class="tabs">
          <svg
            aria-hidden="true"
            height="16"
            viewBox="0 -2 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon octicon-star UnderlineNav-octicon hide-sm"
          >
            <path
              fill-rule="evenodd"
              d="M8 .25a.75.75 0 01.673.418l1.882 3.815 4.21.612a.75.75 0 01.416 1.279l-3.046 2.97.719 4.192a.75.75 0 01-1.088.791L8 12.347l-3.766 1.98a.75.75 0 01-1.088-.79l.72-4.194L.818 6.374a.75.75 0 01.416-1.28l4.21-.611L7.327.668A.75.75 0 018 .25zm0 2.445L6.615 5.5a.75.75 0 01-.564.41l-3.097.45 2.24 2.184a.75.75 0 01.216.664l-.528 3.084 2.769-1.456a.75.75 0 01.698 0l2.77 1.456-.53-3.084a.75.75 0 01.216-.664l2.24-2.183-3.096-.45a.75.75 0 01-.564-.41L8 2.694v.001z"
            ></path>
          </svg>
          즐겨찾기
          <span title="5" data-view-component="true" class="r_count">{{starcount}}</span>
          </span>
        </a>
      </div>
    </div>
  </div> 
<div class="profile_middle">
    <div class="profile_bar_left">
      <div class="profile_img_div">
        <img class="profile_img" :src="profileImg" />
      </div>
      <div class="profile_nick_div">
        <span class="profile_nick">{{ $route.params.nick }}</span>
      </div>
      <div class="profile_info_con" v-html="userInfo.con"></div>
      <div class="profile_edit_btn_div">
        <a href="?tab=setting" v-if="isMy">
          <button class="profile_edit_btn">내 정보 변경</button> 
        </a> 

        <a href='/login'><button class="follow_button" v-if="!islogin" >팔로우</button></a>
        <button class="follow_button" v-if="!isMy && followcount==0" @click="[insertFollow(),refreshAll()]">팔로우</button>
        <button class="follow_button" v-if="!isMy && followcount==1" @click="[deletefollowlist(),refreshAll()]">언팔로우</button>

      </div>

      <div class="profile_folloew_div">
       
          <svg
            text="muted"
            aria-hidden="true"
            height="16"
            viewBox="0 -1 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon octicon-people"
          >
            <path
              fill-rule="evenodd"
              d="M5.5 3.5a2 2 0 100 4 2 2 0 000-4zM2 5.5a3.5 3.5 0 115.898 2.549 5.507 5.507 0 013.034 4.084.75.75 0 11-1.482.235 4.001 4.001 0 00-7.9 0 .75.75 0 01-1.482-.236A5.507 5.507 0 013.102 8.05 3.49 3.49 0 012 5.5zM11 4a.75.75 0 100 1.5 1.5 1.5 0 01.666 2.844.75.75 0 00-.416.672v.352a.75.75 0 00.574.73c1.2.289 2.162 1.2 2.522 2.372a.75.75 0 101.434-.44 5.01 5.01 0 00-2.56-3.012A3 3 0 0011 4z"
            ></path>
          </svg>
           <a class="" href="?tab=followers" >
          팔로워
          <span class="r_count" >{{
            userInfo.followers
          }}</span>
        </a>
        ·
        <a class="" href="?tab=following" style="">
         
          팔로잉
           <span class="r_count">{{
            userInfo.following
          }}</span>
        </a>
      </div>

      <div class="profile_post_info_div">
        <ul class="profile_post_info_ul">
          <li class="profile_post_info_li" v-if="userInfo.location">
            <svg
              class="octicon octicon-location"
              viewBox="0 -1 16 16"
              version="1.1"
              width="16"
              height="16"
              aria-hidden="true"
            >
              <path
                fill-rule="evenodd"
                d="M11.536 3.464a5 5 0 010 7.072L8 14.07l-3.536-3.535a5 5 0 117.072-7.072v.001zm1.06 8.132a6.5 6.5 0 10-9.192 0l3.535 3.536a1.5 1.5 0 002.122 0l3.535-3.536zM8 9a2 2 0 100-4 2 2 0 000 4z"
              ></path>
            </svg>
            <span class="p-label">{{ userInfo.location }}</span>
          </li>
          <li class="profile_post_info_li" v-if="userInfo.company">
            <svg
              style="width: 16px"
              aria-hidden="true"
              height="16"
              viewBox="0 -1 16 16"
              version="1.1"
              width="16"
              data-view-component="true"
              class="octicon octicon-organization"
            >
              <path
                fill-rule="evenodd"
                d="M1.5 14.25c0 .138.112.25.25.25H4v-1.25a.75.75 0 01.75-.75h2.5a.75.75 0 01.75.75v1.25h2.25a.25.25 0 00.25-.25V1.75a.25.25 0 00-.25-.25h-8.5a.25.25 0 00-.25.25v12.5zM1.75 16A1.75 1.75 0 010 14.25V1.75C0 .784.784 0 1.75 0h8.5C11.216 0 12 .784 12 1.75v12.5c0 .085-.006.168-.018.25h2.268a.25.25 0 00.25-.25V8.285a.25.25 0 00-.111-.208l-1.055-.703a.75.75 0 11.832-1.248l1.055.703c.487.325.779.871.779 1.456v5.965A1.75 1.75 0 0114.25 16h-3.5a.75.75 0 01-.197-.026c-.099.017-.2.026-.303.026h-3a.75.75 0 01-.75-.75V14h-1v1.25a.75.75 0 01-.75.75h-3zM3 3.75A.75.75 0 013.75 3h.5a.75.75 0 010 1.5h-.5A.75.75 0 013 3.75zM3.75 6a.75.75 0 000 1.5h.5a.75.75 0 000-1.5h-.5zM3 9.75A.75.75 0 013.75 9h.5a.75.75 0 010 1.5h-.5A.75.75 0 013 9.75zM7.75 9a.75.75 0 000 1.5h.5a.75.75 0 000-1.5h-.5zM7 6.75A.75.75 0 017.75 6h.5a.75.75 0 010 1.5h-.5A.75.75 0 017 6.75zM7.75 3a.75.75 0 000 1.5h.5a.75.75 0 000-1.5h-.5z"
              ></path>
            </svg>
            <span class="p-label">{{ userInfo.company }}</span>
          </li>
          <div v-bind:style="user_email_div">
          <li class="profile_post_info_li" v-if="userInfo.email">
            <svg
              class="octicon octicon-mail"
              viewBox="0 -1 16 16"
              version="1.1"
              width="16"
              height="16"
              aria-hidden="true"
            >
              <path
                fill-rule="evenodd"
                d="M1.75 2A1.75 1.75 0 000 3.75v.736a.75.75 0 000 .027v7.737C0 13.216.784 14 1.75 14h12.5A1.75 1.75 0 0016 12.25v-8.5A1.75 1.75 0 0014.25 2H1.75zM14.5 4.07v-.32a.25.25 0 00-.25-.25H1.75a.25.25 0 00-.25.25v.32L8 7.88l6.5-3.81zm-13 1.74v6.441c0 .138.112.25.25.25h12.5a.25.25 0 00.25-.25V5.809L8.38 9.397a.75.75 0 01-.76 0L1.5 5.809z"
              ></path>
            </svg>
            <a class="Link--primary" href="mailto:harry7141@gmail.com">{{
              userInfo.email
            }}</a>
          </li>
          </div>
          <li class="profile_post_info_li" v-if="userInfo.url">
            <svg
              style="width: 16px"
              aria-hidden="true"
              height="16"
              viewBox="0 -1 16 16"
              version="1.1"
              width="16"
              data-view-component="true"
              class="octicon octicon-link"
            >
              <path
                fill-rule="evenodd"
                d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"
              ></path>
            </svg>
            <a class="Link--primary" href="mailto:harry7141@gmail.com">{{
              userInfo.url
            }}</a>
          </li>
        </ul>
      </div>
    </div>

    <div id="main_div">
      <overview v-if="isOverview" />
      <repositories v-if="isRepositories" />
      <stars v-if="isStars" />
      <setting v-if="isSetting" />
      <followers v-if="isFollowers"/>
      <following v-if="isFollowing"/>
    </div>
  </div>
</div>
</template>

<script>
import axios from "axios";
import overview from "@/components/profile/overView.vue";
import repositories from "@/components/profile/repositories.vue";
import stars from "@/components/profile/stars.vue";
import setting from "@/components/setting/profile.vue";
import followers from "@/components/profile/followers.vue";
import following from "@/components/profile/following.vue";
import store from "../../vuex/store";

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
      isSetting: false,
      isFollowers: false,
      isFollowing: false,
      tab1_color: "0px",
      tab2_color: "0px",
      tab3_color: "0px",
      profileImg: "",
      userInfo: [],
      followcount: 3,
      repocount: 0,
      starcount: 0,
      user_email_div: "",
      isMy: store.getters.getUserNick == this.$route.params.nick,
      islogin: false,
    };
  },
  components: {
    overview: overview,
    repositories: repositories,
    stars: stars,
    setting: setting,
    followers: followers,
    following: following,
  },
  methods: {
    refreshAll() {
      // 새로고침
      this.$router.go();
    },
    selectfollowcount() {
      axios
        .get("/api/selectfollowcount", {
          params: {
            nick: this.$route.params.nick,
            idx: store.getters.getUserIdx,
          },
        })
        .then((response) => {
          // handle success
          this.followcount = response.data;
          // alert(this.followcount)
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },

    deletefollowlist() {
      axios
        .get("/api/deletefollowlist", {
          params: {
            nick: this.$route.params.nick,
            idx: store.getters.getUserIdx,
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
    insertFollow() {
      axios
        .get("/api/insertFollow", {
          params: {
            nick: this.$route.params.nick,
            idx: store.getters.getUserIdx,
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
    getProfileImg() {
      axios
        .get("/api/getProfileImg", {
          responseType: "blob",
          params: {
            img: this.userInfo.img,
          },
        })
        .then((response) => {
          // handle success
          this.profileImg = window.URL.createObjectURL(
            new Blob([response.data])
          );
          console.log(response.data);
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    hasNick() {
      axios
        .get("/api/hasNick", {
          params: {
            nick: this.$route.params.nick,
          },
        })
        .then((response) => {
          // handle success

          if (!response.data) {
            window.location.href = "/pagenotfound";
          }
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    getMemberInfo() {
      axios
        .get("/api/memberByNick", {
          params: {
            nick: this.$route.params.nick,
          },
        })
        .then((response) => {
          // handle success
          this.userInfo = response.data;

          if (this.userInfo.email_check == 1) {
            // 이메일 공개 여부가 1이라면
            this.user_email_div = "display: inline";
          } else if (this.userInfo.email_check == 0) {
            this.user_email_div = "display: none";
          }
          if (this.userInfo.con != null && this.userInfo.con != "") {
            this.userInfo.con = this.userInfo.con.replace(
              /(?:\r\n|\r|\n)/g,
              "<br />"
            );
          }

          this.getProfileImg();
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    selectRepositorycount() {
      axios
        .get("/api/selectRepositorycount", {
          params: {
            nick: this.$route.params.nick,
            isMy: this.$route.params.nick == store.getters.getUserNick,
          },
        })
        .then((response) => {
          // handle success
          this.repocount = response.data;
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    selectRepositorystarcount() {
      axios
        .get("/api/selectRepositorystarcount", {
          params: {
            nick: this.$route.params.nick,
          },
        })
        .then((response) => {
          // handle success
          this.starcount = response.data;
        })
        .catch((error) => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
  },

  mounted() {
    this.hasNick();
    this.selectRepositorycount();
    this.selectRepositorystarcount();
    this.getMemberInfo();
    this.islogin = store.getters.getIsLogin;
    if (this.islogin) {
      this.selectfollowcount();
    }

    let tab = this.$route.query.tab;

    if (tab == "repositories") {
      this.isRepositories = true;
      this.tab2_color = "4px";
    } else if (tab == "stars") {
      this.isStars = true;
      this.tab3_color = "4px";
    } else if (tab == "setting") {
      this.isSetting = true;
    } else if (tab == "followers") {
      this.isFollowers = true;
    } else if (tab == "following") {
      this.isFollowing = true;
    } else {
      this.isOverview = true;
      this.tab1_color = "4px";
    }
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/profile/profile"
</style>
