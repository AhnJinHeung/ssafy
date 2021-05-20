<template>
  <b-row
    class="m-2"
    @click="selectApt"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="2" class="text-center">
      <img src="@/assets/apt.png" class="img-list" alt="" />
    </b-col>
    <b-col cols="10"> [{{ this.apt.일련번호 }}] {{ this.apt.아파트 }}</b-col>
  </b-row>
</template>

<script>
export default {
  name: 'AptListItem',
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    apt: Object,
  },
  methods: {
    selectApt: function() {
      this.$emit('select-apt', this.apt);
    },
    colorChange: function(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.img-list {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
