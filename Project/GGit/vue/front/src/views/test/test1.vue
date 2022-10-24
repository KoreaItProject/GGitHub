
<template>
    <div >

    
    <h1>테스트중{{$route.query}}</h1>


    <input type="text" v-model="text"/>

    <input type="button" value="페이지이동" @click="go">

    <input type="button" @click="get" >
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
import router from "../../router";

export default{
 
    
    data(){
        
        return{
          
            lists:[],
            text:null
           
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

        },
        go(){

        //   router.push({path:'/test2',query:{
        //     text:this.text}});
            router.push({name:'test2',params:{
            text:this.text}});
        }
        
    }
 
}


</script>