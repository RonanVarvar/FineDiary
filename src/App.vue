<template>
  <div id="app">
	<div class="container">
		<div class="row">
			<enterUser></enterUser>
      <router-view></router-view>
		</div>
	</div>
  </div>
</template>

<script>
    import EnterUser from './components/Users/EnterUser.vue';
    import PasswordRemind from './components/Users/PasswordRemind.vue';
    export default {
      name: 'app',
      data () {
        return {
        }
      },
      components: {
        enterUser: EnterUser,
        passwordRemind: PasswordRemind
    }
}
</script>

<style lang="scss">
#app {
  font-family:  Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
