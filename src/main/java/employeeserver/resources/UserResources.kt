package employeeserver.resources
import com.fasterxml.jackson.databind.ObjectMapper
import employeeserver.model.User
import employeeserver.services.UserService
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
        return Response.ok(user.toString()).build()
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(@QueryParam("id") id: String):Response{
        val getUser = userService.getUser(id)
        return Response.ok(getUser).build()
    }

    @PUT
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateUser(@QueryParam("id") id: String,request: String): Response{
        val updateUser = userService.updateUser(id, objectMapper.readValue(request, User::class.java))
        return if (!updateUser) {
            Response.ok().entity("Enter Correct Credentials").build()
        }else
            Response.ok(updateUser.toString()).entity("User is updated").build()
    }
    //////// testing testibng

}

