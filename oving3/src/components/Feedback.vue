<template>
    <h1>Feedback</h1>
        <form @submit.prevent="sendFeedback">
            <label for="navn">Navn:</label>
            <input type="text" placeholder="navn" name="navn" id="navn"></input>
            <label for="email">E-post:</label>
            <input type="email" placeholder="email" id="email" name="email"></input>
            <label for="tilbakemelding" id="tilbakemeldingtekst">Tilbakemelding:</label>
            <textarea placeholder="skriv din tilbakemelding her" name="tilbakemelding" id="tilbakemelding"></textarea>
            <input type="submit" value="Send" id="submit"></input>
        </form>
</template>

<style scoped>
form {
    display: grid;
    grid-template-areas: 
        'navnlabel navn navn'
        'emaillabel email email'
        'tilbakemeldinglabel tilbakemelding tilbakemelding'
        'send send send';

    grid-template-columns: auto auto;
    width: 40%;
    height: 60vh;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid black;
    border-radius: 5px;
}

label {
    font-size: 19px;
}

#navn:focus,
#email:focus {
    outline: none;
    border-bottom: 2px solid black;
}

#navn {
    grid-area: navn;
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

#tilbakemelding {
    grid-area: tilbakemelding;
    resize: none;
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