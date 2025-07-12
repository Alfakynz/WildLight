<template>
  <section class="downloads">
    <h2>Download the modpack</h2>
    <div>
      <div class="modrinth">
        <a href="https://modrinth.com/project/6QzexKXD">
          <DownloadIcon />
          Modrinth
        </a>
      </div>
      <div class="curseforge">
        <a href="https://www.curseforge.com/minecraft/modpacks/wildlight">
          <DownloadIcon />
          CurseForge
        </a>
      </div>
    </div>
  </section>
</template>

<script setup>
import DownloadIcon from './icons/DownloadIcon.vue'
</script>

<style scoped>
.downloads {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.downloads > div {
  display: flex;
  justify-content: center;
  align-items: center;
}

.downloads > div div {
  display: flex;
  align-items: center;
  border-radius: 10px;
  width: fit-content;
  margin-bottom: 0.75em;
  transition: all 0.3s;
}

.downloads > div div:hover {
  filter: brightness(1.15);
}

.downloads .modrinth {
  background: #22c55e;
}

.downloads .curseforge {
  background: #f16436;
}

.downloads a {
  display: flex;
  align-items: center;
  gap: 0.75em;
  padding: 0.75em 1.5em;
  color: #000;
  text-decoration: none;
  text-shadow: none;
  font-size: 1.1em;
}

.downloads a:hover {
  text-shadow: none;
}

.downloads a :deep(svg) {
  width: 1.5em;
  height: 1.5em;
}

@media screen and (max-width: 1024px) {
  .downloads > div {
    flex-direction: column;
    gap: 0.5em;
  }
}

@media screen and (min-width: 1025px) {
  .downloads > div {
    flex-direction: row;
    gap: 1.5em;
  }
}
</style>
