package engtelecom.std.rest;

import engtelecom.std.db.BancoDeDados;
import engtelecom.std.db.CampiDAO;
import engtelecom.std.entities.Bloco;
import engtelecom.std.entities.Campus;
import engtelecom.std.entities.Laboratorio;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;


@Path("campi")
public class Campi {

    private BancoDeDados bancoDeDados = BancoDeDados.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CampiDAO getListaCampi() {
        return bancoDeDados.campiDAO;
    }

    @Path("/{sigla-campus}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCampus(@PathParam("sigla-campus") String campus) {
        Campus c = bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase());
        if (c != null) {
            return Response.ok(c).build();
        }
        throw new NotFoundException();

    }

    @Path("/{sigla-campus}/blocos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaBlocos(@PathParam("sigla-campus") String campus) {
        Campus c = bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase());
        if (c != null) {
            return Response.ok(c.getBlocos()).build();
        }
        throw new NotFoundException();
    }

    @Path("/{sigla-campus}/blocos/{bloco}/laboratorios")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabsDoBlocos(@PathParam("sigla-campus") String campus, @PathParam("bloco") String bloco) {
        try {
            Map<String, Laboratorio> m = this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios();
            return Response.ok(m).build();
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    @Path("/{sigla-campus}/blocos/{bloco}/laboratorios/{sigla-lab}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabsDoBlocos(@PathParam("sigla-campus") String campus, @PathParam("bloco") String bloco, @PathParam("sigla-lab") String laboratorio) {

        try {
            Laboratorio lab = this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios().get(laboratorio.toUpperCase());
            return Response.ok(lab).build();
        } catch (Exception e) {
            throw new NotFoundException();
        }


    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addCampus(Campus c) {
        if (this.bancoDeDados.campiDAO.listaDosCampi.put(c.getSigla().toUpperCase(), c) == null) {
            throw new InternalServerErrorException();
        }

        return Response.ok("sucesso").build();
    }

    @Path("/{sigla-campus}/blocos")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addBloco(@PathParam("sigla-campus") String campus, Bloco b) {
        Campus c = this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase());
        if (c == null) {
            throw new NotFoundException();
        }
        c.getBlocos().put(b.getSigla().toUpperCase(), b);
        return Response.ok("sucesso").build();
    }


    @Path("/{sigla-campus}/blocos/{bloco}/laboratorios")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addLaboratorio(@PathParam("sigla-campus") String campus, @PathParam("bloco") String bloco, Laboratorio lab) {

        try {
            this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios().put(lab.getSigla().toUpperCase(), lab);
        } catch (Exception e) {
            throw new NotFoundException();
        }

        return Response.ok("sucesso").build();
    }

    @Path("/{sigla-campus}/blocos/{bloco}/laboratorios")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response updateLaboratorio(@PathParam("sigla-campus") String campus, @PathParam("bloco") String bloco, Laboratorio lab) {
        Laboratorio l;
        try {
            l = this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios().get(lab.getSigla());

        } catch (Exception e) {
            throw new NotFoundException();
        }

        if (l != null) {
            this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios().put(lab.getSigla().toUpperCase(), lab);
        }

        return Response.ok("sucesso").build();
    }

    @Path("/{sigla-campus}/blocos/{bloco}/laboratorios/{sigla-lab}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response removeLab(@PathParam("sigla-campus") String campus, @PathParam("bloco") String bloco, @PathParam("sigla-lab") String laboratorio) {
        Laboratorio l = this.bancoDeDados.campiDAO.buscaCampusPelaSigla(campus.toUpperCase()).buscaBlocoPelaSigla(bloco.toUpperCase()).getLaboratorios().remove(laboratorio.toUpperCase());

        if (l != null) {
            return Response.ok("sucesso").build();
        }
        throw new NotFoundException();
//        return Response.status(Response.Status.NOT_FOUND).entity("campus e/ou bloco e/ou laboratório não encontrado").build();
    }
}