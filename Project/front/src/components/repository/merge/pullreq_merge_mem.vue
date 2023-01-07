<template lang="">
    <div>
        <div class="pullreq_merge_name">

        </div>
        <div class="pullreq_merge_container">
            <div class="pullreq_merge_div_left">
                <div class="pullreq_merge_div_left2">
                    <div class="pullreq_merge_div_left_data" v-for="(data, index) in test_data">
                        {{index}}
                    </div>
                </div> 
            </div>
            <div class="pullreq_merge_div_right">
                <div class="test">
                    <div v-if="pullreq_merge_right_top_state == true">
                        <button class @click="pullreq_merge_right_top_state_func()">-</button>
                    </div>
                    <div v-if="pullreq_merge_right_top_state == false">
                        <button @click="pullreq_merge_right_top_state_func()">+</button>
                    </div>
                </div>
                <div class="pullreq_merge_div_right_top" v-if="pullreq_merge_right_top_state == true" :style="cssVariable">
                    <!-- <span>111</span> -->
                    <div class="pullreq_merge_div_right_top_left_contain">
                        <sapn>&nbsp;&nbsp;메인 파일</sapn>
                        <div class="pullreq_merge_div_right_top_left">
                            <table>
                                <tr v-for="(data,index) in test_line">
                                    <td class="td1"></td>
                                    <td class="td2">{{index+1}}</td>
                                    <td class="td3">
                                        <span class="td3_span">{{data}}</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>

                    <div class="pullreq_merge_div_right_top_right_contain">
                        <span>&nbsp;&nbsp;병합 파일</span>
                        <div class="pullreq_merge_div_right_top_right">
                            <table>
                                <tr v-for="(data,index) in test_line">
                                    <td class="td1"></td>
                                    <td class="td2">{{index+1}}</td>
                                    <td class="td3">
                                        <span class="td3_span">{{data}}</span>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>

                </br>
                <span style="margin-top:300px;">&nbsp;&nbsp;병합 비교</span>
                <div class="pullreq_merge_div_right_bottom">
                    <div class="pullreq_merge_div_right_bottom_changecode">
                        <table>
                            <tr v-for="(data,index) in test_line">
                                <td class="td1"></td>
                                <td class="td2">{{index+1}}</td>
                                <td class="td3">
                                    <span class="td3_span" data-code-marker="+">{{data}}</span>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data(){
        return{
            test_data:["","",""],
            test_line:[],

            pullreq_merge_right_top_state: true,


            top: '',
            position: '',
            transition: '',
            height: '',
            back: ""
        }
    },
    mounted(){
        this.test();
    },
    methods: {
        test(){
            axios.post("/api/testcon", {

            })
            .then(response => {
                //console.log(response);
                this.test_line = response.data
            })
        },
        pullreq_merge_right_top_state_func(){
            this.top = '0%';
            this.position = 'relative';
            this.transition = 'all .3s ease-out';
            this.height = '100%';
            this.back = "black";
            this.pullreq_merge_right_top_state = !this.pullreq_merge_right_top_state;
        }
    },
    computed: {
        cssVariable(){
            return {
                "--top": this.top,
                "--position": this.position,
                "--transition": this.transition,
                "--background": this.background,
                "--height": this.height,
                "--back": this.back
            }
        }
    }
}
</script>
<style lang="sass">
    @import "src/assets/sass/repository/pullreq_merge/pullreq_merge_mem"
</style>