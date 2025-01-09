function updateCounterDiv() {
    let counterDiv = document.getElementById("counterDiv");
    if (!counterDiv) {
        counterDiv = document.createElement('div');
        counterDiv.id = 'counterDiv';
        counterDiv.className = 'paragrafer';
        counterDiv.innerHTML = 'Button pressed: 0 times';
        document.getElementById('innhold').appendChild(counterDiv);
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
