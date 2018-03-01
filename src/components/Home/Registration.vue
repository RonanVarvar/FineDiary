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
                <div class="wide">
                    <input
                          type="text"
                          class="info"
                          placeholder="Номер мобільного телефону"
                          id="phone"
                          v-model="phone">
                          <button class="buttonAdd" @click='addMobileNumber()'>Додати +</button>
                </div>
                <div class="addMobile"></div>
            </div>
            <div class="col-lg-4">
                <p class="head">Шкільні дані</p>
                <div class="wide">
                    <input type="text"
                           id="school"
                           class="name"
                           placeholder="Школа, в якій ви викладаєте"
                           v-model="school">
                </div>
                <div class="wide">
                    <input
                          type="text"
                          id="subject"
                          class="name"
                          placeholder="Предмет який ви викладаєте"
                          v-model="subject">
                          <button class="buttonAdd" @click='addSubject()'>Додати +</button>
                </div>
                                <div class="addSubject"></div>
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
                <div class="wide">
                    <button @click="closeModal('teacher')"
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
                          id="classes"
                          v-model="classes">
                          <button class="buttonAdd" @click='addClasses()'>Додати +</button>
                </div>
                <div class="addClasses"></div>
            </div>
        </div>
    </form>
  </b-modal>
  <b-modal  centered ref="learner" class="studentModal" ok-only hide-header-close>
      <form @submit.stop.prevent="handleSubmit()">
          <div class="col-lg-12">
              <div class="col-lg-4">
                  <p class="head">Дані учня/учениці</p>
                  <div>
                      <input type="text" class="name" placeholder="Ім'я"
                          v-model="lname">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="По-батькові"
                          v-model="lpatronymic">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="Прізвіще"
                          v-model="lsurname">
                  </div>
                  <b-form-group  label="Стать учня" class="checkedSex">
                      <b-form-radio-group id="radios2" v-model="sex"
                      plain
                      size="xs"
                          :options="options" name="radioOpenions">
                      </b-form-radio-group>
                  </b-form-group>
                  <p class="sub-header">Дата народження</p>
                  <date-picker :date="startTime" :option="option"
                      :limit="limit">
                  </date-picker>
                  <br><br>
                  <div>
                      <input type="text" class="info" placeholder="Номер мобільного телефону"
                          v-model="lphone">
                  </div>
                  <div>
                      <input type="text" class="info" placeholder="Домашня адреса"
                          v-model="ladress">
                  </div>
                  <div>
                      <input type="text" class="info" placeholder="Школа"
                          v-model="lschool">
                  </div>
                  <div>
                      <input type="text" class="info" placeholder="Класс"
                          v-model="lclass">
                  </div>
              </div>
              <div class="col-lg-4">
                  <p class="head">Данні батьків/опікунів</p>
                  <p class="head">Батько</p>
                  <div>
                      <input type="text" class="name" placeholder="Ім'я"
                          v-model="parent1name">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="По-батькові"
                          v-model="parent1patronymic">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="Прізвище"
                          v-model="parent1surname">
                  </div>
                  <br />
                  <div class="wide">
                      <input type="text" class="info" placeholder="Номер мобільного телефону"
                          v-model="parent1phone">
                  </div>
                  <br /><br /><br /><br /><br/>
                  <div>
                      <button @click="closeModal('learner')"class='buttonNav'>Назад</button>
                      <button @click="saveLearner()" class='buttonNav'>Зберегти</button>
                  </div>
              </div>
              <div class="col-lg-4">
                  <br /><br/>
                  <p class="head">Мати</p>
                  <div>
                      <input type="text" class="name" placeholder="Ім'я"
                          v-model="parent2name">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="По-батькові"
                          v-model="parent2patronymic">
                  </div>
                  <div>
                      <input type="text" class="name" placeholder="Прізвище"
                          v-model="parent2surname">
                  </div>
                  <br />
                  <div class="wide">
                      <input type="text" class="info" placeholder="Номер мобільного телефону"
                          v-model="parent2phone">
                  </div>
              </div>
          </div>
      </form>
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
import axios from 'axios'

  export default {
    data () {
      return {
        email: '',
        password: '',
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
          lname: '',
          lpatronymic: '',
          lsurname: '',
          sex: '',
          lphone: '',
          ladress: '',
          parent1name: '',
          parent1patronymic: '',
          parent1surname: '',
          parent1phone: '',
          parent2name: '',
          parent2patronymic: '',
          parent2surname: '',
          parent2phone: '',
          lclass: '',
          lschool: '',
          options: [
            { text: 'Жіноча', value: 'female'},
            { text: 'Чоловіча', value: 'male' }
          ],
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
      },
    methods: {
      showModal: function(name) {
        this.$refs[name].show();
      },
      closeModal: function(name) {
        this.$refs[name].hide();
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
                "email":"dfgdfgg@.com",
                "password":"tch",
                "name":"Teacher2",
                "patronymic":"Patronymic",
                "lastname":"lastname",
                "birthday":"привет",
                "mobile":"88666",
                "school":"СШ-5",
                "formMaster":"false"
            },
            //regData = Object.assign(mainData, formData);
            testData = Object.assign(test),
            data = JSON.stringify(testData);
            console.log(JSON.stringify(testData));
          //  console.log(JSON.stringify(regData));

           axios.post('http://192.168.0.107:8090/auth/register/teacher',  test)
              .then((response) => {
                console.log(response);
              })
              .catch((error) => {
                console.log(error);
              })
          },
      handleSubmit() {
      },
      saveLearner() {
         let datepicker = document.getElementsByClassName('cov-datepicker')[0],
             birthData = datepicker.value,
             learnerData = {
                 name: this.lname,
                 patronymic: this.lpatronymic,
                 birthday: birthData,
                 phone: this.lphone,
                 name: this.lname,
                 patronymic: this.lpatronymic,
                 surname: this.lsurname,
                 sex: this.sex,
                 phone: this.lphone,
                 adress: this.ladress,
                 parent1name: this.parent1name,
                 parent1patronymic: this.parent1patronymic,
                 parent1surname: this.parent1surname,
                 parent1phone: this.parent1phone,
                 parent2name: this.parent2name,
                 parent2patronymic: this.parent2patronymic,
                 parent2surname: this.parent2surname,
                 parent2phone: this.parent2phone,
                 school: this.lschool,
                 class: this.lclass
              };
            sessionStorage.clear(),
            sessionStorage.setItem('formData', JSON.stringify(learnerData));
            this.$refs.learner.hide();
        },
        addSubject() {
          let addElem = document.getElementsByClassName('addSubject')[0],
              elem = document.createElement('button'),
              dataElem = document.getElementById('subject').value;

              elem.classList.add('Add');
              elem.innerHTML = dataElem;
              addElem.insertAdjacentElement("beforeBegin", elem);
              elem.onclick  = function() {
                this.parentNode.removeChild(this);return false;
              }
        },
        addClasses() {
          let addElem = document.getElementsByClassName('addClasses')[0],
              elem = document.createElement('button'),
              dataElem = document.getElementById('classes').value;

              elem.classList.add('Add');
              elem.innerHTML = dataElem;

              addElem.insertAdjacentElement("beforeBegin", elem);
              elem.onclick  = function() {
                this.parentNode.removeChild(this);return false;
              }
        },
        addMobileNumber() {
          let addElem = document.getElementsByClassName('addMobile')[0],
              elem = document.createElement('button'),
              dataElem = document.getElementById('phone').value;

              elem.classList.add('Add');
              elem.innerHTML = dataElem;
              addElem.insertAdjacentElement("beforeBegin", elem);
              elem.onclick  = function() {
                this.parentNode.removeChild(this);return false;
              }
            },
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
.buttonAdd {
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid white;
  border-radius: 20px;
  width: auto;
  height: 55px;
  padding: 10px;
  background-color: transparent;
  color: white;
  cursor: pointer;
overflow: hidden;
display: inline-block
}
.Add {
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid white;
  border-radius: 20px;
  width: auto;
  height: 55px;
  padding: 10px;
  background-color: transparent;
  color: white;
  cursor: pointer;
overflow: hidden;
display: inline-block
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
.cov-date-caption {
  font-family: Arimo;
}
.week {
  font-family: Arimo;
}
.day {
  font-family: Arimo;
}
.button-box {
  font-family: Arimo;
}
.date-item {
  font-family: Arimo;
}
.label {
  font-size: 16pt;
}
.col-lg-12 {
  display: inline-flex;
  border-radius: 20px;
}
.TeacherForm {
  width: 100%;
  height: 90%;
  margin-bottom: 20px;
}
.head {
  color: #fff;
  font-size: 16pt;
}
.white {
  color: #fff;
  font-size: 25px;
  display: flex;
}
.wide {
  display: inline-flex;
  width: 100%;
}
.col-lg-12 {
  background-color: rgba(105, 220, 156, .9);
}
.checkedSex {
  font-size: 25px;
  color: #fff;
}
.custom-control-label{
  font-size: 25px;
  color: #fff;
}
#radios1 {
  display: inline-flex;
}
.sub-header {
    color: #fff;
    font-size: 16pt;
}
.buttonNav {
  font-size: 16pt;
  font-family: Arimo;
  border: 2px solid white;
  border-radius: 20px;
  width: 185px;
  height: 55px;
  padding: 10px;
  background-color: transparent;
  color: white;
  cursor: pointer;
}
.btn-primary {
  display: none;
}
</style>
