<template>
    <div class="main">
            <headerTeacherPage></headerTeacherPage>
        <h3 class="header">Мои классы</h3>
        <div class="divContent">
            <make-blocks :dataMy="dataMy" v-for="classItem in dataMy.MyClasses" :classItem="classItem"></make-blocks>
            <make-block-addManagingOtherClass text="Додати керівництво  іншого класу +"></make-block-addManagingOtherClass>
        </div>
        <h3 class="header headerGreen">Классы в которых я приподаю</h3>
        <div class="divContent">
            <make-blocks :dataMy="dataMy" v-for="classItem in dataMy.AllClassesIteach" :classItem="classItem"></make-blocks>
            <make-block-addManagingOtherClass text="Додати класс для викладання +"></make-block-addManagingOtherClass>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue';
    import makeBlocks from './makeBlocks.vue';
    import headerTeacherPage from './headerTeacherPage.vue';

    export default {
        name: 'TeacherHomePage',
        components: {
            makeBlocks: makeBlocks,
            headerTeacherPage: headerTeacherPage
        },
        data () {
            return {
                dataMy: {
                    MyClasses:[
                        {number:"9-a", id:2, "subjects":[{ id:1, subject: "математика"}, { id:2, subject: "фізика"}, { id:3, subject: "фіз-ра"}, { id:4, subject: "физика"}]},
                        {number:"11", id:3, "subjects":[{ id:5, subject: "информатика"}, { id:2, subject: "укр мова"}]},
                    ],
                    AllClassesIteach:[
                        {number:"9-а", id:2, "subjects":[{ id:1, subject: "математика"}, { id:2, subject: "физика"}, { id:3, subject: "физ-ра"}, { id:4, subject: "физика"}]},
                        {number:"8", id:6, "subjects":[{ id:5, subject: "информатика"}, { id:2, subject: "укр мова"}]},
                        {number:"6-д", id:7, "subjects":[{ id:4, subject: "алгебра"}]},
                    ]
                },
                users: [  ],
                height:{}
            }
        },
        methods: {
        },
        mounted() {
            console.log('beforeCreate');
            console.log(this);
            console.log(this.dataMy);
            //запрос к серверу на получение данных
        }
    }

    Vue.component('make-block-addManagingOtherClass', {
        template: '<ul class="ForUl ForUlAddBlock"><li><a>{{text}}</a></li></ul>',
        props: ['text'],
    })

</script>

<style>
    .main{
        width: 100%;
        padding: 0px;
        margin: 0px;
        height:100%;
        background: white;
        padding-bottom: 100px;

    }
    li a:hover{
       color:black;
    }
    ul, li{
        padding: 0; margin: 0;
    }
/*Content*/
    div.divContent{
        background: white;
        display: flex;
        flex-wrap:wrap;
        text-align: left;
        margin-left:2%;
    }
    ul.ForUlAddBlock{/*add block*/
        display: flex;
        list-style: none;
        width:280px;
        height:210px;
        border-radius: 20px;
        border: 2px solid rgb(0,218,132);
        text-align: center;
    }
    ul.ForUlAddBlock li:before{
        height:100%;
        content:"";
        vertical-align: middle;
        display: inline-block;
    }
    ul.ForUlAddBlock li a{
        vertical-align: middle;
        display: inline-block;
        padding: 10px;
        color:rgb(0,218,132);
    }
    h3.header{
        text-align: left;
        padding: 20px;
    }
    h3.header.headerGreen{
        color: rgb(0,218,132);
    }

</style>
