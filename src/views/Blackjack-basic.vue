<template>
  <div class="blackjack-basic">
    <button @click="refresh">Try Again</button>
    <Game />
  </div>
</template>

<script>
// @ is an alias to /src
import Game from "@/components/Game.vue";

export default {
  name: "Blackjack-basic",
  components: {
    Game
  },
  methods: {
    refresh() {
      location.reload();
    }
  }
};
</script>

<style lang="scss" scoped>
button {
  font-size: 1.5rem;
  font-weight: bold;
  width: 250px;
  height: 45px;
  color: white;
  background: #1cd698;
  border-radius: 15px;
}
</style>