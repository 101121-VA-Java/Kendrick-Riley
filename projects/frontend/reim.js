let apiUrl = "http://localhost:8080/reimbursement/";

let token = sessionStorage.getItem("token");
if (!token || token.split(':')[1] == '0') {
    window.location.href = 'index.html';
} else {

    document.getElementById('myuser3').addEventListener('click', getPending);
    populateTable();
}

function getPending() {

    apiUrl = 'http://localhost:8080/reimbursement/pending';
    populateTable();
}

async function populateTable() {

    let token = sessionStorage.getItem("token")

    let response = await fetch(apiUrl, {
        headers: {
            'Authorization': token

        }
    });

    let r_response = await response.json();
    console.log(r_response);

    let tableBody1 = document.getElementById('reim3-tbody');

    tableBody1.innerHTML = '';

    // stop iterating over????/?
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
        tableBody1.appendChild(row);
    }

}