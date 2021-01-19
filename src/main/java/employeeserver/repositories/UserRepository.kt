package employeeserver.repositories
import employeeserver.model.User
import javassist.NotFoundException

class UserRepository {
    ///Make the list static
    companion object {
        var usersList: MutableList<User> = mutableListOf()
    }
    fun addUser(user : User): User{
        usersList.add(user)
        print(usersList)
        return user
    }
    fun getUser(id: String): User {
        val user = usersList.find { it.id == id } ?: throw NotFoundException("Enter proper Id")
        return user
    }
    fun updateUser(id: String,user: User): User {
        val userAtId = usersList.find { it.id == id } ?: throw NotFoundException("Enter proper Id")
        val indexOfUser = usersList.indexOfFirst { it.id == id }
        usersList.add(indexOfUser,user)
        return user
    }
    fun deleteUser(id: String): User {
        val userAtId = usersList.find { it.id == id } ?: throw NotFoundException("Enter proper Id")
        val indexOfUser = usersList.indexOfFirst { it.id == id }
        return usersList.removeAt(indexOfUser)
    }
}
