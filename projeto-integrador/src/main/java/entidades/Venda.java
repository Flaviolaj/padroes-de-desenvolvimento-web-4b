package entidades;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Venda extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer codigo;

    public LocalDateTime horario;

    public double valorTotal;

    public int quantidadeTotal;

    @ManyToOne (optional = false)
    public Cliente Cliente;

    @ManyToOne (optional = false)
    public Funcionario Funcionario;
    

    
}