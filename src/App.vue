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
    import Home from './components/Home/Home.vue';
    import headerHome from './components/Home/HeaderHome.vue';
    import EnterUser from './components/Home/EnterUser.vue';
    import PasswordRemind from './components/Home/PasswordRemind.vue';
    import Registration  from './components/Home/Registration.vue';
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
        headerHome: headerHome,
        enterUser: EnterUser,
        passwordRemind: PasswordRemind,
        registration: Registration,
        massagePassPemind: MassagePassRemind,
        newPasswordForm: NewPasswordForm,
    }
}

</script>

<style lang="scss">
body {
  background: url('./assets/background.jpg') no-repeat center center fixed;
}

#app {
  font-family:  Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

</style>
