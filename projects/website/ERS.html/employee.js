function myFunction() {
    let newReim = {
        reimb_amount: '',
        reimb_submitted: '',
        reimb_description: '',
        reimb_author: '',
    };
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 201) {
                console.log('Reimbursment was sent successfuly!');
            } else {
                console.log('Error! Reimbursment was not added');
            }
        }
    }
    xhr.open("POST", "http://localhost:8080/reimbursement");
    let requestBody = JSON.stringify(newReim);
    xhr.send(requestBody);
}
// have to change xhr.open to the path on the backend.