// TODO statemanagement

<script setup>
import store from '../store.js';

const { state, disableSubmit } = store;
</script>

<template>
    <h1 style="text-align: center;">Feedback</h1>
        <form>
            <label for="name">Navn:</label>
            <input type="text" placeholder="name" name="name" id="name" v-model="state.feedbackData.name"></input>
            <label for="email">E-post:</label>
            <input type="email" placeholder="email" id="email" name="email" v-model="state.feedbackData.email"></input>
            <label for="feedback" id="feedbacktekst">Tilbakemelding:</label>
            <textarea placeholder="skriv din tilbakemelding her" name="feedback" id="feedback" v-model="state.feedbackData.feedback"></textarea>
            <input type="submit" value="Send" id="submit" :disabled="disableSubmit"></input>
        </form>
</template>

<style scoped>
form {
    display: grid;
    grid-template-areas: 
        'namelabel name name'
        'emaillabel email email'
        'feedbacklabel feedback feedback'
        'send send send';

    grid-template-columns: auto auto;
    width: 30vw;
    height: 60vh;
    min-width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid black;
    border-radius: 5px;
}

label {
    font-size: 19px;
}

#name:focus,
#email:focus {
    outline: none;
    border-bottom: 2px solid black;
}

#name {
    grid-area: name;
    height: fit-content;
    border: none;
    border-bottom: 2px solid gray;
}

#email {
    grid-area: email;
    height: fit-content;
    border: none;
    border-bottom: 2px solid gray;
}

#feedback {
    grid-area: feedback;
    resize: none;
    border: 2px solid gray;
}

#submit {
    grid-area: send;
    width: 100px;
    height: 30px;
    border-radius: 15px;
    justify-self: center;
    align-self: center;
}
</style>