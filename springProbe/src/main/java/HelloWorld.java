import javax.ws.rs.*;
@Path
public class HelloWorld {

    public String sayHello() {
        @GET
        return "Hello World!!!";
    }
}
