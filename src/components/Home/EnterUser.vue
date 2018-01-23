<template>
  <div id="EnterUser">
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
      			<button @click='' class='button'>Вхід</button>
      			<button @click='navigateToReg' class='button'>Зареєструватися</button>
          </div>
        <div @click="" class="linkPasswordRemind">
            <router-link to="/PasswordRemind"
            class="passwordRemind">
              Не пам'ятаю пароль
            </router-link>
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
      }
    },
    methods: {
        navigateToReg() {
          this.$router.push('/UserFirstRegForm');
        }
      }
  }
</script>

<style lang="scss" scoped>
#enterUser{
  font-family: Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}

.passwordRemind {
  text-decoration: none;
  color: #86e6b1;
  cursor: pointer;
}

.logo {
	  text-align: center;
}

.form-control {
  width: 400px;
  height: 55px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 20px;
}

.linkPasswordRemind {
  margin-top: 20px;
}

.button {
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 15px;
  width: 200px;
  height: 55px;
  padding: 10px;
  background-color: white;
  color: #49da8a;
  cursor: pointer;
}

</style>
