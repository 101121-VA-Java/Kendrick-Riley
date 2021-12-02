let apiUrl = "http://localhost:8080/users";

let token = sessionStorage.getItem("token");

document.getElementById('myuser3').addEventListener('click', getByManId);

// function getAll() {
//     apiUrl = 'http://localhost:8080/users/getAll';
//     populateTable();
// }


// This path is not working to get id
function getByManId() {
    apiUrl = `http://localhost:8080/users?id=${sessionStorage.token.split(":")[0]}`;
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
let apiUrlr = "http://localhost:8080/reimbursement";


document.getElementById('myuser5').addEventListener('click', getPending);

function getPending() {
    // Top url went to get all pending??
    // apiUrlr = 'http://localhost:8080/reimbursement/pending';
    apiUrlr = 'http://localhost:8080/reimbursement/id' + token.split(':')[0];;
    populateTable();
}

async function populateTable() {

    let token = sessionStorage.getItem("token")

    let response = await fetch(apiUrlr, {
        headers: {
            'Authorization': token

        }
    });

    let r_response = await response.json();

    let tableBody2 = document.getElementById('reim5-tbody');

    tableBody2.innerHTML = '';

    for (r of r_response) {
        let row = document.createElement('tr');

        let reimb_amount = document.createElement('td');
        reimb_amount.innerHTML = r.amount;

        let reimb_submitted = document.createElement('td');
        reimb_submitted.innerHTML = r.submittedDate;

        let reimb_status_id = document.createElement('td');
        reimb_status_id.innerHTML = r.status_Id;

        let reimb_type_id = document.createElement('td');
        reimb_type_id.innerHTML = r.type_Id;

        let reimb_author = document.createElement('td');
        reimb_author.innerHTML = r.author;

        let reimb_resolver = document.createElement('td');
        reimb_resolver.innerHTML = r.resolver;

        row.appendChild(reimb_amount);
        row.appendChild(reimb_submitted);
        row.appendChild(reimb_status_id);
        row.appendChild(reimb_type_id);
        row.appendChild(reimb_author);
        row.appendChild(reimb_resolver);
        tableBody2.appendChild(row);
    }
}