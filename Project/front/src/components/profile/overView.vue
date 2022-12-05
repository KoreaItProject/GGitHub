<template>
  <div class="overView_container">
    <div class="overView_readme overView_div">
      <div class="overView_readme_title">
        <svg
          aria-hidden="true"
          height="16"
          viewBox="0 0 16 16"
          version="1.1"
          width="16"
          data-view-component="true"
          class="overView_readme_pencil"
        >
          <path
            fill-rule="evenodd"
            d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"
          ></path>
        </svg>
      </div>
      <div class="overView_readme_content" v-html="changeMarkdown"></div>
    </div>
    <div class="overView_pinned_div">
      <div class="overView_pinned_top">
        <span class="overView_pinned_top_left">Pinned</span>
        <span class="overView_pinned_top_right"
          ><a>Customize your pins</a></span
        >
      </div>
      <div class="overView_pins_div">
        <div
          class="overView_pins overView_div"
          v-for="pin in pins"
          v-bind:key="pin"
        ></div>
      </div>
      <div class="overView_contribution_div" :style="cssVariable">
        <calendar-heatmap :values="[{ date: '2022-1-10', count: 1 },{date: '2022-1-11', count: 1},{ date: '2022-1-12', count: 6 }]" 
                          :end-date="Date()"
                          :max="5"
                          :range-color="[
                          '#ebedf0',
                          '#9be9a8',
                          '#40c463',
                          '#30a14e',
                          '#216e39'
                          ]"
                          >
        </calendar-heatmap>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import marked from "marked";

export default {
  props: ['entries', 'colorRange', 'tooltipEnabled', 'tooltipUnit', 'locale', 'max', 'onClick', 'selector'],
  name: "ShowMdPage",
  mounted() {
    // this.renderHeatMap()
  },
  watch: {
    entries() {
      // this.renderHeatMap()
    }
  }, 
  data() {
    return {
      mdText:
        "[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=ymiru0324&layout=compact&&theme=dark&&&langs_count=6)](https://github.com/ymiru0324)",
      pins: ["", "", "", ""],
      contribution_top: "0px"
    };
  },
  computed: {
    cssVariable() {
      return {
        "--contribution-top": this.contribution_top
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
        sanitize: true,
        smartLists: true,
        smartypants: false
      });
      let changedText = marked(this.mdText);
      changedText = changedText.replaceAll("&lt;", "<");
      changedText = changedText.replaceAll("&gt;", ">");
      changedText = changedText.replaceAll("&quot;", '"');
      return changedText;
    },
  }
};
</script>
<style lang="sass">
@import "src/assets/sass/profile/overView"
</style>
