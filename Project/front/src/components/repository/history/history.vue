<template lang="">
    <div class="repository_history_container">
        <div class ="repository_history_div">
            <div class="repository_history_left">
                  <select name="barnch_select" class="branch_select_btn" v-model="isMain">
                        <option :value=true selected>메인</option> 
                        <option :value=false>내 작업영역</option> 
                  </select>
              <mainHistory v-if="isMain"/>
              <myHistory v-if="!isMain"/>
            </div>
            <div class="repository_history_right">
              <div class="history_right">

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
    return { isMain: true };
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