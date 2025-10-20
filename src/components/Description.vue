<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { marked } from 'marked'

const featuresHtml = ref<string>('Loading features...')

async function fetchFeatures() {
  try {
    const response = await fetch(
      'https://raw.githubusercontent.com/Alfakynz/WildLight/refs/heads/main/README.md',
    )
    const text = await response.text()

    // Regex plus robuste : tolère espaces, emojis et variations du titre
    const match = text.match(/##\s*✨?\s*Features[\s\S]*?(?=^##\s|\Z)/m)

    if (match && match[0]) {
      const markdownContent = match[0]
        .replace(/^##\s*✨?\s*Features/, '## ✨ Features') // garde un titre propre
        .trim()

      // Utilise marked.parseAsync pour Vue 3 (et éviter les problèmes d’attente)
      const parsed = await marked.parse(markdownContent)
      featuresHtml.value = parsed
    } else {
      console.warn('Features section not found.')
      featuresHtml.value = 'Features section not found.'
    }
  } catch (error) {
    console.error('Error fetching README:', error)
    featuresHtml.value = 'Failed to load features.'
  }
}

onMounted(fetchFeatures)
</script>

<template>
  <section class="description">
    <div v-html="featuresHtml" class="features"></div>
  </section>
</template>
