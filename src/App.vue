<template>
  <div id="app">
	<!--<div class="container">
		<div class="row">
      <header-home></header-home>-->
      <transition name="fade">
        <router-view></router-view>
      </transition>
      <!--</div>
  </div>-->
</div>
</template>

<script>
  import Home from './components/Home/Home.vue';
  import HeaderHome from './components/Home/HeaderHome.vue';
  import EnterUser from './components/Home/EnterUser.vue';
  import PasswordRemind from './components/Home/PasswordRemind.vue';
  import Registration  from './components/Home/Registration.vue';
  import MassagePassRemind from './components/Home/MassagePassRemind.vue';
  import NewPasswordForm from './components/Home/NewPasswordForm.vue';
  import TeacherHomePage from './components/User/TeacherHomePage.vue';
  import makeBlocks from './components/User/makeBlocks.vue';

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
      TeacherHomePage:TeacherHomePage,
      makeBlocks:makeBlocks
  }
}

</script>

<style lang="scss">
body {
background: url('./assets/background.jpg') no-repeat center center fixed;
    padding:0px;
    margin:0px;
 /* background-position: right;  Положение фона */
}

#app {
font-family:  Arimo;
-webkit-font-smoothing: antialiased;
-moz-osx-font-smoothing: grayscale;
text-align: center;
    width:100%;
    height:100%;
    position: relative;

}

</style>
