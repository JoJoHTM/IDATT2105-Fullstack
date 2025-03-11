<script setup>
  import ResultItem from './ResultItem.vue';
  import Buttons from './Buttons.vue';
  import History from './History.vue';
  import RouterButtons from './RouterButtons.vue';

</script>

<template>
  <RouterButtons />
  <div id="frame">
    <div id="calculatorFrame">
      <ResultItem />
      <Buttons />
    </div>
    <History />
  </div>
</template>

