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
    <!-- <div id="main_title"> -->
    <h1 id="title">How people build software</h1>
    <br />
    <h4 id="sub">
      Millions of developers use GitHub to build personal projects, support
      their businesses, and work together on open source technologies.
    </h4>
    <!-- </div> -->

    <div id="signupForm">
      <form @submit.prevent="singup">
        <p>
          <input
            class="input"
            name="uid"
            placeholder="Enter your ID"
            v-model="user_id"
          /><br />
        </p>
        <br />
        <p>
          <input
            class="input"
            name="uemail"
            placeholder="Enter your Email"
            v-model="user_email"
          /><br />
        </p>

        <br />
        <p>
          <input
            name="password"
            class="input"
            placeholder="Enter your password"
            v-model="user_pw"
            type="password"
          />
        </p>
        <br />
        <h6 class="">
          Use at least one letter, one numeral, and seven characters.
        </h6>
        <p>
          <button type="submit" class="btn--primary">
            Sign up for GgitHub
          </button>
        </p>
        <br />
        <p>
          <button type="button" class="btn--primary">
            <img
              src="src\assets\imgs\main\btn_google_signin_light_focus_web.png"
            />
          </button>
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
          src="@/assets/imgs/people/tae.jpg"
        />
      </div>
      <div class="div_test5">
        <img
          style="width: 450px; height: 450px"
          src="@/assets/imgs/people/jin.jpg"
        />
      </div>
      <div class="div_test6">
        <img
          style="width: 450px; height: 450px"
          src="@/assets/imgs/people/jun.jpg"
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
@import "src/assets/sass/main/main_1"
</style>