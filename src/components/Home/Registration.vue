<template>
<div>
  <header-home></header-home>
  <!--Teacher modal window-->
<student-form></student-form>
  <teacher-form></teacher-form>



  <!--First form for registration -->
  <div id="Registration">
    <form>
      <div class="container">
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input type="text" id="email-reg" class="form-control" placeholder="Введіть Ваш E-mail" v-model="email">
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input type="password" id="password-reg" class="form-control" placeholder="Придумайте пароль" v-model="password">
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <b-btn v-b-modal.teacherModal class="button-typeUser">Я вчитель</b-btn>
          </br>
          <b-btn v-b-modal.studentModal class="button-typeUser">Учень/батьки</b-btn>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <button class="button" @click="navigateToBack">Назад</button>
          <button class="button" @click.prevent='Registration'>Зареєструватися</button>
        </div>
      </div>
    </form>
  </div>
</div>
</template>

<script>
import headerHome from './HeaderHome.vue'
import teacherForm from './TeacherForm.vue'
import studentForm from './StudentForm.vue'

export default {
  data () {
  },
    components: {
      headerHome,
      teacherForm,
      studentForm
    },
  methods: {
    navigateToBack() {
      this.$router.push('/');
    },
    Registration(event) {
      this.regUsers.push({
        'email': this.email,
        'password': this.password,
      });
    },
    back() {
      this.$router.push('/');
    },
    teacher: {
      name: ''
    },
    addSchool() {},
    addSubject() {},
    addClasses() {},
    addMobileNumber() {}
  }
  }
</script>

<style>
#Registration {
  position: relative;
  z-index: 0;
}


#teacherModal {
    border-radius: 20px;
    position: absolute;
      z-index: 20;
}

#teacherModal {
  position: absolute;
  margin-top: -270px;
  z-index: 20;
}

.header {
  font-family: 'Montserrat', sans-serif;
  font-size: 20pt;
}
.form-control, .name {
  width: 400px;
  height: 55px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 20px;
}
.info {
  width: 300px;
  height: 50px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 14pt;
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
  border: 2px ridge #29c770;
  border-radius: 20px;
  background-color: white;
  cursor: pointer;
}
.buttonAdd {
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 15px;
  width: 100px;
  height: 55px;
  padding: 10px;
  background-color: white;
  color: #49da8a;
  cursor: pointer;
}
.form-group {
  border: none;
}
.custom-control-label {
  font-size: 36px;
  color: #3fc863;
  cursor: pointer;
}
.custom-control-input {
  zoom: 2.3;
}
</style>
