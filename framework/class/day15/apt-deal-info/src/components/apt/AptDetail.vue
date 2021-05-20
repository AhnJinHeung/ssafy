<template>
  <b-container v-if="apt" class="bv-example-row">
    <b-row>
      <b-col
        ><h3>{{ apt.아파트 }}</h3></b-col
      >
    </b-row>
    <b-row class="mb-2 mt-1">
      <b-col><img src="@/assets/apt.png" alt=""/></b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="secondary">일련번호 : {{ apt.일련번호 }}</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="primary">아파트 이름 : {{ apt.아파트 }}</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="info">법정동 : {{ apt.법정동 }}</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="warning">층수 : {{ apt.층 }}층</b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="danger"
          >거래금액 : {{ (apt.거래금액.replace(',', '') * 10000) | price }}원</b-alert
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'AptDetail',
  props: {
    // 선택한 아파트가 없을때는 비어있는 문자열.
    // 배열 형태로 여러가지를 설정해 놓으면 type에 맞게 적용
    apt: [Object, String],
  },
  filters: {
    // test20.html
    price: function(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    },
  },
};
</script>

<style></style>
