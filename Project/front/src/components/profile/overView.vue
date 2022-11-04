<template>
  <div style="width: 100%">
    <div></div>
    <div
      v-html="changeMarkdown"
      style="
        width: 100%;
        border: 1px solid red;
        text-align: center;
        padding: 30px;
        margin-top: 20px;
      "
    ></div>
  </div>
</template>

<script>
import axios from "axios";
import marked from "marked";
export default {
  name: "ShowMdPage",
  data() {
    return {
      mdText:
        "[![Top Langs](https://github-readme-stats.vercel.app/api/top-langs/?username=ymiru0324&layout=compact&&theme=dark&&&langs_count=6)](https://github.com/ymiru0324)",
    };
  },
  computed: {
    changeMarkdown() {
      marked.setOptions({
        renderer: new marked.Renderer(),
        gfm: true,
        headerIds: false,
        tables: true,
        breaks: true,
        pedantic: false,
        sanitize: true,
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
</style>