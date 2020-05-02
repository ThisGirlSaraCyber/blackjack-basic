<template>
  <div class="game">
    <dealer ref="dealer" @result="postexec" />
    <div class="message">
      {{ mainMessage }}
    </div>
    <player @stand="stand" :showButtons="showButtons" />
    <div class="message result">
      {{ resultMessage }}
    </div>
  </div>
</template>

<script>

import Dealer from './Dealer'
import Player from './Player'

export default {
  name: "game",
  components: { Dealer, Player },
  data () {
    return {
      mainMessage: 'Welcome to a game of Blackjack-Basic Strategy',
      playersResult: 0,
      dealersResult: 0,
      showButtons: true,
    }
  },
  methods: {
    stand: function (playersResult) {
      this.playersResult = playersResult;
      this.$refs.dealer.$emit('postexec', playersResult === 'Bust')
    },
    postexec: function (dealersResult) {
      this.dealersResult = dealersResult
      this.showButtons = false
      this.mainMessage = `Dealer : ${dealersResult} / Player : ${this.playersResult}`
    },
  },
  computed: {
    resultMessage: function () {
      if (this.showButtons) {
        return ''
      }
      if (this.playersResult > this.dealersResult || this.dealersResult === 'Bust') {
        return 'YAY'
      }
      if (this.playersResult < this.dealersResult || this.playersResult === 'Bust') {
        return 'Try again'
      }
      return 'Draw'
    }
  }
}
</script>

<style lang="scss" scoped>
.game {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  min-height: 70vh;
}

.message {
  font-size: 1.5rem;
  font-weight: bold;
  margin: 2rem;
}

.result {
  font-size: 3rem;
  color: yellowgreen;
}
</style>
