<template>
  <div>
    <div class="logo">
      <img src="../../assets/logo.png" alt="Файний щоденник" width="110px">
      <h1 class="header">ФАЙНИЙ ЩОДЕННИК</h1>
    </div>
  <div id="EnterUser">
      <form class="login" @submit.prevent="login">
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="text"
                  id="email"
                  class="form-control"
                  placeholder="E-mail"
                  v-model="useremail"
                  required
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="password"
                  id="password"
                  class="form-control"
                  placeholder="Пароль"
                  v-model="password"
                  required
                  >
          </div>
    		  <div class="col-sm-6 col-md-4 col-lg-3">
      			<button @click.prevent='login' class='button' type="submit">Вхід</button>
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
  </div>
</template>

<script>
import headerHome from './HeaderHome.vue'

  export default {
    name: 'EnterUser',
    componets: {
      headerHome
    },
    data () {
        return {
          userData: {
            email: '',
            password: ''
        },
          users: [  ]
      }
    },
    methods: {
       navigateToReg() {
          this.$router.push('/registration');
        },
        login: function () {
          const { username, password } = this
          myLoginRoutine({ username, password }).then(() => {
            this.$router.push('/')
          })
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

.header {
  font-family: 'Montserrat', sans-serif;
  font-size: 20pt;
}

.logo {
	  text-align: center;
    margin-top: 80px;
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
