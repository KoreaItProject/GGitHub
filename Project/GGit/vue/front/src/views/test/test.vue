
<template>
    <div >

    
    <h1>테스트중</h1>
    <v-btn @click="get" >버튼</v-btn>
        <table>
            <tr v-for="index in lists">
                <td>{{index.id}}</td>
                <td>{{index.email}}</td>
            </tr>
        </table>

    </div>
</template>

<script>
import { useListeners } from 'vue';
import axios from 'axios';
export default{
 
    
    data(){
        
        return{
          
            lists:[]
           
        }
        
    },
   

    methods:{
        get(){
        axios.get('https://reqres.in/api/users?page=2')
        .then(response => {
            // handle success
           
            this.lists=response.data.data
            console.log(this.lists);

        })
        .catch(error => {
            // handle error
            console.log(error);
        })
        .finally(()=> {
            // always executed
        });

    }
    }
 
}


</script>