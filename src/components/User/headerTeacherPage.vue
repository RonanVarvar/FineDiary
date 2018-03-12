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
        <div style="clear: both"></div>
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
        text-align: left;
        display: block;
        width: 100%;
        height: 100%;
        position: relative;
    }
    li a:hover, li:hover{
        color:black;
    }
    ul, li{
        padding: 0; margin: 0;
    }
    .divLogo{
        float: left;
        margin-top:22px;
        margin-left: 22px;
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
    .ulMenu{
        float: left;
        margin-left: 100px;
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
        float: right;
        margin-right: 22px;
        margin-top: 26px;
        vertical-align: middle;
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
    div.LeftInfo img{
        vertical-align: middle;
    }
    div.LeftInfo img:last-child{
        margin-left: 10px;
    }
    span.inlineBlock{
        margin-right: 10px;
    }






    @media screen and (min-width:1001px) and (max-width:1500px){
        .divLogo{
            margin-top: 15px;
        }
        .ulMenu{
            margin-left: 20px;
        }
        li.cell a{
            padding:30px;
        }
        .searchDiv{
            margin-top: 15px;
            vertical-align: middle;
        }
        .SearchInput{
            padding: 10px;
            width:160px;
        }
        .searchDiv .LeftInfo span{
            vertical-align: top;
            font-size: 17px;
        }
    }

    @media screen and (min-width:761px) and (max-width:1000px){
        .divLogo{
            margin-top: 2px;
            margin-left: 5px;
        }
        .divLogo span, li.cell a, .searchDiv .LeftInfo span{
            font-size: 17px;
        }
        .ulMenu{
            margin-left: 5px;
        }
        li.cell a{
            padding:21px;
        }
        .searchDiv{
            margin-top: 9px;
            margin-right: 5px;
        }
        .SearchInput{
            margin-right: 0px;
            padding: 5px;
            width:110px;
        }
    }

    @media (max-width:760px){ /*при маленьком екране блок открытый не становится  position: absolute;*/
        div.divHeader{
            padding-bottom: 180px;
        }

        .divLogo span{
           font-size: 17px;
        }
        .ulMenu{position: absolute;
            font-size: 18px;
            width:50%;
            left: 10px;
            top:120px;
            float: none;
            margin-left: 0px;
        }

        ul.menuListOpen{
            position: static;
            display: inline-block !important;/*что бы display:none; не срабатывал*/
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
            font-size: 18px;
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

        .MenuHeader{/*не отображать пункт меню*/
            display: none !important;
        }

        /*меню высвечивающееся*/
        /*правая часть меню с поиском и приветствием*/
        .searchDiv{
            text-align: right;
            width: 40%;
        }
        .SearchInput{width: 150px;
            border-radius: 15px;
            display:inline-block;
            padding: 9px;
            margin-bottom: 10px;
            margin-right: 0px;

        }
        div.LeftInfo {
            vertical-align: top;
            display:block;
        }

        div.LeftInfo span.inlineBlock{
            display: inline-block;
            font-size: 15px;
            margin-bottom: 0px;
            text-align: left;
            padding-left: 0px;
        }
        div.LeftInfo img:last-child{
            margin-right: 10px;
        }
        /*правая часть меню с поиском и приветствием*/
    }

    @media (max-width:420px){
        div.divHeader{
            padding-bottom: 5px;
        }
        .divLogo{
            margin-left:5px;
            margin-top:5px;
            display: block;
            margin-bottom: 20px;
        }
        .divLogo span{
            margin-left: 0px;
            font-size: 15px;
        }
        .ulMenu{
            display: block;
            margin: 20px 0px 0px 0px;
            width: 100%;
            position: static;
        }
        .searchDiv{text-align: left;
            display: block;
            width: 90%;
            margin-left:5px;
        }

        .searchDiv div.LeftInfo span{
            margin: 0px 0px 5px 0px;
            display: inline-block;
            text-align: left;
        }
    }

</style>