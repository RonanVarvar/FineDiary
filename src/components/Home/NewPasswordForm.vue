<template>
  <div>
    <header-home></header-home>
    <form>
      <div class="row">
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="text"
                id="newEmail"
                class="form-control"
                placeholder="E-mail"
                >
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="password"
                id="newPassword"
                class="form-control"
                placeholder="Пароль"
                >
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <button @click='navigateToBack' class='button'>Головна</button>
        <button @click='' class='button'>Головна</button>
      </div>
    </div>
  </form>
  </div>
</template>

<script>
import headerHome from './HeaderHome.vue'

export default {
  name: 'NewPasswordForm',
  components: {
      headerHome
  },
  methods: {
    navigateToBack() {
      this.$router.push('/');
    }
  }
}
</script>

<style>
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

</style>
