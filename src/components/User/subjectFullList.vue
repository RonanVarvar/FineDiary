<template>
    <div class="journalsList">
        <ul>
            <li class="makeRelative">
                <a class="width90 noHoverColor"> {{classNumber}} </a>
                <a class="toRightSideEl"> <img src="./img/item_to_classNumber.png"/> </a>
            </li>
            <li v-for="(item, index) in subjects" v-bind:class="{ makeRelative: item.id === Number(selectedJournalId)}">
                 <a v-bind:class="{width90: item.id === Number(selectedJournalId)}"> Журнал {{ item.subject }}  </a>
                 <a v-bind:class="{toRightSideEl: item.id === Number(selectedJournalId)}" v-show="item.id === Number(selectedJournalId)"> X </a>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'subjectFullList',
        props:['subjects', 'classNumber', 'selectedJournalId'],//получает предметы, номер класса выбранного, предмет(его ид)

    }
</script>

<style>
    div.journalsList{
        width:310px;
        padding: 0px;
        margin: 0px;
        display: inline-block;
        background: rgb(0,218,132);
        border-radius: 20px 0 0 20px;
    }
    div.journalsList ul li a{
        cursor: pointer;
    }
    div.journalsList ul{
        width:85%;
        list-style: none;
        margin: 0 auto;
        padding-top: 10px;
        padding-bottom: 100px;
    }
    div.journalsList ul li{
        text-align: left;
        width: 100%;
        display: inline-block;
        vertical-align: middle;
    }
    div.journalsList ul li:first-child{
        border-bottom: 2px solid white;
        padding: 0px;
        margin-bottom: 10px;
    }

    div.journalsList ul li:first-child a{
        font-size: 25px;
        font-weight: bold;
    }
    div.journalsList ul li a{
        display: inline-block;
        padding: 10px 0px 10px 0px;
        color:white;
        font-size: 19px;
    }
    div.journalsList ul li a.toRightSideEl{
        font-weight: bold;
    }
    div.journalsList ul li a:hover{
        color: black;
    }
    div.journalsList a.noHoverColor:hover{
        color: white;
    }
    .toRightSideEl{
        right: 0px;
        top:0px;
        position: absolute;
    }
    .makeRelative{
        position: relative;
    }

</style>