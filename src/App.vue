<template>
  <div id="app">
	<div class="container">
		<div class="row">
      <router-view></router-view>
		</div>
	</div>
  </div>
</template>

<script>
    import EnterUser from './components/Home/EnterUser.vue';
    import PasswordRemind from './components/Home/PasswordRemind.vue';
    import UserFirstRegForm from './components/Home/UserFirstRegForm.vue';
    export default {
      name: 'app',
      data () {
        return {
        }
      },
      components: {
        enterUser: EnterUser,
        passwordRemind: PasswordRemind,
        userFirstRegForm: UserFirstRegForm
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
