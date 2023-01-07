<template lang="">
    <div>
        <div class="pullreq_merge_name">

        </div>
        <div class="pullreq_merge_container" :style="cssVariable">
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

                <div class="pullreq_merge_div_right_bottom_span" :style="cssVariable">
                    <span>&nbsp;&nbsp;병합 비교</span>
                </div>
                <div class="pullreq_merge_div_right_bottom" :style="cssVariable">
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

            pullreq_merge_right_top_state: false,

            pullreq_merge_div_right_bottom_span: '0px',
            test1: '1000px',
            test2: '300px',
            test3: '150%',
            test4: '165%'

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
            this.pullreq_merge_right_top_state = !this.pullreq_merge_right_top_state;
            if(this.pullreq_merge_right_top_state){ // 폈을때
                this.pullreq_merge_div_right_bottom_span = '280px';
                this.test1 = "2000px";
                this.test2 = "300px";
                if(window.innerWidth < 1100){
                   this.test3 = "70%"
                }else{
                    this.test3 = "70%" 
                }
            }else{ // 접혔을때
                this.pullreq_merge_div_right_bottom_span = '0px';
                if(window.innerWidth < 1100){
                    this.test1 = "1200px";
                }else{
                    this.test1 = "1000px";
                }
                this.test1 = "1000px";
                this.test2 = "300px";
                this.test3 = "150%";
            }
           
        }
    },
    computed: {
        cssVariable(){
            return {
                "--pullreq_merge_div_right_bottom_span": this.pullreq_merge_div_right_bottom_span,
                "--test1": this.test1,
                "--test2": this.test2,
                "--test3": this.test3,
                "--test4": this.test4,
            }
        }
    }
}
</script>
<style lang="sass">
    @import "src/assets/sass/repository/pullreq_merge/pullreq_merge_mem"
</style>