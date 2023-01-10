<template lang="">
    <div>
  <div class="general_string">위험요소</div>
        <div class="danger_div_box">
            <li
            style="list-style:none;
            padding: 16px" v-if="public==1">
                <div >
                    <button class="change_visibility" @click=" setPrivate">비공개로 전환</button>
                </div>
                <div class="change_repository_visibility">
                    <strong>공개 전환</strong>
                    <div class="change_repository_visibility_message">
                        현재 저장소는 공개 상태입니다
                    </div>
                </div>
            </li>
            <li
            style="list-style:none;
            padding: 16px"
            v-if="public==0">
                <div >
                    <button class="change_visibility"  @click="setPublic" >공개로 전환</button>
                </div>
                <div class="change_repository_visibility">
                    <strong>공개 전환</strong>
                    <div class="change_repository_visibility_message">
                          현재 저장소는 비공개 상태입니다.
                    </div>
                </div>
            </li>
           
            <li
            style="list-style:none;
            padding: 16px">
                <div >
                    <button class="delete_btn"  @click="delopen">현재 저장소 삭제</button>
                </div>
                <div class="delete_this_repository">
                <strong>저장소 삭제</strong>
                <div class="delete_this_repository_message">
                   저장소를 삭제하면 되돌릴 수 없습니다.
                </div>
            </div>
            </li>
        </div>

    <div class="delinfo_container" v-if="delshow">
        <div class="delinfo_div">
            <div class="delinfo_top">
                저장소 삭제
            </div>
            <div class="delinfo_top_info">
                 저장소를 삭제하면 모든 데이터가 삭제되고 다시 되돌릴 수 없습니다.
            </div>
            <div class="delinfo_con"  v-show="!vibration">
                 저장소를 삭제하려면 {{infoText}} 를 입력해주세요
            </div>
            <div class="vibration delinfo_con" v-show="vibration" >
                 저장소를 삭제하려면 {{infoText}} 를 입력해주세요
            </div>
            <input type="text" class="delinfo_con_input" @input="getinput"></input>
            <div class="delinfo_btn" @click="del">
                확인
            </div>
            <div class="delinfo_btn" @click="delshow=false">
                취소
            </div>
        </div>
    </div>

    </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      public: true,
      delshow: false,
      infoText:
        "/" + this.$route.params.nick + "/" + this.$route.params.repository,
      repoidx: 0,
      vibration: false,
      infoInput: "",
    };
  },
  methods: {
    delopen() {
      this.delshow = true;
    },
    delclose() {
      this.delshow = false;
    },
    setPublic() {
      if (confirm("현재 저장소를 공개로 전환합니다")) {
        axios
          .get("/api/setPublic", {
            params: {
              idx: this.repoidx,
              publ: 1,
            },
          })
          .then((response) => {
            window.location.href =
              "/" +
              this.$route.params.nick +
              "/" +
              this.$route.params.repository;
          });
      }
    },
    setPrivate() {
      if (confirm("현재 저장소를 비공개로 전환합니다")) {
        axios
          .get("/api/setPublic", {
            params: {
              idx: this.repoidx,
              publ: 0,
            },
          })
          .then((response) => {
            window.location.href =
              "/" +
              this.$route.params.nick +
              "/" +
              this.$route.params.repository;
          });
      }
    },
    getpublic() {
      axios
        .get("/api/getPublic", {
          params: {
            nick: this.$route.params.nick,
            repoName: this.$route.params.repository,
          },
        })
        .then((response) => {
          this.public = response.data;
        });
    },

    del() {
      if (this.infoText != this.infoInput) {
        this.vibration = true;
        setTimeout(() => (this.vibration = false), 300);
      } else {
        axios
          .get("/api/deleterepo", {
            params: {
              repoidx: this.repoidx,
            },
          })
          .then((response) => {
            if (response.data == 1) {
              alert("저장소 삭제완료");
            } else {
              alert("저장소 삭제실패");
            }
          });
      }
    },
    getinput(e) {
      this.infoInput = e.target.value;
    },
  },
  mounted() {
    axios
      .get("/api/repoIdxByNickName", {
        params: {
          nick: this.$route.params.nick,
          reponame: this.$route.params.repository,
        },
      })
      .then((response) => {
        this.repoidx = response.data;
        if (this.repoidx == 0) {
          window.location.href = "pagenotfound";
        }
        this.getpublic();
      });
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/danger'
</style>