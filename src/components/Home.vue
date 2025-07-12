<template>
  <main>
    <IntroView />
    <DownloadsView />
    <ScreenshotsView />
  </main>
</template>

<script setup>
import { onMounted } from 'vue'
import IntroView from './Intro.vue'
import DownloadsView from './Downloads.vue'
import ScreenshotsView from './Screenshots.vue'

onMounted(() => {
  const nav = document.querySelector('nav')
  const main = document.querySelector('main')
  if (nav && main) {
    main.style.paddingTop = nav.offsetHeight + 'px'
  }
})
</script>
