package employeeserver.repositories
import com.sun.org.apache.xml.internal.utils.WrongParserException
import employeeserver.model.User
import javassist.NotFoundException

class UserRepository {
    ///Make the list and map static
    companion object {
        var usersList: MutableList<User> = mutableListOf()
   //     var usersMap : MutableMap<Int,User> = mutableMapOf()
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
    fun updateUser(id: String,user: User): Boolean {
        val indexOfUser = usersList.indexOfFirst { it.id == id }
//        val index = indexOfUser.toString()
        if (indexOfUser == -1)
            return  false
//            throw WrongParserException("Please Enter Correct ID")
        else
            user.id= id
            usersList.add(indexOfUser,user)
            return true
    }
    fun deleteUser(id: String): User {
        val indexOfUser = usersList.indexOfFirst { it.id == id }
        return usersList.removeAt(indexOfUser)
    }

}
