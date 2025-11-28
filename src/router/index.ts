import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../pages/Home.vue'
import WikiView from '../pages/Wiki.vue'
import InstallView from '../pages/wiki/Install.vue'
import ModsView from '../pages/wiki/Mods.vue'
import BugsView from '../pages/wiki/Bugs.vue'
import VersionsView from '../pages/wiki/Versions.vue'
import ConfigView from '../pages/wiki/Config.vue'
import CreditsView from '../pages/wiki/Credits.vue'
import ToolsView from '../pages/wiki/Tools.vue'

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
    path: '/wiki/versions',
    name: 'Versions',
    component: VersionsView,
  },
  {
    path: '/wiki/config',
    name: 'Configurations',
    component: ConfigView,
  },
  {
    path: '/wiki/credits',
    name: 'Credits',
    component: CreditsView,
  },
  {
    path: '/wiki/tools',
    name: 'Tools',
    component: ToolsView,
  },
]

const router = createRouter({
  history: createWebHistory('/WildLight/'),
  routes,
})

export default router
