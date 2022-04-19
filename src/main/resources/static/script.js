'use strict'
// Element imports
const listHero = document.getElementById(`listHero`);
const inputName = document.getElementById(`inputName`);
const inputPowerLevel = document.getElementById(`inputPowerLevel`);
const inputPowers = document.getElementById(`inputPowers`);
const inputBackstory = document.getElementById(`inputBackstory`);
const buttonCreate = document.getElementById(`buttonCreate`);

//function to add to unordered list
const addItemToList = item => {
    const child = document.createElement(`li`);
    child.id = item.id;
    child.innerHTML = `${JSON.stringify(item)}`;
    listHero.appendChild(child);
}

//get all, write to list
const get = () => {
    listHero.innerHTML = ``;
    axios.get(`http://localhost:8080/read/all`)
        .then((response) => {
            if (!Array.isArray(response.data)) {
                addItemToList(response.data);
                console.log(response.data);
            } else {
                for (let item of response.data) {
                    addItemToList(item);
                    console.log(item);
                }
            }
        }).catch((err) => {
            console.log(err);
        });
}

get();

// add to db
const post = () => {
    axios.post(`http://localhost:8080/create`, {
        name: inputName.value,
        powerLevel: inputPowerLevel.value,
        powers: inputPowers.value,
        tragicBackstory: inputBackstory.value
    })
        .then((response) => {
            console.log(response);
        }).catch((err) => {
            console.log(err);
        });
}

buttonCreate.onclick = () => {
    post();
    get();
}



