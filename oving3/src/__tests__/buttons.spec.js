import { describe, it, expect } from 'vitest';
import { mount } from '@vue/test-utils';  
import Buttons from '../components/Buttons.vue';

import store from '../store.js';

const {state} = store;


describe('Buttons', () => {
    it('should render the buttons', () => {
        const wrapper = mount(Buttons);
        expect(wrapper.html()).toMatchSnapshot();
    });
});

describe('Buttons', () => {
    it('should clear the calculator', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.currentValue = "5";
        await wrapper.find('#clear').trigger('click');
        expect(state.calculatorData.currentValue).toBe("0");
    });
});

describe('Buttons', () => {
    it('should add a number to the calculator', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.currentValue = "5";
        await wrapper.find('[value="2"]').trigger('click');
        expect(state.calculatorData.currentValue).toBe("52");
    });
});

describe('Buttons', () => {
    
    it('should add a decimal to the calculator', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.currentValue = "5";
        await wrapper.find('#comma').trigger('click');
        expect(state.calculatorData.currentValue).toBe("5,");
    });


    // DENNE FUNKER IKKE, RETURNERER ALLTID ERROR FREMFOR 10
    it('should equal a sum', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.operations.length = 0;
        state.calculatorData.currentValue = "0";
        // Click the buttons in the order of the test
        wrapper.find('[value="5"]').trigger('click');
        wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        wrapper.find('#plus').trigger('click');
        wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        wrapper.find('[value="5"]').trigger('click');
        wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        wrapper.find('#equals').trigger('click');
        wrapper.vm.$nextTick(); // Wait for DOM update
        historyWrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        // Check the final state
        expect(state.calculatorData.currentValue).toBe("10");
    });
});

/*describe('Buttons', () => {
    it('should equal a sum', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.operations.length = 0;
        // Click the buttons in the order of the test
        await wrapper.find('[value="5"]').trigger('click');
        await wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        await wrapper.find('#plus').trigger('click');
        await wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        await wrapper.find('[value="5"]').trigger('click');
        await wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        await wrapper.find('#equals').trigger('click');
        await wrapper.vm.$nextTick(); // Wait for DOM update
        console.log(state.calculatorData); // Log the state to debug
        
        // Check the final state
        expect(state.calculatorData.currentValue).toBe("10");
    });
});*/

describe('Buttons', () => {
    it('should add operation to operations list', async () => {
        const wrapper = mount(Buttons);
        state.calculatorData.currentValue = "5";
        await wrapper.find('#plus').trigger('click');
        expect(state.calculatorData.operations).toStrictEqual(["5","+"]);
    });
});

