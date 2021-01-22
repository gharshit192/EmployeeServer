package employeeserver.services
import employeeserver.model.User
import employeeserver.repositories.UserRepository
import java.lang.IllegalArgumentException

class UserService {
    private val userRepository = UserRepository()

    fun addUser(user: User): User {
        if (user.name == null || user.email == null) {
            throw NullPointerException("Please Enter Name")
        }
        return userRepository.addUser(user)
    }

    fun getUser(id: String): User {
        if (id.isEmpty())
            throw NullPointerException("Enter proper id")
        else
            return userRepository.getUser(id)
    }

    fun updateUser(id: String, user: User): Boolean {
        if (id.isEmpty())
            throw NullPointerException("Enter proper id")
        else
            return userRepository.updateUser(id,user)
    }
    fun deleteUser(id: String): Boolean {
        if (id.isEmpty())
            throw IllegalArgumentException("Enter proper id")
        else
            return userRepository.deleteUser(id)

    }
}