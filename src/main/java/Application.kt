import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import employeeserver.resources.UserResource
import java.net.URI
import javax.ws.rs.core.UriBuilder

fun main() {
    var baseUri: URI = UriBuilder.fromUri("http://localhost/").port(8080).build()
    var config: ResourceConfig = ResourceConfig(UserResource::class.java)
    var server: HttpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, config)



}
