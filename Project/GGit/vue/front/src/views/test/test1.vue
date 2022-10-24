
<template>
    <div >

    
    <h1>테스트중{{$route.query}}</h1>
    <v-btn @click="get" >버튼</v-btn>
        <table>
            <tr >
                <td>id</td>
                <td>이름</td>
            </tr>
            <tr v-for="index in lists">
                <td>{{index.id}}</td>
                <td>{{index.name}}</td>
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
        axios.get('/api/')
        .then(response => {
            // handle success
           
           this.lists=response.data
           console.log(this.lists)

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