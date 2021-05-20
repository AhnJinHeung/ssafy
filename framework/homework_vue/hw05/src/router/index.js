import Vue from 'vue';
import VueRouter from 'vue-router';

import Emp from '@/views/Emp.vue';
import Regist from '@/views/Regist.vue';
import List from '@/views/List.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Emp',
    component: Emp,
    redirect: '/list',
    children: [
      {
        path: 'regist',
        name: 'Regist',
        component: Regist,
      },
      {
        path: 'list',
        name: 'List',
        component: List,
      },
    ],
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
