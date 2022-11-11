<template lang="">
    <div class="setting_profile_container">
        <div class="setting_profile_title_div">
            <h2>프로필 설정</h2>
        </div>
        <div class="setting_profile_div">
            <div class="setting_profile_left">
                <div class="setting_profile_name_div">
                    닉네임
                    <input class="setting_input" type="text" placeholder="LeeTaeHyeon123"/>
                    <span class="nick_span">사용중인 닉네임입니다</span>
                </div>
                <div class="setting_profile_bio_div">
                    소개
                    <textarea class="setting_profile_bio"></textarea>
                    <span class="bio_span">0 / 200</span>
                </div>
                 <div class="setting_profile_url_div">
                    URL
                    <input class="setting_input" type="text" />
                </div>
                 <div class="setting_profile_company_div">
                    소속
                    <input class="setting_input" type="text" />
                </div>
                 <div class="setting_profile_location_div">
                    위치
                    <input class="setting_input" type="text" />
                </div>
                <div class="setting_save_btn_div">
                    <button class="setting_save_btn">저장</button>
                </div>
            </div>
            <div class="setting_profile_right">
                <img class="setting_profile_img" src='@/assets/imgs/profile/profileImg.jpg' width=200px height=200px />
                <div class="setting_profile_img_edit">
                    <svg aria-hidden="true" height="16" viewBox="0 -1 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-pencil">
                        <path fill-rule="evenodd" d="M11.013 1.427a1.75 1.75 0 012.474 0l1.086 1.086a1.75 1.75 0 010 2.474l-8.61 8.61c-.21.21-.47.364-.756.445l-3.251.93a.75.75 0 01-.927-.928l.929-3.25a1.75 1.75 0 01.445-.758l8.61-8.61zm1.414 1.06a.25.25 0 00-.354 0L10.811 3.75l1.439 1.44 1.263-1.263a.25.25 0 000-.354l-1.086-1.086zM11.189 6.25L9.75 4.81l-6.286 6.287a.25.25 0 00-.064.108l-.558 1.953 1.953-.558a.249.249 0 00.108-.064l6.286-6.286z"></path>
                    </svg>
                    변경
                </div>
                <div class="setting_profile_img_delete">
                    <svg  width="16" height="16" version="1.1"  viewBox="0 -3 96 96" enable-background="new 0 0 96 96" xml:space="preserve">
                    <polygon fill="white" points="96,14 82,0 48,34 14,0 0,14 34,48 0,82 14,96 48,62 82,96 96,82 62,48 "/>
                    </svg>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {};
</script>
<style lang="sass">
@import "src/assets/sass/setting/profile"
</style>