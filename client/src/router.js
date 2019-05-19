import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Rating from './views/Rating.vue';
import User from './views/User.vue';
import Achievement from './views/Achievement.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '',
      name: 'home',
      component: Home,
    },
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/rating',
      name: 'rating',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ './views/Rating.vue'),
      component: Rating,
    },
    {
      path: '/user',
      name: 'user',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ './views/User.vue'),
      component: User,
    },
    {
      path: '/achievement',
      name: 'achievement',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      // component: () => import(/* webpackChunkName: "about" */ './views/Achievement.vue'),
      component: Achievement,
    },
  ],
});
