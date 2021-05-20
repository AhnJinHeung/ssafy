<template lang="">
    <div>
        <table class="table table-bordered table-condensed">
          <colgroup>
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
            <col :style="{width: '20%'}" />
          </colgroup>
          <tr>
            <th>사원 아이디</th>
            <th>사원명</th>
            <th>부서</th>
            <th>직책</th>
            <th>연봉</th>
          </tr>
          <tr v-for="(board, index) in result" :key="index + '_result'">
            <td>{{board.id}}</td>
            <td>{{board.name}}</td>
            <td>{{board.dept_name}}</td>
            <td>{{board.title}}</td>
            <td>{{board.salary}}</td>
          </tr>
        </table>
    </div>
</template>
<script>
import { mapState } from 'vuex';
export default {
    name: 'SearchList',
    computed: {
      ...mapState(['result']),
    }
}
</script>
<style lang="">
    
</style>