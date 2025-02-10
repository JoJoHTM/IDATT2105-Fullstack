<script setup>
import { ref } from 'vue';
import RouterButtons from './RouterButtons.vue';
import store from '../store.js';
import json from '../assets/formSubmission.json';

const { state, disableSubmit } = store;

function showPopup() {
    const popup = document.getElementById('popup');
    popup.showModal();
}

const submitForm = async (event) => {
    event.preventDefault();
    showPopup();
}

function closePopUp() {
    const popup = document.getElementById('popup');
    popup.close();
}
</script>

<template>
    <h1 style="text-align: center;">Tilbakemelding</h1>
    <RouterButtons />
    <dialog id="popup">
        <h2>Takk for tilbakemeldingen!</h2>
        <button @click="closePopUp" id="closeButton">X</button>
    </dialog>
    <form @submit="submitForm">
        <label for="name">Navn:</label>
        <input type="text" placeholder="Navn" id="name" v-model="state.feedbackData.name" required></input>
        <label for="email">E-post:</label>
        <input type="email" placeholder="Email" id="email" v-model="state.feedbackData.email" required></input>
        <label for="feedback" id="feedbacktekst">Tilbakemelding:</label>
        <textarea placeholder="Skriv din tilbakemelding her" id="feedback" v-model="state.feedbackData.feedback" required></textarea>
        <input type="submit" value="Send" id="submit" :disabled="disableSubmit"</input>
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

#closeButton {
    position: absolute;
    top: 0;
    right: 0;
    background-color: red;
    border: none;
    font-size: 20px;
    cursor: pointer;
}

</style>