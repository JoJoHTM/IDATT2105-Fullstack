<script>
    import { inject } from 'vue';

    export function useRow() {
        const operations = inject('operations');

        function addRow() {
            let history = document.getElementById('history');
            let row = document.createElement('li');
            row.className = 'row';
            row.innerHTML = operations.value.join('') + ' = ' + eval(operations.value.join(''));
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