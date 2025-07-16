<template>
  <section class="screenshots">
    <h2>Explore the world of WildLight</h2>
    <div class="diaporama">
      <!-- Desktop arrows -->
      <button
        class="arrow left desktop-only"
        @click="prevScreenshot"
        :aria-label="'Previous screenshot'"
      >
        <ArrowLeft />
      </button>
      <transition name="fade" mode="out-in">
        <img
          :src="screenshots[current]"
          :key="screenshots[current]"
          alt="WildLight screenshot"
          class="screenshot-img"
        />
      </transition>
      <button
        class="arrow right desktop-only"
        @click="nextScreenshot"
        :aria-label="'Next screenshot'"
      >
        <ArrowRight />
      </button>
    </div>

    <!-- Dots under image (desktop only) -->
    <div class="dots desktop-only">
      <span
        v-for="(img, idx) in screenshots"
        :key="img"
        :class="{ active: idx === current }"
        @click="goTo(idx)"
      ></span>
    </div>

    <!-- Mobile arrows + dots in one row -->
    <div class="mobile-dots-nav mobile-only">
      <button class="arrow left" @click="prevScreenshot" :aria-label="'Previous screenshot'">
        <ArrowLeft />
      </button>
      <div class="dots">
        <span
          v-for="(img, idx) in screenshots"
          :key="img"
          :class="{ active: idx === current }"
          @click="goTo(idx)"
        ></span>
      </div>
      <button class="arrow right" @click="nextScreenshot" :aria-label="'Next screenshot'">
        <ArrowRight />
      </button>
    </div>
  </section>
</template>

<script setup>
import { ref } from 'vue'
import ArrowLeft from './icons/arrow-left.vue'
import ArrowRight from './icons/arrow-right.vue'

const screenshots = [
  new URL('../assets/images/screenshots/Night.png', import.meta.url).href,
  new URL('../assets/images/screenshots/Underwater.png', import.meta.url).href,
  new URL('../assets/images/screenshots/Survival.png', import.meta.url).href,
  new URL('../assets/images/screenshots/Bliss.png', import.meta.url).href,
  new URL('../assets/images/screenshots/Complementary Shaders - Unbound.png', import.meta.url).href,
  new URL('../assets/images/screenshots/Makeup - Ultra Fast.png', import.meta.url).href,
]

const current = ref(0)

function prevScreenshot() {
  current.value = (current.value - 1 + screenshots.length) % screenshots.length
}

function nextScreenshot() {
  current.value = (current.value + 1) % screenshots.length
}

function goTo(idx) {
  current.value = idx
}
</script>

<style scoped>
h2 {
  text-align: center;
}

.screenshots {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.diaporama {
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  min-height: 320px;
  min-width: 320px;
  width: 100%;
  box-sizing: content-box;
}

.screenshot-img {
  max-width: 480px;
  max-height: 320px;
  width: 100%;
  height: 280px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  object-fit: cover;
  background: #222;
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 50px;
}

.arrow {
  background: #ffffff80;
  border: none;
  border-radius: 50%;
  width: 2em;
  height: 2em;
  font-size: 2em;
  color: #222;
  cursor: pointer;
  margin: 0 1em;
  transition: all 0.3s;
  z-index: 2;
}

.arrow:hover {
  background-color: var(--color-text);
  filter: drop-shadow(0 0 5px #f5d06f80);
}

.arrow svg {
  margin-top: 5px;
}

.dots {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 0.5em;
}

.dots span {
  display: inline-block;
  width: 0.8em;
  height: 0.8em;
  border-radius: 50%;
  background: #ffffff80;
  cursor: pointer;
  transition: all 0.5s;
}

.dots span.active {
  background: var(--color-text);
  filter: drop-shadow(0 0 5px #f5d06f80);
}

.dots span:hover {
  background: var(--color-text);
  filter: drop-shadow(0 0 5px #f5d06f80);
}

/* Smooth fade transition */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.4s cubic-bezier(0.4, 0, 0.2, 1);
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

/* Desktop only / Mobile only helpers */
.desktop-only {
  display: inline-block;
}

.dots.desktop-only {
  display: flex;
}

.mobile-only {
  display: none;
}

/* Mobile adaptation */
@media screen and (max-width: 1024px) {
  .diaporama {
    min-width: 45vw;
    min-height: 45vw;
    width: 100%;
    flex-direction: column;
    border: 1px solid rgba(255, 255, 255, 0.1);
    border-radius: 25px;
  }

  .screenshot-img {
    max-width: 98vw;
    max-height: 45vw;
    width: 100%;
    height: auto;
    border: none;
    border-radius: 25px;
  }

  .arrow {
    width: 2em;
    height: 2em;
    font-size: 1.5em;
    margin: 0 0.5em;
  }

  .desktop-only {
    display: none !important;
  }

  .mobile-only {
    display: flex !important;
    justify-content: center;
    gap: 1.5em;
    margin-top: 1em;
    width: 100%;
  }

  .mobile-arrows {
    width: 100%;
  }

  .mobile-dots-nav {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 1.5em;
    width: 100%;
  }
}
</style>
