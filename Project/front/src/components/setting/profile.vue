<template lang="">
  <div class="setting_profile_container">
    <div class="setting_profile_title_div">
      <h2>프로필 설정</h2>
    </div>
    <div class="setting_profile_div">
      <div class="setting_profile_left">
        <div class="setting_profile_name_div">
          닉네임
          <input
            class="setting_input"
            type="text"
            :placeholder="userInfo.nick"
            v-model="nick"
            @input="changeNick"
          />
          <span class="nick_span nick_span_red" v-if="!nickCheck"
            >사용중인 닉네임입니다.</span
          >
          <span class="nick_span nick_span_blue" v-if="nickCheck"
            >사용 가능한 닉네임입니다.</span
          >
        </div>
        <div class="setting_profile_bio_div">
          소개
          <textarea
            class="setting_profile_bio"
            maxlength="150"
            v-model="userInfo.con"
          ></textarea>
          <span class="bio_span"
            >{{ userInfo.con == null ? 0 : userInfo.con.length }} / 150</span
          >
        </div>
        <div class="setting_profile_url_div">
          URL
          <input class="setting_input" type="text" v-model="userInfo.url" />
        </div>
        <div class="setting_profile_company_div">
          소속
          <input class="setting_input" type="text" v-model="userInfo.company" />
        </div>
        <div class="setting_profile_location_div">
          위치
          <input
            class="setting_input"
            type="text"
            v-model="userInfo.location"
          />
        </div>
        <div class="setting_profile_email_div">
          이메일 공개 여부
          <div class="test">
            <p>공개</p><input class="email_radio_open" id="test111" type="radio" name="group" v-model="email_open" value="1" @click="email_open_func">
            <p>비공개</p><input class="email_radio_private" type="radio" name="group" v-model="email_private" value="0" @click="email_private_func">
          </div>
        </div>
        <div class="setting_save_btn_div">
          <button class="setting_save_btn" @click="save">저장</button>
        </div>
      </div>
      <div class="setting_profile_right">
        <img
          class="setting_profile_img"
          :src="profileImg"
          width="200px"
          height="200px"
        />
        <div class="setting_profile_img_edit" @click="editImg">
          <svg
            aria-hidden="true"
            height="16"
            viewBox="0 -1 16 16"
            version="1.1"
            width="16"
            data-view-component="true"
            class="octicon octicon-pencil"
          >
            <path
              fill-rule="evenodd"
              d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"
            ></path>
          </svg>
          변경<input
            type="file"
            style="display: none"
            ref="edit_img"
            accept="image/*"
            v-on:change="imgChanged"
          />
        </div>
        <div class="setting_profile_img_delete" @click="delectImg">
          <svg
            width="16"
            height="16"
            version="1.1"
            viewBox="0 -3 96 96"
            enable-background="new 0 0 96 96"
            xml:space="preserve"
          >
            <polygon
              fill="white"
              points="96,14 82,0 48,34 14,0 0,14 34,48 0,82 14,96 48,62 82,96 96,82 62,48 "
            />
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
import axios from "axios";
import store from "../../vuex/store";

export default {
  data() {
    return {
      userInfo: { con: "" },
      profileImg: "",
      nickCheck: true,
      nick: "",
      email_open: "",
      email_private: "",
      email_check_value: "",
      imgch: 0
    };
  },
  methods: {
    ...mapActions(["nick_cookie_update"]),
    getProfileImg() {
      axios
        .get("/api/getProfileImg", {
          responseType: "blob",
          params: {
            img: this.userInfo.img
          }
        })
        .then(response => {
          // handle success
          this.profileImg = window.URL.createObjectURL(
            new Blob([response.data])
          );
        })
        .catch(error => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    getMemberInfo() {
      axios
        .get("/api/memberByNick", {
          params: {
            nick: store.getters.getUserNick
          }
        })
        .then(response => {
          // handle success
          this.userInfo = response.data;

          if(response.data.email_check == 1){
            this.email_open = 1;
            this.email_check_value = 1;
          }else if(response.data.email_check == 0){
            this.email_private = 0;
            this.email_check_value = 0;
          }

          if (this.userInfo.con != null && this.userInfo.con != "") {
            this.userInfo.con = this.userInfo.con.replace(/<br\/>/g, "\n");
          }

          this.getProfileImg();
        })
        .catch(error => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    changeNick() {
      if (this.nick != "") {
        axios
          .get("/api/hasNick", {
            params: {
              nick: this.nick
            }
          })
          .then(response => {
            // handle success
            this.nickCheck = !response.data;
          })
          .catch(error => {
            // handle error
            console.log(error);
          })
          .finally(() => {
            // always executed
          });
      }
    },
    //프로필 이미지 설정
    editImg() {
      this.$refs.edit_img.click();
    },
    delectImg() {
      this.imgch = 2;
      this.profileImg = require("@/assets/imgs/main/profileDef.png");
    },
    imgChanged(e) {
      var files = e.target.files || e.dataTransfer.files;
      if (!files.length) return;
      var reader = new FileReader();
      reader.onload = e => {
        this.profileImg = e.target.result;
      };
      reader.readAsDataURL(files[0]);
      this.imgch = 1;
    },
    saveImg() {
      if (this.imgch == 1) {
        var frm = new FormData();
        var photoFile = this.$refs.edit_img;
        console.log(photoFile.files[0]);
        frm.append("saveImg", photoFile.files[0]);
        frm.append("idx", store.getters.getUserIdx);
        console.log(frm);
        axios
          .post("/api/saveImg", frm, {
            headers: {
              "Content-Type": "multipart/from-data"
            }
          })
          .then(response => {
            // handle success
          });
      } else if (this.imgch == 2) {
        axios
          .get("/api/delectImg", {
            params: {
              idx: store.getters.getUserIdx
            }
          })
          .then(response => {
            // handle success
          });
      }
    },

    save() {
      if (this.nick != "" && this.nickCheck) {
        this.userInfo.nick = this.nick;
      }

      axios
        .get("/api/saveProfile", {
          params: {
            idx: store.getters.getUserIdx,
            nick: this.userInfo.nick,
            con: this.userInfo.con,
            url: this.userInfo.url,
            company: this.userInfo.company,
            location: this.userInfo.location,
            email_check: this.email_check_value
          }
        })
        .then(response => {
          // handle success
          const nick = this.userInfo.nick + "";
          this.nick_cookie_update(nick);
          this.saveImg();
          alert("저장 되었습니다.");
          window.location.href = "" + this.userInfo.nick + "?tab=setting";
        })
        .catch(error => {
          // handle error
          console.log(error);
        })
        .finally(() => {
          // always executed
        });
    },
    email_open_func(){
      this.email_check_value = 1;
    },
    email_private_func(){
      this.email_check_value = 0;
    }
  }, // method
  mounted() {
    this.getMemberInfo();
    
  }
};
</script>
<style lang="sass">
  @import "src/assets/sass/setting/profile"
</style>
