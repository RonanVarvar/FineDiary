<template>
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
    		  <div class="EnterRegistrate">
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
</template>

<script>
  export default {
    name: 'EnterUser',
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
          const { useremail, password } = this
          this.$store.dispatch(AUTH_REQUEST, { useremail, password }).then(() => {
            this.$router.push('/')
          })
        }
}
}
</script>

<style lang="scss" scoped>
#EnterUser{
  font-family: Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.EnterRegistrate{
    margin:0 auto;
    display: inline-block;
    width:50%;
}

.passwordRemind {
  text-decoration: none;
  color: #86e6b1;
  cursor: pointer;
}
.button:first-child{
    margin-bottom: 25px;
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
