'use strict'
// Element imports
const output = document.getElementById(`output`);
const inputName = document.getElementById(`inputName`);
const inputPowerLevel = document.getElementById(`inputPowerLevel`);
const inputPowers = document.getElementById(`inputPowers`);
const inputBackstory = document.getElementById(`inputBackstory`);
const buttonCreate = document.getElementById(`buttonCreate`);
const buttonUpdate = document.getElementById(`buttonUpdate`);
const inputId = document.getElementById(`inputId`);
const buttonDelete = document.getElementById(`buttonDelete`);
const buttonRead = document.getElementById(`buttonRead`);

//function to add to unordered list
const addItemToList = item => {
    const child = document.createElement(`li`);
    child.id = item.id;
    child.innerHTML = `<hr/>ID: ${item.id}<br/>Name: ${item.name}<br/>Power Level: ${item.powerLevel}<br/>Powers: ${item.powers}<br/>Tragic Backstory: ${item.tragicBackstory}<br/>`;
    output.appendChild(child);
    console.log(child);
}

//Read all, write to list
const getAll = () => {
    output.innerHTML = ``;
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

getAll();

// Create
const post = () => {
    axios.post(`http://localhost:8080/create`, {
        name: inputName.value,
        powerLevel: inputPowerLevel.value,
        powers: inputPowers.value,
        tragicBackstory: inputBackstory.value
    })
        .then((response) => {
            console.log(response);
            getAll();
        }).catch((err) => {
            console.log(err);
        });
}

buttonCreate.onclick = () => {
    post();
    getAll();
}

// Update
const put = (id) => {
    axios.put(`http://localhost:8080/update/id/${id}`, {
        name: inputName.value,
        powerLevel: inputPowerLevel.value,
        powers: inputPowers.value,
        tragicBackstory: inputBackstory.value
    })
        .then(() => {
            getAll();
        }).catch((err) => {
            console.log(err);
        });
}
buttonUpdate.onclick = () => put(inputId.value);

// Delete
const deleteId = (id) => {
    axios.delete(`http://localhost:8080/delete/id/${id}`)
        .then(() => {
            getAll();
        }).catch((err) => {
            console.log(err);
        });
}
buttonDelete.onclick = () => deleteId(inputId.value);

const getById = (id) => {
    axios.get(`http://localhost:8080/read/id/${id}`)
        .then((response) => {
            output.innerHTML = ``;
            addItemToList(response.data);
        }).catch((err) => {
            console.log(err);
        });
}

buttonRead.onclick = () => {
    if (inputId.value) {
        getById(inputId.value);
    } else {
        getAll();
    }
}