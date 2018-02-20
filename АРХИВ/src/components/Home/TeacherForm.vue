<template>
  <div>
     <div class="TeacherForm">
       <teacher-form></teacher-form>
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
      </div>
  </div>
</template>

<script>
import myDatepicker from 'vue-datepicker'
import { bus } from './bus.js'

export default {
  data () {
    return {
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
      'date-picker': myDatepicker,
    },
  methods: {
    handleSubmit() {
    },
    back() {
      this.$router.push('/registration');
    },
    addSchool: function () {
      let el, s;
      el = document.getElementById("newEl");
      s = el.innerHTML;
      s = s+'<input type="button" @click="remove.this">';
      el.innerHTML = s;
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
          bus.$emit('mega-event', this.$refs('teacher').hide());
      }
    }
  }
</script>

<style>
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
</style>
