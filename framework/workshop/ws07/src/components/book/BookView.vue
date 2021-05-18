<template>
  <div>
    <view-detail />
  </div>
</template>

<script>
import ViewDetail from "@/components/book/include/ViewDetail.vue";

export default {
  name: "bookview",
  components: {
    ViewDetail
  },
  created() {
    this.$store.dispatch("getBook", `/${this.$route.query.isbn}`);
  }
};
</script>
