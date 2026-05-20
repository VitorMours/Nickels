import { createMemoryHistory, createRouter } from 'vue-router'
import SigninView from './ui/pages/SigninView.vue'
import LoginView from './ui/pages/LoginView.vue'
import HomeView from './ui/pages/HomeView.vue'


const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/login', name: 'login', component: LoginView },
  { path: '/signin', name: 'signin', component: SigninView },
]

export const router = createRouter({
  history: createMemoryHistory(),
  routes,
})