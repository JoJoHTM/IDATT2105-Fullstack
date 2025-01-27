<template>
    <h1>Feedback</h1>
        <form action="/">
            <label for="navn">Navn:</label>
            <input type="text" placeholder="navn" name="navn" id="navn"></input>
            <label for="email">E-post:</label>
            <input type="email" placeholder="email" id="email" name="email"></input>
            <label for="tilbakemelding">Tilbakemelding:</label>
            <input type="text" placeholder="skriv din tilbakemelding her" name="tilbakemelding" id="tilbakemelding"></input>
            <input type="submit" value="Send" id="submit"></input>
        </form>
</template>

<style scoped>
form {
    display: grid;
    grid-template-columns: auto auto;
    width: 50%;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid black;
    border-radius: 5px;
}

#submit {
    grid-column: 1 / span 2;
    margin-top: 10px;
    width: fit-content;
}
</style>