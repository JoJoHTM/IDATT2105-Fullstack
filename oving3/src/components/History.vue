<script>
    import store from '../store.js';
    import { watch } from 'vue';
    const { state } = store;

    watch((state.calculatorData.totalValue), async () => {
        addRow();
    })

    export function useRow() {

        function addRow() {
            let history = document.getElementById('history');
            let row = document.createElement('li');
            row.className = 'row';
            let result = state.calculatorData.totalValue;   
            row.innerHTML = state.calculatorData.operations.join('') + ' = ' + (result == "Infinity" ? 'Udefinert' : result);
            history.appendChild(row);
        }
        return { addRow };
    }


</script>


<template>
    <div id="history">
        <h3 >Logg</h3>
    </div>
</template>

<style scoped>
h3 {
    text-align:center;
    height: fit-content;
}
</style>