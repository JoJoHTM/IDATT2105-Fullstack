<script setup>
    import { ref, inject } from 'vue';
    const currentValue = inject('currentValue');
    const totalValue = inject('totalValue');
</script>


<template>
    <div id="result">
        {{ currentValue == 0 ? ' ' : currentValue }}
    </div>
</template>