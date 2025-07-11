<template>
  <main>
    <h1>Home</h1>
  </main>
</template>

<script setup>
import { onMounted } from 'vue'

onMounted(() => {
  const nav = document.querySelector('nav')
  const main = document.querySelector('main')
  if (nav && main) {
    main.style.paddingTop = nav.offsetHeight + 'px'
  }
})
</script>
