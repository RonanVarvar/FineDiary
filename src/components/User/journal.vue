<template>
    <div id="journal">
        <headerTeacherPage></headerTeacherPage>
        <div class="content">
            <subjectFullList :subjects="journalsList.subjects" :classNumber="journalsList.number" :selectedJournalId="this.$route.params.selectedJournalId"> </subjectFullList>
                <table>
                    <tr>
                        <td v-bind:colspan="marks.length + 3" class="tdWidthSelect">
                            <select v-model="selected">
                                <option v-for="(item,index) in journalsList.semestri" :value="index">{{item.name}}</option>
                            </select>
                            <select v-model="selectedYear">
                                <option v-for="(item,index) in yearsForSelect" :value="index">{{item}}</option>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td v-bind:colspan="marks.length + 3" class="tdWithButtons">
                            <button>Редагувати</button>
                            <button>Додати </button>
                            <button>Зберегти </button>
                            <button><a>X</a></button>
                        </td>
                    </tr>
                    <tr>
                        <td class="headerStyle"> Ім'я учнів </td>
                        <td v-for="(el,index) in marks[0].datesWithMarks" class="rotate">
                            <span v-html="makeDeleteYear(el.date)" class="marginTop5marginBottom5">{{ makeDeleteYear(el.date) }}</span>
                        </td>
                        <td class="width200 headerStyle"> Домашнє завдання </td>
                        <td class="headerStyle"> Інформація </td>
                    </tr>

                    <tr v-for="(el,index) in marks">
                        <td class="alignLeft"> <span>{{index + 1}}</span> {{ el.name}} </td>
                        <td v-for="(el,index) in el.datesWithMarks"> {{el.mark}}</td>
                        <td>{{journalsList.homeTask }}<a href="#"> Детальніше </a> <a href="#"><img src="./img/download_sign.png"/></a></td>
                        <td><a href="#"><img src="./img/red_circleInfo.png" /></a>{{journalsList.listOfPeopleWithMarks.length}}
                            <a href="#"><img src="./img/info_sign.png"/></a>{{journalsList.listOfPeopleWithMarks.length}}
                            <a href="#"><img src="./img/download_sign.png"/></a>
                        </td>
                    </tr>
                </table>
        </div>
    </div>

</template>

<script>
    import headerTeacherPage from './headerTeacherPage.vue';
    import subjectFullList from './subjectFullList.vue';

    export default {
        name: 'journal',
        components: {
            headerTeacherPage: headerTeacherPage,
            subjectFullList: subjectFullList
        },
        data() {
            return {
                selected: '',
                selectedYear: 0,
                yearsForSelect:'',
                journalsList: {},
                marks:[],
        }
        },
        created: function () {//requset to server
            console.log(this.$route.params, "****");
            this.getDataFromServer()
                .then(data => {
                    this.journalsList = data;
                    let currentDate = new Date();
                    for(let x = 0; x < this.journalsList.semestri.length; x++ ){//сортируем массив по возрастанию , по датам в start
                        for(let k = x + 1; k < this.journalsList.semestri.length; k++){
                            if(new Date(this.journalsList.semestri[x].start) > new Date(this.journalsList.semestri[k].start)){
                                let buf = this.journalsList.semestri[x];
                                this.journalsList.semestri[x] =  this.journalsList.semestri[k];
                                this.journalsList.semestri[k] = buf;
                            }
                        }
                    }
                   for(let x = 0; x < this.journalsList.semestri.length; x++ ){//на порядок назад от старта что больше текущей даты
                        if(new Date(this.journalsList.semestri[x].start) > currentDate){
                            this.selected = x -1;
                        }
                   }
                   if(this.selected === ''){ //если больше нет, то последний
                       this.selected = this.journalsList.semestri.length-1;
                   }

                   this.yearsForSelect = this.makeArrwithYears(currentDate); /* вызываем функцию для формирования массива лет текущий + 2 назад*/
                })
                .catch(error => {}).then(data =>{
                     this.getMarksByPeriod(this.journalsList.semestri[this.selected], this.journalsList.id,this.$route.params)
                         .then(data => {
                             this.marks = data;
                         })
                         .catch();
            });//вызываем функцию для получения данных с сервера. Передаем ей id класса и id предмета (на основании того что выбрал ЮЗЕР)
        },
        methods: {
            getDataFromServer() {
                return new Promise((resolve, reject) => {

                    resolve(
                        {
                            number: "9-a",
                            id: 2,
                            subjectSelected: {id: 1, subject: "математика"},
                            homeTask: 'Вирішити приклад',
                            info: ['make task in 2 days'],
                            listOfPeopleWithMarks: [
                                {name: 'Миша Грищев', mark: '10', id: 1}, {name: 'Катя Грищева', mark: '8', id: 2}, {name: 'Стас Кит', mark: '12', id: 3},
                                {name: 'Таня Кот ', mark: '6', id: 4},
                                {name: 'Таня Мишина ', mark: '3', id: 5}, {
                                    name: 'Дима Форк ',
                                    mark: '10',
                                    id: 6
                                }, {name: 'Саша  Мел', mark: '11', id: 7}, {name: 'Никита Кот ', mark: '6', id: 8}
                            ],
                            subjects: [{id: 1, subject: "математика"}, {id: 2, subject: "физика"}, {
                                id: 3,
                                subject: "физ-ра"
                            }, {id: 4, subject: "физика"}],
                            semestri: [{
                                name: '1-й семестр',
                                start: '2017-09-01',
                                end: '2018-01-02'
                                },
                                {
                                name: '3-й семестр',
                                start: '2018-09-01',
                                end: '2018-10-25'},
                                {
                                name: '2-й семестр',
                                start: '2018-02-10',//01.01.2018
                                end: '2018-05-31'}]


                        });

                })
                //запрос к серверу сделать Передаем ей id класса и id предмета
            },
            getMarksByPeriod(objSemestIndex, classId, selectedSubjectId){
                console.log('getMarksByPeriod', objSemestIndex, classId, selectedSubjectId);
                return new Promise((resolve, reject)=>{
                    resolve ([
                            {name: 'Миша Грищев', datesWithMarks:[{date:'2018-02-21',mark: '10' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '9' },{date:'2018-04-01',mark: '12' }, {date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '6' }], id: 1},
                            {name: 'Катя Грищева',datesWithMarks:[{date:'2018-02-21',mark: '11' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '7' },{date:'2018-04-01',mark: '12' },{date:'2018-04-21',mark: '12' },{date:'2018-04-30',mark: '3' }], id: 2},
                            {name: 'Стас Кит',datesWithMarks:[{date:'2018-02-21',mark: '5' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '7' },{date:'2018-04-01',mark: '8' },{date:'2018-04-21',mark: '8' }, {date:'2018-04-30',mark: '6' }], id: 3},
                            {name: 'Таня Кот ', datesWithMarks:[{date:'2018-02-21',mark: '8' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '6' },{date:'2018-04-01',mark: '11' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '6' }], id: 4},
                            {name: 'Таня Мишина ', datesWithMarks:[{date:'2018-02-21',mark: '10' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '5' },{date:'2018-04-01',mark: '12' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '6' }], id: 5},
                            {name: 'Дима Форк ', datesWithMarks:[{date:'2018-02-21',mark: '10' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '3' },{date:'2018-04-01',mark: '10' },{date:'2018-04-21',mark: '9' }, {date:'2018-04-30',mark: '6' }], id: 6},
                            {name: 'Саша  Мел',datesWithMarks:[{date:'2018-02-21',mark: '9' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '9' },{date:'2018-04-01',mark: '11' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '10' }], id: 7},
                            {name: 'Никита Кот ', datesWithMarks:[{date:'2018-02-21',mark: '2' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '9' },{date:'2018-04-01',mark: '12' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '6' }], id: 8},
                            {name: 'Саша  Тул',datesWithMarks:[{date:'2018-02-21',mark: '8' }, {date:'2018-03-01',mark: '9' }, {date:'2018-03-21',mark: '1' },{date:'2018-04-01',mark: '11' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '6' }], id: 7},
                            {name: 'Никита Котен ', datesWithMarks:[{date:'2018-02-21',mark: '2' }, {date:'2018-03-01',mark: '6' }, {date:'2018-03-21',mark: '4' },{date:'2018-04-01',mark: '12' },{date:'2018-04-21',mark: '6' }, {date:'2018-04-30',mark: '8' }], id: 8}
                    ]);
                });
            },
            makeDeleteYear(date){
                let str = date.split('-');
                return str[1] + '/<br>' + str[2];
            },
            makeArrwithYears(currentDate){
                let arrYears = [];
                for(let i = 0; i < 3; i++){
                    arrYears.push(currentDate.getFullYear() - i);
                }
                return  arrYears;
            }
        }
    }
</script>

<style>
div#journal div.content {
    font-size: 0;
    padding-top: 50px;
    padding-bottom: 70px;
    display: inline-block;
    background: white;
    width: 100%;

}

table{
    background: white;
    vertical-align: top;
    border-spacing: 0px;
    border-radius: 0px 20px 20px 20px;
    border:2px solid rgb(0, 218, 132);
    text-align: center;
    display: inline-block;
}

table td.tdWidthSelect, table td.tdWithButtons{
    text-align: left;
    vertical-align: middle;
}
table td.tdWidthSelect{
    border-top: none;
    border-bottom: none;
}
table td.tdWithButtons{
   border-top: none;
}
table td.tdWidthSelect select{
    color: black;
    width: 200px;
}
table td.tdWidthSelect select, table td.tdWidthSelect, table td.tdWithButtons button{
    margin-left: 20px;
    margin-top: 15px;
    margin-bottom: 15px;
}

table td select, table td button{
    font-size: 17px;
    border-radius: 10px;
    padding: 12px;
    width: 150px;
    cursor: pointer;
    border: 2px solid rgb(0, 218, 132);
    background: white;
    color:  rgb(0, 218, 132);
}
div#journal div.headerWithButtons button:last-child:hover {
    color: black;
}

table td button:nth-child(1),table td button:nth-child(3) {
    background: rgb(0, 218, 132);
    color:white;
}

table td button:nth-child(2) {
    color: rgb(0, 218, 132);
}
table td button:last-child{
    color: rgb(0, 218, 132);
    font-weight: bold;
    font-size: 20px;
    border: none;
    width: 30px;
    margin-right: 5px;
}
td.headerStyle{
    color: rgb(0, 218, 132);
    font-weight: bold;
    font-size: 20px;
}
td.alignLeft{
    text-align: left;
}
td span, td a {
    margin-right: 5px;
    margin-left: 5px;
}
.marginTop5marginBottom5{
    margin-top: 5px;
    margin-bottom: 5px;
}

td.rotate span{
    width: 20px;
    display: inline-block;
}
td a{
    text-decoration: none;
    color: rgb(0, 218, 132);
}
td a:hover{
    color:black;
}
table tr:last-child td:first-child{
    border-radius: 0px 0px 0px 20px;
}
table tr:last-child td:last-child{
    border-radius: 0px 0px 20px 0px;
}
td{
    height: 50px;
    border-bottom: 1px solid rgb(0, 218, 132);
    border-right: 2px solid rgb(0, 218, 132);
    border-left: none;
    border-top: 1px solid rgb(0, 218, 132);
    font-size: 17px;
}
table tr:last-child td{
    border-bottom:none;
}
td:first-child{
    border-left: none;
}
td:last-child{
    border-right: none;
}
td.width200{
    width: 200px;
}


    /*ТАБЛИЦА С ДАННЫМИ */

    @media (max-width: 700px) {
        div#journal div.content{
            width: 100%;
            overflow: auto;
        }

        div#journal div.table{
            width: 700px;
        }

    }


</style>
