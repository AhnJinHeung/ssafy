<template>
  <b-container class="bv-example-row">
    <b-row>
      <b-col>
        <img alt="Happy House" src="@/assets/happyhouse.png" />
      </b-col>
    </b-row>
    <Main />
  </b-container>
</template>

<script>
// @ is an alias to /src
import Main from '@/components/Main.vue';

export default {
  name: 'Home',
  components: {
    Main,
  },
};
</script>
