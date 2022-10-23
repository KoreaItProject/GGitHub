
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
        axios.get('http://192.168.55.88:5555/api/twitter/')
        .then(response => {
            // handle success
           
           
            console.log(response);

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