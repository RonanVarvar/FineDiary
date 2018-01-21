<template>
    <div id="passwordRemind">
      <img src="../../assets/logo.png" alt="Файний щоденник">
      <h1>Файний щоденник</h1>
      <input
            type="text"
            id="emailRemind"
            class="form-control"
            placeholder="E-mail"
            >
      <div class="nav-button">
        <button @click="show = !show">
        <router-link to="/EnterUser">Назад</router-link>
      </button>
      <button type="submit">
        Відправити
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PasswordRemind',
  data () {
    return {
      show: false
    }
  }
}
</script>

<style>
</style>
