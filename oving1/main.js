function updateCounterDiv() {
    let counterDiv = document.getElementById("counterDiv");
    if (!counterDiv) {
        counterDiv = document.createElement('div');
        counterDiv.id = 'counterDiv';
        counterDiv.className = 'paragrafer';
        counterDiv.innerHTML = 'Button pressed: 0 times';
        let innhold = document.getElementById('innhold');
        innhold.insertBefore(counterDiv, randomArrayDiv);

        cerateResetButton();
    }

    let count = parseInt(counterDiv.innerHTML.split(': ')[1].split(' ')[0]);
    count++;
    if (count > 19) {
        counterDiv.innerHTML = "NOK NÅ DU ER HER ALLEREDE!";
    }
    else {
        counterDiv.innerHTML = `Du har trykket på samme knapp: ${count} ganger`;
    }
}

function cerateResetButton() {
    let resetButton = document.createElement('button');
    resetButton.id = 'resetButton';
    resetButton.innerHTML = 'Reset';
    resetButton.onclick = removeCounterDiv;
    document.getElementById('meny').appendChild(resetButton);
}

function removeCounterDiv() {
    let counterDiv = document.getElementById('counterDiv');
    let resetButton = document.getElementById('resetButton');
    counterDiv.remove();
    resetButton.remove();
}

function randomList() {
    let arr = ['Ole', 'Dole', 'Doffen', 'Donald', 'Daisy', 'Pluto', 'Mikke', 'Langbein', 'Skrue', 'Rip', 'Rap', 'Rup'];
    let randomArrayDiv = document.createElement('div');
    randomArrayDiv.id = 'randomArrayDiv';
    randomArrayDiv.className = 'paragrafer';
    document.getElementById('innhold').appendChild(randomArrayDiv);

    let ul = document.createElement('ul');
    randomArrayDiv.appendChild(ul);

    for (let i = 0; i < arr.length; i++) {
        let li = document.createElement('li');
        li.textContent = arr[i];
        ul.appendChild(li);
    }
}