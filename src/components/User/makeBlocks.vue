<template>
    <div class="divWrapperforUl">
        <ul class="ForUl FoUlManaging" v-bind:class="{ activeUl: arrow, fixedHeightForBlocks: classItem.subjects.length <= 2 }">
            <li>{{classItem.number}}</li>
            <li><a>Список учеников</a></li>
            <li v-for="(item, index) in classItem.subjects" v-if="index <= 1">
                <router-link :to="{ name: 'journal', params: { myClassId: classItem.id, selectedJournalId: item.id }}">
                    Журнал {{ item.subject }}
                </router-link>
            </li>
            <li class="liUl"   v-if="!!classItem.subjects[2]"  v-bind:class="{ active: arrow }">
                <a v-on:click="ArrowUpOrDown" href="javascript:void(0)">
                    <img v-if="arrow" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAMOSURBVGhD7ZlNq01RGMcPocyE5O3KwBeQyEAhUcrAR7gpShl4jVIGJj4BijIQQmTgM0hRDFDEwFzekju6Xv6/2qtW+zx7r2ftl3Pvrf2vX+32Ws/z/M8+T2ettc9o0KBBgwZFWirOFHC9ILVXvBP/Crjm3oLRRnFfhA9QhjHmzFstE+fFL2F9gBjmMJeYeaX94r2wTNdBDLFzrk3ikbBM5kAOck1ctMRF8VtYxppALnJOrN0Oio/CMtMF5KZGb9osngireB9Qi5qdabm4JGaEVTDF3wJrLAU1qY2HVjokPgmriIdXYmcB19YcD3jAS7a2iKfCSurhmzguFosgrrnHmBXjAU94S4qv8LJo2kZ/xE2xWlSJMeYw18qRAm94rGy3w+KzsII9vBQ7hFfMJcbK5QGveB7TA2EFpPgijom4jbwihlhyWLlT4HlMG4RnnxSgNa6LVaKtyEGunHbDK55NcW6wgso8F9uER4sKPCInua2aZfBaKQ4/b4QVCLTAEeFto60CY8C1R+SmRl274TF5UNstygvYrLgqVgiPVoprIm4VrrnHmEfUoia1Yy94w6NLd0QIfCZynuZRUfc0GWNOzreKhxCPN7fWig9iWnj7e7t4IWLTdTCXGI/wgBc84S1L3ifGAndDNFngiCG2bgGN5fWUJZKy5fgqLJM5kKO8pZmI2m4CqwibzN61RtwSTbflHshNDWp1riXihPgurOJ9QC1qUrsT7RKvhVXMA0fXNkdjauOhsdaJ26LN6S68TAgvK9qcMvGCJ7f4Kk+JH8JK6uGxsF7vcI8xK8YDnvCWbLc94q2wknhgwTogUmIOc60cHvCIV1MsTE3biC31BZHzToq5xOQcHWLwiucxnRNWQIqHYko0FbHksHKnwPOY2BbHfwOkYO4+0ZXIlVu/civP/xep9qIVzoo+Xm2Sk9ypdsNj8r+Wu8IKhntivehb1KCW5QHwmBS/1T9FHFj7K9GjrF9RvLnXk5MiBJ0WnW0TGojaeAgPF29uEXxFZK2kPQsveJrLhzpo0KBBnWg0+g+NlSMSTx1JtgAAAABJRU5ErkJggg==" >
                    <img v-if="!arrow" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAMSSURBVGhD7ZlNyw1hGMcfQtkJyXspX0AiC4WUsrDwDaQoZeE1ysLCwidAURZET0pZ+ApSFAsUsbGWt4SNt99Pz9R0znVmrjlzzvFg/vWreWbu67r+Z+Z67rlnZqpTp06d/gnNg/Ow4vdfs0N60ZPe0joCP+EjHINGwSOWtfWgFz3pLSV/eRFU8BS2w6RlTWuXvegt1Sk3oBxY5iashHHLGtaKPIgeK7UDfkAUXPAJTsACGLXMaW5rRLUL9KjXUPPhGUSBEY7dCaOSuZrW13OfTkIUUMctWAPDylhzRLnr0HOfLkNdWw3CVjgNTdrNscbUtdEg9KrnUNEs0YQXsAvq5BjHRjkypGZR5+2j8AGiJBluw1rolfs8FsVk0JPeGt3XnKuvwbDt9gXOgC0kbrsvGluHHvTSaqWxFR5DVCDDyxmiYxmsrYeRyEt5GN5DVGwcWMuaY1keLYOrMGy7ZTC3Naw1dm2BRxAZaYM5zT1RzYVD8BYiU00wh7nMOXJlky4Fb0zfITJZhTHGmiOjxj90OXjD2gdz3JHQJngAkeEIxxqTkR70oie9pXUdioL3YANk5Bk7AG+gbLqMxxyTPbvW1kMRr7eUtkHvrPQNLsAiyGgxXIRyu7ntPo9lZC1rWrvsRW96rJTL4idQDizj2dwPTc7m/RmaXFVrVF1VPYZL+ELHIQrsRWMbISP7O/t/Zk5zRzV70WuoVdBkSW2rXIIl0FbmMFeTmU+veu7TNEQBddgCB6Hx1IiMMbaqjarQc5/2wmuIAjI8hM2QlWONiXJl0KueQy2Ec/AVouA6bI0rUHWD85hjmrRRGb3pUa+1Wg93IUqU4R30Ljncdp/HopgMetJbY+2BVxAlzVAsAtsuMvWgl1byEp6FNk93wy77rWntVBtltQ7uQFRwHFjLmmPTbmjz6FqHua0xERUvEz5DZGYYzFW8rJi42r7eKRj0+mji8oXbc4hMVmFM5oXeRGVLnILMes0xjv0jbZTVaqhat3nMMX+N/H5R/kzg9sBvGrNdPvz43CCVD0KdOnXq9D9pauoXFp8jJOQWjeUAAAAASUVORK5CYII=" >
                </a>
                <ul class="UldisplayNone" style="display:none" v-show="arrow">
                    <li v-bind:class="{ UldisplayNoneLi :arrow }" v-for="(item, index) in classItem.subjects"  v-if="index > 1">
                        <router-link :to="{ name: 'journal', params: { myClassId: classItem.id, selectedJournalId: item.id }}">
                            Журнал {{ item.subject}}
                        </router-link>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'make-blocks',
        props: ['classItem'],
        data (){
            return {
                arrow: false,
            }
        },
      /* mounted: function(){console.log(document.getElementsByClassName('FoUlManaging'));
            var elements = document.getElementsByClassName('FoUlManaging');
            for(var y=0; y<elements.length; y++){
                if(!elements[y].getElementsByClassName('liUl')[0]){//если у ел есть спрятанный список то не даем высоту фиксированную
                    elements[y].classList.add('fixedHeightForBlocks');
                }
            }
        },*/
        methods: {
            ArrowUpOrDown(){
                this.arrow = !this.arrow;
                console.log(this.arrow);
            }
        }
    }
</script>

<style>

    .divWrapperforUl{
        display: flex;
        width:320px;
    }
    .ForUl{
        width:280px;
        border-radius: 20px;
        font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
        font-size: 20px;
        color:white;
        border:1px solid rgb(0,218,132);
        margin-bottom:10px;
    }
    ul.FoUlManaging{
        background: rgb(0,218,132);
    }

    ul.FoUlManaging li{
        text-align: left;
        width: 100%;
        list-style: none;
        padding: 5px 40px 10px 20px;
    }
    ul.FoUlManaging > li:first-child{
        border-bottom: 2px solid white;
        width: 60%;
        margin:0 auto;
    }
    ul.FoUlManaging li:last-child{
        padding-bottom: 2%;
    }
    ul.FoUlManaging li:nth-child(2) {
        padding-top: 15px;
    }
    ul li:hover{
        cursor: pointer;
        color:black;
    }
    ul.FoUlManaging > li:first-child:hover{
        color:white;
    }

    a{
        cursor: pointer;
        text-decoration: none;
        color:white;
    }
    .active{
        vertical-align: top;
    }
    .liUl{
        text-align: center;
    }
    .activeUl{
        position: absolute;
        z-index: 1;
        border:1px solid black;
    }
    li.liUl:last-child{
        padding: 0px;
        margin: 10px 0px 0px 0px;
    }
    li.liUl:last-child li{
        padding: 5px 0px 5px 0px;
    }

    li.liUl a{
        display:inline-block;
        width:100%;
        height:100%;
        text-align: center;
    }
    li.liUl a img{
        width:25px;
        height:25px;
        margin:0 auto;
    }

    li.UldisplayNoneLi{
        position: relative;
        font-weight: normal;
        margin: 0px;
        color:white;

    }
    .UldisplayNone li:hover{
        color:black;
    }

    .fixedHeightForBlocks{
        height:210px;
    }

    @media (max-width: 700px) {/*при маленьком екране блок открытый не становится  position: absolute;*/
        .ForUl{
            margin-bottom:15px;
        }
        .activeUl{
            position: relative;
            background: rebeccapurple;

        }
        div.divContent{
            width:280px;
            margin:auto;
        }


    }

</style>