import { describe, it, expect } from 'vitest';
import { mount } from '@vue/test-utils';  
import Feedback from '../components/Feedback.vue';
import { createRouter, createWebHistory } from 'vue-router';
import store from '../store.js';

const { state } = store;

const router = createRouter({
    history: createWebHistory(),
    routes: []
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

    it('should have a submit button', () => {
        const wrapper = mount(Feedback, {
            global: {
                plugins: [router, store]
            }
        });
        const button = wrapper.find('input[type="submit"]');
        expect(button.exists()).toBe(true);
    });

    it('should have an input field for feedback', () => {
        const wrapper = mount(Feedback, {
            global: {
                plugins: [router, store]
            }
        });
        const input = wrapper.find('textarea[id="feedback"]');
        expect(input.exists()).toBe(true);
    });

    it('should update the store when feedback is submitted', async () => {
        const wrapper = mount(Feedback, {
            global: {
                plugins: [router, store]
            }
        });
        const input = wrapper.find('textarea[id="feedback"]');
        input.setValue('Great job!');
        await wrapper.find('form').trigger('submit.prevent');
        expect(state.feedbackData.feedback).toBe('Great job!');
    });
});