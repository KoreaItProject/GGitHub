
<template>
  <div>
    <div id="summernote"></div>
  </div>
</template>
<script>
import { useListeners } from "vue";
import axios from "axios";
import router from "../../router";

import sum from "summernote";
import $ from "jquery";
import b from "bootstrap";
import a from "tiptap";

export default {
  data() {
    return {
      members: [],
    };
  },

  mounted() {
    $("#summernote").summernote();
  },
};
</script>

