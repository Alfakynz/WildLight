import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../components/Home.vue'
import WikiView from '../components/Wiki.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomeView,
  },
  {
    path: '/wiki',
    name: 'Wiki',
    component: WikiView,
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes,
})

export default router
