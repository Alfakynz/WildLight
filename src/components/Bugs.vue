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
      <h1>How to report a bug or suggest an idea</h1>
      <p>
        If you encounter a bug in WildLight or have an idea to suggest, please help me by letting me
        know! You can use either of the following methods:
      </p>
      <ol>
        <li>
          <strong>
            Open an issue on
            <a href="https://github.com/Alfakynz/wildlight/issues" target="_blank" rel="noopener"
              >GitHub</a
            >:
          </strong>
          <ul>
            <li>
              Go to my
              <a href="https://github.com/Alfakynz/wildlight/issues" target="_blank" rel="noopener"
                >GitHub Issues page</a
              >.
            </li>
            <li>
              Click on <strong>New issue</strong> and fill out the template with as much detail as
              possible (for bugs: steps to reproduce, expected behavior, screenshots, etc.; for
              ideas: describe your suggestion and why you think it would help).
            </li>
            <li>Submit the issue. I track and respond to bugs and ideas here regularly.</li>
          </ul>
        </li>
        <li>
          <strong
            >Post a bug or idea on my
            <a href="https://discord.gg/TcmUQHZ5U4" target="_blank" rel="noopener">Discord server</a
            >:</strong
          >
          <ul>
            <li>
              Join the
              <a href="https://discord.gg/TcmUQHZ5U4" target="_blank" rel="noopener"
                >WildLight Discord</a
              >.
            </li>
            <li>
              For bugs, post in the <strong>#bugs</strong> channel.<br />
              For ideas or suggestions, post in the <strong>#suggestions-and-ideas</strong> channel.
            </li>
            <li>
              Describe your bug or idea clearly, including steps to reproduce and any relevant
              screenshots or logs for bugs, or details and reasoning for ideas.
            </li>
          </ul>
        </li>
      </ol>
      <p>Thank you for helping me improve WildLight!</p>
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
