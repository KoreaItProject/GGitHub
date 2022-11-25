<template>
  <div class="main_container">
    <div
      class="main_img_div"
      style="
        background: url('./static/imgs/main/bg.jpg');
        background-repeat: no-repeat, round;
        background-size: cover;
        background-position: center;"
    >
      <div class="main_img_div_left">
        <h1 id="title">How people build software</h1>
        <h4 id="sub">
          Millions of developers use GitHub to build personal projects, support
          their businesses, and work together on open source technologies.
        </h4>
      </div>
      <div class="main_img_div_right">
        <div id="signupForm">
          <form @submit.prevent="signup">
            <p>
              <input
                ref="ref_nick"
                class="input"
                name="id"
                placeholder="닉네임"
                @input="check_nick"
              />
            </p>
            <div v-bind:style="check_display">
              <span
                style="color:red"
                class="nick_span nick_span_red"
                v-if="!nickCheck"
                >사용중인 닉네임입니다.</span
              >
              <span
                style="color:blue"
                class="nick_span nick_span_blue"
                v-if="nickCheck"
                >사용 가능한 닉네임입니다.</span
              >
            </div>

            <p>
              <input
                ref="ref_email"
                class="input"
                name="email"
                placeholder="이메일"
                v-model="email"
              />
              <a class="btn_a" @click="mail_sender">
                <span class="btn_span">인증</span>
                <div class="liquid"></div>
              </a>
            </p>

            <p>
              <input
                ref="ref_pw"
                name="password"
                class="input"
                placeholder="패스워드"
                v-model="pw"
                type="password"
              />
            </p>

            <h6 class="">
              Use at least one letter, one numeral, and seven characters.
            </h6>
            <p>
              <button type="submit" class="btn--primary">회원가입</button>
            </p>

            <p>
              <button type="button" class="btn--primary">
                <img
                  src="src\assets\imgs\main\btn_google_signin_light_focus_web.png"
                />
              </button>
            </p>
            By clicking "Sign up for GitHub", you agree to our terms of service
            and privacy policy. We'll occasionally send you account related
            emails.
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { log } from "console";
export default {
  data() {
    return {
      nickCheck: false,
      emailCheck: false,
      nick: "",
      email: "",
      pw: "",
      check_display: "display:none;"
    };
  },
  methods: {
    async signup() {
      if (this.nick == "" || this.email == "" || this.pw == "") {
        alert("빈 곳을 채워주세요");
      } else if (!this.nickCheck) {
        alert("중복된 닉네임입니다");
        this.$refs.ref_nick.focus();
      } else if (!this.emailCheck) {
        alert("이메일 인증을 해주세요!");
      } else {
        const sign_up_result = await axios.post("/api/signup", {
          nick: this.nick,
          email: this.email,
          pw: this.pw
        });
        if (sign_up_result.data > 0) {
          alert("회원가입 성공");
          this.$refs.ref_nick.value = "";
          this.$refs.ref_email.value = "";
          this.$refs.ref_pw.value = "";
          window.location.href = "/login";
        } else if (sign_up_result.data < 1) {
          alert("실패! 다시 시도해주세요~");
        }
      }
    }, // signup()
    async check_nick(e) {
      this.nick = e.target.value;

      if (this.nick == "") {
        this.nickCheck = false;
        this.check_display = "display:none;";
      } else {
        this.check_display = "display:inline;";

        if (this.nick != "") {
          await axios
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
      }
    },
    async mail_sender() {
      if (this.email == "") {
        alert("이메일을 입력해주세요!");
        this.$refs.ref_email.focus();
      } else {
        await axios
          .post("/api/emailsender", { email: this.email })
          .then(response => {
            if (response.status == 200) {
              alert("인증 메일 전송 성공");
            } else {
              alert("메일 전송 실패");
            }
          })
          .catch(error => {
            console.log(error);
          })
          .finally(() => {
            //
          });
      }
    }
  }
};
</script>

<style lang="sass">
@import "src/assets/sass/main/main"
@import "src/assets/sass/main/main_email_check"
</style>
