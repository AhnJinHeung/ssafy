<template>
  <div>
    <input type="text" v-model.trim="todoTitle" @keypress.enter="addTodo" />
    <button @click="addTodo">추가</button>
  </div>
</template>

<script>
export default {
  name: 'TodoForm',
  data() {
    return {
      todoTitle: '',
    };
  },
  methods: {
    addTodo() {
      console.log('addTodo call');
      const todoItem = {
        title: this.todoTitle,
        completed: false,
      };
      console.log(this.$store);
      if (this.todoTitle) this.$store.dispatch('addTodo', todoItem);
      // this.$store.commit('ADD_TODO', todoItem);
      // this.$store.state.todos.push(todoItem);
      this.todoTitle = '';
    },
  },
};
</script>

<style></style>
