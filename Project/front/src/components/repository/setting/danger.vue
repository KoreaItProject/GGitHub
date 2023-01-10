<template lang="">
    <div>
  <div class="general_string">위험요소</div>
        <div class="danger_div_box">
            <li
            style="list-style:none;
            padding: 16px" v-if="public">
                <div >
                    <button class="change_visibility" @click="setPublic">비공개로 전환</button>
                </div>
                <div class="change_repository_visibility">
                    <strong>공개</strong>
                    <div class="change_repository_visibility_message">
                        현재 저장소는 공개 상태입니다
                    </div>
                </div>
            </li>
            <li
            style="list-style:none;
            padding: 16px"
            v-if="!public">
                <div >
                    <button class="change_visibility"  @click="setPrivate" >공개로 전환</button>
                </div>
                <div class="change_repository_visibility">
                    <strong>공개</strong>
                    <div class="change_repository_visibility_message">
                          현재 저장소는 비공개 상태입니다.
                    </div>
                </div>
            </li>
           
            <li
            style="list-style:none;
            padding: 16px">
                <div >
                    <button class="delete_btn" >현재 저장소 삭제</button>
                </div>
                <div class="delete_this_repository">
                <strong>저장소 삭제</strong>
                <div class="delete_this_repository_message">
                   저장소를 삭제하면 되돌릴 수 없습니다.
                </div>
            </div>
            </li>
           
            

        </div>

    </div>
</template>
<script>
export default {
  data() {
    return {
      public: true,
    };
  },
  methods() {},
};
</script>
<style lang="sass">
@import 'src/assets/sass/repository/setting/danger'
</style>