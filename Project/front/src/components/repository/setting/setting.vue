<template lang="">
    <div class="setting_container" :style="cssVariable">
        <div class="setting_div">
            <div class="setting_left_container">
                <ul>
                    <li class="setting_left_li setting_left_li1"><a @click="changetab('general')">
                        <div class="setting_left_span setting_left_span1">
                          <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-gear">
                            <path fill-rule="evenodd" d="M7.429 1.525a6.593 6.593 0 011.142 0c.036.003.108.036.137.146l.289 1.105c.147.56.55.967.997 1.189.174.086.341.183.501.29.417.278.97.423 1.53.27l1.102-.303c.11-.03.175.016.195.046.219.31.41.641.573.989.014.031.022.11-.059.19l-.815.806c-.411.406-.562.957-.53 1.456a4.588 4.588 0 010 .582c-.032.499.119 1.05.53 1.456l.815.806c.08.08.073.159.059.19a6.494 6.494 0 01-.573.99c-.02.029-.086.074-.195.045l-1.103-.303c-.559-.153-1.112-.008-1.529.27-.16.107-.327.204-.5.29-.449.222-.851.628-.998 1.189l-.289 1.105c-.029.11-.101.143-.137.146a6.613 6.613 0 01-1.142 0c-.036-.003-.108-.037-.137-.146l-.289-1.105c-.147-.56-.55-.967-.997-1.189a4.502 4.502 0 01-.501-.29c-.417-.278-.97-.423-1.53-.27l-1.102.303c-.11.03-.175-.016-.195-.046a6.492 6.492 0 01-.573-.989c-.014-.031-.022-.11.059-.19l.815-.806c.411-.406.562-.957.53-1.456a4.587 4.587 0 010-.582c.032-.499-.119-1.05-.53-1.456l-.815-.806c-.08-.08-.073-.159-.059-.19a6.44 6.44 0 01.573-.99c.02-.029.086-.075.195-.045l1.103.303c.559.153 1.112.008 1.529-.27.16-.107.327-.204.5-.29.449-.222.851-.628.998-1.189l.289-1.105c.029-.11.101-.143.137-.146zM8 0c-.236 0-.47.01-.701.03-.743.065-1.29.615-1.458 1.261l-.29 1.106c-.017.066-.078.158-.211.224a5.994 5.994 0 00-.668.386c-.123.082-.233.09-.3.071L3.27 2.776c-.644-.177-1.392.02-1.82.63a7.977 7.977 0 00-.704 1.217c-.315.675-.111 1.422.363 1.891l.815.806c.05.048.098.147.088.294a6.084 6.084 0 000 .772c.01.147-.038.246-.088.294l-.815.806c-.474.469-.678 1.216-.363 1.891.2.428.436.835.704 1.218.428.609 1.176.806 1.82.63l1.103-.303c.066-.019.176-.011.299.071.213.143.436.272.668.386.133.066.194.158.212.224l.289 1.106c.169.646.715 1.196 1.458 1.26a8.094 8.094 0 001.402 0c.743-.064 1.29-.614 1.458-1.26l.29-1.106c.017-.066.078-.158.211-.224a5.98 5.98 0 00.668-.386c.123-.082.233-.09.3-.071l1.102.302c.644.177 1.392-.02 1.82-.63.268-.382.505-.789.704-1.217.315-.675.111-1.422-.364-1.891l-.814-.806c-.05-.048-.098-.147-.088-.294a6.1 6.1 0 000-.772c-.01-.147.039-.246.088-.294l.814-.806c.475-.469.679-1.216.364-1.891a7.992 7.992 0 00-.704-1.218c-.428-.609-1.176-.806-1.82-.63l-1.103.303c-.066.019-.176.011-.299-.071a5.991 5.991 0 00-.668-.386c-.133-.066-.194-.158-.212-.224L10.16 1.29C9.99.645 9.444.095 8.701.031A8.094 8.094 0 008 0zm1.5 8a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM11 8a3 3 0 11-6 0 3 3 0 016 0z"></path>
                          </svg> 
                         일반</div></a></li>
                    <li class="setting_left_li setting_left_li2"><a @click="changetab('collaborator')">
                        <div class="setting_left_span setting_left_span2">
                          <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-people">
                              <path fill-rule="evenodd" d="M5.5 3.5a2 2 0 100 4 2 2 0 000-4zM2 5.5a3.5 3.5 0 115.898 2.549 5.507 5.507 0 013.034 4.084.75.75 0 11-1.482.235 4.001 4.001 0 00-7.9 0 .75.75 0 01-1.482-.236A5.507 5.507 0 013.102 8.05 3.49 3.49 0 012 5.5zM11 4a.75.75 0 100 1.5 1.5 1.5 0 01.666 2.844.75.75 0 00-.416.672v.352a.75.75 0 00.574.73c1.2.289 2.162 1.2 2.522 2.372a.75.75 0 101.434-.44 5.01 5.01 0 00-2.56-3.012A3 3 0 0011 4z"></path>
                          </svg>
                         구성원</div></a></li>
                    <li class="setting_left_li setting_left_li3"><a  @click="changetab('danger')">
                        <div class="setting_left_span setting_left_span3">
                          <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-shield UnderlineNav-octicon d-none d-sm-inline">
                              <path fill-rule="evenodd" d="M7.467.133a1.75 1.75 0 011.066 0l5.25 1.68A1.75 1.75 0 0115 3.48V7c0 1.566-.32 3.182-1.303 4.682-.983 1.498-2.585 2.813-5.032 3.855a1.7 1.7 0 01-1.33 0c-2.447-1.042-4.049-2.357-5.032-3.855C1.32 10.182 1 8.566 1 7V3.48a1.75 1.75 0 011.217-1.667l5.25-1.68zm.61 1.429a.25.25 0 00-.153 0l-5.25 1.68a.25.25 0 00-.174.238V7c0 1.358.275 2.666 1.057 3.86.784 1.194 2.121 2.34 4.366 3.297a.2.2 0 00.154 0c2.245-.956 3.582-2.104 4.366-3.298C13.225 9.666 13.5 8.36 13.5 7V3.48a.25.25 0 00-.174-.237l-5.25-1.68zM9 10.5a1 1 0 11-2 0 1 1 0 012 0zm-.25-5.75a.75.75 0 10-1.5 0v3a.75.75 0 001.5 0v-3z"></path>
                          </svg>
                         위험요소</div></a></li>
                </ul>

            </div>
            <div class="setting_content_container">
                <general v-if='isgeneral'/>
                <collaborators v-if='iscollaborator'/>
               <danger v-if='isdanger'/>
            </div>

        </div>
        
    </div>
</template>
<script>
import axios from "axios";
import danger from "@/components/repository/setting/danger.vue";
import collaborators from "@/components/repository/setting/collaborators.vue";
import general from "@/components/repository/setting/general.vue";


export default {
  computed: {
    cssVariable() {
      return {
        "--li1": this.li1,
        "--li2": this.li2,
        "--li3": this.li3,

        "--span1": this.span1,
        "--span2": this.span2,
        "--span3": this.span3,
      };
    },
  },
  data() {
    return {
      isgeneral: true,
      iscollaborator: false,
      isdanger: false,
      li1: "pink",
      li2: "white",
      li3: "white",
      span1: "rgb(188, 204, 202,0.2)",
      span2: "white",
      span3: "white",
    };
  },
  components: { 
    general: general,
    collaborators: collaborators,
    danger: danger
   

  },

  mounted() {
 
  },methods: {
    changetab(tab){
      if (tab == "general") {
        this.isgeneral = true;
      this.iscollaborator = false;
      this.isdanger = false;
      this.li1 = "pink";
      this.li2 = "white";
      this.li3 = "white";
      this.span1 = "rgb(188, 204, 202,0.2)";
      this.span2 = "white";
      this.span3 = "white";
    } else if (tab == "collaborator") {
      this.isgeneral = false;
      this.iscollaborator = true;
      this.isdanger = false;
      this.li1 = "white";
      this.li2 = "pink";
      this.li3 = "white";
      this.span1 = "white";
      this.span2 = "rgb(188, 204, 202,0.2)";
      this.span3 = "white";
    } else if(tab=="danger"){
      this.isgeneral = false;
      this.iscollaborator = false;
      this.isdanger = true;
      this.li1 = "white";
      this.li2 = "white";
      this.li3 = "pink";
      this.span1 = "white";
      this.span2 = "white";
      this.span3 = "rgb(188, 204, 202,0.2)";
      }
    }
  },
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/setting'
</style>