<template lang="">
    <div class="search_container" :style="cssVariable">
        <div class="search_left_container">
            <ul class="search_left_ul">
                <li class="search_left_li search_left_li1" v-if="isLogin">
                    <a :href="'/search?tab=my&keyword='+keyword">
                    <div class="search_left_span search_left_span1">
                        내 저장소
                    </div></a
                    >
                </li>
                <li class="search_left_li search_left_li2">
                    <a :href="'/search?tab=all&keyword='+keyword">
                    <div class="search_left_span search_left_span2">     
                        모든 저장소
                    </div></a
                    >
                </li>
                <li class="search_left_li search_left_li3">
                    <a :href="'/search?tab=member&keyword='+keyword">
                    <div class="search_left_span search_left_span3">     
                        회원
                    </div></a
                    >
                </li>
        
            </ul>
        </div>

        <div class="search_right_container">
            <my v-if="my"/>
            <all v-if="all"/>
            <member v-if="member"/>
        </div>
        
    </div>
</template>
<script>
import axios from "axios";
import store from "../../vuex/store";
import my from "@/components/search/my";
import all from "@/components/search/all";
import member from "@/components/search/member";
export default {
  computed: {
    cssVariable() {
      return {
        "--li1": this.li1,
        "--li2": this.li2,
        "--li3": this.li3,
        "--span1": this.span1,
        "--span2": this.span2,
        "--span3": this.span3,
      };
    },
  },
  data() {
    return {
      my: false,
      all: false,
      member: false,
      li1: "white",
      li2: "white",
      li3: "white",
      span1: "white",
      span2: "white",
      span3: "white",
      keyword: this.$route.query.keyword,
      tab: this.$route.query.tab,
      isLogin: store.getters.getIsLogin,
      searchResult: {},
    };
  },
  components: {
    my,
    all,
    member,
  },
  methods: {
    tabChange() {
      if (this.tab == "all") {
        (this.li2 = "pink"),
          (this.span2 = "rgb(188, 204, 202,0.2)"),
          (this.all = true);
      } else if (this.tab == "member") {
        (this.li3 = "pink"),
          (this.span3 = "rgb(188, 204, 202,0.2)"),
          (this.member = true);
      } else {
        if (this.isLogin) {
          (this.li1 = "pink"),
            (this.span1 = "rgb(188, 204, 202,0.2)"),
            (this.my = true);
        } else {
          (this.li2 = "pink"),
            (this.span2 = "rgb(188, 204, 202,0.2)"),
            (this.all = true);
        }
      }
    },
  },
  mounted() {
    this.tabChange();
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/search/search'
</style>