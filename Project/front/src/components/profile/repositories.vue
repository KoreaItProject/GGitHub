<template lang="">
  
    <div class = "con_container">
        <div class="con_top">
        <a href="/create" v-if="newbtn">
              <button type ="button" class = "new_repo pink" >
              
              새 저장소</button>
              </a>
          <form action="">
            <input name = "keyword" type ="search" class = "repo_search" placeholder="저장소 검색" v-model="searchStr" v-on:keyup.enter="search"></input>
            <input name = "tab" :value="this.$route.query.tab" hidden/>
            <input type="submit" hidden/>
          </form>
            
        </div>
        <div @click="getClick(data.member_nick,data.repo_name)"  class="repo_div" v-for="data in searchResult">
          <div class="repo_div_con">
              <div class="repo_name_div">
                    <svg aria-hidden="true" height="15px" viewBox="0 -1 16 16" version="1.1" width="15px" data-view-component="true" class="octicon octicon-repo color-fg-muted mr-2">
                        <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
                    </svg>
                  <span class="blue_point repo_name"><span v-html="data.s_nick"></span> / <span v-html="data.s_name"></span></span>
                      <div class="repository_public" v-if="data.repo_publ==1"> public </div>
                      <div class="repository_public" v-if="data.repo_publ==0"> private </div>
                
              </div>

              <div class="repo_description_div" v-html="data.s_description"></div>
              <div class="repo_info_div">

                  <span class="repo_star_div">
                    <font-awesome-icon icon="fa-regular fa-star" />
                    {{data.star_count}}
                  </span>
                  <span class="repo_down_div">
                    <font-awesome-icon icon="fa-regular fa-circle-down" />
                    {{data.repo_download}}
                  </span>
                  <span class="repo_up_div">
                  <font-awesome-icon icon="fa-regular fa-circle-up" />
                  {{data.commits}}
                  </span>
                  <span class="repo_date_div">
                    <font-awesome-icon icon="fa-solid fa-arrows-rotate" />
                    <time-ago local="en" :datetime="data.push_date" refresh tooltip long  />
                  </span>
                
              </div>  
            </div>

           
            
        </div>

        <div class="page_div" v-if="pageCount!=1">
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
      newbtn: this.$route.params.nick == store.getters.getUserNick,
      searchResult: {},
      page: 1,
      pageCount: 10,
      idx: 0,
    };
  },
  components: {
    TimeAgo,
    paginate: Paginate,
  },
  methods: {
    getClick(nick, repo) {
      window.location.href = "/" + nick + "/" + repo;
    },
    getidx() {
      axios
        .get("/api/memberByNick", {
          params: {
            nick: this.$route.params.nick,
          },
        })
        .then((response) => {
          this.idx = response.data.idx;
          axios
            .get("/api/searchPageCount", {
              params: {
                member: this.idx,
                search: this.$route.query.keyword,
                mine: this.idx == store.getters.getUserIdx,
              },
            })
            .then((response) => {
              this.pageCount = Math.trunc(response.data / 10) + 1;
              if (response.data % 10 == 0) {
                this.pageCount--;
              }
              this.getMyResuet();
            });
        });
    },
    getMyResuet() {
      axios
        .get("/api/search", {
          params: {
            member: this.idx,
            search: this.$route.query.keyword,
            page: this.page,
            mine: this.idx == store.getters.getUserIdx,
          },
        })
        .then((response) => {
          this.searchResult = response.data;
        });
    },

    changePage: function (pageNum) {
      this.page = pageNum;
      this.getMyResuet();
      window.scrollTo(0, 0);
    },
  },
  mounted() {
    this.getidx();
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/profile/repositories"
</style>