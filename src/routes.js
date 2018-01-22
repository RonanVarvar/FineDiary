import EnterUser from './components/Home/EnterUser.vue';
import PasswordRemind from './components/Home/PasswordRemind.vue';
import UserFirstRegForm from './components/Home/UserFirstRegForm.vue';

export const routes = [
  { path: '', component: EnterUser},
  { path: '/PasswordRemind', component: PasswordRemind},
  { path: '/UserFirstRegForm', component: UserFirstRegForm}
];
