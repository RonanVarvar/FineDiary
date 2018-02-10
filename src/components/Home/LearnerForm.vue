<template>
  <div>
FUCK!
<input type="text"></input>
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
  display: inline-flex;
}
.TeacherRegForm {
  background-color: rgba(105, 220, 156, .9);
  width: 100%;
  border-radius: 20px;
  background-color: rgba(105,220,156,.9);
  width: 100%;
}
</style>
