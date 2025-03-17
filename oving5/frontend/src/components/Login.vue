<script setup>
    import store from '../store.js';
    import axios from 'axios';
    import routes from '../router/index.js';
    const loginData = store.state.loginData;
    const registerData = store.state.registerData;

    function registerPopup() {
        const popup = document.getElementById('popup');
        popup.showModal();
    }

    function closePopUp() {
        const popup = document.getElementById('popup');
        popup.close();
    }

    function registerDatabase(event) {
        event.preventDefault();
        axios.post("http://localhost:8080/register", registerData).then(response => {
            console.log(response.data);
        })
    }

    function login(event) {
        event.preventDefault();
        axios.post("http://localhost:8080/login", loginData).then(response => {
            console.log(response.data);
            if (response.data != 0) {
                loginData.loggedIn = true;
                loginData.loginID = response.data;
                console.log(loginData.loginID);
                routes.push('/calculator');
            }
            else {
                alert("Login failed, wrong username and or password");
            }
        })
    }

</script>

<template>
    <h1 style="text-align: center; color: orange;">Login</h1>
    <dialog id="popup">
        <form @submit="registerDatabase">
            <label for="registerUsername">Username:</label>
            <input type="text" id="registerUsername" v-model="registerData.username" required></input>
            <label for="registerPassword">Password:</label>
            <input type="password" id="registerPassword" v-model="registerData.password" required></input>
            <input type="submit" value="Register" class="submit"></input>
        </form>
        <button @click="closePopUp" id="closeButton">X</button>
    </dialog>
    <div id="loginFrame">
        <form @submit="login">
            <label for="username">Username:</label>
            <input type="text" id="username" v-model="loginData.username" required></input>
            <label for="password">Password:</label>
            <input type="password" id="password" v-model="loginData.password" required></input>
            <input type="button" value="Register" id="register" @click="registerPopup"></input>
            <input type="submit" value="Login" class="submit"></input>
        </form>
    </div>
</template>


<style scoped>
    #loginFrame {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 60vh;
    }

    form {
        display: grid;
        grid-template-rows: 2fr 1fr 1fr 1fr;
        grid-template-areas: 
            'usernamelabel username username'
            'passwordlabel password password'
            'send send send'
            'register register register';

        width: 20vw;
        height: 50vh;
        min-width: 300px;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid black;
        border-radius: 5px;
    }

    label {
        font-size: 19px;
    }

    #username:focus,
    #password:focus {
        outline: none;
        border-bottom: 2px solid black;
    }

    #username, #registerUsername {
        grid-area: username;
        height: fit-content;
        border: none;
        border-bottom: 2px solid gray;
    }

    #password, #registerPassword {
        grid-area: password;
        height: fit-content;
        border: none;
        border-bottom: 2px solid gray;
    }

    #register {
        grid-area: register;
        width: 100px;
        height: 30px;
        justify-self: center;
        align-self: center;
        border: none;
        background-color: white;
        border-bottom: 2px solid gray;
    }

    #register:hover {
        cursor: pointer;
        color: orange;
    }

    .submit {
        grid-area: send;
        width: 100px;
        height: 30px;
        border-radius: 15px;
        justify-self: center;
        align-self: center;
    }

    .submit:hover {
        cursor: pointer;
        background-color: black;
        color: orange;
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

    #closeButton:hover {
        background-color: darkred;
    }

</style>