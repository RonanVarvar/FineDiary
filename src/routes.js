import HeaderHome from './components/Home/HeaderHome.vue';
import EnterUser from './components/Home/EnterUser.vue';
import PasswordRemind from './components/Home/PasswordRemind.vue';
import registration  from './components/Home/Registration.vue';
import Home from './components/Home/Home.vue';
import MassagePassRemind from './components/Home/MassagePassRemind.vue';
import NewPasswordForm from './components/Home/NewPasswordForm.vue';
import TeacherHomePage from './components/User/TeacherHomePage.vue';
import journal from './components/User/journal.vue';

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  }
  next('/')
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  }
  next('/login')
}

export const routes = [
    { path: '',  components: {
        default: Home
    },  children: [
        { path: '', component: EnterUser },
        { path: '/PasswordRemind', component: PasswordRemind },
        { path: '/registration', component: registration },
        { path: '/MassagePassRemind', component: MassagePassRemind },
        { path: '/NewPasswordForm', component: NewPasswordForm },
    ] },
    {  path: '/TeacherHomePage',
      name: 'TeacherAcount',
      component: TeacherHomePage,
    },
    {  path: '/journal',
        name: 'journal',
        component: journal,
    },
    /*
    {  path: '/account',
      name: 'Account',
      component: TeacherHomePage,
      beforeEnter: ifAuthenticated,
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login,
      beforeEnter: ifNotAuthenticated,
    },*/
];
