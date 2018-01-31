<template>
  <div id="TeacherRegForm">
    <div class="row">
      <div class="wrap">
        <p class="header">Персональні дані</p>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="text"
                class="name"
                placeholder="Ім'я"
                v-model="teacher.name"
                >
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="text"
                class="name"
                placeholder="По-батькові"
                v-model="teacher.middleName"
                >
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="text"
                class="name"
                placeholder="Прізвище"
                v-model="teacher.lastName"
                >
        </div>
        <p class="sub-header">Cтать</p>
        <input type="checkbox" id="woman" value="Woman" v-model="checkedSex">
          <label for="woman">Жіноча</label>
        <input type="checkbox" id="man" value="Man" v-model="checkedSex">
          <label for="man">Чоловіча</label>
        <p class="sub-header">Дата народження</p>
        <datepicker language="uk" format="dd.MM.yyyy"></datepicker>
        </div>
      <div class="wrap">
        <p class="header">Шкільні дані</p>
        <div class="col-sm-8 col-md-6 col-lg-4">
          <input
                type="text"
                class="info"
                placeholder="Школа в якій ви викладаєте"
                v-model="teacher.school"
                >
        </div>
        <div class="col-sm-8 col-md-6 col-lg-4">
          <button class="buttonAdd" @click=''>Додати</button>
        </div>
        <div class="col-sm-8 col-md-6 col-lg-4">
          <input
                type="text"
                class="info"
                placeholder="Предмет який ви викладаєте"
                v-model="teacher.subject"
                >
        </div>
        <div class="col-sm-8 col-md-6 col-lg-4">
          <button class="buttonAdd" @click=''>Додати</button>
        </div>
        <div class="col-sm-8 col-md-6 col-lg-4">
        <input type="checkbox"
                id="form-master"
                value="formMaster"
                v-model="checkedFM">
          <label for="man">У Вас є класне керівництво</label>
          <input type="checkbox"
                  id="Admin"
                  value="Admin"
                  v-model="checkedAdmin">
          <label for="man">Адміністратор школи</label>
      </div>
      <div class="col-sm-6 col-md-4 col-lg-3">
        <button @click='back()' class='button'>Назад</button>
        <button @click='regTeacher()' class='button'>Зберегти</button>
      </div>
      </div>
      <div class="wrap">
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
                type="text"
                class="name"
                placeholder="Ваш клас"
                v-model="teacher.grade"
                >
        </div>
      </div>
      <div class="col-sm-8 col-md-6 col-lg-4">
        <input
              type="text"
              class="info"
              placeholder="Класи, в яких ви викладаєте"
              v-model="teacher.subject"
              >
      </div>
      <div class="col-sm-8 col-md-6 col-lg-4">
          <button class="buttonAdd" @click=''>Додати</button>
      </div>
      <div class="col-sm-8 col-md-6 col-lg-4">
        <input
              type="text"
              class="info"
              placeholder="Номер мобільного телефону"
              v-model="teacher.subject"
              >
      </div>
      <div class="col-sm-8 col-md-6 col-lg-4">
          <button class="buttonAdd" @click=''>Додати</button>
      </div>
    </div>
  </div>
</template>

<script>
import Datepicker from 'vuejs-datepicker'

export default {
  name: 'TeacherRegForm',
  components: {
  Datepicker
},
  methods: {
    back() {
      this.$router.push('/');
    },
    teacher: {
      name: ''
    }
  }
}
</script>

<style>
</style>
