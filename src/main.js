import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import VueAuthenticate from 'vue-authenticate';
import { routes } from './routes';
import BootstrapVue from 'bootstrap-vue';
import Vuex from 'vuex';
import { Navbar, Dropdown } from 'bootstrap-vue/es/components';

Vue.use(BootstrapVue);
Vue.use(VueAxios, axios);
Vue.use(VueRouter);
Vue.use(Vuex);
Vue.use(Navbar);
Vue.use(Dropdown);

const router = new VueRouter({
  routes,
  mode: 'history'
});

new Vue({
  el: '#app',
  router,
  render: h => h (App)
})
