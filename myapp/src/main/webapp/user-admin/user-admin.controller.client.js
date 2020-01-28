(function () {
    let userService = new AdminUserServiceClient();

    let users = [];
    let searchList = [];

    deleteUser = function (index) {
        const userId = users[index]._id;
        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1);
                renderUsers(users);
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
        const role = roleFld.value;
        $("#roleFld").val("FACULTY");

        userService.createUser({
            "username": username,
            "password": password,
            "firstName": firstName,
            "lastName": lastName,
            "role": role
        }).then(newUser => {
            users.push(newUser);
            renderUsers(users);
            })
    };

    searchUser = function () {
        const username = usernameFld.value;
        const password = passwordFld.value;
        const firstName = firstNameFld.value;
        const lastName = lastNameFld.value;
        const role = roleFld.value.toUpperCase();
        if (username === "" &&
            password === "" &&
            firstName === "" &&
            lastName === "" &&
            role === "FACULTY") {
            searchList = users.slice(0);
            if (role === "FACULTY") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].role.toUpperCase() !== "FACULTY") {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            else if (role === "STUDENT") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].role.toUpperCase() !== "STUDENT") {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            else if (role === "ADMIN") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].role.toUpperCase() !== "ADMIN") {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            renderUsers(searchList);
        }
        else {
            searchList = users.slice(0);
            if (username !== "") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].username !== username) {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            if (firstName !== "") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].firstName !== firstName) {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            if (lastName !== "") {
                for (let u = 0; u < searchList.length; u++) {
                    if (searchList[u].lastName !== lastName) {
                        searchList.splice(u, 1);
                        u--;
                    }
                }
            }
            for (let u = 0; u < searchList.length; u++) {
                if (searchList[u].role.toUpperCase() !== role) {
                    searchList.splice(u, 1);
                    u--;
                }
            }
            renderUsers(searchList);
        }
    };

    let currentUserId = -1;
    editUser = function (index) {
        const userId = users[index]._id;
        currentUserId = userId;
        userService.findUserById(userId)
            .then(user => {
                usernameFld.value = user.username;
                passwordFld.value = user.password;
                firstNameFld.value = user.firstName;
                lastNameFld.value = user.lastName;
                $("#roleFld").val(user.role);
            })
    };

    updateUser = function () {
        const username = usernameFld.value;
        usernameFld.value = "";
        const password = passwordFld.value;
        passwordFld.value = "";
        const firstName = firstNameFld.value;
        firstNameFld.value = "";
        const lastName = lastNameFld.value;
        lastNameFld.value = "";
        const role = roleFld.value;
        $("#roleFld").val("FACULTY");

        userService.updateUser(currentUserId, {
            "username": username,
            "password": password,
            "firstName": firstName,
            "lastName": lastName,
            "role": role
        }).then(user => {
            findAllUsers();
            renderUsers(users);
        })
    };

    const findAllUsers = () =>
        userService
            .findAllUsers()
            .then((theUsers) => {
                users = theUsers;
                renderUsers(users);
            });

    const renderUsers = (usersList) => {
        var tableRef = document.getElementsByTagName('tbody')[0];
        tableRef.innerHTML = "";
        for (let u = 0; u < usersList.length; u++) {
            var newRow = tableRef.insertRow(tableRef.rows.length);
            newRow.classList.add('wbdv-user');
            var newCell1 = newRow.insertCell(0);
            var newCell2 = newRow.insertCell(1);
            var newCell3 = newRow.insertCell(2);
            var newCell4 = newRow.insertCell(3);
            var newCell5 = newRow.insertCell(4);
            var newCell6 = newRow.insertCell(5);
            var newCell7 = newRow.insertCell(6);
            var newCell8 = newRow.insertCell(7);
            newCell1.innerHTML = "";
            newCell2.innerHTML = usersList[u].username;
            newCell2.classList.add('wbdv-username');
            newCell3.innerHTML = "&nbsp;";
            newCell4.innerHTML = usersList[u].firstName;
            newCell4.classList.add('wbdv-first-name');
            newCell5.innerHTML = usersList[u].lastName;
            newCell5.classList.add('wbdv-last-name');
            newCell6.innerHTML = usersList[u].role;
            newCell6.classList.add('wbdv-role');
            newCell7.innerHTML = "";
            $deleteBtn = $("<a position=\"\"id=\"wbdv-remove\"class=\"fa-2x fa fa-times col-md-auto wbdv-remove\""
                + "onclick=\"deleteUser($(this).attr('position'))\"/>").attr('position', u + "");
            $editBtn = $("<i id=\"wbdv-edit\" class=\"fa-2x fa fa-pencil col-md-auto wbdv-edit\""
                + "onclick=\"editUser($(this).attr('position'))\"/>").attr('position', u + "");
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