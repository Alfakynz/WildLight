<script setup>
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
    <section class="content">
      <h1>How to install</h1>
      <p class="warning">🚧 This Wiki is under construction 🚧</p>
    </section>
  </main>
</template>

<style scoped>
main {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
}

.content {
  padding: 2rem;
  overflow-x: auto;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
}

@media (max-width: 1024px) {
  main {
    flex-direction: column;
  }
  .content {
    padding: 1rem;
  }
}

.warning {
  background-color: red;
  color: white;
  padding: 0.5rem;
  border-radius: 15px;
  font-size: 1.2rem;
  text-align: center;
  font-weight: bold;
}
</style>
