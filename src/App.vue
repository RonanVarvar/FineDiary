<template>
  <div id="app">
	<div class="container">
      <header-home></header-home>
      <transition name="fade">
        <router-view></router-view>
      </transition>
	</div>
  </div>
</template>


<script>
    import 'bootstrap/dist/css/bootstrap.css';
    import 'bootstrap/dist/css/bootstrap.css';
    import 'bootstrap-vue/dist/bootstrap-vue.css';

    import Home from './components/Home/Home.vue';
    import HeaderHome from './components/Home/HeaderHome.vue';
    import EnterUser from './components/Home/EnterUser.vue';
    import PasswordRemind from './components/Home/PasswordRemind.vue';
    import Registration  from './components/Home/Registration.vue';
    import MassagePassRemind from './components/Home/MassagePassRemind.vue';
    import NewPasswordForm from './components/Home/NewPasswordForm.vue';
    import TeacherHomePage from './components/User/TeacherHomePage.vue';

    export default {
      name: 'app',
      data () {
        return {
        }
      },
      components: {
        home: Home,
        headerHome: HeaderHome,
        enterUser: EnterUser,
        passwordRemind: PasswordRemind,
        registration: Registration,
        massagePassPemind: MassagePassRemind,
        newPasswordForm: NewPasswordForm,
        teacherHomePage:TeacherHomePage
    }
}

</script>

<style lang="scss">
body {
  background: url('./assets/background.jpg') no-repeat center center fixed;
    background-position: right; /* Положение фона */
    background-repeat: no-repeat; /* Отменяем повторение фона */
    margin:0px; padding:0px;
}

#app {
  font-family:  Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
    margin:0px; padding:0px;

  text-align: center;
}
    .container{
        margin:0px;
        border:2px solid greenyellow;
        width:100%;
        padding:0px;
    }
    .row{
        border:1px solid black;
        display: inline-block;
        text-align: center;
        margin:0 auto;
    }

</style>
