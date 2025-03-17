<script>
    import { onMounted } from 'vue';
    import store from '../store.js';
    import axios from 'axios';
    const { state } = store;

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

    function getLogs() {
        console.log("giggidy giggidy goo");
        axios.post("http://localhost:8080/getLogs", { id: state.loginData.loginID })
            .then(response => {
                let history = document.getElementById('history');
                response.data.forEach(log => {
                    let row = document.createElement('li');
                    row.className = 'row';
                    row.innerHTML = log;
                    history.appendChild(row);
                });
            });
    }

    export default {
        setup() {
            onMounted(() => {
                getLogs();
            });
        }
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