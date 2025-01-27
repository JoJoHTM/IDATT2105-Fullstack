<script setup>
    import { inject, ref } from 'vue';
    import { useRow } from './History.vue';
    
    const { addRow } = useRow();
    const currentValue = inject('currentValue');
    const totalValue = inject('totalValue');
    const operations = inject('operations');
    const prevAnswer = ref("0");
    const paranthesis = ref(false);

    function changeCurrentValue(event) {
        if (currentValue.value == "0") {
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

    function setParanthesis() {
        if (currentValue.value != "0") {
            operations.value.push(currentValue.value);
            currentValue.value = "0";
        }
        if (paranthesis.value == false) {
            operations.value.push("(")
            paranthesis.value = true;
        } 
        else {
            operations.value.push(")")
            paranthesis.value = false;
        }
    }

    function deleteLast() {
        if (currentValue.value.length != 1 && currentValue.value != "0") {
            currentValue.value = currentValue.value.slice(0, -1)
        } else if (currentValue.value.length == 1 && currentValue.value != "0") {
            currentValue.value = "0";
        }
    }

    function clear() {
        currentValue.value = "0";
    }

    function addOperation(operation) {
        if (currentValue.value != "0") {
            operations.value.push(currentValue.value);
            currentValue.value = "0";
        }
        operations.value.push(operation);
    }

    function answer() {
        currentValue.value = prevAnswer.value.toString();
    }

    function equals() {
        if (operations.value[operations.value.length - 1] == ')' && currentValue.value == "0") {
            
        }
        else {
            console.log(operations.value[operations.value.length - 1]);
            operations.value.push(currentValue.value);
        }

        try {
            totalValue.value = eval(operations.value.join('')).toString();
            console.log(operations.value);
            addRow();
            operations.value.length = 0;
            currentValue.value = totalValue.value;
            prevAnswer.value = totalValue.value;
        } catch (error) {
            console.error("Error evaluating expression:", error);
            totalValue.value = "Error";
            currentValue.value = totalValue.value;
            operations.value.length = 0;
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
