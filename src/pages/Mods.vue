<script setup lang="ts">
import { ref, onMounted } from 'vue'
import WikiNav from '../components/WikiNav.vue'

onMounted(() => {
  const nav = document.querySelector('nav')
  const main = document.querySelector('main')
  if (nav && main) {
    main.style.paddingTop = nav.offsetHeight + 'px'
  }
})

type Item = { name: string; url: string }

const mods = ref<Item[]>([])
const resourcePacks = ref<Item[]>([])
const shaders = ref<Item[]>([])
const loading = ref<boolean>(true)
const error = ref<string | null>(null)

function parseSection(lines: string[], sectionTitle: string): { name: string; url: string }[] {
  const result: { name: string; url: string }[] = []
  let inSection = false
  for (const line of lines) {
    if (line.trim().toLowerCase() === sectionTitle.toLowerCase()) {
      inSection = true
      continue
    }
    if (inSection) {
      if (line.startsWith('## ')) break
      const match = line.match(/^- \[(.+?)\]\((.+?)\)/)
      if (match) {
        result.push({ name: match[1], url: match[2] })
      }
    }
  }
  return result
}

function smoothScrollTo(id: string) {
  const element = document.getElementById(id)
  if (element) {
    element.scrollIntoView({ behavior: 'smooth', block: 'center' })
  }
}

onMounted(async () => {
  loading.value = true
  error.value = null
  try {
    const res = await fetch(
      'https://raw.githubusercontent.com/Alfakynz/WildLight/refs/heads/main/1.21.1/PACK_CONTENT.md',
    )
    if (!res.ok) throw new Error('Failed to fetch mod list')
    const text = await res.text()
    const lines = text.split('\n')
    mods.value = parseSection(lines, '## Mods used')
    resourcePacks.value = parseSection(lines, '## Resource packs used')
    shaders.value = parseSection(lines, '## Shader packs used')
  } catch (e) {
    if (e instanceof Error) {
      error.value = e.message
    } else {
      error.value = String(e)
    }
  } finally {
    loading.value = false
  }
})
</script>

<template>
  <main>
    <WikiNav />
    <section class="wiki-content">
      <h1>List of mods, Resource Packs and Shaders</h1>
      <p>
        This page lists all the mods, resource packs, and shaders used in WildLight.
        <br />
        Click on the links to view more details or download them.
      </p>
      <nav>
        <a href="#mods" @click.prevent="smoothScrollTo('mods')">Mods</a>
        <a href="#resource-packs" @click.prevent="smoothScrollTo('resource-packs')"
          >Resource Packs</a
        >
        <a href="#shaders" @click.prevent="smoothScrollTo('shaders')">Shaders</a>
      </nav>
      <div v-if="loading">Loading...</div>
      <div v-else-if="error">{{ error }}</div>
      <template v-else>
        <div class="mod-section">
          <h2 id="mods">Mods</h2>
          <ul>
            <li v-for="mod in mods" :key="mod.url">
              <a :href="mod.url" target="_blank" rel="noopener">{{ mod.name }}</a>
            </li>
          </ul>
        </div>
        <div class="mod-section">
          <h2 id="resource-packs">Resource Packs</h2>
          <ul>
            <li v-for="pack in resourcePacks" :key="pack.url">
              <a :href="pack.url" target="_blank" rel="noopener">{{ pack.name }}</a>
            </li>
          </ul>
        </div>
        <div class="mod-section">
          <h2 id="shaders">Shaders</h2>
          <ul>
            <li v-for="shader in shaders" :key="shader.url">
              <a :href="shader.url" target="_blank" rel="noopener">{{ shader.name }}</a>
            </li>
          </ul>
        </div>
      </template>
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

.wiki-content nav {
  margin-bottom: 1rem;
}

.wiki-content nav a {
  margin: 0 1rem;
}

.mod-section {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.mod-section ul {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-left: 0;
}

.mod-section ul li {
  list-style: none;
}
</style>
