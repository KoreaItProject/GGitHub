<template lang="">
    <div>
        <div class="repository_history_table_div">          

              <div class="repository_history_table" v-for="(data,index) in history" @click="clickIndex=index">            
              
        
                   <div class="history_message">{{data.push_message}}</div>
                   <div class="history_nick">{{data.member_nick}}</div>
                    <div class="history_date">{{data.push_date}}</div>
                    <div class="history_token">{{data.push_token}}</div>
      
           
              </div>
       

        </div>
    </div>
</template>
<script>
import axios from "axios";
import store from "@/vuex/store";

export default {
  data() {
    return {
      clickIndex: -1,
    };
  },
  methods: {
    click(index) {
      this.clickIndex = index;
    },
  },
  mounted() {
    axios
      .get("/api/selectHistory", {
        params: {
          mode: "main",
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
};
</script>
<style lang="">
</style>