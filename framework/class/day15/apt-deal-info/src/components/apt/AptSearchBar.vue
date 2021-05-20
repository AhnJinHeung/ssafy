<template>
  <b-row class="mt-4 mb-4">
    <b-col class="sm-3" align="left">
      <b-form-input
        v-model="dongCode"
        placeholder="동코드 입력...(예 : 11110)"
        @keypress.enter="sendKeyword"
      ></b-form-input>
    </b-col>
    <b-col class="sm-3" align="left">
      <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: 'SearchBar',
  data() {
    return {
      dongCode: '',
    };
  },
  methods: {
    sendKeyword: function() {
      // 검색버튼이 없을시 (data 제거하로 아래와 같이..)
      // console.log(event.target.value);
      // this.$emit('send-keyword', event.target.value);

      this.$emit('send-keyword', this.dongCode);
    },
  },
};
</script>

<style></style>
