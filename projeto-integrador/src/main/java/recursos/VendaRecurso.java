package recursos;

import java.util.List;

import entidades.Venda;
import entidades.Cliente;
import entidades.Funcionario;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("vendas")
public class VendaRecurso {

    @GET
    public List<Venda> listar() {
        return Venda.listAll(Sort.ascending("codigo"));
    }

    @POST
    @Transactional
    public void salvar(Venda venda) {


        if (venda.Cliente != null && venda.Cliente.codigo != null) {
            Cliente cliente = Cliente.findById(venda.Cliente.codigo);
            if (cliente != null) {
                venda.Cliente = cliente;
            }
        }

        if (venda.Funcionario != null && venda.Funcionario.codigo != null) {
            Funcionario funcionario = Funcionario.findById(venda.Funcionario.codigo);
            if (funcionario != null) {
                venda.Funcionario = funcionario;
            }
        }

        venda.persist();
    }

    @DELETE
    @Path("{codigo}")
    @Transactional
    public void excluir(@PathParam("codigo") Integer codigo) {
        Venda venda = Venda.findById(codigo);

        if (venda != null) {
            venda.delete();
        }
    }

    @PUT
    @Path("{codigo}")
    @Transactional
    public void editar(@PathParam("codigo") Integer codigo, Venda venda) {

        Venda vendaExistente = Venda.findById(codigo);

        if (vendaExistente != null) {
            vendaExistente.horario = venda.horario;
            vendaExistente.valorTotal = venda.valorTotal;
            vendaExistente.quantidadeTotal = venda.quantidadeTotal;


            if (venda.Cliente != null && venda.Cliente.codigo != null) {
                Cliente cliente = Cliente.findById(venda.Cliente.codigo);
                if (cliente != null) {
                    vendaExistente.Cliente = cliente;
                }
            }


            if (venda.Funcionario != null && venda.Funcionario.codigo != null) {
                Funcionario funcionario = Funcionario.findById(venda.Funcionario.codigo);
                if (funcionario != null) {
                    vendaExistente.Funcionario = funcionario;
                }
            }

            vendaExistente.persist();
        }
    }
}
