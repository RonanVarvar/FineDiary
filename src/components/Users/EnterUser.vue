<template>
  <div id="EnterUser" v-show="show">
    <div class="logo">
    <!--  <img src="../assets/logo.png" alt="Файний щоденник">-->
    <h1 class="header">Файний щоденник</h1>
    </div>
      <form>
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="text"
                  id="email"
                  class="form-control"
                  placeholder="E-mail"
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="password"
                  id="password"
                  class="form-control"
                  placeholder="Пароль"
                  >
          </div>
    		  <div class="col-sm-6 col-md-4 col-lg-3">
      			<button @click=''>Вхід</button>
      			<button @click=''>Зареєструватися</button>
          </div>
        <div>
            <button @click="show = !show"><router-link class="passwordRemind"
            to="/PasswordRemind">
              Не пам'ятаю пароль
            </router-link></button>
		    </div>
		  </div>
		</form>
		</div>
</template>

<script>
  export default {
    name: 'EnterUser',
    data () {
      return {
        show: true
      }
    }
  }
</script>

<style lang="scss" scoped>
#enterUser {
  font-family:  Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
.passwordRemind {
  text-decoration: none;
}
.logo {
	width: 70px;
}
</style>
