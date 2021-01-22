package employeeserver.resources
import com.fasterxml.jackson.databind.ObjectMapper
import employeeserver.model.User
import employeeserver.services.UserService
import java.io.IOException
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/user/v1")
class UserResource {
    private var objectMapper = ObjectMapper()
    private val userService = UserService()

    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    fun status(): Response {
        return Response.status(Response.Status.OK).entity("Status of the User").build()
    }

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addUser(request: String): Response {
        val user = userService.addUser(objectMapper.readValue(request, User::class.java))
        return Response.ok(user.toString()).entity("User added successfully").build()
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(@QueryParam("id") id: String): Response {
        val getUser = userService.getUser(id)
        return Response.ok(getUser).entity("User find succesfully").build()
    }

    @PUT
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateUser(@QueryParam("id") id: String, request: String): Response {

        val updateUser = userService.updateUser(id, objectMapper.readValue(request, User::class.java))
                 return if (!updateUser) {
                     Response.ok().entity("Enter Correct Credentials").build()
                 } else
        return Response.ok(updateUser.toString()).entity("User is updated").build()
    }

    @DELETE
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteUser(@QueryParam("id") id: String): Response {
        val isDeletedUser = userService.deleteUser(id)
        return if (!isDeletedUser) {
            Response.ok().entity("Enter Correct Credentials").build()
        } else
        return   Response.ok(isDeletedUser).entity("User is deleted").build()
    }
}
