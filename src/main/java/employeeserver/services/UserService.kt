package employeeserver.services
import employeeserver.model.User
import employeeserver.repositories.UserRepository

class UserService {
     private val userRepository = UserRepository()

     fun addUser(user: User): User {
         if(user.name== null || user.email ==null){
             throw NullPointerException("Please Enter Name")
         }
         return userRepository.addUser(user)
     }
     fun getUser(id: String): User {
         if (id.isEmpty())
             throw NullPointerException("Please Enter Id")
         else
             return userRepository.getUser(id)
     }
     fun updateUser(id: String, user: User): Boolean {
         return userRepository.updateUser(id,user)
     }
     fun deleteUser(id: String): User {
         if (id.isEmpty())
             throw NullPointerException("Please Enter Id")
         else
             return userRepository.deleteUser(id)
     }
 }
