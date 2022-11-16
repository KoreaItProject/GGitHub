<template lang="">
    <div class="general_main_div">
        <div class="general_top_div">
            <div class="general_string">일 &nbsp;반</div>
            <div class="repo_name_change">저장소 이름 변경</div>
            <input class="repo_name_change_input" placeholder="repo-name" ></input>
            <button class="repo_rename_btn">
                적용하기
            </button>
            <div class="repo_about_setting_box">
                <div class="repo_about">
                    저장소 소개글 변경
                </div>
                <div>
                <textarea class="repo_about_textarea" placeholder="about-message" ></textarea>
                </div>
                <button class="repo_about_btn">적용하기</button>
            </div>

        </div>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/general'
</style>