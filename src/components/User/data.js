const dataClasses = {
    MyClasses:{ class:{number:"9-a", id:2,:{ "subjects":[{ id:1, subject: "математика"}, { id:2, subject: "физика"}, { id:3, subject: "химия"}, { id:4, subject: "физика"}] }}},
    AllClassesIteach:{ "9-a":{ "subjects":["математика", "русский язык"] },
                       "5-a":{ "subjects":["математика", "химия"] }
    },
};

const dataChildrenList = {id:30, classNumber: "9-a", ChildrenList:[
    {name:"Nina", surname: "Petrova"},{name:"Taya", surname: "Vet"},{name:"Dima", surname: "Sidorov"},
    {name:"Zina", surname: "Petrovaa"},{name:"Vova", surname: "Gorb"},{name:"Vita", surname: "Poland"},
 ]};//в  ответ на запрос получить список учеников (отдаем класс (школа?, айдишник школам + как то подтягивать при отправки верный id) )


const dataZyrnal = {id:22, subject: "математика", "9-a":[
    {name:"Nina", surname: "Petrova", mark:"10"},{name:"Taya", surname: "Vet", mark:"11"},{name:"Dima", surname: "Sidorov", mark:"5"},
    {name:"Zina", surname: "Petrovaa", mark:"5"},{name:"Vova", surname: "Gorb", mark:"12"},{name:"Vita", surname: "Poland",mark:"18"},
]};//в  ответ на запрос получить журнал (отдаем класс и предмет)