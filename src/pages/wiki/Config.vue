<script setup lang="ts">
import WikiNav from '../../components/WikiNav.vue'
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
      <h1>Configuration</h1>
      <p>
        You can use the
        <a href="https://modrinth.com/project/DnyS3EEW" target="_blank">Options Profiles</a> mod
        included in the pack to select a preconfigured option. There are 3 configured options and 1
        default option.
      </p>
      <ul>
        <li><b>Default</b>: The default setup (tested on a Mac Mini M2)</li>
        <li><b>Performance</b>: No shaders, fast rendering, maximum possible FPS</li>
        <li>
          <b>Balanced</b>: Uses shaders, offers a middle ground between Performance and Quality
        </li>
        <li>
          <b>Quality</b>: Uses shaders, provides maximum visual fidelity, best for powerful PCs
        </li>
      </ul>
    </section>
  </main>
</template>

<style scoped>
main {
  display: flex;
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
