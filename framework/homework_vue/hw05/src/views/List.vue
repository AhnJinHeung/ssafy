<template lang="">
    <div>
        <h2>사원 목록</h2>
        <search-nav/>
        <search-list/>
    </div>
</template>
<script>
import SearchList from '@/components/SearchList.vue';
import SearchNav from '@/components/SearchNav.vue';

export default {
    name: 'List',
    components: {
        SearchList,
        SearchNav,
    },
    data() {
        return {
            
        }
    }
}
</script>
<style lang="">
    
</style>