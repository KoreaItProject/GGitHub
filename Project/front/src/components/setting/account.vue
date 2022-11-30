<template lang="">
    <div class="account_main_top_div">
        <div class="account_main_div">

            <div v-if="pw_check_ok == 1">
                <main>
                    <div class="auth-form">
                        <div class="auth-form-header"><h1>GGit</h1></div>
                            <div class="auth-form-body">
                                <form @submit.prevent="onSubmitPasswordUpdate" >
                                    <label class="body-label">비밀번호 변경</label>
                                    <input ref="ref_pw_update_input" type="password" name="pw_first" id="pw_field" class="form-control input-block" v-model="pw_update_input"></input>
                                    <input type="submit" name="commit" value="변 경 하 기" class="btn btn-primary btn-block"></input>
                                </form>
                                <div class="line_div">
                                    <p></p>
                                </div>
                                <div>
                                    <input type="button" name="commit" value="회 원 탈 퇴" class="btn btn-primary btn-block-out" @click="user_del"></input>
                                </div>
                            </div>
                        <router-view :key="$route.fullPath"/>
                    </div>
                </main>
            </div>
            <div v-if="pw_check_ok == 0">
                <main>
                    <div class="auth-form">
                        <div class="auth-form-header"><h1>GGit</h1></div>
                            <div class="auth-form-body">
                                <form @submit.prevent="onSubmitPasswordCheck" >
                                    <label class="body-label">비밀번호</label>
                                    <input ref="ref_pw_first" type="password" name="pw_first" id="pw_field" class="form-control input-block" v-model="pw_first" @input="pw_diff_check2"></input>

                                    <div>
                                        <label for="password">비밀번호 확인</label>
                                        <input ref="ref_pw_second" type="password" name="pw_second" id="password" class="form-control input-block" v-model="pw_second" @input="pw_diff_check"></input>
                                        <div class="pw_check_div" >
                                            <p v-bind:style="check_display">일치합니다</p>
                                        </div>
                                        <input type="submit" name="commit" value="확인" class="btn btn-primary btn-block"></input>
                                    </div>
                                </form>
                            </div>
                        <router-view :key="$route.fullPath"/>
                    </div>
                </main>
            </div>

        </div>
    </div>

</template>
<script>
import axios from "axios";
import { log } from 'console';
import jsCookie from "js-cookie";
import store from "../../vuex/store";
import vue_cookie from 'vue-cookies';
import router from '../../router';

export default {
    data(){
        return{
            pw_first: "", // 계정 탭 - 진입 전 비밀번호 입력 데이터
            pw_second: "", // 계정 탭 - 진입 전 비밀번호 확인 입력 데이터
            pw_check_ok: 1, // 비밀번호 일치시 1 (default : 0)
            pw_update_input: '', // 비밀번호 변경 데이터(유저가 입력한 pw 데이터)
            check_display: "display:none;", // 일치합니다 표시 데이터
            pw_diff_check_bool: false
        };
    },
    methods: {
        pw_diff_check(e) {
            if(e.target.value == ""){
                this.check_display = "display:none;";
                this.pw_diff_check_bool = false;
            }else{
                if(this.pw_first == e.target.value){
                    this.check_display = "display:inline;";
                    this.pw_diff_check_bool = true;
                }else{
                    this.check_display = "display:none;";
                    this.pw_diff_check_bool = false;
                }
            }
        },
        pw_diff_check2(e){
            if(e.target.value == ""){
                this.check_display = "display:none;"
                this.pw_diff_check_bool = false;
            }else{
                if(this.pw_second == e.target.value){
                    this.check_display = "display:inline;"
                    this.pw_diff_check_bool = true;
                }else{
                    this.check_display = "display:none;"
                    this.pw_diff_check_bool = false;
                }
            }
        },
        onSubmitPasswordCheck(){
            if(this.pw_first == "" || this.pw_second == ""){
                alert("빈칸을 채워주세요");
            }else if(this.pw_diff_check_bool == false){
                alert("비밀번호가 일치하지 않습니다!");
                this.$refs.ref_pw_second.focus();
            }else{
                console.log("---->" + this.pw_second);
                axios.post('/api/setting_check_pw', {
                    pw : this.pw_second,
                    idx : store.getters.getUserIdx
                })
                .then( response =>{
                    if(response.data.idx == null){
                        alert("비밀번호 불일치");
                        this.$refs.ref_pw_second.focus();
                    }else{
                        alert("비밀번호 일치");
                        this.pw_check_ok = 1;
                    }
                    
                })
            }
        },
        user_del(){
            if(confirm("탈퇴 하시겠습니까?") == true){
                axios.post('/api/user_del', {
                    idx: store.getters.getUserIdx
                })
                .then(response => {
                    //console.log(response.data);
                    if(response.data == 1){
                        alert("정상 탈퇴");
                        this.$cookies.remove('nick');
                        this.$cookies.remove('isLogin');
                        this.$cookies.remove('idx');
                        location.href="/";
                    }else{
                        alert("탈퇴 안됨");
                    }
                })
            }else{
                alert("취소 누름");
            }
        },
        onSubmitPasswordUpdate(){
            if(this.pw_update_input == ""){
                alert("빈칸을 채워주세요!");
            }else{
                if(confirm("비밀번호를 변경하시겠습니까?") == true){
                    axios.post('/api/user_pw_update',{
                        idx: store.getters.getUserIdx,
                        pw: this.pw_update_input
                    })
                    .then(response => {
                        if(response.data > 0){
                            alert("비밀번호를 변경 성공!");
                            this.pw_update_input = "";
                        }else{
                            alert("비밀번호 변경 실패");
                            this.$refs.ref_pw_update_input.focus();
                        }
                    })
                }else{ 
                    // ...
                }
            }
            
        }
     
    }
};
</script>
<style lang="sass">
    @import 'src/assets/sass/setting/account.sass'
</style>