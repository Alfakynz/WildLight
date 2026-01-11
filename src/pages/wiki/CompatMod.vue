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
      <h1>Mods compatibility</h1>
      <p>WildLight Compat adds some compatibility fixes between:</p>
      <ul>
        <li>
          <a href="https://modrinth.com/project/Xy8aRQKS" target="_blank">Physics Mod</a> and Breeze
          monsters: breeze particles were buggy, ground particles were to big.
        </li>
        <li>
          <a href="https://modrinth.com/project/Xy8aRQKS" target="_blank">Physics Mod</a> and
          <a href="https://modrinth.com/project/fnAffV0n" target="_blank">Deeper and Darker</a>:
          portal particles were buggy, reinforced deepslate particles appeared instead of the portal
          ones (see
          <a href="https://github.com/haubna/PhysicsMod/issues/1099" target="_blank">#1099</a>).
        </li>
        <li>
          <a href="https://modrinth.com/project/Xy8aRQKS" target="_blank">Physics Mod</a> and
          <a href="https://modrinth.com/project/POQ2i9zu" target="_blank">Friends and Foes</a>:
          wildfire particles were buggy, ground particles appeared instead of the mob ones.
        </li>
        <li>
          <a href="https://modrinth.com/project/idGcORfw" target="_blank"
            >Detail Armor Bar Compat</a
          >
          and <a href="https://modrinth.com/project/eE2Db4YU" target="_blank">Immersive Armors</a>:
          the armors were not compatible. Waiting for
          <a href="https://github.com/Raik176/detail-armor-bar-compat/pull/19" target="_blank"
            >pull request #19</a
          >.
        </li>
        <li>
          <a href="https://modrinth.com/project/YQnwl5Vv" target="_blank">Visual Overhaul</a> and
          all modded woods: the wood in the furnace wasn't textured. Waiting for
          <a href="https://github.com/TeamMidnightDust/VisualOverhaul/pull/99" target="_blank"
            >pull request #99</a
          >.
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
