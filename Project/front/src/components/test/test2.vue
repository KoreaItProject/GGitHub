
<template>
  <div>
    <h1>이동 완료</h1>
    <input type="button" value="맴버 정보 가져오기" />
    <table>
      <tr>
        <td>idx</td>
        <td>nick</td>
        <td>email</td>
        <td>auth</td>
        <td>pw</td>
        <td>date</td>
      </tr>
      <tr v-for="data in members" v-bind:key="data">
        <td>{{ data.idx }}</td>
        <td>{{ data.nick }}</td>
        <td>{{ data.email }}</td>
        <td>{{ data.auth }}</td>
        <td>{{ data.pw }}</td>
        <td>{{ data.date }}</td>
      </tr>
    </table>
  </div>
</template>
<script>
import { useListeners } from "vue";
import axios from "axios";
import router from "../../router";

export default {
  data() {
    return {
      members: [],
    };
  },

  mounted() {
    axios
      .get("/api/member")
      .then((response) => {
        // handle success
        this.members = response.data;
        console.log();
      })
      .catch((error) => {
        // handle error
        console.log(error);
      })
      .finally(() => {
        // always executed
      });
  },
};
</script>

