<template>
  <div class="player">
    <div class="flex">
      <card v-for="(card, index) in hand" :key="index" :suit="card.suit" :number="card.number" :hide="card.hide"></card>
    </div>
    <div class="flex" v-show="showButtons">
      <button @click="hit">Hit</button>
      <button @click="stand">Stand</button>
    </div>
  </div>
</template>

<script>

import pick from '../utils/deck'
import calc from '../utils/calc'
import Card from './Card'

export default {
  name: 'player',
  components: { Card },
  props: ['showButtons'],
  data () {
    return {
      hand: [],
      result: 0,
    }
  },
  created: function () {
    this.hand.push(pick());
    this.hand.push(pick());
    this.result = calc(this.hand);
  },
  methods: {
    hit () {
      this.hand.push(pick());
      this.result = calc(this.hand);
    },
    stand () {
      this.$emit('stand', this.result)
    }
  },
  watch: {
    result: function (newValue) {
      if (newValue === 'Bust') {
        this.$emit('stand', newValue)
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.flex {
  display: flex;
  justify-content: center;
}

button {
  font-size: 1.5rem;
  font-weight: bold;
  width: 250px;
  height: 45px;
  color: white;
  background: #d8623f;
  border-radius: 15px;
}
</style>
