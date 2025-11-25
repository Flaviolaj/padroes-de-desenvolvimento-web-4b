package recursos;

import java.util.List;

import entidades.Fabricante;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("fabricantes")
public class FabricanteRecurso {

    @GET
    public List<Fabricante> listar() {
        return Fabricante.listAll(Sort.ascending("nome"));
    }

    @POST
    @Transactional
    public void salvar(Fabricante fabricante) {
        fabricante.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Fabricante fabricante = Fabricante.findById(codigo);

        if (fabricante != null) {
            fabricante.delete();
        }
    }

    @PUT
    @Path("{codigo}")
    @Transactional
    public void editar(@PathParam("codigo") Integer codigo, Fabricante fabricante) {
        Fabricante fabricanteExistente = Fabricante.findById(codigo);

        if (fabricanteExistente != null) {
            fabricanteExistente.nome = fabricante.nome;

            fabricanteExistente.persist();
        }
    }
}
