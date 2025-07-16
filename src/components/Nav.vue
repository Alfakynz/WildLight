<template>
  <nav>
    <ul>
      <li>
        <router-link to="/">
          <div class="wildlight">WildLight</div>
        </router-link>
      </li>
      <li>
        <router-link to="/wiki">
          <div>Wiki</div>
          <img src="/src/assets/images/icons/wiki.png" alt="Wiki" />
        </router-link>
      </li>
      <li>
        <a href="https://modrinth.com/project/6QzexKXD" target="_blank">
          <div>Modrinth</div>
          <img src="/src/assets/images/icons/modrinth.png" alt="Modrinth" />
        </a>
      </li>
      <li>
        <a href="https://www.curseforge.com/minecraft/modpacks/wildlight" target="_blank">
          <div>CurseForge</div>
          <img src="/src/assets/images/icons/curseforge.png" alt="CurseForge" />
        </a>
      </li>
      <li>
        <a href="https://github.com/Alfakynz/WildLight" target="_blank">
          <div>GitHub</div>
          <img src="/src/assets/images/icons/github.png" alt="GitHub" />
        </a>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
@media screen and (max-width: 1024px) {
  nav {
    padding: 1rem;
  }

  nav div {
    display: none;
  }

  nav img {
    display: inline-block;
    width: 25px;
    height: 25px;
    vertical-align: middle;
  }

  nav ul li {
    margin: 0 0.35rem;
  }

  .wildlight {
    display: block;
    padding: 0.25rem;
  }
}

@media screen and (min-width: 1025px) {
  nav {
    padding: 2rem 5rem;
  }

  nav img {
    display: none;
  }

  nav ul li {
    margin: 0 1rem;
  }
}

nav {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  box-sizing: border-box;
  z-index: 1000;
  display: flex;
  justify-content: center;
  align-items: center;
}

nav ul {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  margin: 0;
  padding: 0.5rem 0;
  background: #1e1e1e80;
  box-shadow: 0 0 10px #00000080;
  backdrop-filter: blur(5px);
  border: 1px solid rgba(255, 255, 255, 0.1);
  border-radius: 25px;
  list-style: none;
}

nav div {
  font-family: 'Cinzel', serif;
  font-size: 1.15rem;
  padding: 0.5rem 1rem;
  border-radius: 25px;
  transition: all 0.3s;
}

nav img {
  padding: 0.5rem;
  border-radius: 25px;
  filter: drop-shadow(0 0 5px #f5d06f80);
  transition: all 0.3s;
}

nav div:hover,
nav img:hover {
  background: #f5d06f20;
}

nav div:hover {
  filter: drop-shadow(0 0 15px #f5d06f);
}

nav img:hover {
  filter: drop-shadow(0 0 15px #f5d06f);
}
</style>
