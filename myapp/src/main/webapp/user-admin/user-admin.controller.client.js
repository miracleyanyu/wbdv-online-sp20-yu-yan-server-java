(function () {
    let userService = new AdminUserServiceClient();

    let users = [];
    let userList = $("#user-table");

    deleteUser = function (index) {
        const userId = users[index]._id;
        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1);
                renderUsers();
            })
    };

    createUser = function () {
        const username = usernameFld.value;
        usernameFld.value = "";
        const password = passwordFld.value;
        passwordFld.value = "";
        const firstName = firstNameFld.value;
        firstNameFld.value = "";
        const lastName = lastNameFld.value;
        lastNameFld.value = "";
        const role = roleFld.value.upper;
        roleFld.value = "";

        userService.createUser({
            "username": username,
            "password": password,
            "firstName": firstName,
            "lastName": lastName,
            "role": role
        }).then(newUser => {
            users.push(newUser);
            findAllUsers();
            renderUsers();
            })
    };

    const findAllUsers = () =>
        userService
            .findAllUsers()
            .then((theUsers) => {
                users = theUsers;
                renderUsers();
            });

    const renderUsers = () => {
        var tableRef = document.getElementsByTagName('tbody')[0];
        tableRef.innerHTML = "";
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
            $deleteBtn = $("<a position=\"\"id=\"wbdv-remove\"class=\"fa-2x fa fa-times col-md-auto wbdv-remove\""
                + "onclick=\"deleteUser($(this).attr('position'))\"/>").attr('position', u + "");
            $editBtn = $("<i id=\"wbdv-edit\" class=\"fa-2x fa fa-pencil col-md-auto wbdv-edit\"/>");
            newCell8.innerHTML =
                  "<span class=\"float-right\">"
                + $deleteBtn.prop('outerHTML')
                + $editBtn.prop('outerHTML')
                + "</span>";
            newCell8.classList.add('wbdv-actions');
        }
    };

    const main = () => {
        findAllUsers();
    };
    $(main)

})();