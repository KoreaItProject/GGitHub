<template lang="">
    <div>
        <div class="pullreq_merge_name">
            
        </div>
        <div class="pullreq_merge_container" :style="cssVariable">
            <div class="pullreq_merge_div_left">
                <div class="pullreq_merge_div_left2">
                    <div class="pullreq_merge_div_left2_div">
                        
                        <button class="pullreq_merge_div_left2_backBtn" @click="merge_func_close()">
                            <svg style="width:15px; height:15px;"  xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                <path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/>
                            </svg>
                        </button>
                        <button class="pullreq_merge_div_left2_MergeBtn" @click="merge()">병합하기</button>
                    </div>
                    
                    <div class="pullreq_merge_div_left_scroll">
                        <div class="pullreq_merge_div_left_data" @click="left_data_click_func(index)" v-for="(data, index) in merge_data">
                            <div class="left_data_top">
                                <div class="left_data_top_filename">
                                    <span>{{data.fileName}}</span>
                                </div>
                            </div>
                            <div class="left_data_bottom">
                                <div class="left_data_bottom_filepath">
                                    <span>{{data.filePath}}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>

            <div class="pullreq_merge_div_right">
                <div class="plus_minus_div">
                    <div class="minus_div" v-if="pullreq_merge_right_top_state == true">
                        <a class="minus_div_a" @click="pullreq_merge_right_top_state_func()">
                            <div class="minus_div_a_div">
                                <svg style="width:20px; height:20px;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                    <path d="M432 256c0 17.7-14.3 32-32 32L48 288c-17.7 0-32-14.3-32-32s14.3-32 32-32l352 0c17.7 0 32 14.3 32 32z"/>
                                </svg>
                            </div>
                        </a>
                    </div> 
                    <div class="plus_div" v-if="pullreq_merge_right_top_state == false">
                        <a class="plus_div_a" @click="pullreq_merge_right_top_state_func()">
                            <div>
                                <svg style="width:20px; height:20px;" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
                                    <path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/>
                                </svg>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="pullreq_merge_div_right_top" v-if="pullreq_merge_right_top_state == true" :style="cssVariable">
                    <div class="pullreq_merge_div_right_top_left_contain">
                        <span>&nbsp;&nbsp;메인 파일</span>
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
                                <tr v-for="(data,index) in merge_data[left_data_index].fileData">
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
                        <!-- <table>
                            <tr v-for="(data,index) in merge_data[left_data_index].fileData">
                                <td class="td1"></td>
                                <td class="td2">{{index+1}}</td>
                                <td class="td3">
                                    <span class="td3_span">{{data}}</span>
                                </td>
                            </tr>
                        </table> -->
                        <!-- <div id="summernote">asd</div> -->
                        <!-- <vue-editor v-model="merge_data[left_data_index].fileData"> -->
                            <!-- {{this.merge_data[this.left_data_index].fileData}} -->
                            <!-- <table>
                                <tr v-for="(data,index) in merge_data[left_data_index].fileData">
                                    <td class="td1"></td>
                                    <td class="td2">{{index+1}}</td>
                                    <td class="td3">
                                        <span class="td3_span">{{data}}</span>
                                    </td>
                                </tr>
                            </table> -->
                        <!-- </vue-editor> -->

                        <div id="summernote"></div>
                       

                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import $ from 'jquery';


export default {
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
    },
    data(){
        return{
            merge_data: [[]],
            test_line: [],

            pullreq_merge_right_top_state: false,

            pullreq_merge_div_right_bottom_span: '-20px',
            test1: '1000px',
            test2: '300px',
            test3: '150%',
            test4: '165%',
            
            token: this.token_repoidx.token,
            repo_idx: this.token_repoidx.repo_idx,
            
            left_data_index: '0',
            editor: null,
            content: null,
        }
    },
    props:{
        token_repoidx: Object,
    },
    mounted(){
        this.getMergeFile();
        
        $('#summernote').summernote();
        alert("@@@");

       
    },
    components: {
  
    },
    methods: {
        getMergeFile(){
            axios.post("/api/testcon", {
                repo_idx: this.repo_idx,
                token: this.token
            })
            .then(response => {
                console.log(response);
                this.merge_data = response.data;
                this.test_editor();
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
                this.pullreq_merge_div_right_bottom_span = '-20px';
                if(window.innerWidth < 1100){
                    this.test1 = "1200px";
                }else{
                    this.test1 = "1000px";
                }
                this.test1 = "1000px";
                this.test2 = "300px";
                this.test3 = "150%";
            }
        },
        merge_func_close(){
            this.$emit("merge_func_close");
        },
        left_data_click_func(index){
            this.test_editor2();
            this.left_data_index = index;
        },
        merge(){
            if(confirm("병합하시겠습니까?")){
                
            }else{
                
            }
        }
    },
 
    
}
</script>
<style lang="sass">
    @import "src/assets/sass/repository/pullreq_merge/pullreq_merge_mem"
</style>