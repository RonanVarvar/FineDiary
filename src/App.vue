<template>
  <div id="app">
	<div class="container">
		<div class="row">
      <header-home></header-home>
      <router-view></router-view>
		</div>
	</div>
  </div>
</template>

<script>
    import Home from './components/Home/Home.vue';
    import HeaderHome from './components/Home/HeaderHome.vue';
    import EnterUser from './components/Home/EnterUser.vue';
    import PasswordRemind from './components/Home/PasswordRemind.vue';
    import UserFirstRegForm from './components/Home/UserFirstRegForm.vue';
    import MassagePassRemind from './components/Home/MassagePassRemind.vue';
    import NewPasswordForm from './components/Home/NewPasswordForm.vue';

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
        userFirstRegForm: UserFirstRegForm,
        massagePassPemind: MassagePassRemind,
        newPasswordForm: NewPasswordForm
    }
}
</script>

<style lang="scss">
#app {
  font-family:  Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
