<template lang="">
    <div>
    
          <div class="repository_history_table_div scrollBar">
            
              <div v-for="(data,index) in history" >
                <div class="repository_history_table">    
                  <div class="repo_history_div">
                    <div class="repo_history_con" @click="clickDiv(index,data.repo_idx)">
                      <div class="history_message">
                        <font-awesome-icon icon="fa-regular fa-circle-check" v-if="data.selected==1"/>{{data.push_message}}</div>
                      <div class="history_nick"><time-ago local="en" :datetime="data.push_date" refresh tooltip long  /></div>
                      <div class="history_date">{{data.before_token}}</div>
                      <div class="history_token">{{data.push_token}}</div>
                    </div>
                    <div class="repo_history_btn" @click="click(index)" title="현재 상태로 지정">
                      
                      <font-awesome-icon icon="fa-check" />
                    </div>
                  </div>       
                 
             
                
                   
                      <div class="history_info_div" v-if="clickIndex==index">

                      <div class="history_info_left">
                          {{data.push_message}}
                          
                      </div>
                      <div class="history_info_right scrollBar">
                          <div v-for="data in changed" class="history_info_right_div">
                            <div class="history_info_right_divs1">{{data.path}}</div><div class="history_info_right_divs2">{{data.state}}</div>
                          </div>
                      </div>
                    </div>
                   
                </div>
                 <div style="text-align:center;;width:100%;padding:5px 0">
                    <font-awesome-icon icon="fa-solid fa-arrow-up" />
                  </div> 
              </div>
              <div class="repository_history_table" style="padding:5px 0;text-align:center">
                저장소 생성
              </div>
           

      </div>
      </div>
</template>

<script>
import "@/assets/js/fontAwesomeIcon.js";
import axios from "axios";
import store from "@/vuex/store";
import { TimeAgo } from "vue2-timeago";
export default {
  data() {
    return {
      clickIndex: -1,
      history: {},
      changed: {},
    };
  },
  components: {
    TimeAgo,
  },
  methods: {
    clickDiv(index, repo) {
      this.clickIndex == index
        ? (this.clickIndex = -1)
        : (this.clickIndex = index);
      axios
        .get("/api/getHistoryChanged", {
          params: {
            repo: repo,
            token: this.history[index].push_token,
          },
        })
        .then((response) => {
          this.changed = response.data;
          // console.log(this.clone);
          //alert(this.clone);
        });
    },
    click(idx) {
      axios
        .get("/api/changeSelected", {
          params: {
            token: this.history[idx].push_token,
            repo: this.$route.params.repository,
            member: store.getters.getUserIdx,
            ownerNick: this.$route.params.nick,
          },
        })
        .then((response) => {
          this.getHistory();
        });
    },
    getHistory() {
      axios
        .get("/api/selectHistory", {
          params: {
            mode: "my",
            repo: this.$route.params.repository,
            member: store.getters.getUserIdx,
            ownerNick: this.$route.params.nick,
          },
        })
        .then((response) => {
          this.history = response.data;

          // console.log(this.clone);
          //alert(this.clone);
        });
    },
  },
  mounted() {
    this.getHistory();
  },
};
</script>
<style lang="">
</style>