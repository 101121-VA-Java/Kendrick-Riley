let apiUrl = "http://localhost:8080/reimbursement/";

let token = sessionStorage.getItem("token");
if (!token || token.split(':')[1] == '0') {
    window.location.href = 'index.html';
} else {

    document.getElementById('myuser3').addEventListener('click', getPending);
    populateTable();
}

function getPending() {

    apiUrl = 'http://localhost:8080/reimbursement/pending{author-Id}';
    populateTable();
}

async function populateTable() {

    let token = sessionStorage.getItem("token")

    let response = await fetch(apiUrl, {
        headers: {
            'Authorization': token

        }
    });;
    // let authorId = document.getElementById("${authorId}").value


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
async function reimbursementApprove() {
    let arr = sessionStorage.token.split(":");
    console.log(arr);
    let id = arr[0];

    let id1 = document.getElementById("id").value;
    let statusId = document.getElementById("statusId").value;
    // let description = document.getElementById("description").value;


    let data = { statusId };
    console.log(data);
    for (const key in data)
        if (!data[key])
            return;

    let response = await fetch(`http://localhost:8080/reimbursement/${id}`, {
        method: 'PUT',
        headers: {
            'Authorization': sessionStorage.token
        },
        body: JSON.stringify(data)
    });

    if (response.status == 200) {
        //window.location.reload();
        document.getElementById('error-div').innerHTML = 'Update Complete.'
    } else {
        document.getElementById('error-div').innerHTML = 'Unable to update employee.'
    }
}

function changeReimbursement() {
    let id = document.getElementById("id").value;

    console.log(id);

    for (const key in id)
        if (!id[key])
            return;
    let xhr = new XMLHttpRequest();
    let status_Id = 2;

    xhr.open("PUT", 'http://localhost:8080/reimbursement/${id}');
    console.log(id);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Hey! You're doing the thing!");
        } else if (xhr.readyState === 4) {
            console.log("Please fix the input sting @ ReimbursementController.java:67");
        }
    };
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.send(JSON.stringify(status_Id));
}