<template >
    <div>
        
    </div>
</template>
<script>
import { useListeners } from 'vue';
import axios from 'axios';
import router from "../../router";

export default{}
  
axios.get('/api/download' , {
   responseType: "blob"
}).then(response => {
   const url = window.URL.createObjectURL(new Blob([response.data]));
   const link = document.createElement('a');
   link.href = url;
   link.setAttribute('download', response.headers.filename); //or any other extension
   console.log(response.headers.filename)
   document.body.appendChild(link);
   link.click();
}).catch(exception => {
   alert("파일 다운로드 실패");
});

    

</script>
<style >
    
</style>