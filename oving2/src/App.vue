<script setup>
  import ResultItem from './components/ResultItem.vue';
  import Buttons from './components/Buttons.vue';

  import { ref, provide } from 'vue';
  const currentValue = ref(0);
  const totalValue = ref(0);
  provide('currentValue', currentValue);
  provide('totalValue', totalValue);
</script>

<template>
  <div id="frame">
    <ResultItem />
    <Buttons />
  </div>
</template>

