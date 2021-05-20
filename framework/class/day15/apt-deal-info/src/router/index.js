import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import About from '@/views/About.vue';
import Apt from '@/views/Apt.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Main',
    redirect: '/vuetest/',
  },
  {
    path: '/vuetest/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/vuetest/apt',
    name: 'Apt',
    component: Apt,
  },
  {
    path: '/vuetest/about',
    name: 'About',
    component: About,
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

export default router;
