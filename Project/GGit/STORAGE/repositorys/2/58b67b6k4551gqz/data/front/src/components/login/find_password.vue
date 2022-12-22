<template lang="">
    <div>
        <div class="header_main">
            <div class="header_middle">
                <a href="/">
                    <img class="logo" src="static/imgs/login/logoblack.png" />
                </a>
            </div>
        </div>
        <main>
            <div class="container_main">
                <form id="forgot_password_form">
                    <div class="auth-form-header">
                        <h1>암호 재설정</h1>
                    </div>
                    <div class="auth-form-body">
                        <label>사용자 계정의 확인된 메일 주소를 입력하면 암호 재설정 링크가 전송됩니다.</label>
                        <input type="text" 
                               id="email_field" 
                               class="input-block" 
                               autofocus="autofocus" 
                               placeholder="이메일을 입력해주세요"/>
                    </div>
                </form>
            </div>
        </main>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="sass">
    @import 'src/assets/sass/login/find_password.sass'
</style>