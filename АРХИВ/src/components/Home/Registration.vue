<template>
<div>
  <header-home></header-home>
  <b-modal  centered ref="teacher" class="teacherModal" ok-only hide-header-close>
    <form @submit.prevent="handleSubmit">
        <div class="col-lg-12">
            <div class="col-lg-4">
                <p class="head">Персональні дані</p>
                <div>
                    <input
                          type="text"
                          class="name"
                          placeholder="Ім'я"
                          v-model="name">
                </div>
                <div>
                    <input type="text"
                           class="name"
                           placeholder="По-батькові"
                           v-model="patronymic">
                </div>
                <div>
                    <input type="text"
                           class="name"
                           placeholder="Прізвище"
                           v-model="surname">
                </div>
                <br>
                <p class="sub-header">Дата народження</p>
                <date-picker :date="startTime" :option="option"
                    :limit="limit">
                </date-picker>
            </div>
            <div class="col-lg-4">
                <p class="head">Шкільні дані</p>
                <div class="wide">
                    <input type="text"
                           class="info"
                           placeholder="Школа в якій ви викладаєте"
                           v-model="school">
                    <button class="buttonAdd"
                            @click='addSchool'>Додати +</button>
                </div>
                <div id="newEl"></div>
                <div id='schoolAdd'></div>
                <div class="wide">
                    <input
                          type="text"
                          class="info"
                          placeholder="Предмет який ви викладаєте"
                          v-model="subject">
                    <button class="buttonAdd"
                            @click='addSubject()'>Додати +</button>
                </div>
                <br>
                <div class="white">
                    <input type="checkbox"
                           id="form-master"
                           value="formMaster"
                           v-model="formMaster">
                    <label class="label" for="form-master">
                      В мене є класне керівництво</label>
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br>
                <div>
                    <button @click='back()'
                            class='buttonNav'>Назад</button>
                    <button @click='saveTeacher()'
                            class='buttonNav'>Зберегти</button>
                </div>
            </div>
            <div class="col-lg-4">
                <br><br><br><br><br>
                <div>
                    <input type="text"
                           class="name"
                           placeholder="Ваш клас"
                           v-model="myclass">
                </div>
                <div class="wide">
                    <input
                          type="text"
                          class="info"
                          placeholder="Класи, в яких ви викладаєте"
                          v-model="classes">
                    <button class="buttonAdd"
                            @click='addClasses()'>Додати +</button>
                </div>
                <div class="wide">
                    <input
                          type="text"
                          class="info"
                          placeholder="Номер мобільного телефону"
                          v-model="phone">
                    <button class="buttonAdd"
                            @click='handleSubmit()'>Додати +</button>
                </div>
            </div>
        </div>
    </form>
  </b-modal>
  <b-modal  centered ref="learner" class="studentModal" ok-only hide-header-close>
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
          <b-btn  v-b-modal.modalPrevent
              @click="showModal('teacher')"
              class="button-typeUser">Я вчитель</b-btn>
          </br>
          <b-btn  v-b-modal.modalPrevent
              @click="showModal('learner')"
              class="button-typeUser">Учень/батьки</b-btn>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3">
          <button
              class="button"
              @click="navigateToBack">Назад</button>
          <button
              class="button"
              @click.prevent='Registration'>Зареєструватися</button>
        </div>
      </div>
    </form>
  </div>
</div>
</template>

<script>
import myDatepicker from 'vue-datepicker'
import headerHome from './HeaderHome.vue'
import teacherForm from './TeacherForm.vue'
import learnerForm from './LearnerForm.vue'
import axios from 'axios'
import { bus } from './bus.js'

  export default {
    data () {
      return {
        email: '',
        password: '',
        show: true,
          name: '',
          patronymic: '',
          surname: '',
          subject: '',
          sex: '',
          school: '',
          subject: '',
          myclass: '',
          formMaster: '',
          classes:'',
          phone: '',
        startTime: {
            time: ''
          },
          endtime: {
            time: ''
          },
          option: {
            type: 'day',
            week: ['Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Суб', 'Нд'],
            month: ['Січень', 'Лютий', 'Березень', 'Квітень', 'Травень', 'Червень',
            'Липень', 'Серпень', 'Вересень', 'Жовтень', 'Листопад', 'Грудень'],
            format: 'DD.MM.YYYY',
            placeholder: '',
            inputStyle: {
              'display': 'inline-block',
              'padding': '15px',
              'line-height': '18px',
              'font-size': '18px',
              'border': '2px solid #29c770',
              'border-radius': '20px',
              'box-shadow': '0 1px 3px 0 rgba(0, 0, 0, 0.2)',
              'color': 'black',
              'font-family' : 'Arimo'
            },
            color: {
              header: '#29c770',
              headerText: 'white'
            },
            buttons: {
              ok: 'ОК',
              cancel: 'Скасувати'
            },
            overlayOpacity: 0.5, // 0.5 as default
            dismissible: true // as true as default
          },
          limit: [{
            type: 'weekday',
            available: [0, 1, 2, 3, 4, 5, 6]
          },
          {
            type: 'fromto',
            from: '',
            to: ''
          }]
        }
      },
      components: {
        headerHome,
        'date-picker': myDatepicker,
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
        let formData = JSON.parse(sessionStorage.getItem("formData")),
            mainData = {
              email: this.email,
              password: this.password,
            },
            test = {
              name: 'Roman',
              surname: 'Veselovsky'
            },
            //regData = Object.assign(mainData, formData);
            testData = Object.assign(test, mainData),
            data = JSON.stringify(testData);
          //  console.log(JSON.stringify(testData));
          //  console.log(JSON.stringify(regData));
           axios.post('http://54.37.125.181:8080/project/auth/register', data)
              .then((response) => {
                console.log(response);
              })
              .catch((error) => {
                console.log(error);
              });
      },
      addSchool: function () {
        let el, s;
        el = document.getElementById("newEl");
        s = el.innerHTML;
        s = s+'<input type="button" @click="remove.this">';
        el.innerHTML = s;
      },
      handleSubmit() {
      },
      addSubject() {},
      addClasses() {},
      addMobileNumber() {},
      saveTeacher() {
         let datepicker = document.getElementsByClassName('cov-datepicker')[0],
             birthData = datepicker.value,
             theacherData = {
                 name: this.name,
                 patronymic: this.patronymic,
                 surname: this.surname,
                 subject: this.subject,
                 myclass: this.myclass,
                 classes: this.classes,
                 formMaster: this.formMaster,
                 birthday: birthData,
                 phone: this.phone,
              };

            sessionStorage.setItem('formData', JSON.stringify(theacherData));
          this.$refs.teacher.hide();
        },
      back() {
        this.$router.push('/');
      }
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
  margin-top: -200px;
}
.form-control, .name {
  width: 390px;
  height: 50px;
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
.button{
  width: 200px;
  text-decoration:none;
  text-align:center;
  padding: 15px 15px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
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
  transition:  color 0.12s ease;
  cursor: pointer;
}
.button:hover {
  padding: 13px 13px;
  border:ridge 2px #54e191;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
  font: 16pt Arimo;
  color: #49da8a;
  background:#ffffff;
  -webkit-box-shadow:inset 0,0,0px 0,0,0px 0,-13,-13px #ffffff,#ffffff,#ffffff;
  -moz-box-shadow:inset 0px 0px -13px #ffffff;
  box-shadow:inset 0px 0px -13px #ffffff;
  cursor: pointer;
  }
.button:active{
  padding:13px 13px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
  font:16pt Arimo;
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
.button-typeUser{
  margin-bottom: 30px;
  width: 410px;
  text-decoration:none;
  text-align:center;
  padding: 15px 15px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
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
  transition:  color 0.12s ease;
  cursor: pointer;
}
.button-typeUser:hover {
  padding: 13px 13px;
  border:ridge 2px #54e191;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
  font: 16pt Arimo;
  color: #49da8a;
  background:#ffffff;
  -webkit-box-shadow:inset 0,0,0px 0,0,0px 0,-13,-13px #ffffff,#ffffff,#ffffff;
  -moz-box-shadow:inset 0px 0px -13px #ffffff;
  box-shadow:inset 0px 0px -13px #ffffff;
  cursor: pointer;
  }
.button-typeUser:active{
  padding:13px 13px;
  border:none;
  -webkit-border-radius:15px;
  -moz-border-radius:15px;
  border-radius: 20px;
  font:16pt Arimo;
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
