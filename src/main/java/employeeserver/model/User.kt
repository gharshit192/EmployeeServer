package employeeserver.model

class User {
    var id: String? = null
    var name: String? = null
    var email: String? = null

    override fun toString(): String {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}'
    }
}