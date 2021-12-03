let apiUrl = "http://localhost:8080/users";

let token = sessionStorage.getItem("token");

document.getElementById('myuser3').addEventListener('click', getByManId);

function getByManId() {
    apiUrl = 'http://localhost:8080/users/' + token.split(':')[0];
    populateTable();
}

async function populateTable() {

    let response = await fetch(apiUrl, {
        method: 'get',
        headers: {
            'Authorization': token
        }
    });
    /* For this method you dont need a for in loop due to the fact that you are
    only getting one employee*/
    let u =
        await response.json();

    let tableBody = document.getElementById('user4-tbody');

    tableBody.innerHTML = '';


    let row = document.createElement('tr');

    let USER_IDTd = document.createElement('td');
    USER_IDTd.innerHTML = u.id;

    let USERNAMETd = document.createElement('td');
    USERNAMETd.innerHTML = u.userName;

    let fNAMETd = document.createElement('td');
    fNAMETd.innerHTML = u.firstName;

    let LNAMETd = document.createElement('td');
    LNAMETd.innerHTML = u.lastName;

    let EMAILTd = document.createElement('td');
    EMAILTd.innerHTML = u.email;

    let ROLETd = document.createElement('td');
    ROLETd.innerHTML = u.role;

    row.appendChild(USER_IDTd);
    row.appendChild(USERNAMETd);
    row.appendChild(fNAMETd);
    row.appendChild(LNAMETd);
    row.appendChild(EMAILTd);
    row.appendChild(ROLETd);
    tableBody.appendChild(row);

}