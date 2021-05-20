<template>
  <b-container v-if="aptlist && aptlist.length != 0" class="bv-example-row mt-3">
    <apt-list-item
      v-for="(apt, index) in aptlist"
      :key="index"
      :apt="apt"
      @select-apt="selectApt"
    />
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>아파트 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import AptListItem from '@/components/apt/AptListItem.vue';

export default {
  name: 'AptList',
  components: {
    AptListItem,
  },
  props: {
    aptlist: Array,
  },
  methods: {
    selectApt: function(apt) {
      this.$emit('select-apt', apt);
    },
  },
};
</script>

<style></style>
