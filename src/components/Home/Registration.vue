<template>
<div>
  <header-home></header-home>
  <b-modal centered ref="teacher" class="teacherModal" ok-only hide-header-close>
      <teacher-form></teacher-form>
  </b-modal>
  <b-modal centered ref="learner" class="studentModal" ok-only hide-header-close>
      <learner-form></learner-form>
  </b-modal>
  <div id="Registration">
    <form>
      <div class="container">
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input type="text"
            id="email-reg"
            class="form-control"
            placeholder="Введіть Ваш E-mail"
            v-model="email">
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <input
            type="password"
            id="password-reg"
            class="form-control"
            placeholder="Придумайте пароль"
            v-model="password">
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <b-btn
              @click="showModal('teacher')"
              class="button-typeUser">Я вчитель</b-btn>
          </br>
          <b-btn
              @click="showModal('learner')"
              class="button-typeUser">Учень/батьки</b-btn>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <button
              class="button"
              id="show-show"
              @click="navigateToBack">Назад</button>
          <button
              class="button"
              id="show-show"
              @click.prevent='Registration'>Зареєструватися</button>
        </div>
      </div>
    </form>
  </div>
</div>
</template>

<script>
import headerHome from './HeaderHome.vue'
import teacherForm from './TeacherForm.vue'
import learnerForm from './LearnerForm.vue'

  export default {
    data () {
      return {
        email: '',
        password: ''
      };
    },
      components: {
        headerHome,
        teacherForm,
        learnerForm
      },
    methods: {
      showModal: function(name) {
        this.$refs[name].show();
      },
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

.teacherModal, .studentModal {
  position: absolute;
  z-index: 20;
  margin-top: -270px;
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
  width: 280px;
  height: 50px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 14pt;
  font-family: Arimo;
  border: 2px solid #29c770;
  border-radius: 20px;
}
.button{text-decoration:none; text-align:center;
 padding:14px 54px;
 border:none;
 -webkit-border-radius:15px;
 -moz-border-radius:15px;
 border-radius: 15px;
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
 transition:  color 0.12s ease;}.button:hover{
 padding:13px 53px;
 border:ridge 2px #54e191;
 -webkit-border-radius:15px;
 -moz-border-radius:15px;
 border-radius: 15px;
 font: 16pt Arimo;
 color:#49da8a;
 background:#ffffff;
 -webkit-box-shadow:inset 0,0,0px 0,0,0px 0,-13,-13px #ffffff,#ffffff,#ffffff;  -moz-box-shadow:inset 0px 0px -13px #ffffff;  box-shadow:inset 0px 0px -13px #ffffff;
cursor: pointer;
 }.button:active{
 padding:13px 53px;
 border:none;
 -webkit-border-radius:15px;
 -moz-border-radius:15px;
 border-radius: 15px;
 font: 16pt Arimo monospace;
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
  border: 2px solid white;
  border-radius: 20px;
  width: 125px;
  height: 55px;
  padding: 10px;
  background-color: transparent;
  color: white;
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
