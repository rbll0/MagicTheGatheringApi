package fiap.tds.resources;

import fiap.tds.models.Collections;
import fiap.tds.repositories.CollectionsRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("collections")
public class CollectionsResource {
    private CollectionsRepository collectionsRepository;

    public CollectionsResource() {
        this.collectionsRepository = new CollectionsRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCollections() {
        List<Collections> collections = collectionsRepository.getAllCollections();
        return Response.ok(collections).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollectionById(@PathParam("id") int id) {
        Collections collection = collectionsRepository.getCollectionById(id);
        if (collection == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(collection).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCollection(Collections collection) {
        collectionsRepository.createCollection(collection);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCollection(@PathParam("id") int id, Collections collection) {
        Collections existingCollection = collectionsRepository.getCollectionById(id);
        if (existingCollection == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        collectionsRepository.updateCollection(collection);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCollection(@PathParam("id") int id) {
        Collections existingCollection = collectionsRepository.getCollectionById(id);
        if (existingCollection == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        collectionsRepository.deleteCollection(id);
        return Response.ok().build();
    }
}
