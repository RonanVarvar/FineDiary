import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import { routes } from './routes';
import BootstrapVue from 'bootstrap-vue';
import Vuex from 'vuex';

Vue.use(BootstrapVue);
Vue.use(axios);
Vue.use(VueAxios, axios);
Vue.use(VueRouter);
Vue.use(Vuex);

const router = new VueRouter({
  routes,
  mode: 'history'
});

const token = localStorage.getItem('user-token')
if (token) {
  axios.defaults.headers.common['Authorization'] = token
}

new Vue({
  el: '#app',
  router,
  render: h => h (App)
})
