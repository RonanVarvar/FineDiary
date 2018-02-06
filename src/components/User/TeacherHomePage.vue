<template>
    <div class="main">
        <div class="table">
             <b-nav-form>
                     <div class="divLogo">
                         <img src="./img/logoFD.png">
                         <span> ФАЙНИЙ <br> ЩОДЕННИК </span>
                     </div>
                        <ul class="ulMenu">
                            <li class="cell" id="menu" v-on:mouseover="MenuHovered" v-on:mouseout="MenuOutHovered">
                                <a href="#">Меню</a>
                                    <ul class="menuListOpen">
                                        <li>Створити розклад</li>
                                        <li>Додати класс</li>
                                        <li>створити код запрошення</li>
                                    </ul>
                            </li>
                            <li class="cell"><a href="#">Довідка</a></li>
                        </ul>
                 <div class="searchDiv">
                    <b-form-input class="SearchInput" type="text" placeholder="Search"></b-form-input>
                    <div class="LeftInfo">
                        <span class="inlineBlock">Добрый день,<br> Имя</span>
                        <img class="inlineBlock" src="./img/SovaLogo.png">
                        <img class="inlineBlock" src="./img/SharLogo.png">
                    </div>
                 </div>
                </b-nav-form>
            </b-navbar>
        </div>

    </div>
</template>

<script>
    export default {
        name: 'TeacherHomePage',
        data () {
            return {
                userData: {
                    email: '',
                    password: ''
                },
                users: [  ]
            }
        },
        methods: {
            MenuHovered() {
               console.log('MenuHovered');
               let liIdMenu = document.querySelector('.menuListOpen').style.display = 'block';
               console.log(liIdMenu);
               // liIdMenu.style.display = 'block';
            },
            MenuOutHovered(){
                let liIdMenu = document.querySelector('.menuListOpen').style.display = 'none';
            }
        }
    }

</script>

<style>
.main{
    padding: 0px;
    margin: 0px;
    position: absolute;
    top:0px;
    width: 100%;
    height:100%;
    background: white;
}
.table{
    top:10px;
    background: rgb(0,212,125);
    border-collapse: separate; /* Способ отображения границы */
    border-spacing: 7px 0px; /* Расстояние между ячейками */
}

.divLogo{
    width: 18%;
    display: inline-block;
    text-align: left;
    margin-left: 2%;
}

.divLogo img{
    vertical-align: middle;
    display: inline-block;
}

.divLogo span{
    vertical-align: middle;
    display: inline-block;
}

.ulMenu{
    text-align: left;
    width: 48%;
    display: inline-block;
    height:100%;
}

.searchDiv{
    display: inline-block;
    text-align: right;
    width: 30%;
    margin-right: 2%;
}

div.cellFist span{
    display: inline-block;
    vertical-align: middle;
    text-align: left;
    color: rgb(1,0,0);
    font-size: 20px;
    line-height: 1.0;
 }

li.cell{
    text-align: center;
    display: inline-block;
    list-style: none;
    height:100%;
    font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
    vertical-align: bottom;
}

li.cell a{
    padding:40px;
    cursor: pointer;
    display: block;
    color: rgb(255,255,255);
    font-size: 20px;
    text-decoration: none;
}

li.cell:hover{
    background: rgb(1,229,150);
}

ul, li{
    padding: 0; margin: 0;
}

.SearchInput{
    display: inline-block;
    border-radius: 15px;
    width: 30%;
}
.LeftInfo{
    display: inline-block;
}

div.LeftInfo .inlineBlock{
    padding: 5px;
    display: inline-block;
    vertical-align: middle;
}

span.inlineBlock{
   color: rgb(255,255,255);
    line-height: 1.3;
    font-size: 18px;
    text-align: left;
}
#menu{
    position: relative;
}
ul.menuListOpen{
    position: absolute;
    border:2px solid rgb(1,232,154);
    top:100%;
    left:-25%;
    width: 150%;
    border-radius: 15px;
    text-align: center;
    display: none;
}
ul.menuListOpen li{
    padding: 10px;
    list-style: none;
    color:rgb(0, 219,127);
}
ul.menuListOpen li:hover{
    color:black;
    background: none;
    cursor: pointer;
}
</style>
