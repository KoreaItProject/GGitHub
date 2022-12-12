<template lang="">
    <div>
    
        <div class="repository_history_table_div">          
            <table class="repository_history_table">
                <colgroup>
                       <col width="60%">
                        <col width="10%">
                        <col width="15%">
                        <col width="15%">
                </colgroup>  
                <tr>
                    <th>내용</th>
                    <th>날짜</th>
                  
                    <th>토큰</th>
                    <th>이전토큰</th>
                </tr>

            </table>
            <div class="repository_history_table_data_div scrollBar">
                <table class="repository_history_table" v-for="(data,index) in history">            
                <colgroup>
                        <col width="60%">
                        <col width="10%">
                        <col width="15%">
                        <col width="15%">
                </colgroup>  
                 <tr @click="clickIndex=index">
                    <td width="60%">{{data.push_message}}</td>
                    <td class="center_text">{{data.push_date}}</td>
                    <td class="center_text">{{data.push_token}}</td>
                    <td class="center_text">{{data.before_token}}</td>
                </tr>
                <div class="repository_history_click_container" v-show="clickIndex==index">
                    <button>현재 내 작업 영역으로 지정</button>
                </div>
            </table>
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