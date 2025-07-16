<template>
  <nav class="wiki-nav">
    <ul>
      <li>
        <router-link to="/wiki/install" active-class="active">How to install</router-link>
      </li>
      <li>
        <router-link to="/wiki/mods" active-class="active"
          >List of mods, rp and shaders</router-link
        >
      </li>
      <li>
        <router-link to="/wiki/bugs" active-class="active"
          >Report a bug or suggest an idea</router-link
        >
      </li>
      <li>
        <router-link to="/wiki/config" active-class="active">Minecraft configuration</router-link>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
nav {
  position: sticky;
  top: 8rem;
  min-width: 220px;
  max-width: 260px;
  background: rgba(30, 30, 30, 0.25);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 25px;
  padding: 1.5rem;
  box-sizing: border-box;
  backdrop-filter: blur(4px);
}

nav ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

nav a {
  font-family: 'Cinzel', serif;
  font-size: 1.1rem;
  letter-spacing: 1px;
}

.active {
  font-weight: bold;
  text-shadow: 0 0 10px #f5d06f80;
}

@media screen and (max-width: 1024px) {
  .wiki-nav {
    position: static;
    width: 100%;
    max-width: none;
    min-width: 0;
    padding: 1rem;
  }
}
</style>
