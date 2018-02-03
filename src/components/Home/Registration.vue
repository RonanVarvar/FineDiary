<template>
  <div>
  <b-modal  centered ref="myModalRef" id="teacherModal" ok-only hide-header-close>
    <div class="TeacherRegForm">
        <div class="row ">
            <div class="wrap col-sm-6 col-md-4 col-lg-3">
                <p class="header">Персональні дані</p>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <input type="text" class="name" placeholder="Ім'я" v-model="teacher.name">
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <input type="text" class="name" placeholder="По-батькові" v-model="teacher.middleName">
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <input type="text" class="name" placeholder="Прізвище" v-model="teacher.lastName">
                </div>
                <p class="sub-header">Cтать</p>
                <input type="checkbox" id="woman" value="Woman" v-model="checkedSex">
                <label for="woman">Жіноча</label>
                <input type="checkbox" id="man" value="Man" v-model="checkedSex">
                <label for="man">Чоловіча</label>
                <p class="sub-header">Дата народження</p>
                <date-picker :date="startTime" :option="option" :limit="limit"></date-picker>
            </div>
            <div class="wrap col-sm-6 col-md-4 col-lg-3">
                <p class="header">Шкільні дані</p>
                <div class="col-sm-8 col-md-6 col-lg-4">
                    <input type="text" class="info" placeholder="Школа в якій ви викладаєте"
                        v-model="teacher.school">
                </div>
                <div class="col-sm-8 col-md-6 col-lg-4">
                    <button class="buttonAdd" @click='addSchool()'>Додати</button>
                </div>
                <div class="col-sm-8 col-md-6 col-lg-4">
                    <input type="text" class="info" placeholder="Предмет який ви викладаєте"
                        v-model="teacher.subject">
                </div>
                <div class="col-sm-8 col-md-6 col-lg-4">
                    <button class="buttonAdd" @click='addSubject()'>Додати</button>
                </div>
                <div class="col-sm-8 col-md-6 col-lg-4">
                    <input type="checkbox" id="form-master" value="formMaster" v-model="checkedFM">
                    <label for="man">У Вас є класне керівництво</label>
                    <input type="checkbox" id="Admin" value="Admin" v-model="checkedAdmin">
                    <label for="man">Адміністратор школи</label>
                </div>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <button @click='back()' class='button'>Назад</button>
                    <button @click='regTeacher()' class='button'>Зберегти</button>
                </div>
            </div>
            <div class="wrap col-sm-6 col-md-4 col-lg-3">
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <input type="text" class="name" placeholder="Ваш клас" v-model="teacher.grade">
                </div>
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
                <input type="text" class="info" placeholder="Класи, в яких ви викладаєте"
                    v-model="teacher.subject">
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
                <button class="buttonAdd" @click='addClasses()'>Додати</button>
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
                <input type="text" class="info" placeholder="Номер мобільного телефону"
                    v-model="teacher.subject">
            </div>
            <div class="col-sm-8 col-md-6 col-lg-4">
                <button class="buttonAdd" @click='addMobileNomber()'>Додати</button>
            </div>
        </div>
    </div>
</b-modal>
  <div id="Registration">
      <form>
        <div class="row">
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="text"
                  id="email-reg"
                  class="form-control"
                  placeholder="Введіть Ваш E-mail"
                  v-model="email"
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <input
                  type="password"
                  id="password-reg"
                  class="form-control"
                  placeholder="Придумайте пароль"
                  v-model="password"
                  >
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3">
            <b-btn v-b-modal.teacherModal class="button-typeUser" >Я вчитель</b-btn>
          </br>
            <b-btn v-b-modal.student Modal class="button-typeUser" >Учень/батьки</b-btn>
          </div>
    		  <div class="col-sm-6 col-md-4 col-lg-3">
            <button  class="button" @click="navigateToBack">Назад</button>
      			<button class="button" @click.prevent='Registration'>Зареєструватися</button>
          </div>
		  </div>
		</form>


    </div>
</div>
</template>

<script>
import myDatepicker from 'vue-datepicker'

export default {
  data () {
    return {
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
      'date-picker': myDatepicker
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
    addMobileNomber() {}
  }
  }
</script>

<style>
#Registration {
  position: relative;
  z-index: 0;
}
#teacherModal {
  position: absolute;
  margin-top: -270px;
  z-index: 20;
}
.wrap {
  display: inline-block;
}
.TeacherRegForm {
  background-color: rgba(105,220,156,.9);
}
.header {
  font-family: 'Montserrat', sans-serif;
  font-size: 20pt;
}
.form-control {
  width: 400px;
  height: 55px;
  margin-bottom: 28px;
  padding-left: 15px;
  font-size: 16pt;
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

</style>
