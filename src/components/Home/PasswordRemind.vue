<template>
    <div id="passwordRemind">
      <header-home></header-home>
      <input
            type="text"
            id="emailRemind"
            class="form-control"
            placeholder="Введіть Вашу e-mail адресу"
            >
      <div class="nav-button">
        <button class="button" @click="navigateToBack">
          Назад
      </button>
      <button class="button" @click="massageSend" type="submit">
          Відправити
      </button>
    </div>
  </div>
</template>

<script>
import headerHome from './HeaderHome.vue'

export default {
  name: 'PasswordRemind',
  components: {
      headerHome
  },
  methods: {
    navigateToBack() {
      this.$router.push('/');
    },
    massageSend () {
      this.$router.push('/MassagePassRemind');
    }
  }
}
</script>

<style scoped>
.header {
  font-family: 'Montserrat', sans-serif;
  font-size: 20pt;
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
.button{
  width: 200px;
  text-decoration:none;
  text-align:center;
  padding: 15px 15px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
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
  border-radius: 20px;
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
  border-radius: 20px;
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
