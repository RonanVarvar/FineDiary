<template>
  <div id="app">
	<div class="row">
      <transition name="fade">
        <router-view></router-view>
      </transition>
   </div>
 </div>
</template>

<script>
  import axios from 'axios';

  import Home from './components/Home/Home.vue';
  import headerHome from './components/Home/HeaderHome.vue';
  import EnterUser from './components/Home/EnterUser.vue';
  import PasswordRemind from './components/Home/PasswordRemind.vue';
  import Registration  from './components/Home/Registration.vue';
  import MassagePassRemind from './components/Home/MassagePassRemind.vue';
  import NewPasswordForm from './components/Home/NewPasswordForm.vue';
  import TeacherHomePage from './components/User/TeacherHomePage.vue';
  import makeBlocks from './components/User/makeBlocks.vue';
  import journal from './components/User/journal.vue';

  export default {
    name: 'app',
    data () {
      return {
      }
    },
    components: {
      home: Home,
      headerHome: headerHome,
      enterUser: EnterUser,
      passwordRemind: PasswordRemind,
      registration: Registration,
      massagePassPemind: MassagePassRemind,
      newPasswordForm: NewPasswordForm,
      teacherHomePage: TeacherHomePage,
      journal: journal
  },
  created: function () {
    axios.interceptors.response.use(undefined, function (err) {
      return new Promise(function (resolve, reject) {
        if (err.status === 401 && err.config && !err.config.__isRetryRequest) {
        // if you ever get an unauthorized, logout the user
          this.$store.dispatch(AUTH_LOGOUT)
        // you can also redirect to /login if needed !
        }
        throw err;
      });
    });
  }
}
</script>

<style lang="scss">
body {
background: url('./assets/background.jpg') no-repeat center  fixed;
  background-position: right; /* Положение фона */
    padding: 0px;
    margin: 0px;
}
#app {
font-family:  Arimo;
-webkit-font-smoothing: antialiased;
-moz-osx-font-smoothing: grayscale;
   padding:0px;
   margin:0px;
   width:100%;
   height:100%;
  text-align: center;
}
</style>
