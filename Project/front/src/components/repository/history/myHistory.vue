<template lang="">
    <div>
    
          <div class="repository_history_table_div">
            
      
                <div class="repository_history_table" v-for="(data,index) in history">            
          
                
                   <div class="history_message"> <font-awesome-icon icon="fa-sharp fa-solid fa-check" />{{data.push_message}}</div>
                   <div class="history_nick">{{data.push_date}}</div>
                    <div class="history_date">{{data.before_token}}</div>
                    <div class="history_token">{{data.push_token}}</div>
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
    click(index) {
      this.clickIndex = index;
    },
  },
  mounted() {
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
};
</script>
<style lang="">
</style>