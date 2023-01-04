<template lang="">
    <div>
        <div class="header-wrapper">
            <div class="header-banner">
                <div class="container">
                    <a href="/">
                        <img class="logo" src="static/imgs/login/logoblack.png" />
                    </a>
                    
                    
                </div>
            </div>
        </div>
        <main>
            <div class="auth-form">
                <div class="auth-form-header"><h1>GGit</h1></div>
                <div class="auth-form-body">
                    <form @submit.prevent="onSubmitLogin" >
                        <label class="body-label" for="login_field">이메일</label>
                        <input ref="ref_email" type="text" name="login" id="login_field" class="form-control input-block" v-model="email"></input>

                        <div>
                            <label for="password">패스워드</label>
                            <a class="label-link" tabindex="0" href="/find_password">패스워드 찾기</a>
                            <input type="password" name="password" id="password" class="form-control input-block" v-model="pw"></input>
                            <input type="submit" name="commit" value="로그인" class="btn btn-primary btn-block"></input>
                        </div>
                    </form>
                </div>
                <!-- <router-view :key="$route.fullPath"/> -->
            </div>
        </main>
    </div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
import axios from "axios";
import store from "../../vuex/store";
export default {
  data() {
    return {
      email: "",
      pw: "",
    };
  },

  methods: {
    ...mapActions(["login"]), //vuex/actions에 있는 login 함수
    async onSubmitLogin() {
      if (this.email === "") {
        alert("이메일을 입력하세요");
      } else if (this.pw === "") {
        alert("비밀번호를 입력하세요");
      } else {
        const u_data = await this.login({
          user_email: this.email,
          user_pw: this.pw,
        });

        if (
          store.getters.getUserIdx == null ||
          store.getters.getUserIdx == "undefined" ||
          store.getters.getUserIdx == ""
        ) {
          alert("로그인 실패 아이디 및 비밀번호를 확인해주세요");
          this.$refs.ref_email.focus();
        } else {
          window.history.back();
        }
      }
    },
    computed: {
      ...mapGetters({
        errorState: "getErrorState",
      }),
    }, // computed
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/login/login.sass'
</style>