<script setup>
    import store from '../store.js';

    const { state } = store;
</script>


<template>
    <div id="result">
        {{ state.calculatorData.currentValue == "Infinity" ? 'Kan ikke dele på null' : state.calculatorData.currentValue }}
    </div>
</template>