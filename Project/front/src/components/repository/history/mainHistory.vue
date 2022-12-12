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
                    <th>사용자</th>
                    <th>토큰</th>
                </tr>

            </table>
            <div class="repository_history_table_data_div scrollBar">
              <table class="repository_history_table" v-for="(data,index) in history">            
                <colgroup>

                </tr>
                <div class="repository_history_click_container" v-show="clickIndex==index">
                    <button>내 작업 영역으로 가져오기</button>
                </div>
              </table>
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