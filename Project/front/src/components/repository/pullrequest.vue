<template lang="">
    <div>
        <div v-if="pullreq_page == true">
            <div class="pullreq_top_div" :style="cssVariable">
                <div class="merge_request_div">
                    <div class="pullrequest_left_container" >
                        <ul>
                             <li class="setting_left_li setting_left_li1">
                                <a @click="changetab('repomember')">
                                    <div class="setting_left_span setting_left_span1">
                                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-people">
                                            <path fill-rule="evenodd" d="M5.5 3.5a2 2 0 100 4 2 2 0 000-4zM2 5.5a3.5 3.5 0 115.898 2.549 5.507 5.507 0 013.034 4.084.75.75 0 11-1.482.235 4.001 4.001 0 00-7.9 0 .75.75 0 01-1.482-.236A5.507 5.507 0 013.102 8.05 3.49 3.49 0 012 5.5zM11 4a.75.75 0 100 1.5 1.5 1.5 0 01.666 2.844.75.75 0 00-.416.672v.352a.75.75 0 00.574.73c1.2.289 2.162 1.2 2.522 2.372a.75.75 0 101.434-.44 5.01 5.01 0 00-2.56-3.012A3 3 0 0011 4z"></path>
                                        </svg>
                                    병합 요청 (멤버)
                                    </div>
                                </a>
                            </li>  
                            <li class="setting_left_li setting_left_li2">
                                <a @click="changetab('pullreq')">
                                    <div class="setting_left_span setting_left_span2">
                                        <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-git-pull-request UnderlineNav-octicon d-none d-sm-inline">
                                            <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                                        </svg>
                                        병합 요청 (외부)
                                    </div>
                                </a>
                            </li>
                           
                        </ul>
                    </div>
                    <div class="pullreq_main_div">                
                        <div id="pullreq_main">
                            <pullreqnomem @merge_func="merge_func" v-if="ispullreq"/>
                            <pullreqmem @merge_func="merge_func" v-if="isrepomember"/>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
        <div v-if="merge_page == true" style="height: 100%">
            <pullreq_merge_mem @merge_func_close="merge_func_close" :token_repoidx="this.token_repoidx"></pullreq_merge_mem>
        </div>
    </div>
</template>
<script>
import pullreqnomem from "@/components/repository/pullrequest_nomem.vue";
import pullreqmem from "@/components/repository/pullrequest_mem.vue";
import pullreq_merge_mem from "@/components/repository/merge/pullreq_merge_mem.vue";
import axios from "axios";

export default {
  computed: {
    cssVariable() {
      return {
        "--li1": this.li1,
        "--li2": this.li2,
        "--span1": this.span1,
        "--span2": this.span2,
      };
    },
  },
  data() {
    return {
      select_bool: true,

      pullreq_page: true,
      merge_page: false,

      isrepomember: true,
      ispullreq: false,

      li2: "white",
      li1: "pink",

      span2: "white",
      span1: "rgb(188, 204, 202,0.2)",

      //repo_idxs: this.repo_idx_props,

      token_repoidx: {
        token: "",
        repo_idx: "",
      },
    };
  },
  components: {
    pullreqnomem: pullreqnomem,
    pullreqmem: pullreqmem,
    pullreq_merge_mem: pullreq_merge_mem,
  },
  mounted() {
    this.find_repo();
  },
  methods: {
    changetab(tab) {
      if (tab == "repomember") {
        this.isrepomember = true;
        this.ispullreq = false;

        this.li1 = "pink";
        this.li2 = "white";

        this.span1 = "rgb(188, 204, 202,0.2)";
        this.span2 = "white";
      } else if (tab == "pullreq") {
        this.isrepomember = false;
        this.ispullreq = true;

        this.li1 = "white";
        this.li2 = "pink";

        this.span1 = "white";
        this.span2 = "rgb(188, 204, 202,0.2)";
      }
    },
    find_repo() {
      // 존재하는 저장소인지 확인하자
      axios
        .post("/api/find_repo", {
          name: this.$route.params.repository,
        })
        .then((response) => {
          if (response.data == "") {
            location.href = "/pagenotfound";
          }
        });
    },
    merge_func(token_para, repo_idx_para, mainToken, fast) {
      this.token_repoidx.token = token_para;
      this.token_repoidx.repo_idx = repo_idx_para;
      this.token_repoidx.mainToken = mainToken;
      this.token_repoidx.fast = fast;
      this.pullreq_page = false;
      this.merge_page = true;
    },
    merge_func_close() {
      this.pullreq_page = true;
      this.merge_page = false;
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/pullrequest"
</style>