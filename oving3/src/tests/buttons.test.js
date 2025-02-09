import { describe, it, expect, test } from 'vitest';

import {clear} from '../components/Buttons.vue';
import store from '../store.js';

const {state} = store;


test('sets the current value to 0', () => {

    state.calculatorData.currentValue = "1";
    clear();
    expect(state.calculatorData.currentValue).toBe("0");
})


