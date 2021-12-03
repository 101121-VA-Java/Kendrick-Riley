// retrieving token from session storage if it exists
let token = sessionStorage.getItem("token");

let apiUrl = "http://localhost:8080";

function login() {
    // resetting error div
    document.getElementById("error-div").innerHTML = "";

    //retrieving user credentials
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let xhr = new XMLHttpRequest();

    xhr.open("POST", `${apiUrl}/auth`);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let authToken = xhr.getResponseHeader("Authorization");
            sessionStorage.setItem("token", authToken);
            let tok = sessionStorage.getItem("token");

            if (tok.split(":")[1] === "1" || tok.split(":")[1] === "2") {
                // navigate to a different view (ie: homepage)
                window.location.href = "manager_dashboard.html";
            } else {
                window.location.href = "employee_dashboard.html";
            }
        } else if (xhr.readyState === 4) {
            // provide user with feedback of failure to login
            document.getElementById("error-div").innerHTML = "Unable to login.";
        }
    }

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    let requestBody = `username=${username}&password=${password}`;

    xhr.send(requestBody);
}

function showReimbursementsOfOneEmployee() {
    let searchId = document.getElementById('authorId').value;
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && (xhr.status >= 200 && xhr.status < 300)) {
            let response = xhr.response;
            response = JSON.parse(response);
            populateTable3(response);
            console.log(response);


        }
    }
    xhr.open('GET', `http://localhost:8080/reimbursement/pending?author-id=${searchId}`);
    xhr.setRequestHeader("Authorization", sessionStorage.token);
    xhr.send();
}

function populateTable3() {

    let tableBody1 = document.getElementById('reim3-tbody');

    tableBody1.innerHTML = '';

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

    row.appendChild(reimb_amount);
    row.appendChild(reimb_submitted);
    row.appendChild(reimb_status_id);
    row.appendChild(reimb_type_id);
    row.appendChild(reimb_author);
    tableBody1.appendChild(row);
}

let addReimbursement = () => {
    if (!sessionStorage.token) return;
    let amount = document.getElementById("reimb-amount").value;
    let description = document.getElementById("reimb-description").value;
    let arr = document.getElementsByName("flexRadioDefault");
    let checkedElement = null;
    for (let i = 0; i < arr.length; i++)
        if (arr[i].checked) checkedElement = arr[i];
    let type_Id = checkedElement.id.split("-")[1];
    switch (type_Id) {
        case "lodging":
            type_Id = "1";
            break;
        case "travel":
            type_Id = "2";
            break;
        case "food":
            type_Id = "3";
            break;
        case "other":
            type_Id = "4";
            break;
        default:
            break;
    }
    let author = sessionStorage.token.split(":")[0];
    let newReimbursement = { amount, description, author, type_Id };
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                console.log('Reimbursement was successfully added!');
                alert("Reimbursement was successfully added!");
            } else {
                console.log('Reimbursement was not added...');
            }
        }
    }
    xhr.open("POST", "http://localhost:8080/reimbursement");
    let requestBody = JSON.stringify(newReimbursement);
    xhr.send(requestBody);
}

function logout() {
    sessionStorage.clear();
    window.location.href = "index.html";

}

async function editOrUpdateEmployee() {
    let arr = sessionStorage.token.split(":");
    console.log(arr);
    let id = arr[0];

    var role = "";
    let userName = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let email = document.getElementById("email").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;

    if (arr[1] == 3) {
        var role = 'EMPLOYEE';
    } else if (arr[1] == 2) {
        var role = 'MANAGER';
    } else if (arr[1] == 1) {
        var role = 'ADMIN';
    }

    let data = { id, role, userName, password, email, firstName, lastName };
    // The for...in statement iterates over all enumerable properties of an object 
    // that are keyed by strings (ignoring ones keyed by Symbols), including inherited enumerable properties.
    console.log(data);
    for (const key in data)
        if (!data[key])
            return;

    let response = await fetch(`http://localhost:8080/users/${id}`, {
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