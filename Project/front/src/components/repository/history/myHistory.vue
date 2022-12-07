<template lang="">
    <div>
    
        <div class="repository_history_table_div">          
            <table class="repository_history_table">
                <colgroup>
                        <col width="65%">
                        <col width="10%">
                        <col width="15%">
                        <col width="10%">
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
                        <col width="65%">
                        <col width="10%">
                        <col width="15%">
                        <col width="10%">
                </colgroup>  
                <tr @click="clickIndex=index">
                    <td width="65%">  <font-awesome-icon icon="trash-alt" /> 내 작업 영역 내용</td>
                    <td>날짜</td>
                    <td>사용자</td>
                    <td>토큰</td>
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
export default {
  data() {
    return {
      clickIndex: -1,
      history: ["", "", "", "", "", "", "", ""],
    };
  },
  methods: {
    click(index) {
      this.clickIndex = index;
    },
  },
};
</script>
<style lang="">
</style>