package employeeserver.repositories
import employeeserver.model.User


class UserRepository {
    ///Make the  map static
    companion object {
        var usersMap: HashMap<CharSequence, User> = hashMapOf()
        //      var usersListEmail: MutableList<CharSequence> = mutableListOf()
    }
    fun addUser(user: User): User {
        usersMap[user.getId()] = user
//        usersListEmail.add(user.email)
//        var value = usersListEmail.contains(user.email)
//        if (value){
//            throw Exception("Enter correct email id or email id is already entered")
//        }else {
//            usersMap.put(user.getId(), user)
//            return user
//        }
        return user
    }
    fun getUser(id: String): User {
        return usersMap[id] ?: throw NullPointerException("Enter proper id")
    }
    fun updateUser(id: String, user: User): Boolean {
        val value = usersMap.containsKey(id)
        if (value) {
            usersMap[id] = user
            return true
        } else {
            throw Exception("Id not found")
        }
    }
    fun deleteUser(id: String): Boolean {
        val value = usersMap.containsKey(id)
        return if (value) {
            usersMap.remove(id)
            true
        } else
            false
    }
}