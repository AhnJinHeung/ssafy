<template lang="">
    <div class="text-right">
        <span><input type="text" v-model="word" placeholder="사원 이름"/></span>
        <span><button class="mr-2" @click="getEmpList(word)">검색</button></span>
        <span><button @click="moveRegist">등록</button></span>
    </div>
</template>
<script>
import { mapActions } from 'vuex';
export default {
    name: 'SearchNav',
    data() {
        return {
            word: '',
        }
    },
    methods: {
      ...mapActions(['getEmpList']),
      moveRegist() {
      this.$router.push('regist');
    },
    },
}
</script>
<style lang="">
    
</style>