<template>
    <div id="journal">
        <headerTeacherPage></headerTeacherPage>
        <div class="content">
            <subjectFullList :subjects="journalsList.subjects" :classNumber="journalsList.number"
                             :selectedJournalId="this.$route.params.selectedJournalId"></subjectFullList>
            <div class="wrapperForTable">
                <div class="journaOpened">
                    <div class="headerWithButtons">

                        <select v-model="selected">
                            <option v-for="(item,index) in journalsList.semestri" :value="index">{{item.name }}</option>
                        </select>

                        <div>
                            <button>Редагувати</button>
                            <button>Додати </button>
                            <button>Зберегти </button>
                            <button>X</button>
                        </div>
                    </div>
                    <div class="table">
                        <div class="row tableHeader">
                            <div class="tableCell additionalPadding"> Ім'я учнів </div>
                            <div class="tableCell makeRelative additionalPadding"> Оцінки <a href="#"><img
                                    class='placeRight top5px additionalPadding' src="./img/show_marks.png"/></a></div>
                            <div class="tableCell additionalPadding"> Домашнє завдання </div>
                            <div class="tableCell additionalPadding"> Інформація </div>
                        </div>
                        <div class="row tableHeader alignLeft" v-for="(el,index) in journalsList.listOfPeopleWithMarks">
                            <div class="tableCell" v-for="(el2, index2) in el"
                                 v-bind:class="{ width50: index2 === 'mark', alignLeft:index2 === 'name'}"
                                 v-if="index2!='id'">
                                <span v-show="index2 === 'name'" class="number">{{ index + 1 }}</span>
                                {{el2}}
                            </div>
                            <div class="tableCell homeTask NoAlign-itemsCenter">
                                <span>{{journalsList.homeTask}}</span>
                                <span class="makeRelative colorGreen"><a href="#"> Детальніше </a> <a href="#"><img
                                        class='placeRight' src="./img/download_sign.png"/></a> </span>
                            </div>
                            <div class="tableCell">
                                <a href="#"><img
                                        src="./img/red_circleInfo.png"/></a><span>{{journalsList.listOfPeopleWithMarks.length}}</span>
                                <a href="#"><img
                                        src="./img/info_sign.png"/></a><span>{{journalsList.listOfPeopleWithMarks.length}}</span>
                                <a href="#"><img src="./img/download_sign.png"/></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
                journalsList: {}
            }
        },
        created: function () {//requset to server
            console.log(this.$route.params, "****");
            this.getDataFromServer()
                .then(data => {
                    this.journalsList = data;
                    this.selected =  this.journalsList.semestri.length-1;
                })
                .catch(error => {});//вызываем функцию для получения данных с сервера. Передаем ей id класса и id предмета (на основании того что выбрал ЮЗЕР)
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
                                {name: 'Миша Грищев', mark: '10', id: 1}, {
                                    name: 'Катя Грищева',
                                    mark: '8',
                                    id: 2
                                }, {name: 'Стас Кит', mark: '12', id: 3}, {name: 'Таня Кот ', mark: '6', id: 4},
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
                                start: '01.09.2017',
                                end: '22.12.2017'
                            }, {name: '2-й семестр', start: '10.01.2018', end: '31.05.2018'}]
                        });

                })
                //запрос к серверу сделать Передаем ей id класса и id предмета
            },
        }
    }
</script>

<style>
    div#journal {
        width: 100%;
        background: white;
        padding-bottom: 80px;
    }

    div#journal div.content {
        font-size: 0;
        margin-top: 80px;
        width: 95%;
        display: inline-block;
    }

    div#journal div.wrapperForTable {
        width: 80%;
        vertical-align: top;
        display: inline-block;
    }

    div#journal div.journaOpened {
        width: 100%;
        border: 2px solid rgb(0, 218, 132);
        vertical-align: top;
        border-radius: 0px 20px 20px 20px;
    }

    div#journal button, select {
        font-size: 17px;
        border-radius: 10px;
        padding: 12px;
        width: 150px;
        margin-left: 15px;
        cursor: pointer;
        border: 2px solid rgb(0, 218, 132);
        background: white;
        color: white;
    }

    div#journal div.headerWithButtons {
        position: relative;
        text-align: right;
        padding: 15px 0px 15px 0px;
    }

    div#journal select {
        position: absolute;
        left: 10px;
        color: black;
        width: 200px;
    }

    div#journal div.headerWithButtons button:last-child {
        color: rgb(0, 218, 132);
        font-weight: bold;
        font-size: 20px;
        border: none;
        width: 30px;
        margin-right: 5px;
    }

    div#journal div.headerWithButtons button:last-child:hover {
        color: black;
    }

    div#journal div.headerWithButtons div button:nth-child(1), div#journal div.headerWithButtons div button:nth-child(3) {
        background: rgb(0, 218, 132);
    }

    div#journal div.headerWithButtons div button:nth-child(2) {
        color: rgb(0, 218, 132);
    }

    /*ТАБЛИЦА С ДАННЫМИ */
    div#journal div.table {
        display: flex;
        display: -webkit-flex;
        display: -ms-flex;
        flex-flow: column nowrap;
        justify-content: space-between;
        border: none;

    }

    div#journal div.table .row {
        font-size: 18px;
        color: rgb(0, 218, 132);
        display: flex;
        display: -webkit-flex;
        display: -ms-flex;
    }

    div#journal div.table .tableCell {
        display: flex;
        display: -webkit-flex;
        display: -ms-flex;
        padding: 5px 10px 5px 10px;
        flex-grow: 0.5; /*что бы были одинаковой ширины*/
        flex-basis: 0; /*базовый размер отдельно взятого flex-блока*/
        border: 2px solid rgb(0, 218, 132);
        border-bottom: none;
        border-right: none;
        align-items: center;
        justify-content: center;
        color: black;
    }

    div#journal div.table .additionalPadding {
        padding-top: 15px;
        padding-bottom: 15px;
        font-size: 23px;
        color: rgb(0, 218, 132);
    }

    div#journal div.table .tableCell:first-child {
        border-left: none;
    }

    div#journal div.table .tableCell.makeRelative {
        position: relative;
    }

    div#journal div.table img.placeRight {
        position: absolute;
        right: 10px;
        top: 0px;
    }

    .top5px {
        top: 5px !important;
    }

    div#journal div.table .alignLeft {
        justify-content: flex-start;
    }

    div#journal div.table span {
        margin-right: 15px;
        margin-left: 15px;
    }

    div#journal div.table .tableCell.homeTask {
        display: flex;
        flex-grow: 0.5;
        flex-direction: column;
    }

    div#journal div.table .tableCell.homeTask span {
        display: flex;
        width: 80%;
    }

    div#journal div.table .tableCell.homeTask span:first-child {
        color: black;
        font-size: 18px;
    }

    div#journal div.table .colorGreen {
        color: rgb(0, 218, 132);
    }

    div#journal div.table .tableCell.homeTask span:last-child {
        font-size: 16px;
    }

    div#journal div.table .tableCell.homeTask span:first-child, div#journal div.table .tableCell.homeTask span:last-child {
        padding: 2px 0px 2px 0px;
    }

    div#journal div.table span a {
        text-decoration: none;
        color: inherit;
    }

    /*ТАБЛИЦА С ДАННЫМИ */

    @media (max-width: 700px) {
        div#journal div.journaOpened {
            width: 900px;
        }

        div#journal div.table {
            width: 900px;
        }

        div#journal div.wrapperForTable { /*border:1px solid yellow;*/
            overflow: auto;
        }
    }

    @media screen and (min-width: 701px) and (max-width: 900px) {
        div#journal div.table .tableCell {
            padding: 0px;
            margin: 0px;
        }

        div#journal div.table span {
            margin: 0px 4px 0px 4px;
        }

        div#journal div.table span.makeRelative.colorGreen img.placeRight {
            right: -10px;
        }
    }

    @media screen and (min-width: 400px) and (max-width: 1000px) {
        div#journal div.journaOpened button.buttonCalendar {
            display: block;
            position: static;
        }

        div#journal div.journaOpened div.headerWithButtons div {
            display: block;
            text-align: left;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        div#journal div.journaOpened div.headerWithButtons div button:nth-child(4) {
            display: block;
            padding: 0px;
            margin-top: 20px;
        }

    }

    @media screen and (min-width: 920px) {
        div#journal div.content {
            width: 100%;
        }
    }

    @media screen and (min-width: 320px) and (max-width: 1207px) {
        div#journal div.wrapperForTable { /*border:1px solid yellow;*/
            margin-top: 20px;
        }

    }

</style>
