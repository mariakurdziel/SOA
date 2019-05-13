package RestServices;

import DAO.MovieDAO;
import Models.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieService {

    @GET // This annotation indicates GET request
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") Long id) {
        return Response.status(200).entity(MovieDAO.getMovieById(id)).build();
    }


    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{userId}")
    public Response createMovie(Movie movie, @PathParam("userId") Long userId) {
        try {
            MovieDAO.addMovie(movie, userId);
        } catch (NullPointerException e) {
            Response.status(400).entity("User with given id does not exist").build();
        } catch (Exception e) {
            Response.status(500).build();
        }
        return Response.status(200).build();
    }

    @DELETE
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {
        MovieDAO.deleteMovie(id);
        return Response.status(200).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/")
    public Response updateMovie(Movie movie) {
        try{
            MovieDAO.updateMovie(movie);
        } catch (NullPointerException e) {
            return Response.status(400).entity("Movie with given id does not exist").build();
        } catch (Exception e) {
            return Response.status(500).build();
        }

        return Response.status(200).build();
    }
}
