import HeaderHome from './components/Home/HeaderHome.vue';
import EnterUser from './components/Home/EnterUser.vue';
import PasswordRemind from './components/Home/PasswordRemind.vue';
import registration  from './components/Home/Registration.vue';
import Home from './components/Home/Home.vue';
import Header from './components/Home/HeaderHome.vue';
import MassagePassRemind from './components/Home/MassagePassRemind.vue';
import NewPasswordForm from './components/Home/NewPasswordForm.vue';
import TeacherHomePage from './components/User/TeacherHomePage.vue';

export const routes = [
    { path: '', name: 'home', components: {
        default: Home,
        'header-top': Header
    },  children: [
        { path: '', component: EnterUser },
        { path: '/PasswordRemind', component: PasswordRemind },
        { path: '/registration', component: registration },
        { path: '/MassagePassRemind', component: MassagePassRemind },
        { path: '/NewPasswordForm', component: NewPasswordForm },
        { path: '/TeacherHomePage', component: TeacherHomePage },
    ] }
];
