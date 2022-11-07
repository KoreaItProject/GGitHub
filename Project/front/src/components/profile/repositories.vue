<template lang="">


       

    <div class="repo">
        <div class = " repo_search_main">
            <input type ="search" class = "repo_search" placeholder="Find a repository"></input>
            <button type ="button" class = "new_repo" href="#">New</button> 
        </div>

        <div class="repo_list">
            <ul>
                <li v-for='name in Repo'>
                    <div class="repo_info">
                                <div class="repo_name">
                                    <a href="#">{{name}}</a>
                                    
                                    <span></span>
                                    <span class="repo_public">공개여부</span>
                                    <span><button type="button" class="repo_star">☆Star</button></span>
                                    
                                </div>

                                <div class="repo_update">
                                <span>Update 날짜</span>
                                
                            
                            
                                </div>
                            </div>
                        </li>
                
            </ul>

        </div>







    </div>

    



 


</template>
<script>

export default{
    data(){
        
        return{
          
            Repo: ['ddd','aaa','asd','lkj213'],
           
        }
        
    },
    methods:{

    }
}


</script>
<style lang="sass">
@import "src/assets/sass/profile/repositories"
</style>