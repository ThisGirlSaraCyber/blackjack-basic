<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Vue Env.</router-link>|
      <router-link to="/about">Blackjack - Basic Strategy Rules</router-link>|
      <router-link to="/blackjack-basic">The Blackjack - Basic Strategy Game</router-link>
    </div>
    <router-view />
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
