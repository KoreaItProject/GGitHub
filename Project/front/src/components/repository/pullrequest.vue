<template lang="">
    
    <div class="pullreq_top_div">
        <div class="pullreq_main_div">
            <div class="pullreq_select_div">
                <select class="pullreq_select" v-model="select_bool"> 
                    <option :value=true selected>저장소 멤버</option> 
                    <option :value=false>풀 리퀘스트 요청</option> 
                </select>
            </div>
            
            <div class="pullreq_main_list">
                <div class="pullreq_main_header">

                </div>
                <div class="pullreq_main_body">
                    <div class="pullreq_main_body_flex">
                        <div class="pullreq_main_body_icon">
                            <span class="pullreq_main_body_icon_span">
                                <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="color-fg-color">
                                    <path fill-rule="evenodd" d="M7.177 3.073L9.573.677A.25.25 0 0110 .854v4.792a.25.25 0 01-.427.177L7.177 3.427a.25.25 0 010-.354zM3.75 2.5a.75.75 0 100 1.5.75.75 0 000-1.5zm-2.25.75a2.25 2.25 0 113 2.122v5.256a2.251 2.251 0 11-1.5 0V5.372A2.25 2.25 0 011.5 3.25zM11 2.5h-1V4h1a1 1 0 011 1v5.628a2.251 2.251 0 101.5 0V5A2.5 2.5 0 0011 2.5zm1 10.25a.75.75 0 111.5 0 .75.75 0 01-1.5 0zM3.75 12a.75.75 0 100 1.5.75.75 0 000-1.5z"></path>
                                </svg>
                            </span>
                        </div>
                        <div class="pullreq_main_body_innerdiv">
                            <a class="pullreq_main_body_a"><h4>유저 닉네임</h4></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            select_bool: true
        };
    },
    components: {
        
    },
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/pullrequest"
</style>