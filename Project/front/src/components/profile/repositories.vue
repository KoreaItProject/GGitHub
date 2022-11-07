<template lang="">


       

    <div>
        <div class = " search">
            <input type ="search" class = "repo-search" placeholder="Find a repository"></input>
            <button type ="button" class = "new repository" href="#"></button> 
        </div>

        <div class="repo-list">
            <ul>
                <li v-for='name in Repo'>
                    <h1>{{name}}</h1>
                    <span class="public">asdf</span>
                
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
</style>