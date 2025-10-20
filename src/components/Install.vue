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
      <h1>How to install WildLight</h1>
      <p>
        You can install the WildLight modpack using either <strong>Modrinth</strong> or
        <strong>CurseForge</strong>. Both methods are easy and safe!
      </p>
      <ol>
        <li>
          <strong>Modrinth (recommended):</strong>
          <ul>
            <li>
              Go to the
              <a href="https://modrinth.com/project/6QzexKXD" target="_blank" rel="noopener"
                >WildLight Modrinth page</a
              >.
            </li>
            <li>
              Click the <strong>Install with Modrinth App</strong> button, or download the
              <strong>modpack file</strong> for your preferred launcher (Modrinth App, Prism,
              MultiMC, etc.).
            </li>
            <li>
              If using the Modrinth App, simply click "Install" and follow the prompts.<br />
              If using another launcher, import the downloaded <code>.mrpack</code> file into your
              launcher.
            </li>
            <li>Launch the modpack and enjoy!</li>
          </ul>
        </li>
        <li>
          <strong>CurseForge:</strong>
          <ul>
            <li>
              Go to the
              <a
                href="https://www.curseforge.com/minecraft/modpacks/wildlight"
                target="_blank"
                rel="noopener"
                >WildLight CurseForge page</a
              >.
            </li>
            <li>
              Click the <strong>Install</strong> button to open the modpack in the CurseForge app,
              or download the <strong>modpack zip</strong> for manual installation.
            </li>
            <li>
              If using the CurseForge app, just click "Install" and wait for the process to
              finish.<br />
              For manual installation, import the zip file into your preferred launcher.
            </li>
            <li>Start Minecraft and select the WildLight profile to play.</li>
          </ul>
        </li>
      </ol>
      <p>
        <strong>Need help?</strong> If you have trouble installing, check the documentation on
        Modrinth/CurseForge or ask for help on the
        <a href="https://discord.gg/TcmUQHZ5U4" target="_blank" rel="noopener"
          >WildLight Discord server</a
        >.
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
