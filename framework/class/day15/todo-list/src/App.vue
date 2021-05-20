<template>
  <div id="app">
    <h1>오늘의 할일</h1>
    <h2>모든 할 일: {{totalTodoCount}}</h2>
    <h2>완료 된 일: {{completedTodoCount}}</h2>
    <h2>남은 할 일: {{unCompletedTodoCount}}</h2>
    <todo-form />
    <todo-list />
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import TodoForm from '@/components/TodoForm';
import TodoList from '@/components/TodoList';

export default {
  name: 'App',
  components: {
    TodoForm,
    TodoList,
  },
  computed: {
    // totalTodoCount() {
    //   return this.$store.getters.totalTodoCount;
    // },
    // completedTodoCount() {
    //   return this.$store.getters.completedTodoCount;
    // },
    // unCompletedTodoCount() {
    //   return this.$store.getters.unCompletedTodoCount;
    // }

    // ...mapGetters({
    //   'totalTodoCount': 'totalTodoCount',
    //   'completedTodoCount': 'completedTodoCount',
    //   'unCompletedTodoCount': 'unCompletedTodoCount'
    // })

    ...mapGetters(['totalTodoCount', 'completedTodoCount', 'unCompletedTodoCount'])
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
