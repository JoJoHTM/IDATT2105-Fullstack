<script setup>
    import { ref, inject } from 'vue';
    const currentValue = inject('currentValue');
    const totalValue = inject('totalValue');
</script>


<template>
    <div id="result">
        {{ currentValue }}
    </div>
</template>