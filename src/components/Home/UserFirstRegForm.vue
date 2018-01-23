<template>
  <div id="UserFirstRegForm">
      <form>
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="text"
                  id="email-reg"
                  class="form-control"
                  placeholder="Введіть Ваш E-mail"
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="password"
                  id="password-reg"
                  class="form-control"
                  placeholder="Придумайте пароль"
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <button class="button-typeUser">Я вчитель</button>
          </br>
            <button class="button-typeUser">Учень/батьки</button>
          </div>
    		  <div class="col-sm-6 col-md-4 col-lg-3">
            <button  class="button" @click="navigateToBack">Назад</button>
      			<button class="button" @click=''>Зареєструватися</button>
          </div>
		  </div>
		</form>
		</div>
</template>

<script>
export default {
  name: 'UserFirstRegForm',
  methods: {
    navigateToBack() {
      this.$router.push('/');
    }
  }
}
</script>

<style>
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
.button-typeUser {
  font-size: 16pt;
  width: 400px;
  height: 55px;
  margin-bottom: 28px;
  padding: 10px;
  border: 2px solid #29c770;
  border-radius: 20px;
  background-color: white;
  cursor: pointer;
}
</style>
