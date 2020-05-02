<template>
  <div class="blackjack-basic">
    <Game msg="Welcome to Your Game"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Game from '@/components/Game.vue'

export default {
  name: 'Blackjack-basic',
  components: {
    Game
  }
}
</script>