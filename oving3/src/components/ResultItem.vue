<script setup>
    import { ref, inject } from 'vue';
    const currentValue = inject('currentValue');
</script>


<template>
    <div id="result">
        {{ currentValue == "Infinity" ? 'Kan ikke dele på null' : currentValue }}
    </div>
</template>