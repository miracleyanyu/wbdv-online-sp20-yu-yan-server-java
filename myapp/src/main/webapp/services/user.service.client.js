function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/yuyan/users';
    var self = this;
    function createUser(user) {

    }
    function findAllUsers() {
        return fetch(self.url)
                .then(response => response.json())
    }
    function findUserById(userId) {
        return fetch(`${self.url}/${userId}`)
                .then((response) => {
                    return response.json()
                })
    }
    function updateUser(userId, user) {

    }
    function deleteUser(userId) {
        return fetch(`${self.url}/${userId}`, {
            method: "DELETE"
        })
    }
}
