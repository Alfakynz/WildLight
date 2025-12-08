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
        <router-link to="/wiki/versions" active-class="active">Versions</router-link>
      </li>
      <li>
        <router-link to="/wiki/config" active-class="active">Configurations</router-link>
      </li>
      <li>
        <router-link to="/wiki/credits" active-class="active">Credits</router-link>
      </li>
      <li>
        <router-link to="/wiki/tools" active-class="active">Tools</router-link>
      </li>
      <li>
        <router-link to="/wiki/mods-compat" active-class="active">Compat with mods</router-link>
      </li>
      <li>
        <router-link to="/wiki/rp-compat" active-class="active"
          >Compat with resource packs</router-link
        >
      </li>
    </ul>
  </nav>
</template>

<style scoped>
nav {
  position: sticky;
  top: 9rem;
  min-width: 220px;
  max-width: 300px;
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
  gap: 0.5rem;
}

nav li {
  padding: 0;
}

nav li a {
  font-family: 'Cinzel', serif;
  font-size: 1.1rem;
  letter-spacing: 1px;
  display: block;
  width: 100%;
  height: 100%;
  padding: 0.5rem 1rem;
  border-radius: 25px;
  text-decoration: none;
  box-sizing: border-box;
  transition: all 0.3s;
}

nav li a:hover {
  background: #f5d06f20;
  filter: drop-shadow(0 0 15px #f5d06f);
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
