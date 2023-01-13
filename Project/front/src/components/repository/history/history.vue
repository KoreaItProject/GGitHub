<template lang="">
    <div class="repository_history_container">
        <div class ="repository_history_div">
            <div class="repository_history_left">
              <div class="repository_history_head">
                <div class="repository_history_tit"><h3><font-awesome-icon icon="fa-regular fa-file-code" /> 메인 히스토리</h3></div>
                <div class="repository_history_tit_right">
                  <span class="blue_point">  <i class="fa-solid fa-arrows-turn-to-dots "></i></span> 비교병합  <span class="blue_point">  <i class="fa fa-bolt"></i></span>빠른병합
                </div>
              </div>
                
              <mainHistory />
 
            </div>
            <div class="repository_history_right" @click="false">

              <div class="repository_history_head">
                <div class="repository_history_tit"> <h3><font-awesome-icon icon="fa-regular fa-copy" /> 작업 히스토리</h3></div>
                <div class="repository_history_tit_right">
                  <font-awesome-icon icon="fa-solid fa-arrow-up" /> 이어짐
                  <i class="fa-solid fa-arrow-turn-up" style="color:#fa5a5a"></i> 이전상태
                  <font-awesome-icon icon="fa-solid fa-arrow-right " /> 메인상태
                </div>
              </div>
              
             
              <div class="history_right">

              <myHistory />
              </div>
            </div>
            
        </div>
    </div>
</template>

<script>
import mainHistory from "./mainHistory.vue";
import myHistory from "./myHistory.vue";
import store from "@/vuex/store.js";
export default {
  data() {
    return {
      col: this.$route.query.col,
    };
  },
  components: {
    mainHistory: mainHistory,
    myHistory: myHistory,
  },
  mounted() {},
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/history"
</style>