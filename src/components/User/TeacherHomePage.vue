<template>
    <div class="main">
       <div class="divHeader">
                <div class="divLogo">
                    <img src="./img/logoFD.png">
                    <span> ФАЙНИЙ <br> ЩОДЕННИК </span>
                </div>
                <ul class="ulMenu">
                    <li class="cell" id="menu" v-on:mouseover="MenuHovered" v-on:mouseout="MenuOutHovered">
                        <a href="#" class="MenuHeader">Меню</a>
                        <ul class="menuListOpen">
                            <li>Створити розклад</li>
                            <li>Додати класс</li>
                            <li>створити код запрошення</li>
                        </ul>
                    </li>
                   <li class="cell"><a href="#">Довідка</a></li>
                </ul>
                <div class="searchDiv">
                    <input class="SearchInput" type="text" placeholder="Search"/>
                    <div class="LeftInfo">
                        <span class="inlineBlock">Добрый день,<br> Имя</span>
                            <img class='imgSova' src="./img/SovaLogo.png">
                            <img  src="./img/SharLogo.png">
                    </div>
                </div>
       </div>
      <!--  </div>-->
        <h3 class="header">Мои классы</h3>
        <div class="divContent">
            <make-blocks :dataMy="dataMy" v-for="classItem in dataMy.MyClasses" :classItem="classItem"></make-blocks>
            <make-block-addManagingOtherClass text="Додати керівництво  іншого класу +"></make-block-addManagingOtherClass>
        </div>
        <h3 class="header headerGreen">Классы в которых я приподаю</h3>
        <div class="divContent">
            <make-blocks :dataMy="dataMy" v-for="classItem in dataMy.MyClasses" :classItem="classItem"></make-blocks>
            <make-block-addManagingOtherClass text="Додати класс для викладання +"></make-block-addManagingOtherClass>
        </div>
    </div>
</template>

<script>
    import Vue from 'vue';
    import makeBlocks from './makeBlocks.vue';

    export default {
        name: 'TeacherHomePage',
        components: {
            makeBlocks: makeBlocks
        },
        data () {
            return {
                dataMy: {
                    MyClasses:[
                        {number:"9-a", id:2, "subjects":[{ id:1, subject: "математика"}, { id:2, subject: "физика"}, { id:3, subject: "физ-ра"}, { id:4, subject: "физика"}]},
                        {number:"11", id:3, "subjects":[{ id:5, subject: "информатика"}, { id:2, subject: "укр мова"}]},
                    ],
                    AllClassesIteach:{ "9-a":{ "subjects":["математика", "русский язык"] },
                        "5-a":{ "subjects":["математика", "химия"] }
                    }
                },
                users: [  ],
                height:{}
            }
        },
        methods: {
            MenuHovered() {console.log(this.dataMy);
                let liIdMenu = document.querySelector('.menuListOpen').style.display = 'block';
            },
            MenuOutHovered(){
                let liIdMenu = document.querySelector('.menuListOpen').style.display = 'none';
            },
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
        padding-bottom: 40px;
    }
   div.divHeader{
        background: rgb(0,212,125);
        border-collapse: separate; /* Способ отображения границы */
        border-spacing: 7px 0px; /* Расстояние между ячейками */
        text-align: left;
        display: inline-block;
        width: 100%;
    }
   li a:hover{
     /*  color:black;*/
   }

    ul, li{
        padding: 0; margin: 0;
    }
    .divLogo{
        vertical-align: middle;
        display: inline-block;
        margin-right:10%;
        margin-left:10px;
        font-size: 22px;
    }
    .divLogo img, .divLogo span, .ulMenu, li.cell, .searchDiv, .LeftInfo, div.LeftInfo .inlineBlock{
        display: inline-block;
        vertical-align: middle;
    }

    li.cell{
        text-align: center;
        padding:10px;
        list-style: none;
        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
    }
    li.cell a{
        padding:40px;
        display: block;
        color: rgb(255,255,255);
        font-size: 20px;
        text-decoration: none;
    }
    li.cell:hover{
        background: rgb(1,229,150);
    }


    #menu{
        position: relative;
    }
    a.MenuHeader{
        display: none;
    }
    ul.menuListOpen{
        z-index: 2;
        position: absolute;
        border:2px solid rgb(1,232,154);
        top:100%;
        left:-28%;
        width: 150%;
        border-radius: 15px;
        text-align: center;
        display: none;
        background: white;
        padding: 10px;
    }

    div.divContent{
        background: white;
        display: flex;
        flex-wrap:wrap;
        text-align: left;
        margin-left:2%;
    }

    ul.menuListOpen li{
        padding: 7px;
        list-style: none;
        color:rgb(0, 219,127);
    }
    ul.menuListOpen li:hover{
      /*  color:black;*/
        background: none;
        cursor: pointer;
        font-size: 18px;
    }


    .searchDiv{
        margin-left: 20%;
    }

    .SearchInput{
        border-radius: 15px;
        display: inline-block;
        width: 250px;
        padding: 12px;
        margin-right: 40px;
    }

    div.LeftInfo .inlineBlock{
        padding-left: 20px;
    }

    span.inlineBlock{
        color: rgb(255,255,255);
        line-height: 1.3;
        font-size: 19px;
        text-align: left;
    }


/*Content*/
    ul.ForUlAddBlock{/*add block*/
        display: flex;
        list-style: none;
        width:280px;
        border-radius: 15px;
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
    ul.ForUlAddBlock li a:hover{
       /* color:black;*/
    }

    h3.header{
        text-align: left;
        padding: 20px;

    }
    h3.header.headerGreen{
        color: rgb(0,218,132);
    }



    @media (max-width: 700px) {/*при маленьком екране блок открытый не становится  position: absolute;*/
        h3.header, h3.header.headerGreen{
           text-align: center;
        }
        div.divHeader{
            padding-bottom: 15px;
        }
        .divLogo{
            width:100%;
            padding-top: 10px;
        }

        .ulMenu{
            margin-top: 20px;
            margin-left: 15px;
            width:50%;
            border:none;
        }
        ul.menuListOpen{/*border:1px solid blueviolet;*/
            position: static;
            display: inline-block !important;/*что бы display:none; не срабатывал */
            border-radius: 0px;
            border:none;
            width:100%;
            background: rgb(0,212,125);
            padding: 0px;
            margin: 0px;
        }

        ul.menuListOpen li{
            margin-top: 5px;
            list-style: none;
            background: rgb(1,229,150);
            color: white;
        }

        .ulMenu li.cell{
            margin-top: 5px;
            padding: 5px 0px 5px 0px;
            width:100%;
            background: rgb(1,229,150);
        }
        .ulMenu li.cell:hover{
            background: none;
        }

        li.cell a{
            padding: 0px;
            font-size: inherit;
            color: rgb(255,255,255);
        }
        li.cell a:hover{
            color: black;
        }

        li#menu{
            vertical-align: top;
            padding: 0px;
            margin:0px;

        }

        .MenuHeader{/*не отображать пункт меню */
            display: none !important;
        }







        /*меню высвечивающееся*/
        /*правая часть меню с поиском и приветствием */
        .searchDiv{
            width: 40%;
            right: 5px;
            position: absolute;
            top:15px;
            margin-left: 60%;
        }
        .SearchInput{
            border-radius: 15px;
            display:inline-block;
            width: 90%;
            padding: 5px;
            margin-bottom: 10px;

        }
        div.LeftInfo .inlineBlock{
           vertical-align: top;
            display:inline-block;
        }

        span.inlineBlock{
            display: inline-block;
            width: 40%;
            text-align: left;
            font-size: 14px;
            margin-bottom: 10px;
        }

        div.LeftInfo div{
            display: inline-block;
            width: 100%;
        }
        div.LeftInfo img:last-child{
            margin-left: 10px;
        }
        /*правая часть меню с поиском и приветствием */


        div.divContent{
            background: white;
            display: flex;
            flex-wrap:wrap;
            text-align: left;
        }

    }

</style>
<img class="imgSova" src="./img/SovaLogo.png">
<img class="imgGlobus" src="./img/SharLogo.png">