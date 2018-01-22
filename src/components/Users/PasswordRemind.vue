<template>
<div>
  <div class="logo">
    <img src="../../assets/logo.png" alt="Файний щоденник" width="80px">
    <h1 class="header">ФАЙНИЙ ЩОДЕННИК</h1>
  </div>
    <div id="passwordRemind">
      <input
            type="text"
            id="emailRemind"
            class="form-control"
            placeholder="Введіть Вашу e-mail адресу"
            >
      <div class="nav-button">
        <button>
        <router-link to="/">Назад</router-link>
      </button>
      <button type="submit">
        Відправити
      </button>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'PasswordRemind',
  data () {
    return {
    }
  }
}
</script>

<style>
.logo {
   font-family: Arimo;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
