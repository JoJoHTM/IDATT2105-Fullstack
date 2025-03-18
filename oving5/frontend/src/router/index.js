import { createRouter, createWebHistory} from 'vue-router'
import store from '../store.js'

const loginData = store.state.loginData

const routes = [
    {path: '/login', name: 'Login', component: () => import('../components/Login.vue')},
    {path: '/calculator', name: 'Calculator', component: () => import('../components/Calculator.vue')},
    {path: '/feedback', name: 'Feedback', component: () => import('../components/Feedback.vue')},
]


const router = createRouter({
    history: createWebHistory(),
    routes
    })

router.beforeEach((to, from,next) => {
    const jwtToken = sessionStorage.jwtToken;

    if(!jwtToken && to.name != 'Login'){
        next({name: 'Login'})
    } else {
        next();
    }
});

export default router