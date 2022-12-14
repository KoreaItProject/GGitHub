<template lang="">
    <div class="repository_history_container">
        <div class ="repository_history_div">
            <div class="repository_history_left">
              <div class="repository_history_head">
                <div class="repository_history_tit"><h3>{{isMain?"메인":"작업"}} 히스토리</h3></div>
                  <select name="barnch_select" class="branch_select_btn" v-model="isMain">
                        <option :value=true selected>메인</option> 
                        <option :value=false>작업</option> 
                  </select>
              </div>
                
              <mainHistory v-if="isMain"/>
              <myHistory v-if="!isMain"/>
            </div>
            <div class="repository_history_right" @click="false">
              <h3 v-if="!isMain">메인 히스토리</h3>
              <h3 v-if="isMain">작업 히스토리</h3>
              <div class="history_right">
              <mainHistory v-if="!isMain"/>
              <myHistory v-if="isMain"/>
              </div>
            </div>
            
        </div>
    </div>
</template>

<script>
import mainHistory from "./mainHistory.vue";
import myHistory from "./myHistory.vue";
export default {
  data() {
    return {
      col: this.$route.query.col,
      isMain: true,
    };
  },
  components: {
    mainHistory: mainHistory,
    myHistory: myHistory,
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/history"
</style>