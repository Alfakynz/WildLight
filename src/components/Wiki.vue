<script setup lang="ts">
import WikiNav from './WikiNav.vue'
import { onMounted } from 'vue'

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
    <WikiNav />
    <section class="wiki-content">
      <h1>Wiki</h1>
      <p>
        Welcome to the Wiki section! Here you can find information about the modpack, including
        installation instructions, a list of mods, resource packs, shaders, and more.
      </p>
      <p>
        Use the navigation on the left to explore different sections. If you have any questions or
        need help, feel free to reach out to the community.
      </p>
    </section>
  </main>
</template>

<style scoped>
main {
  flex-direction: row;
  align-items: flex-start;
  width: 100vw;
  max-width: 100vw;
  box-sizing: border-box;
}

@media (max-width: 1024px) {
  main {
    flex-direction: column;
  }
}
</style>
