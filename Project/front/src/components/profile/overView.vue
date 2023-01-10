<template>
  <div class="overView_container">
    <div>111</div>
    <div class="overView_readme overView_div" v-show="mdText != ''">
      <div
        class="overView_readme_content markdown-body"
        v-html="changeMarkdown"
      ></div>
    </div>
    <div class="overView_pinned_div">
      <div class="overView_pinned_top">
        <span class="overView_pinned_top_left">Pinned</span>
        <span class="overView_pinned_top_right"
          ><a>Customize your pins</a></span
        >
      </div>
      <div class="overView_pins_div">
        <draggable
          v-model="pins"
          @change="checkMove()"
          ghost-class="ghost"
          handle=".handle"
          class="list-group"
          tag="div"
          v-bind="dragOptions"
          @start="drag = true"
          @end="drag = false"
        >
          <div
            class="overView_pins overView_div"
            v-for="pin in pins"
            v-bind:key="pin.idx"
          >
            <div class="overView_pins_div_inner">
              <div class="overView_pins_div_inner_first">
                <div class="overView_pins_div_inner_first_left">
                  <svg
                    class="octicon mr-1"
                    aria-hidden="true"
                    height="16"
                    viewBox="0 0 16 16"
                    version="1.1"
                    width="16"
                    data-view-component="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M2 2.5A2.5 2.5 0 014.5 0h8.75a.75.75 0 01.75.75v12.5a.75.75 0 01-.75.75h-2.5a.75.75 0 110-1.5h1.75v-2h-8a1 1 0 00-.714 1.7.75.75 0 01-1.072 1.05A2.495 2.495 0 012 11.5v-9zm10.5-1V9h-8c-.356 0-.694.074-1 .208V2.5a1 1 0 011-1h8zM5 12.25v3.25a.25.25 0 00.4.2l1.45-1.087a.25.25 0 01.3 0L8.6 15.7a.25.25 0 00.4-.2v-3.25a.25.25 0 00-.25-.25h-3.5a.25.25 0 00-.25.25z"
                    ></path>
                  </svg>
                  <a class="blue_point" @click="pin_click(pin.nick, pin.name)"
                    ><span>{{ pin.nick }} / {{ pin.name }}</span></a
                  >
                </div>
                <div class="overView_pins_div_inner_first_right">
                  <span class="repo_move_icon handle">
                    <svg
                      height="17px"
                      viewBox="0 0 16 16"
                      version="1.1"
                      width="17px"
                    >
                      <path
                        d="M10 13a1 1 0 100-2 1 1 0 000 2zm-4 0a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zm3 1a1 1 0 100-2 1 1 0 000 2zm1-5a1 1 0 11-2 0 1 1 0 012 0zM6 5a1 1 0 100-2 1 1 0 000 2z"
                      ></path>
                    </svg>
                  </span>
                </div>
              </div>
              <p class="overView_pins_second">{{ pin.description }}</p>
              <p class="overView_pins_third">
                <a class="overView_pins_third_a1">
                  <svg
                    aria-label="star"
                    role="img"
                    height="16"
                    viewBox="0 0 16 16"
                    version="1.1"
                    width="16"
                    data-view-component="true"
                  >
                    <path
                      fill-rule="evenodd"
                      d="M8 .25a.75.75 0 01.673.418l1.882 3.815 4.21.612a.75.75 0 01.416 1.279l-3.046 2.97.719 4.192a.75.75 0 01-1.088.791L8 12.347l-3.766 1.98a.75.75 0 01-1.088-.79l.72-4.194L.818 6.374a.75.75 0 01.416-1.28l4.21-.611L7.327.668A.75.75 0 018 .25zm0 2.445L6.615 5.5a.75.75 0 01-.564.41l-3.097.45 2.24 2.184a.75.75 0 01.216.664l-.528 3.084 2.769-1.456a.75.75 0 01.698 0l2.77 1.456-.53-3.084a.75.75 0 01.216-.664l2.24-2.183-3.096-.45a.75.75 0 01-.564-.41L8 2.694v.001z"
                    ></path>
                  </svg>
                  1
                  <!-- 즐겨찾기기능이 구현되야함 -->
                </a>
              </p>
            </div>
          </div>
        </draggable>
      </div>
      <div class="overView_contribution_div" :style="cssVariable">
        <div class="overView_contribution_inner_div">
          <calendar-heatmap
            :values="this.contribution_data"
            :end-date="Date()"
            tooltip-unit="contribution"
            :max="5"
            :range-color="[
              '#ebedf0',
              '#9be9a8',
              '#40c463',
              '#30a14e',
              '#216e39',
            ]"
          >
          </calendar-heatmap>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import marked from "marked";
import store from "../../vuex/store";
import { log } from "console";
import draggable from "vuedraggable";

export default {
  props: [
    "entries",
    "colorRange",
    "tooltipEnabled",
    "tooltipUnit",
    "locale",
    "max",
    "onClick",
    "selector",
  ],
  name: "ShowMdPage",
  data() {
    return {
      mdText: "",
      pins: [],
      contribution_top: "0px",
      contribution_data: [], // 잔디 데이터
      user_idx: "",
      readme_status: null
    };
  },
  mounted() {
    this.getContributionData();
    this.getMD();
    this.getUserIdx();
  },
  methods: {
    getContributionData() {
      axios
        .post("/api/getContributionData", {
          nick: this.$route.params.nick,
        })
        .then((response) => {
          // console.log(response.data);
          this.contribution_data = response.data;
        });
    },
    getMD() {
      axios
        .get("/api/getMD", {
          params: {
            nick: this.$route.params.nick,
          },
        })
        .then((response) => {
          if(response.data == ''){
            this.readme_status = false;
          }else{
            this.readme_status = true;
          }
          this.mdText = response.data;
        });
    },
    getUserIdx() {
      // 닉네임으로 user의 idx 가져오기
      axios
        .post("/api/getUserIdx", {
          nick: this.$route.params.nick,
        })
        .then((response) => {
          this.user_idx = response.data;
          this.getMyPin();
        });
    },
    getMyPin() {
      // 고정되어있는 저장소 데이터 가져오기
      axios
        .post("/api/getMyPin", {
          u_idx: this.user_idx,
        })
        .then((response) => {
          this.pins = response.data;
        });
    },
    pin_click(nick, name) {
      window.location.href = "/" + nick + "/" + name;
    },
    checkMove() {
      console.log(this.pins);
      axios
        .post("/api/pinSort", {
          idx: store.getters.getUserIdx,
          pins: this.pins,
        })
        .then((response) => {})
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {});
    },
  },
  components: {
    draggable,
  },
  computed: {
    dragOptions() {
      return {
        animation: 325,
        group: "description",
        disabled: false,
        ghostClass: "ghost",
        searchStr: "",
      };
    },
    cssVariable() {
      return {
        "--contribution-top": this.contribution_top,
      };
    },
    changeMarkdown() {
      this.contribution_top =
        Math.trunc((this.pins.length + 1) / 2) * 113 + "px";

      marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        headerIds: false,
        tables: true,
        breaks: true,
        pedantic: false,
        smartLists: true,
        smartypants: false,
      });
      let changedText = marked(this.mdText);
      changedText = changedText.replaceAll("&lt;", "<");
      changedText = changedText.replaceAll("&gt;", ">");
      changedText = changedText.replaceAll("&quot;", '"');
      return changedText;
    },
  },
};
</script>
<style lang="sass">
@import "src/assets/sass/profile/overView"
@import "src/assets/sass/reset/markdown"
</style>
