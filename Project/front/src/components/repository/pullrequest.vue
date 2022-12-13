<template lang="">
    
    <div class="pullreq_top_div">
        <div class="pullreq_main_div">
            <div class="pullreq_select_div">
                <select class="pullreq_select" v-model="select_bool"> 
                    <option :value=true selected >저장소 멤버</option> 
                    <option :value=false >풀 리퀘스트 요청</option>
                </select>
            </div>
            
            <div id="pullreq_main">
                <pullreqnomem v-if="!select_bool"/>
            </div>
        </div>
    </div>
</template>
<script>
import pullreqnomem from "@/components/repository/pullrequest_nomem.vue";
export default {
    data(){
        return{
            select_bool: true
        };
    },
    components: {
        pullreqnomem : pullreqnomem
    },
    mounted(){

    },
    methods: {
        
    }
};
</script>
<style lang="sass">
@import "src/assets/sass/repository/pullrequest"
</style>