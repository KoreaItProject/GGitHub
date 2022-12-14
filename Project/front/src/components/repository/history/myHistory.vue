<template lang="">
    <div>
    
          <div class="repository_history_table_div scrollBar">
            
              <div v-for="(data,index) in history" >
                <div class="repository_history_table">    
                  <div class="repo_history_div">
                    <div class="repo_history_con"  @click="clickIndex==index?clickIndex=-1:clickIndex=index">
                      <div class="history_message">
                        <font-awesome-icon icon="fa-regular fa-circle-check" v-if="data.selected==1"/>{{data.push_message}}</div>
                      <div class="history_nick">{{data.push_date}}</div>
                      <div class="history_date">{{data.before_token}}</div>
                      <div class="history_token">{{data.push_token}}</div>
                    </div>
                    <div class="repo_history_btn" @click="click(index)">
                      
                      <font-awesome-icon icon="fa-check" />
                    </div>
                  </div>       
                 
             
                
                   
                      <div class="history_info_div" v-if="clickIndex==index">

                      <div class="history_info_left">
                          {{data.push_message}}
                          
                      </div>
                      <div class="history_info_right">

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
export default {
  data() {
    return {
      clickIndex: -1,
      history: { push_massge: "데이터가 없습니다." },
    };
  },
  methods: {
    click(token) {
      axios
        .get("/api/changeSelected", {
          params: {
            token: token,
            repo: this.$route.params.repository,
            member: store.getters.getUserIdx,
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