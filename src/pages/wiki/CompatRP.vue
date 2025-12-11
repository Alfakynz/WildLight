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
      <h1>Resource Packs compatibility</h1>
      <p>WildLight Compat adds some compatibility fixes between:</p>
      <ul>
        <li>
          <a href="https://modrinth.com/project/sQCUH0Mr" target="_blank"
            >Recolourful Containers GUI + HUD (DARK)</a
          >
          with:
          <ul>
            <li>The Fabric creative button to change page in the inventory</li>
            <li>
              <a href="https://modrinth.com/project/bRFWnJ87" target="_blank"
                >Animal Feeding Trough</a
              >
            </li>
            <li>
              <a href="https://modrinth.com/project/IhBYAM6m" target="_blank"
                >Enhanced Workbenches</a
              >
            </li>
            <li>
              <a href="https://modrinth.com/project/4I1XuqiY" target="_blank"
                >Entity Model Features</a
              >
            </li>
            <li>
              <a href="https://modrinth.com/project/j7Ux0G0U" target="_blank">Not Interested!</a>
            </li>
            <li>
              <a href="https://modrinth.com/project/VLAWWg1B" target="_blank">Useful Backpacks</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="https://modrinth.com/project/O7z3QKAG">Icons</a> with:
          <ul>
            <li><a href="https://modrinth.com/project/mOgUt4GM" target="_blank">Mod Menu</a></li>
            <li>
              <a href="https://modrinth.com/project/DnyS3EEW" target="_blank">Options Profiles</a>
            </li>
            <li><a href="https://modrinth.com/project/Xy8aRQKS" target="_blank">Physics Mod</a></li>
            <li><a href="https://modrinth.com/project/AANobbMI" target="_blank">Sodium</a></li>
            <li><a href="https://modrinth.com/project/ZouiUX7t" target="_blank">Sounds</a></li>
          </ul>
        </li>
        <li>
          <a href="https://modrinth.com/project/rUgZvGzi" target="_blank">Eating Animation</a> with:
          <ul>
            <li>
              <a href="https://modrinth.com/project/AtHRJSUW" target="_blank">Wilder Wild</a> See
              <a href="https://github.com/Theoness1/EatingAnimation/pull/62" target="_blank">#62</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="https://modrinth.com/project/xuN3KzPl" target="_blank">Fusion Connected Glass</a>
          with:
          <ul>
            <li>
              <a href="https://modrinth.com/project/fnAffV0n" target="_blank">Deeper and Darker</a>
            </li>
            <li>
              <a href="https://modrinth.com/project/AtHRJSUW" target="_blank">Wilder Wild</a>
            </li>
          </ul>
        </li>
      </ul>
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
