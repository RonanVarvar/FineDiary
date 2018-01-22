<template>
<div>
  <div class="logo">
    <img src="../../assets/logo.png" alt="Файний щоденник" width="110px">
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
        <button @click="navigateToBack">
          Назад
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
</style>
