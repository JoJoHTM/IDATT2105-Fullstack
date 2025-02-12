import { describe, it, expect } from 'vitest';
import { mount } from '@vue/test-utils';  
import Feedback from '../components/Feedback.vue';
import { createRouter, createWebHistory } from 'vue-router';
import store from '../store.js';

const { state } = store;

const routes = [
    {path: '/', name: 'Calculator', component: () => import('../components/Calculator.vue')},
    {path: '/feedback', name: 'Feedback', component: () => import('../components/Feedback.vue')},
]

const router = createRouter({
    history: createWebHistory(),
    routes
});

describe('Feedback', () => {
    it('should render the feedback form', () => {
        const wrapper = mount(Feedback, {
            global: {
                plugins: [router, store]
            }
        });
        expect(wrapper.html()).toMatchSnapshot();
    });     
});