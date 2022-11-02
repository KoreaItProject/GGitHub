<template lang="">
    <div class="profile_container">
        <profile_bar_top/>

        <profile_bar_left/>

       

            <div id="main_div">
                내용
            </div>
        

    </div>
</template>
<script>

import profile_bar_left from './profile_bar_left.vue';
import profile_bar_top from './profile_bar_top.vue';
export default {
    components:{
        "profile_bar_left":profile_bar_left,
        "profile_bar_top":profile_bar_top,
    }
}
</script>
<style lang="sass">
    @import 'src/assets/profile/profile_bar'

        

    
</style>