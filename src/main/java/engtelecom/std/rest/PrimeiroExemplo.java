package engtelecom.std.rest;

import engtelecom.std.entities.Pessoa;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("exemplo")
public class PrimeiroExemplo {

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public Response olaMundo() {
        String mensagem = "Olá mundo";
        return Response.ok(mensagem).build();
    }

    @Path("{nome}")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public Response olaNome(@PathParam("nome") String nome) {

        String mensagem = "Olá " + nome;

        return Response.ok(mensagem).build();
    }

    @Path("pessoas")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response obtemPessoa() {
        Pessoa p = new Pessoa("Fulano", "email@email.com");
        return Response.ok(p).build();
    }

    @Path("pessoas")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPessoa(Pessoa p, @Context UriInfo uriInfo) {

        // Retornando o código HTTP 201 com a URL do recurso criado no campo Location do cabeçalho HTTP
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(p.getNome());

        return Response.created(builder.build()).build();
    }

    @Path("pessoas")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatePessoa(Pessoa p) {
        return Response.ok("Pessoa atualizada").build();
    }

    @Path("pessoas/{pessoa}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response removePessoa(@PathParam("pessoa") String nome) {
        if (nome.equalsIgnoreCase("Fulano")) {
            return Response.ok("Pessoa excluída").build();
        }
        throw new NotFoundException();
    }
}
