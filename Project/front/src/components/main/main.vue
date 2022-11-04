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

    <!-- gsap scrolltrigger view -->
    <div class="ttt">
      <div class="div_test1">올겨울...</div>
      <div class="div_test2">SI를 강타할 그들이 온다</div>
      <div class="div_test3">그들은 바로...</div>
      <div class="div_test4">
        <img
          style="width: 450px; height: 450px"
          src="static/imgs/people/tae.jpg"
        />
      </div>
      <div class="div_test5">
        <img
          style="width: 450px; height: 450px"
          src="static/imgs/people/jin.jpg"
        />
      </div>
      <div class="div_test6">
        <img
          style="width: 450px; height: 450px"
          src="static/imgs/people/jun.jpg"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted: function () {
    this.scrollAnimation();
  },
  methods: {
    scrollAnimation() {
      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test1",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test1", { x: innerWidth * 1, opacity: 0 });

      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test2",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test2", { x: innerWidth * 1, opacity: 0 });

      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test3",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test3", { x: innerWidth * 1, opacity: 0 });

      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test4",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test4", { x: innerWidth * 1, opacity: 0 });

      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test5",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test5", { x: innerWidth * 1, opacity: 0 });

      gsap
        .timeline({
          scrollTrigger: {
            trigger: ".div_test6",
            start: "top 50%",
            end: "bottom 20%",
            markers: false,
            scrub: true,
            pin: true,
            toggleActions: "start none none none",
          },
        })
        .from(".div_test6", { x: innerWidth * 1, opacity: 0 });
    },
  },
};
</script>

<style lang="sass">
////// gsap scrolltrigger ///////
$main_heght: 7500px //메인 div 크기 여기서 설정 -그 크기 만큼 footer가 내려감

.footer_container
  margin-top: $main_heght+100px
.div_test1
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px
  margin-top: 1300px
  margin-bottom: 300px

.div_test2
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px
  margin-bottom: 300px

.div_test3
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px
  margin-bottom: 300px

.div_test4
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px

.div_test5
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px

.div_test6
  text-align: center
  //border: 1px solid red
  font-family: 'nanumsquare'
  color: black
  text-align: center
  font-size: 100px
.ttt
  height: $main_heght

////// gsap scrolltrigger ///////

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