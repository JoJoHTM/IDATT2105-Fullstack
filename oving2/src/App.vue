<script setup>
  import ResultItem from './components/ResultItem.vue';
  import Buttons from './components/Buttons.vue';
  import History from './components/History.vue';

  import { ref, provide } from 'vue';
  const currentValue = ref(0);
  const totalValue = ref(0);
  const operations = ref([]);
  provide('currentValue', currentValue);
  provide('totalValue', totalValue);
  provide('operations', operations);
</script>

<template>
  <div id="frame">
    <div id="calculatorFrame">
      <ResultItem />
      <Buttons />
    </div>
    <History />
  </div>
</template>

