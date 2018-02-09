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
