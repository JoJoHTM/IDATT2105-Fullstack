import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import { createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', name: 'Calculator', component: () => import('./components/Calculator.vue')},
        {path: '/feedback', name: 'Feedback', component: () => import('./components/Feedback.vue')},
    ]
    })

createApp(App)
.use(router)
.mount('#app')

