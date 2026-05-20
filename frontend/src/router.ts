import { createMemoryHistory, createRouter } from 'vue-router'
import SigninView from './pages/SigninView.vue'
import LoginView from './pages/LoginView.vue'
import HomeView from './pages/HomeView.vue'


const routes = [
  { path: '/', component: HomeView },
  { path: '/login', component: LoginView },
  { path: '/signin', component: SigninView },
]

export const router = createRouter({
  history: createMemoryHistory(),
  routes,
})