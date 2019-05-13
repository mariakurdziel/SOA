package RestServices;

import DAO.UserDAO;
import Models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserService {

    @GET // This annotation indicates GET request
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") Long id) {
        return Response.status(200).entity(UserDAO.getUserById(id)).build();
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(User user) {
        UserDAO.addUser(user);
        return Response.status(200).build();
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        UserDAO.deleteUser(id);
        return Response.status(200).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response updateUser(User user) {
        try{
            UserDAO.updateUser(user);
        } catch (NullPointerException e) {
            return Response.status(400).entity("User with given id does not exist").build();
        } catch (Exception e) {
            return Response.status(500).build();
        }

        return Response.status(200).build();
    }

}
