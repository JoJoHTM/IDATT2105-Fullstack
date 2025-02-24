<script setup>
    import { ref } from 'vue';
    import store from '../store.js';
    import { useRow } from './History.vue';
import axios from 'axios';
    const prevAnswer = ref("0");
    const paranthesis = ref(false);

    const { addRow } = useRow();
    const { state } = store;

    function changeCurrentValue(event) {
        if (state.calculatorData.currentValue == "0") {
            if (event.target.value != ",") {
                state.calculatorData.currentValue = event.target.value;
            }
        } else {
            if (event.target.value == ",") {
                if (!state.calculatorData.currentValue.includes(",")) {
                    state.calculatorData.currentValue += event.target.value;
                }
            }
            else {
                state.calculatorData.currentValue += event.target.value;
            }
        }
    }

    function setParanthesis() {
        if (state.calculatorDatacurrentValue != "0") {
            state.calculatorData.operations.push(state.calculatorData.currentValue);
            state.calculatorData.currentValue = "0";
        }
        if (paranthesis.value == false) {
            state.calculatorData.operations.push("(")
            paranthesis.value = true;
        } 
        else {
            state.calculatorData.operations.push(")")
            paranthesis.value = false;
        }
    }

    function deleteLast() {
        if (state.calculatorData.currentValue.length != 1 && state.calculatorData.currentValue != "0") {
            state.calculatorData.currentValue = state.calculatorData.currentValue.slice(0, -1)
        } else if (state.calculatorData.currentValue.length == 1 && state.calculatorData.currentValue != "0") {
            state.calculatorData.currentValue = "0";
        }
    }

    function clear() {
        state.calculatorData.currentValue = "0";
    }

    function addOperation(operation) {
        if (state.calculatorData.currentValue != "0") {
            state.calculatorData.operations.push(state.calculatorData.currentValue);
            state.calculatorData.currentValue = "0";
        }
        state.calculatorData.operations.push(operation);
    }

    function answer() {
        state.calculatorData.currentValue = prevAnswer.value.toString();
    }

    function equals() {
        if (state.calculatorData.operations[state.calculatorData.operations.length - 1] == ')' && state.calculatorData.currentValue == "0") {
            
        }
        else {
            console.log(state.calculatorData.operations[state.calculatorData.operations.length - 1]);
            state.calculatorData.operations.push(state.calculatorData.currentValue);
        }

        try {
            axios.post("http://localhost:8080/", state.calculatorData.operations)
                .then(response => {
                    state.calculatorData.totalValue = response.data;
                    addRow();
                    state.calculatorData.operations.length = 0;
                    state.calculatorData.currentValue = state.calculatorData.totalValue;
                    prevAnswer.value = state.calculatorData.totalValue;
                });
            } catch (error) {
                console.error(error);
            }   
    }
</script>


<template>
    <button id="clear" @click="clear">C</button>
    <button id="answer" @click="answer">ANS</button>
    <button id="delete" @click="deleteLast">DEL</button>
    <button id="plus" @click="() => addOperation('+')">+</button>
    <button class="number" value="1" @click="changeCurrentValue">1</button>
    <button class="number" value="2" @click="changeCurrentValue">2</button>
    <button class="number" value="3" @click="changeCurrentValue">3</button>
    <button id="minus" @click="addOperation('-')">-</button>
    <button class="number" value="4" @click="changeCurrentValue">4</button>
    <button class="number" value="5" @click="changeCurrentValue">5</button>
    <button class="number" value="6" @click="changeCurrentValue">6</button>
    <button id="multiply" @click="addOperation('*')">*</button>
    <button class="number" value="7" @click="changeCurrentValue">7</button>
    <button class="number" value="8" @click="changeCurrentValue">8</button>
    <button class="number" value="9" @click="changeCurrentValue">9</button>
    <button id="divide" @click="addOperation('/')">/</button>
    <button id="paranthesis" @click="setParanthesis()">( )</button>
    <button class="number" value="0" @click="changeCurrentValue">0</button>
    <button id="comma" value="," @click="changeCurrentValue">,</button>
    <button id="equals" @click="equals">=</button>
</template>
