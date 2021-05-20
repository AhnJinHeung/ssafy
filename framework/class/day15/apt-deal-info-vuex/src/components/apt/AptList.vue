<template>
  <b-container v-if="apts && apts.length != 0" class="bv-example-row mt-3">
    <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" />
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from 'vuex';
import AptListItem from '@/components/apt/AptListItem.vue';

export default {
  name: 'AptList',
  components: {
    AptListItem,
  },
  computed: {
    ...mapState(['apts']),
  },
};
</script>

<style></style>
