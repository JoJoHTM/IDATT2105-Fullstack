<script setup>
  import ResultItem from './ResultItem.vue';
  import Buttons from './Buttons.vue';
  import History from './History.vue';

  import { ref, provide } from 'vue';
  const currentValue = ref("0");
  const totalValue = ref("0");
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

