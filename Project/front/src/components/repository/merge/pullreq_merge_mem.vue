<template lang="">
    <div>
        <div class="pullreq_merge_name">

        </div>
        <div class="pullreq_merge_container">
            <div class="pullreq_merge_div_left">
                <div class="pullreq_merge_div_left2">
                    <div class="pullreq_merge_div_left_data" v-for="data in test_data">

                    </div>
                </div> 
            </div>
            <div class="pullreq_merge_div_right">
                <div class="pullreq_merge_div_right_top">
                    <div class="pullreq_merge_div_right_top_left">
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
                    <div class="pullreq_merge_div_right_top_right">
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
                console.log(response);
                this.test_line = response.data
            })
        }
    },
}
</script>
<style lang="sass">
    @import "src/assets/sass/repository/pullreq_merge/pullreq_merge_mem"
</style>