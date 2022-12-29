<template lang="">
    <div class="general_main_div">
        <div class="general_top_div">
            <div class="general_string">정보</div>
            <div class="repo_name_change">저장소 이름 변경</div>
            <input ref="ref_repo_name" class="repo_name_change_input" :placeholder="repo_name" @input="input_rename" v-on:keyup.enter="repo_rename_func" v-model="repo_rename"/>
            <button class="repo_rename_btn" @click="repo_rename_func">적용하기</button>

            <div class="repo_about_setting_box">
                <div class="repo_about">저장소 소개글 변경</div>
                <div>
                    <textarea class="repo_about_textarea" :placeholder="repo_message" @input="repo_remesagge" v-model="repo_remessage"></textarea>
                </div>
                <button class="repo_about_btn" @click="repo_remessage_func()" >적용하기</button>
            </div>

        </div>
    </div>
</template>
<script>
import axios from "axios";
import { rename } from "fs";
import { log } from "console";
export default {
  data() {
    return {
      repo_remessage: "",
      repo_message: "",
      repo_owner: "",
      repoIdx: "",
      repo_rename: "",
      repo_name: this.$route.params.repository,
    };
  },
  mounted() {
    this.repoIdxByNickName();
    this.repo_owner = this.$route.params.nick;
  },
  methods: {
    repo_rename_func() {
      if (this.repo_rename.trim() == "") {
        alert("내용을 작성해주세요");
        this.repo_rename = "";
        this.$refs.ref_repo_name.focus();
      } else {
        if (confirm(this.repo_rename + " 으/로 변경하시겠습니까?")) {
          axios
            .post("/api/repo_rename", {
              idx: this.repoIdx,
              repo_rename: this.repo_rename,
            })
            .then((response) => {
              if (response.data > 0) {
                alert("변경 성공");
                location.href =
                  "/" +
                  this.repo_owner +
                  "/" +
                  this.repo_rename +
                  "?tab=setting";
                this.repo_rename = "";
              } else {
                alert("변경 실패");
                this.$refs.ref_repo_name.focus();
              }
            });
        } else {
          this.$refs.ref_repo_name.focus();
        }
      }
    }, // repo_rename_func
    input_rename(e) {
      this.repo_rename = e.target.value;
    },
    repo_remesagge(e) {
      this.repo_remesagge = e.target.value;
    },
    repoIdxByNickName() {
      axios
        .get("/api/repoIdxByNickName", {
          params: {
            nick: this.$route.params.nick,
            reponame: this.$route.params.repository,
          },
        })
        .then((response) => {
          this.repoIdx = response.data;
          this.get_repo_message();
        });
    },
    get_repo_message() {
      // 저장소 소개글 가져오는 함수
      axios
        .post("/api/getrepomessage", {
          idx: this.repoIdx,
        })
        .then((response) => {
          console.log(response.data);
          this.repo_message = response.data.description;
        });
    },
    repo_remessage_func() {
      // 저장소 소개글 업데이트 함수
      if (this.repo_remessage.trim() == "") {
        alert("변경 내용을 작성해주세요");
      } else {
        axios
          .post("/api/repo_remessage_func", {
            idx: this.repoIdx,
            description: this.repo_remessage,
          })
          .then((response) => {
            if (response.data > 0) {
              alert("변경 성공");
              this.$router.go();
            } else {
              alert("변경 실패");
            }
          });
      }
    },
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/general'
</style>