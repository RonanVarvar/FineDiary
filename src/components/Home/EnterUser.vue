<template>
  <div>
    <div class="logo">
      <img src="../../assets/logo.png" alt="Файний щоденник" width="110px">
      <h1 class="header">ФАЙНИЙ ЩОДЕННИК</h1>
    </div>
  <div id="EnterUser">
      <b-form class="login" @submit.prevent="login" @submit="onSubmit">
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <b-form-input
                  type="email"
                  id="email"
                  class="form-control"
                  placeholder="E-mail"
                  v-model="useremail"
                  required
                  ></b-form-input>
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
      			<button @click='login' class='button' type="submit">Вхід</button>
      			<button @click='navigateToReg' class='button'>Зареєструватися</button>
          </div>
        <div @click="" class="linkPasswordRemind">
            <router-link to="/PasswordRemind"
            class="passwordRemind">
              Не пам'ятаю пароль
            </router-link>
		    </div>
		  </div>
		</b-form>
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
            useremail: '',
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
  width: 390px;
  height: 50px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 15px;
}

.linkPasswordRemind {
  margin-top: 20px;
}

.button{
  width: 200px;
  text-decoration:none;
  text-align:center;
  padding: 15px 15px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 15px;
  font: 16pt Arimo;
  color:#ffffff;
  background-color:#74f4ad;
  background-image: -moz-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -webkit-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -o-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -ms-linear-gradient(top, #74f4ad 0% ,#2fcb75 100%);
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2fcb75', endColorstr='#2fcb75',GradientType=0 );
  background-image: linear-gradient(top, #74f4ad 0% ,#2fcb75 100%);
  -webkit-transition: color 0.12s ease;
  -moz-transition:  color 0.12s ease;
  -o-transition:  color 0.12s ease;
  transition:  color 0.12s ease;
  cursor: pointer;
}
.button:hover {
  padding: 13px 13px;
  border:ridge 2px #54e191;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 15px;
  font: 16pt Arimo;
  color: #49da8a;
  background:#ffffff;
  -webkit-box-shadow:inset 0,0,0px 0,0,0px 0,-13,-13px #ffffff,#ffffff,#ffffff;
  -moz-box-shadow:inset 0px 0px -13px #ffffff;
  box-shadow:inset 0px 0px -13px #ffffff;
  cursor: pointer;
  }
.button:active{
  padding:13px 13px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 15px;
  font:16pt Arimo;
  color:#ffffff;
  background-color:#74f4ad;
  background-image: -moz-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -webkit-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -o-linear-gradient(top, #74f4ad 0%, #2fcb75 100%);
  background-image: -ms-linear-gradient(top, #74f4ad 0% ,#2fcb75 100%);
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#2fcb75', endColorstr='#2fcb75',GradientType=0 );
  background-image: linear-gradient(top, #74f4ad 0% ,#2fcb75 100%);
  -webkit-box-shadow:-7px 0px -16px #bababa, inset 0px 0px -13px #ffffff;
  -moz-box-shadow: -7px 0px -16px #bababa,  inset 0px 0px -13px #ffffff;
  box-shadow:-7px 0px -16px #bababa, inset 0px 0px -13px #ffffff;
  cursor: pointer;
}
</style>
