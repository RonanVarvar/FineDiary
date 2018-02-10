<template>
  <div>
    <div class="TeacherForm">
      <div class="row col-lg-12">
        <div class="col-lg-4">
            <p class="header">Персональні дані</p>
            <div>
                <input type="text" class="name" placeholder="Ім'я" v-model="teacher.name">
            </div>
            <div>
                <input type="text" class="name" placeholder="По-батькові" v-model="teacher.middleName">
            </div>
            <div>
                <input type="text" class="name" placeholder="Прізвище" v-model="teacher.lastName">
            </div>
            <br>
              <b-form-group label="Стать" class="checkedSex">
                <b-form-radio-group id="radios1" v-model="sex" :options="options" name="radioOpenions">
                </b-form-radio-group>
             </b-form-group>
            <p class="sub-header">Дата народження</p>
            <date-picker :date="startTime" :option="option" :limit="limit"></date-picker>
        </div>
        <div class="col-lg-4">
            <p class="header">Шкільні дані</p>
            <div>
                <input type="text" class="info" placeholder="Школа в якій ви викладаєте"
                    v-model="teacher.school">
               <!-- <button class="buttonAdd" @click='addSchool()'>Додати</button> -->
            </div>
            <div class="wide">
                <input type="text" class="info" placeholder="Предмет який ви викладаєте"
                    v-model="teacher.subject">
                <button class="buttonAdd" @click='addSubject()'>+Додати</button>
            </div>
               <br>
           <div class="white">
                <input type="checkbox" id="form-master" value="formMaster" v-model="checkedFM">
                <label for="man">Класне керівництво</label>
                <input type="checkbox" id="Admin" value="Admin" v-model="checkedAdmin">
                <label for="man">Адміністратор школи</label>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br><br>
            <div>
                <button @click='regTeacher()' class='button'>Зберегти</button>
            </div>
        </div>
        <div class="col-lg-4">
          <br><br><br><br><br>
            <div>
                <input type="text" class="name" placeholder="Ваш клас" v-model="teacher.grade">
            </div>
            <div class="wide">
                <input type="text" class="info" placeholder="Класи, в яких ви викладаєте"
                    v-model="teacher.subject">
                <button class="buttonAdd" @click='addClasses()'>+Додати</button>
            </div>
            <div class="wide">
                <input type="text" class="info" placeholder="Номер мобільного телефону"
                    v-model="teacher.phone">
                <button class="buttonAdd" @click='addMobileNumber()'>+Додати</button>
            </div>
        </div>
    </div>
  </div>

</div>
</template>

<script>
import myDatepicker from 'vue-datepicker'

export default {
  data () {
    return {
      sex: '',
      options: [
        { text: 'Жіноча', value: 'female'},
        { text: 'Чоловіча', value: 'male' }
      ],
      teacherRole: '',
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
          month: ['Січень', 'Лютий', 'Березень', 'Квітень', 'Травень', 'Червень', 'Липень', 'Серпень', 'Вересень', 'Жовтень', 'Листопад', 'Грудень'],
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
.col-lg-12 {
  display: inline-flex;
  border-radius: 20px;

}
.TeacherForm {

  width: 100%;
  height: 90%;
  margin-bottom: 20px;
}
.header {
  color: #fff;
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
