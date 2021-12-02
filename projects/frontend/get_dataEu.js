let apiUrl = "http://localhost:8080/users";

let token = sessionStorage.getItem("token");

document.getElementById('myuser3').addEventListener('click', getByManId);

// function getAll() {
//     apiUrl = 'http://localhost:8080/users/getAll';
//     populateTable();
// }
// This path is not working to get id
function getByManId() {
    apiUrl = 'http://localhost:8080/users?id' + token.split(':')[0];
    populateTable();
}

async function populateTable() {

    let response = await fetch(apiUrl, {
        headers: {
            'Authorization': token
                //  token: 1
        }
    });


    let users = await response.json();
    console.log(users);
    let tableBody = document.getElementById('user4-tbody');

    tableBody.innerHTML = '';

    for (u of users) {
        let row = document.createElement('tr');

        let USER_IDTd = document.createElement('td');
        USER_IDTd.innerHTML = u.id;

        let USERNAMETd = document.createElement('td');
        USERNAMETd.innerHTML = u.userName;

        //  let PASSWORDTd = document.createElement('td');
        //  PASSWORDTd.innerHTML = u.lastName;

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
        //  row.appendChild(PASSWORDTd);
        row.appendChild(fNAMETd);
        row.appendChild(LNAMETd);
        row.appendChild(EMAILTd);
        row.appendChild(ROLETd);
        tableBody.appendChild(row);
    }



}