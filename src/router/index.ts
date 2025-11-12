import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../pages/Home.vue'
import WikiView from '../pages/Wiki.vue'
import InstallView from '../pages/Install.vue'
import ModsView from '../pages/Mods.vue'
import BugsView from '../pages/Bugs.vue'
import ConfigView from '../pages/Config.vue'

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
  {
    path: '/wiki/install',
    name: 'Install',
    component: InstallView,
  },
  {
    path: '/wiki/mods',
    name: 'Mods',
    component: ModsView,
  },
  {
    path: '/wiki/bugs',
    name: 'Bugs',
    component: BugsView,
  },
  {
    path: '/wiki/config',
    name: 'Config',
    component: ConfigView,
  },
]

const router = createRouter({
  history: createWebHistory('/WildLight/'),
  routes,
})

export default router
