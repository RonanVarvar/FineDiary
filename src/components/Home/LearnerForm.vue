<template>
<div>
  <div class="StudentForm">
      <form>
    <div class="col-lg-12">
      <div class="col-lg-4">
          <p class="head">Дані учня/учениці</p>
          <div>
              <input type="text" class="info" placeholder="Введіть реєстраційній код"
                  v-model="student.code">
          </div>
          <div>
              <input type="text" class="info" placeholder="Ім'я"
                  v-model="student.name">
          </div>
          <div>
              <input type="text" class="info" placeholder="По-батькові"
                  v-model="student.secondName">
          </div>
          <div>
              <input type="text" class="info" placeholder="Прізвіще"
                  v-model="student.lastName">
          </div>
          <br>
            <b-form-group label="Стать учня" class="checkedSex">
              <b-form-radio-group id="radios1" v-model="sex" :options="options" name="radioOpenions">
              </b-form-radio-group>
           </b-form-group>
           <p class="sub-header">Дата народження</p>
           <date-picker :date="startTime" :option="option" :limit="limit">
           </date-picker>
             <br><br>
           <div>
               <input type="text" class="info" placeholder="Номер мобільного телефону"
                   v-model="student.phone">
           </div>
           <div>
               <input type="text" class="info" placeholder="Домашня адреса"
                   v-model="student.home">
           </div>
      </div>
      <div class="col-lg-4">
        <p class="head">Данні батьків/опікунів</p>
        <p class="head">Батько</p>
        <div>
          <input type="text" class="name" placeholder="Ім'я" v-model="parent_1.name">
        </div>
        <div>
          <input type="text" class="name" placeholder="По-батькові" v-model="parent_1.middleName">
        </div>
        <div>
          <input type="text" class="name" placeholder="Прізвище" v-model="parent_1.lastName">
        </div>
        <br />
        <div class="wide">
            <input type="text" class="info" placeholder="Номер мобільного телефону"
                v-model="parent_1.phone">
            <button class="buttonAdd" @click='addMobileNumber()'>Додати +</button>
        </div>
        <br /><br /><br /><br /><br />
        <div>
          <button @click='back()' class='buttonNav'>Назад</button>
          <button @click='regStudent()' class='buttonNav'>Зберегти</button>
        </div>
      </div>
      <div class="col-lg-4">
            <br /><br/>
         <p class="head">Мати</p>
         <div>
           <input type="text" class="name" placeholder="Ім'я" v-model="parent_2.name">
         </div>
         <div>
           <input type="text" class="name" placeholder="По-батькові" v-model="parent_2.middleName">
         </div>
         <div>
           <input type="text" class="name" placeholder="Прізвище" v-model="parent_2.lastName">
         </div>
         <br />
         <div class="wide">
             <input type="text" class="info" placeholder="Номер мобільного телефону"
                 v-model="parent_2.phone">
             <button class="buttonAdd" @click='addMobileNumber()'>Додати +</button>
         </div>
        </div>
    </div>
          </form>
  </div>
</div>
</template>

<script>
import myDatepicker from 'vue-datepicker'

export default {
  data() {
    return {
      sex: '',
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
          'padding': '10px',
          'line-height': '16px',
          'font-size': '18px',
          'border': '2px solid #29c770',
          'border-radius': '15px',
          'box-shadow': '0 1px 3px 0 rgba(0, 0, 0, 0.2)',
          'color': 'black',
          'font-family': 'Arimo'
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
        }
      ],
      parent_1: {},
      parent_2: {}
    }
  },
  components: {
    'date-picker': myDatepicker,
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
    student: {
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
    font-size: 25px;
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
