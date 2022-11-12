<template lang="">
    <div class="repository_history_container">
        <div class ="repository_history_div">
            <div class="repository_history_left">
                <div class="repository_history_table_div">          
                    <table class="repository_history_table">
                      <colgroup>
                                <col width="55%">
                                <col width="15%">
                                <col width="20%">
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
                                 <col width="55%">
                                <col width="15%">
                                <col width="20%">
                                <col width="10%">
                        </colgroup>  
                        <tr @click="click(index)">
                            <td width="55%">내용</td>
                            <td>날짜</td>
                            <td>사용자</td>
                            <td>토큰</td>
                        </tr>
             
                      
                    </table>
                    </div>
                </div>
            </div>
            <div class="repository_history_right">
                <div class="repository_history_control_container">

                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      history: [
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
      ],
    };
  },
  methods: {
    click(index) {
      alert(index);
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/history"
</style>