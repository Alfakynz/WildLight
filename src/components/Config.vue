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
      <h1>Configuration</h1>
      <h2>Minecraft Version</h2>
      <p>
        This modpack uses <strong>Minecraft 1.21.1</strong> with the <strong>Fabric</strong> mod
        loader.
      </p>
      <p>Other versions of Minecraft are not supported. I don't plan to support them for now.</p>
      <h2>Modpack Versioning Scheme</h2>
      <ul>
        <li>
          <strong>x.x.X</strong> &mdash; Update, remove, or change a mod, resource pack, shader, or
          config.<br />
          <em>(Example: 1.0.<b>1</b> &rarr; updated a mod or config)</em>
        </li>
        <li>
          <strong>x.X.x</strong> &mdash; Add a new mod, resource pack, or shader.<br />
          <em>(Example: 1.<b>1</b>.0 &rarr; added a new shader)</em>
        </li>
        <li>
          <strong>X.x.x</strong> &mdash; Add a new dimension or theme to the modpack.<br />
          <em>(Example: <b>2</b>.0.0 &rarr; added a new theme: better immersion in the world)</em>
        </li>
      </ul>
      <p>
        This versioning helps you track what kind of changes have been made to the modpack with each
        release.
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
