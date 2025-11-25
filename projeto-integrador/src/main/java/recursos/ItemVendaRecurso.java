package recursos;

import java.util.List;

import entidades.ItemVenda;
import entidades.Produto;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("itensvenda")
public class ItemVendaRecurso {

    @GET
    public List<ItemVenda> listar() {
        return ItemVenda.listAll(Sort.ascending("codigo"));
    }

    @POST
    @Transactional
    public void salvar(ItemVenda item) {


        if (item.Produto != null && item.Produto.codigo != null) {
            Produto produto = Produto.findById(item.Produto.codigo);

            if (produto != null) {
                item.Produto = produto;
            }
        }

        item.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        ItemVenda item = ItemVenda.findById(codigo);

        if (item != null) {
            item.delete();
        }
    }

    @PUT
    @Path("{codigo}")
    @Transactional
    public void editar(@PathParam("codigo") Integer codigo, ItemVenda item) {

        ItemVenda itemExistente = ItemVenda.findById(codigo);

        if (itemExistente != null) {
            itemExistente.valorParcial = item.valorParcial;
            itemExistente.quantidadeParcial = item.quantidadeParcial;

            if (item.Produto != null && item.Produto.codigo != null) {
                Produto produto = Produto.findById(item.Produto.codigo);
                if (produto != null) {
                    itemExistente.Produto = produto;
                }
            }

            itemExistente.persist();
        }
    }
}
