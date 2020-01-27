(function () {
    let userService = new AdminUserServiceClient();

    let users = [];
    let userList = $("#wbdv-tbody");
    let usernameFld = $("#username-fld");
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;

    const findAllUsers = () =>
        userService
            .findAllUsers()
            .then((theUsers) => {
                users = theUsers;
                renderUsers();
            });

    const renderUsers = () => {
        var tableRef = document.getElementsByTagName('tbody')[0];
        for (let u = 0; u < users.length; u++) {
            var newRow = tableRef.insertRow(tableRef.rows.length);
            newRow.classList.add('wbdv-template');
            newRow.classList.add('wbdv-user');
            newRow.classList.add('wbdv-hidden');
            var newCell1 = newRow.insertCell(0);
            var newCell2 = newRow.insertCell(1);
            var newCell3 = newRow.insertCell(2);
            var newCell4 = newRow.insertCell(3);
            var newCell5 = newRow.insertCell(4);
            var newCell6 = newRow.insertCell(5);
            var newCell7 = newRow.insertCell(6);
            var newCell8 = newRow.insertCell(7);
            newCell1.innerHTML = "";
            newCell2.innerHTML = users[u].username;
            newCell2.classList.add('wbdv-username');
            newCell3.innerHTML = "&nbsp;";
            newCell4.innerHTML = users[u].firstName;
            newCell4.classList.add('wbdv-first-name');
            newCell5.innerHTML = users[u].lastName;
            newCell5.classList.add('wbdv-last-name');
            newCell6.innerHTML = users[u].role;
            newCell6.classList.add('wbdv-role');
            newCell7.innerHTML = "";
            newCell8.innerHTML = ""
                + "<span class=\"float-right\">"
                + "<i id=\"wbdv-remove\"class=\"fa-2x fa fa-times col-md-auto wbdv-remove\"></i>"
                + "<i id=\"wbdv-edit\" class=\"fa-2x fa fa-pencil col-md-auto wbdv-edit\"></i>"
                + "</span>";
            newCell8.classList.add('wbdv-actions');
        }
    };

    const main = () => {
        findAllUsers();
    };
    $(main)

})();