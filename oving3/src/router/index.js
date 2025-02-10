import { createRouter, createWebHistory} from 'vue-router'

const routes = [
    {path: '/', name: 'Calculator', component: () => import('../components/Calculator.vue')},
    {path: '/feedback', name: 'Feedback', component: () => import('../components/Feedback.vue')},
]


const router = createRouter({
    history: createWebHistory(),
    routes
    })

export default router