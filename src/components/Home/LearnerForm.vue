<template>
<div>
  <div class="StudentForm">
    <form @submit.stop.prevent="handleSubmit()">
        <div class="col-lg-12">
            <div class="col-lg-4">
                <p class="head">Дані учня/учениці</p>
                <div>
                    <input type="text" class="info" placeholder="Ім'я"
                        v-model="name">
                </div>
                <div>
                    <input type="text" class="info" placeholder="По-батькові"
                        v-model="patronymic">
                </div>
                <div>
                    <input type="text" class="info" placeholder="Прізвіще"
                        v-model="surname">
                </div>
                <br>
                <b-form-group label="Стать учня" class="checkedSex">
                    <b-form-radio-group id="radios2" v-model="sex"
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
                        v-model="phone">
                </div>
                <div>
                    <input type="text" class="info" placeholder="Домашня адреса"
                        v-model="adress">
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
                    <button class="buttonAdd" @click='addMobileNumber()'>Додати +</button>
                </div>
                <div>
                    <button @click='back()' class='buttonNav'>Назад</button>
                    <button @click='saveLearner()' class='buttonNav'>Зберегти</button>
                </div>
            </div>
            <div class="col-lg-4">
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
                <div class="wide">
                    <input type="text" class="info" placeholder="Номер мобільного телефону"
                        v-model="parent2phone">
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
    }
  },
  components: {
    'date-picker': myDatepicker,
  },
  methods: {
    handleSubmit() {
    },
    navigateToBack() {
      this.$router.push('/');
    },
    back() {
      this.$router.push('/');
    },
    addSchool() {},
    addSubject() {},
    addClasses() {},
    addMobileNumber() {},
    saveLearner() {
       let datepicker = document.getElementsByClassName('cov-datepicker')[0],
           birthData = datepicker.value,
           learnerData = {
               name: this.name,
               patronymic: this.patronymic,
               birthday: birthData,
               phone: this.phone,
               name: this.name,
               patronymic: this.patronymic,
               surname: this.surname,
               sex: this.sex,
               phone: this.phone,
               adress: this.adress,
               parent1name: this.parent1name,
               parent1patronymic: this.parent1patronymic,
               parent1surname: this.parent1surname,
               parent1phone: this. parent1phone,
               parent2name: this.parent2name,
               parent2patronymic: this.parent2patronymic,
               parent2surname: this.parent2surname,
               parent2phone: this.parent2phone,
            };
            sessionStorage.clear(),
          sessionStorage.setItem('formData', JSON.stringify(learnerData));
      }
  }
}
</script>

<style>

</style>
