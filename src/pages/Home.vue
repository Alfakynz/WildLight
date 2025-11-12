<script setup lang="ts">
import { onMounted } from 'vue'
import IntroView from '../components/Intro.vue'
import DownloadsView from '../components/Downloads.vue'
import ScreenshotsView from '../components/Screenshots.vue'
import DescriptionView from '../components/Description.vue'

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
