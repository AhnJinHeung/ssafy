import Main from './components/Main.js';
import EmpList from './components/EmpList.js';
import RegisterEmp from './components/RegisterEmp.js';

const router = new VueRouter({
  routes: [
    {
      path: '/',
      name: 'main',
      component: Main,
    },
    {
      path: '/EmpList',
      name: 'EmpList',
      component: EmpList,
    },
    {
      path: '/RegisterEmp',
      name: '/RegisterEmp',
      component: RegisterEmp,
    },
  ],
});

const app = new Vue({
  el: '#app',
  router,
});
