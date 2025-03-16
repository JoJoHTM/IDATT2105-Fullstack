import { createRouter, createWebHistory} from 'vue-router'
import store from '../store.js'

const loginData = store.state.loginData

const routes = [
    {path: '/', name: 'Login', component: () => import('../components/Login.vue')},
    {path: '/calculator', name: 'Calculator', component: () => {
        if(loginData.loggedIn){
            return import('../components/Calculator.vue')
        }}
    },
    {path: '/feedback', name: 'Feedback', component: () => {
        if(loginData.loggedIn){
            return import('../components/Feedback.vue')
        }}
    },
]


const router = createRouter({
    history: createWebHistory(),
    routes
    })

export default router