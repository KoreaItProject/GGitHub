<template lang="">
    <div class="member_container">
        <a class="member_div" v-for="data in searchResult" :href="'./'+data.member_nick">
            <div class="member_div_top">
                <span>사진</span>
                <span class="nick blue_point" v-html="data.s_nick"></span>
                
            </div>
      
            <div class="member_div_mid">
                   <span class="member_div_mid_span">follower {{data.followerCount}}</span>
                <span class="member_div_mid_span">following {{data.followingCount}}</span>
               <span class="member_div_mid_span">
                  <svg aria-hidden="true" height="15px" viewBox="0 -1 16 16" version="1.1" width="15px" data-view-component="true" class="octicon octicon-repo color-fg-muted mr-2">
                      <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
                  </svg>
                    {{data.repo_count}}</span>
                
               
                  <span class="member_div_mid_span">                 
                    <font-awesome-icon icon="fa-regular fa-circle-up" />
                    {{data.commits}}</span>
                <span class="member_div_mid_span" v-if="data.push_date!=null">
                <font-awesome-icon icon="fa-solid fa-arrows-rotate" /> <time-ago local="en" :datetime="data.push_date" refresh tooltip long  /></span>

                <div class="member_con" v-if="data.member_con!=''">
                    {{data.member_con}}
                </div>
            </div>

        </a>





























        <div class="page_div"  v-if="pageCount!=1">
          <!-- https://www.npmjs.com/package/vuejs-paginate/v/1.9.5 -->
          <paginate
                    :page-count="pageCount"
                    :page-range="5"
                    :margin-pages="2"
                    :click-handler="changePage"
                    :prev-text="'이전'"
                    :next-text="'다음'"
                    :container-class="'pagination'"
                    :page-class="'page-item'"
                    :hide-prev-next="true"
                    >
            </paginate>
        </div>
    </div>
</template>
<script>
import axios from "axios";
import store from "../../vuex/store";
import { TimeAgo } from "vue2-timeago";

import Paginate from "vuejs-paginate";
export default {
  data() {
    return {
      searchResult: {},
      page: 1,
      pageCount: 10,
    };
  },
  components: {
    TimeAgo,
    paginate: Paginate,
  },
  methods: {
    getMyResuet() {
      axios
        .get("/api/searchMember", {
          params: {
            search: this.$route.query.keyword,
            page: this.page,
          },
        })
        .then((response) => {
          this.searchResult = response.data;
          console.log(this.searchResult);
        });
    },

    changePage: function (pageNum) {
      this.page = pageNum;
      this.getMyResuet();
      window.scrollTo(0, 0);
    },
  },
  mounted() {
    axios
      .get("/api/countMember", {
        params: {
          search: this.$route.query.keyword,
        },
      })
      .then((response) => {
        this.pageCount = Math.trunc(response.data / 10) + 1;
      });
    this.getMyResuet();
  },
};
</script>
<style lang="">
</style>