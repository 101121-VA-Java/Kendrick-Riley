 let apiUrl = "http://localhost:8080/users/getAll";

 let token = sessionStorage.getItem("token");
 if (!token || token.split(':')[1] == '3') {
     window.location.href = 'index.html';
 } else {
     document.getElementById('alluser1').addEventListener('click', getAll);
     document.getElementById('myuser2').addEventListener('click', getByManId);


     function getAll() {
         apiUrl = 'http://localhost:8080/users/getAll';
         populateTable();
     }

     function getByManId() {
         apiUrl = 'http://localhost:8080/users/id' + token.split(':')[0];
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

         let tableBody = document.getElementById('user-tbody');

         tableBody.innerHTML = '';

         for (u of users) {

             if (token.split(':')[1] === 1) {
                 row.setAttribute('data-toggle', 'modal');
                 row.setAttribute('data-target', '#updateUserModal');
                 row.addEventListener('click', setupModal);

             }
             let row = document.createElement('tr');

             let USER_ID = document.createElement('td');
             USER_ID.innerHTML = u.id;

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


             row.appendChild(USER_ID);
             row.appendChild(USERNAMETd);
             row.appendChild(fNAMETd);
             row.appendChild(LNAMETd);
             row.appendChild(EMAILTd);
             row.appendChild(ROLETd);
             tableBody.appendChild(row);
         }
     }


 }