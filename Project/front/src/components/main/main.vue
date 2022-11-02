<template>
  <div
    class="background"
    style="
      background: url('./static/imgs/main/bg.jpg');
      background-repeat: no-repeat, round;
      background-size: cover;
      background-position: center;
    "
  >
    <div id="hello">
      <h1 id="hi">How people build software</h1>
      <br />
      <h4 id="hii">
        Millions of developers use GitHub to build personal projects, support
        their businesses, and work together on open source technologies.
      </h4>
    </div>

    <div id="signupForm">
      <form @submit.prevent="singup">
        <p>
          <input
            class="w3-input"
            name="uid"
            placeholder="Enter your ID"
            v-model="user_id"
          /><br />
        </p>

        <br />
        <p>
          <input
            name="password"
            class="w3-input"
            placeholder="Enter your password"
            v-model="user_pw"
            type="password"
          />
        </p>
        <br />
        Use at least one letter, one numeral, and seven characters.
        <p>
          <button type="submit" class="btn--primary">
            Sign up for GgitHub
          </button>
        </p>
        <br />
        <p>
          <button type="button" class="btn--primary">구글로 로그인</button>
        </p>
        By clicking "Sign up for GitHub", you agree to our terms of service and
        privacy policy. We'll occasionally send you account related emails.
      </form>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style lang="sass">
#hello
  border: 1px solid red

  width: 15%

  margin-top: 100px
  margin-right: 3%
  margin-bottom: 30px
  margin-left: 30%
  float: left
#hi
  font-size: 40px
#signupForm
  border: 1px solid blue
  display: block
  width: 500px

  margin-top: 100px
  margin-right: 10%
  margin-bottom: 30px
  margin-left: 10%
  float: left
.background
  border: 1px solid black
  width: 100%
  height: 700px

.btn
  height: 34px
  background: #eee linear-gradient(to bottom,#fcfcfc,#eee)
  border: 1px solid #d5d5d5
  border-radius: 4px
  display: inline-flex
  align-items: center
  padding: 0 12px
  font-size: 14px
  font-weight: 500
  line-height: 1.5
  cursor: pointer
  box-sizing: border-box
  position: relative

.btn:hover::before
  content: ""
  position: absolute
  top: 0
  left: 0
  width: 100%
  height: 100%
  background: rgba(0,0,0,0.07)

.btn--primary
  width: 300px
  height: 40px
  border: 1px solid #65b836
  color: #fff
  background: #55a532 linear-gradient(#91dd70,#55ae2e)
</style>