<template>
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
</template>

<script>

    export default {
        name: 'headerTeacherPage',
        methods: {
            MenuHovered(event){
                var el =document.querySelector('.menuListOpen li');
                console.log(menu.offsetWidth, '!!!!!!!!!!!!', el.offsetWidth);
                // console.log(event.target.parentElement.children[1].offsetWidth, '!!!!!!!!!!!!', event.target.offsetWidth);
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
</script>

<style>
    div.divHeader{
        background: rgb(0,212,125);
        border-collapse: separate; /* Способ отображения границы */
        border-spacing: 7px 0px; /* Расстояние между ячейками */
        text-align: left;
        display: inline-block;
        width: 100%;

    }
    li a:hover, li:hover{
        color:black;
    }

    ul, li{
        padding: 0; margin: 0;
    }
    .divLogo{
        vertical-align: middle;
        display: inline-block;
        margin-right:10%;
        margin-left:40px;
        font-size: 22px;
    }
    .divLogo img, .divLogo span, .ulMenu, li.cell, .searchDiv, .LeftInfo, div.LeftInfo .inlineBlock{
        display: inline-block;
        vertical-align: middle;
    }
    li.cell{
        text-align: center;
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


    ul.menuListOpen li{
        padding: 7px;
        list-style: none;
        color:rgb(0, 219,127);
    }
    ul.menuListOpen li:hover{
        background: none;
        cursor: pointer;
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
        display: inline-block;
    }

    span.inlineBlock{
        color: rgb(255,255,255);
        line-height: 1.3;
        font-size: 19px;
    }

    div.LeftInfo img:last-child{
        margin-left: 10px;
    }
    span.inlineBlock{
        margin-right: 10px;
    }



    @media (max-width: 700px) {/*при маленьком екране блок открытый не становится  position: absolute;*/
        div.divHeader{
            padding-bottom: 15px;
        }
        .divLogo{
            width:100%;
            padding-top: 10px;
            margin-left: 20px;
        }

        .ulMenu{
            margin-top: 20px;
            margin-left: 15px;
            width:50%;
            border:none;
        }
        ul.menuListOpen{
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

        /*правая часть меню с поиском и приветствием */


    }
    @media screen and (min-width:320px) and (max-width:701px){
        .divLogo span{
            font-size: 16px;
        }
    }
    @media screen and (min-width:701px) and (max-width:1000px){
        .divLogo{
            width:100%;
            padding-top: 10px;
            margin-bottom: 10px;
            margin-left:20px;
        }

        #menu{
            position: relative;
            margin-left: 60px;
        }
        ul.menuListOpen{
            margin-left: -25%;
            left:0px;
        }
        li.cell {
            padding: 1px;
        }
        li.cell a{
            padding: 25px;
        }
        .searchDiv{
            width: 40%;
            right: 10px;
            position: absolute;
            top:15px;
            margin-left: 60%;
            text-align: right;
        }
        .SearchInput{
            display: inline-block;
            padding: 10px;
            margin: 0px 0px 10px 0px;
        }
    }

    @media screen and (min-width:1001px) and (max-width:1700px){
        div.divHeader{
            display: flex;
            padding-top: 10px;
            padding-left: 10px;
        }
        .divLogo{
            width:20%;
            display: inline-block;
            padding: 0px;
            margin: 0px;
        }
        #menu{
            width:50%;
            position: relative;
            display: flex;
            padding: 0px;
            margin-left: 0px;
        }
        .ulMenu{
            padding: 1px;
            margin: 0px;
            display: flex;
        }
        li.cell {
            padding: 0px;
            display: flex;
        }
        li.cell a{
            padding: 25px;
        }
        .searchDiv{
            display: inline-block;
            text-align: right;
            padding: 0px;
            margin: 0px;
            width:60%;
        }
        .SearchInput{
            display: inline-block;
            padding: 6px;
            width:180px;
        }

    }
</style>