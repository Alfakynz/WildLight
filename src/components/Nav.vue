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
          <img src="/src/assets/images/wiki.png" alt="Wiki" />
        </router-link>
      </li>
      <li>
        <a href="https://modrinth.com/project/6QzexKXD">
          <div>Modrinth</div>
          <img src="/src/assets/images/modrinth.png" alt="Modrinth" />
        </a>
      </li>
      <li>
        <a href="https://www.curseforge.com/minecraft/modpacks/wildlight">
          <div>CurseForge</div>
          <img src="/src/assets/images/curseforge.png" alt="CurseForge" />
        </a>
      </li>
      <li>
        <a href="https://github.com/Alfakynz/WildLight">
          <div>GitHub</div>
          <img src="/src/assets/images/github.png" alt="GitHub" />
        </a>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
@media screen and (max-width: 768px) {
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

@media screen and (min-width: 769px) {
  nav img {
    display: none;
  }

  nav ul li {
    margin: 0 1rem;
  }
}
</style>
