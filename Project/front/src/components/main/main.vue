<template>
  <div class="main_container">
    <div
      class="main_img_div"
      style="
        background: url('./static/imgs/main/bg.jpg');
        background-repeat: no-repeat, round;
        background-size: cover;
        background-position: center;
      "
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
                style="color: red"
                class="nick_span nick_span_red"
                v-if="!nickCheck"
                >사용중인 닉네임입니다.</span
              >
              <span
                style="color: blue"
                class="nick_span nick_span_blue"
                v-if="nickCheck"
                >사용 가능한 닉네임입니다.</span
              >
            </div>

            <input
              ref="ref_email"
              id="input_email"
              class="input"
              name="email"
              placeholder="이메일"
              v-model="email"
            />
            <a class="btn_a" @click="mail_sender">
              <span class="btn_span">인증</span>
              <div class="liquid"></div>
            </a>

            <div v-if="this.emailCheck == true">
              <input
                ref="ref_check_code"
                id="input_code"
                class="input"
                name="email_code"
                placeholder="인증번호"
                v-model="input_code"
              />
              <a class="btn_a" @click="code_check">
                <span class="btn_span">확인</span>
                <div class="liquid"></div>
              </a>
            </div>

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

            <div class="div_letter">
              <h6 class="">
                Use at least one letter, one numeral, and seven characters.
              </h6>
            </div>
            <p style="margin: 10px 0px">
              <button type="submit" class="btn--primary">회원가입</button>
            </p>

            <div class="div_letter">
              By clicking "Sign up for GitHub", you agree to our terms of
              service and privacy policy. We'll occasionally send you account
              related emails.
            </div>
          </form>
        </div>
      </div>
    </div>
    <div><img class="img2" src="@/assets/imgs/main/bg2.png" /></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      nickCheck: false,
      emailCheck: false,
      codeCheck: false,
      return_code: "",
      input_code: "",
      nick: "",
      email: "",
      pw: "",
      check_display: "display:none;",
      smgHtmlPath: "https://www.naver.com/",
    };
  },
  mounted() {},
  methods: {
    async signup() {
      if (this.nick == "" || this.email == "" || this.pw == "") {
        alert("빈 곳을 채워주세요");
      } else if (!this.nickCheck) {
        alert("중복된 닉네임입니다");
        this.$refs.ref_nick.focus();
      } else if (!this.emailCheck) {
        alert("이메일 인증을 해주세요!");
      } else if (!this.codeCheck) {
        alert("인증 번호를 확인해주세요!");
      } else {
        const sign_up_result = await axios.post("/api/signup", {
          nick: this.nick,
          email: this.email,
          pw: this.pw,
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
                nick: this.nick,
              },
            })
            .then((response) => {
              // handle success
              this.nickCheck = !response.data;
            })
            .catch((error) => {
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
          .then((response) => {
            this.return_code = response.data;
            if (response.status == 200) {
              alert("인증 메일 전송 성공");
              this.emailCheck = true;
              document.getElementById("input_email").readOnly = true;
            } else {
              alert("메일 전송 실패");
            }
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            //
          });
      }
    }, // mail_sender()
    code_check() {
      if (this.input_code == this.return_code) {
        alert("인증 완료!");
        this.codeCheck = true;
        document.getElementById("input_code").readOnly = true;
      } else {
        alert("인증 실패!");
        this.$refs.ref_check_code.focus();
      }
    },
  },
};
</script>


<style lang="sass">
@import "src/assets/sass/main/main"
@import "src/assets/sass/main/main_email_check"
@import "src/assets/sass/main/maincon"
</style>
