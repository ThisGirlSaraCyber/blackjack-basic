<template>
  <div class="about">
    <img :src="image">
  </div>
</template>

<script>
export default {
  name: 'about',
  props: {
    number: Number,
  },
  computed: {
    image: function () {
      return require(`../assets/BJA_Basic_Strategy.jpg`)
    }
  }
}
</script>
