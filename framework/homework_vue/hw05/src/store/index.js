import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    result: [],
  },
  mutations: {
    GET_EMP_LIST(state, emps) {
      state.result = emps;
    },
  },
  actions: {
    getEmpList({ commit }, word) {
      const addr = 'http://localhost:8097/hrmboot/api/employee';
      var result = [];
      axios
        .get(addr + '/all')
        .then((response) => {
          response.data.forEach((item) => {
            if (item.name.includes(word)) {
              result.push(item);
            }
          });
          console.log(result);
          commit('GET_EMP_LIST', result);
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
  modules: {},
});
