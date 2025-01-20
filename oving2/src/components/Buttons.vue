<script setup>
    import { inject, ref } from 'vue';
    const currentValue = inject('currentValue');
    const totalValue = inject('totalValue');
    const operations = [];
    const prevAnswer = ref(0);

    function changeCurrentValue(event) {
        if (currentValue.value == 0) {
            if (event.target.value != ",") {
                currentValue.value = event.target.value;
            }
        } else {
            if (event.target.value == ",") {
                if (!currentValue.value.includes(",")) {
                    currentValue.value += event.target.value;
                }
            }
            else {
                currentValue.value += event.target.value;
            }
        }
    }

    function deleteLast() {
        if (currentValue.value.length != 1 && currentValue.value != 0) {
            currentValue.value = currentValue.value.slice(0, -1);
        } else if (currentValue.value.length == 1 && currentValue.value != 0) {
            currentValue.value = 0;
        }
    }

    function clear() {
        currentValue.value = 0;
    }

    function addOperation(operation) {
        operations.push(currentValue.value);
        operations.push(operation);
        currentValue.value = 0;
    }

    function answer() {
        currentValue.value = prevAnswer.value;
    }

    function equals() {
        operations.push(currentValue.value);
        totalValue.value = eval(operations.join(''));
        operations.length = 0;
        currentValue.value = totalValue.value;
        prevAnswer.value = totalValue.value;
    }
</script>


<template>
    <button id="clear" @click="clear">C</button>
    <button id="answer" @click="answer">ANS</button>
    <button id="delete" @click="deleteLast">DEL</button>
    <button id="plus" @click="addOperation('+')">+</button>
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
    <button></button>
    <button class="number" value="0" @click="changeCurrentValue">0</button>
    <button id="comma" value="," @click="changeCurrentValue">,</button>
    <button id="equals" @click="equals">=</button>
</template>

