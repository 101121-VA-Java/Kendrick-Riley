// // retrieving token from session storage if it exists
// // let token = sessionStorage.getItem("token");


// let nav_right = document.getElementById("nav-right");
// let nav_left = document.getElementById("nav-left");
// // I am here of changing the code
// if (token) {
//     let tokenArr = token.split(':');
//     let id = tokenArr[0];
//     let role = tokenArr[1];

//     if (role === '1' || role === '2') {
//         createNavElement('Employees', nav_left, 'employee_dashboard.html', null);
//     }

//     createNavElement('Info', nav_right, null, null);
//     createNavElement('Logout', nav_right, null, logout);
// } else {
//     createNavElement('Login', nav_right, 'login_form.html', null);
// }

// function logout() {
//     sessionStorage.clear();
//     location.reload();
// }

// function createNavElement(innerHTML, parentElement, link, callback) {
//     let li = document.createElement('li');
//     li.setAttribute('class', 'nav-item');
//     let a = document.createElement('a');
//     a.setAttribute('class', 'nav-link');

//     if (link) {
//         a.setAttribute('href', link);
//     } else {
//         a.setAttribute('href', '#');
//     }

//     if (callback) {
//         a.addEventListener('click', callback);
//     }

//     a.innerHTML = innerHTML;

//     li.appendChild(a);

//     parentElement.appendChild(li);
// }