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
          <form @submit.prevent="singup">
            <p>
              <input
                class="input"
                name="uid"
                placeholder="Enter your ID"
                v-model="user_id"
              />
            </p>

            <p>
              <input
                class="input"
                name="uemail"
                placeholder="Enter your Email"
                v-model="user_email"
              />
            </p>

            <p>
              <input
                name="password"
                class="input"
                placeholder="Enter your password"
                v-model="user_pw"
                type="password"
              />
            </p>

            <h6 class="">
              Use at least one letter, one numeral, and seven characters.
            </h6>
            <p>
              <button type="submit" class="btn--primary">
                Sign up for GgitHub
              </button>
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
export default {};
</script>

<style lang="sass">
@import "src/assets/sass/main/main"
</style>