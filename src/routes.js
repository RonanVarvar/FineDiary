import EnterUser from './components/Users/EnterUser.vue';
import PasswordRemind from './components/Users/PasswordRemind.vue';
import UserFirstRegForm from './components/Users/UserFirstRegForm.vue';

export const routes = [
  { path: '', component: EnterUser},
  { path: '/PasswordRemind', component: PasswordRemind},
  { path: '/UserFirstRegForm', component: UserFirstRegForm}
];
