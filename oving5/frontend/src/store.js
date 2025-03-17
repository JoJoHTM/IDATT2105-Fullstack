import { reactive, computed, ref } from 'vue';

const state = reactive({
    feedbackData: {
        name: '',
        email: '',
        feedback: ''
    },
    calculatorData: {
        currentValue: "0",
        totalValue: "0",
        operations: []
    },
    loginData: {
        username: '',
        password: '',
        loggedIn: false,
        loginID: 0
    },
    registerData: {
        username: '',
        password: ''
    }
});

const disableSubmit = computed(() => {
    return state.feedbackData.name === '' || state.feedbackData.email === '' || state.feedbackData.feedback === '';
});


export default {
    state,
    disableSubmit
};