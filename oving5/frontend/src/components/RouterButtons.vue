<script setup>
import { RouterLink } from 'vue-router';

</script>

<template>
    <div>
        <RouterLink to="/calculator" style="border-right: 2px solid orange; margin-bottom: 20px;">
            <button>Kalkulator</button>
        </RouterLink>
        <RouterLink to="/feedback">
            <button>Tilbakemelding</button>
        </RouterLink>
    </div>
</template>


<style scoped>

    div {
        position: absolute;
        top: 0;
        right: 0;
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
    }

    .divider {
        width:0%;
    }

    a {
        text-decoration: none;
    }

    button {
        color: orange;
        margin: 10px;
        padding: 10px;
        font-size: 20px;
        background-color: #ffffff;
        border: none;
    }

    button:hover {
        cursor: pointer;
    }
</style>