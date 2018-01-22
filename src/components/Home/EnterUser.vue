<template>
  <div>
  <div class="logo">
    <img src="../../assets/logo.png" alt="Файний щоденник" width="110px">
    <h1 class="header">ФАЙНИЙ ЩОДЕННИК</h1>
  </div>
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
      			<button @click='' class='button'>
              <router-link to="/UserFirstRegForm"
              class="registration-link">Зареєструватися</router-link>
            </button>
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
  </div>
</template>

<script>
  export default {
    name: 'EnterUser',
    data () {
      return {
      }
    }
  }
</script>

<style lang="scss" scoped>
/*.body {
  background-image: url(../assets/background.jpg);
}*/
#enterUser{
  font-family: Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
.header {
  font-family: 'Montserrat', sans-serif;
  font-size: 20pt;
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

.registration-link {
 text-decoration: none;
 color: #49da8a;
}

</style>
