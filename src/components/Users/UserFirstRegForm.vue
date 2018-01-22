<template>
  <div>
  <div class="logo">
    <img src="../../assets/logo.png" alt="Файний щоденник" width="80px">
    <h1 class="header">ФАЙНИЙ ЩОДЕННИК</h1>
  </div>
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
            <button>Я вчитель</button>
            <button>Учень/батьки</button>
          </div>
    		  <div class="col-sm-6 col-md-4 col-lg-3">
      			<router-link to="/">Назад</router-link>
      			<button @click=''>Зареєструватися</button>
          </div>
		  </div>
		</form>
		</div>
  </div>
</template>

<script>
export default {
  name: 'UserFirstRegForm',
  data () {
    return {
        show: true
    }
  }
}
</script>

<style>
</style>
