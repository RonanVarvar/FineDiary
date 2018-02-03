import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './App.vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import VueAuthenticate from 'vue-authenticate';
import { routes } from './routes';
import Datepicker from 'vuejs-datepicker';
import BootstrapVue from 'bootstrap-vue';
import Vuex from 'vuex';

Vue.use(BootstrapVue);
Vue.use(VueAxios, axios);
Vue.use(VueRouter);
Vue.use(Vuex);

const router = new VueRouter({
  routes,
  mode: 'history'
});

new Vue({
  el: '#app',
  router,
  render: h => h (App)
})
