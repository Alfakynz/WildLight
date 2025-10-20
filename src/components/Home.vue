<script setup lang="ts">
import { onMounted } from 'vue'
import IntroView from './Intro.vue'
import DownloadsView from './Downloads.vue'
import ScreenshotsView from './Screenshots.vue'
import DescriptionView from './Description.vue'

onMounted(() => {
  const nav = document.querySelector('nav')
  const main = document.querySelector('main')
  if (nav && main) {
    main.style.paddingTop = nav.offsetHeight + 'px'
  }
})
</script>

<template>
  <main>
    <IntroView />
    <DownloadsView />
    <ScreenshotsView />
    <DescriptionView />
  </main>
</template>
