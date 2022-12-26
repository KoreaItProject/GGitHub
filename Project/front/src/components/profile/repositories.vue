<template lang="">
    <div class="repo">
        <div class = " repo_search_main">
            <a href="/create" v-if="newbtn">
            <button type ="button" class = "new_repo pink" >
            <svg aria-hidden="true" height="16" viewBox="0 -2 16 16" version="1.1" width="16" data-view-component="true" class="octicon_octicon_repo">
            <path fill-rule="evenodd" d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"></path>
            </svg>
            New</button>
            </a>
            <input type ="search" class = "repo_search" placeholder="저장소 검색" v-model="searchStr" v-on:keyup.enter="search"></input>
            
        </div>
      
          <div class="repo_list" id ="repo_list">
            <draggable  v-model="repo" @change ="checkMove"   ghost-class="ghost" handle=".handle"  class="list-group"  tag="ul"     v-bind="dragOptions"    @start="drag = true"    @end="drag = false" >             
              <li class="repo_li" v-for='data in repo'  >
               <a :href="'/'+data.member_nick + '/' + data.repo_name"  v-if="!(!newbtn&&data.repo_publ==0)">   <!--내가 이페이지 주인이 아니고 private일때 안보인다 -->
                  <div class="repo_info" >
                      <div class="repo_name_div" >
                        <span class="repo_name">
                              {{data.member_nick}} / {{data.repo_name}}</span>
                        <span class="repo_public" v-if="data.repo_publ==1">public</span>
                        <span class="repo_public" v-if="data.repo_publ==0">private</span>
                        <span class="repo_move_icon handle" v-if="isdrag">
                          <svg  height="17px" viewBox="0 0 16 16" version="1.1" width="17px" >
                              <path d="M10 13a1 1 0 100-2 1 1 0 000 2zm-4 0a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zm3 1a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zM6 5a1 1 0 100-2 1 1 0 000 2z"></path>
                          </svg>
                        </span>
                      </div>

                      <div class="repo_update">
                        <span><time-ago local="en" :datetime="data.push_date" refresh tooltip long  /></span>
                      </div>
                    </div>
                  </a>       
              </li>
            </draggable>   
          </div>
    </div>


</template>
<script>
import axios from "axios";
import draggable from "vuedraggable";
import store from "../../vuex/store";
import { TimeAgo } from "vue2-timeago";
export default {
  data() {
    return {
      repo: {},
      enabled: true,
      dragging: false,
      newbtn: this.$route.params.nick == store.getters.getUserNick,
      isdrag: this.$route.params.nick == store.getters.getUserNick,
    };
  },
  components: {
    draggable,
    TimeAgo,
  },
  computed: {
    dragOptions() {
      return {
        animation: 325,
        group: "description",
        disabled: false,
        ghostClass: "ghost",
        searchStr: "",
      };
    },
  },
  // methods: {
  //   checkMove: function (e) {
  //     console.log(this.repo);
  //     console.log(this.dragging);

  //     axios
  //       .post("/api/repoSort",{owner:store.getters.getUserIdx,repo: this.repo})
  //       .then((response) => {
  //         // handle success
  //       })
  //       .catch((error) => {
  //         // handle error
  //         console.log(error);
  //       })
  //       .finally(() => {
  //         // always executed
  //       });
  //   },
  // },
  methods: {
    checkMove: function (e) {
      console.log(this.repo);
      axios
        .post("/api/repoSort", {
          repo: this.repo,
          idx: store.getters.getUserIdx,
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

    search: function () {
      var str = this.searchStr;

      var strFound;
      // NAVIGATOR-SPECIFIC CODE

      strFound = window.find(str);

      if (!strFound) {
        strFound = window.find(str, 0, 1);

        while (window.find(str, 0, 1)) continue;
      }

      // EXPLORER-SPECIFIC CODE
    },
  },

  mounted() {
    axios
      .get("/api/myRepositories", {
        params: {
          nick: this.$route.params.nick,
        },
      })
      .then((response) => {
        // handle success
        this.repo = response.data;
        console.log(this.repo);
      })
      .catch((error) => {
        // handle error
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/profile/repositories"
</style>