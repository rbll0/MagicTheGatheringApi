package fiap.tds.resources;

import fiap.tds.models.Cards;
import fiap.tds.repositories.CardsRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("cards")
public class CardsResource {
    private CardsRepository cardsRepository;

    public CardsResource() {
        this.cardsRepository = new CardsRepository();
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCardAll() {
        List<Cards> cards = cardsRepository.getCardAll();
        return Response.ok(cards).build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cards getCard(@PathParam("id") int id) {
        return cardsRepository.getCardById(id);
    }
    @POST
    public Response createCard(Cards card) {
        cardsRepository.createCard(card);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCard(@PathParam("id") int id, Cards card) {
        cardsRepository.updateCard(card);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCard(@PathParam("id") int id) {
        cardsRepository.deleteCard(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
