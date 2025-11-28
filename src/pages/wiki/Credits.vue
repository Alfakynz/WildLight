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
      <h1>Credits</h1>
      <p>
        Thanks to <a href="https://github.com/nNoidea" target="_blank">nNoidea</a> for Eating
        Animation support for Wilder Wild compatibility! (via
        <a href="https://github.com/Theoness1/EatingAnimation/pull/62" target="_blank"
          >Eating Animation PR #62</a
        >)
      </p>
      <p>
        And a big thanks as well to every other mod, resource pack, and shader creator! Your
        projects are all awesome!
      </p>
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
