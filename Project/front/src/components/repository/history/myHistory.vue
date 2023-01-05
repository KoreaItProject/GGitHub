<template lang="">
  <div>
  
        <div class="repository_history_table_div scrollBar">
          
            <div v-for="(data,index) in history" >
              <div class="repository_history_table">    
                <div class="repo_history_div">
                  <div class="repo_history_con" @click="clickDiv(index,data.repo_idx)">
                    <div class="history_message blue_point">
                      <font-awesome-icon icon="fa-regular fa-circle-check" v-if="data.selected==1"/>{{data.push_message}}</div>
                    <div class="history_nick">  <font-awesome-icon icon="fa-solid fa-arrows-rotate" /> <time-ago local="en" :datetime="data.push_date" refresh tooltip long  /></div>
                    <div class="history_date"><font-awesome-icon icon="fa-regular fa-file-code" /> {{data.before_token}}</div>
                    <div class="history_token"><font-awesome-icon icon="fa-regular fa-copy" /> {{data.push_token}}</div>
                  </div>
                  <div class="repo_history_btn" @click="click(index)" title="현재 상태로 지정">
                    
                    <font-awesome-icon icon="fa-check" />
                  </div>
                </div>       
               
           
              
                 
                    <div class="history_info_div" v-if="clickIndex==index">

                    <div class="history_info_left">
                        {{data.push_message}}
                        
                    </div>
                    <a class="history_info_right scrollBar">
                        <div v-for="data in changed" class="history_info_right_div">
                          <del class="history_info_right_divs history_info_right_del" v-if="data.state=='del'">{{data.path}}</del>
                          <ins class="history_info_right_divs history_info_right_add" v-if="data.state=='add'">{{data.path}}</ins>
                          <div class="history_info_right_divs history_info_right_change" v-if="data.state=='change'">{{data.path}}</div>

                        </div>
                      </a>
                  </div>
                 
              </div>
               <div style="text-align:center;;width:100%;padding:5px 0">
                  <font-awesome-icon icon="fa-solid fa-arrow-up" v-if="data.fromMain==0"/>
                  <font-awesome-icon icon="fa-solid fa-arrow-right" v-if="data.fromMain==1"/>
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
        alert("작업 저장소 상태가 변경 되었습니다.");
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