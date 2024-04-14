package br.com.financemaster.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ContaBancaria {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_conta",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","contabancariaId"},
                        name = "unique_usuario_conta"
                    ),
                    joinColumns = @JoinColumn(
                        name = "contabancariaId",
                        referencedColumnName = "id",
                        table = "contabancaria",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    )
                )
    private Usuario usuario = new Usuario();

    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "conta_cartao",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"contabancariaId","cartaoId"},
                        name = "unique_conta_cartao"
                    ),
                    joinColumns = @JoinColumn(
                        name = "contabancariaId",
                        referencedColumnName = "id",
                        table = "contabancaria",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "cartaoId",
                        referencedColumnName = "id",
                        table = "cartao",
                        unique = false
                    )
                )
    private List<Cartao> cartoes = new ArrayList<Cartao>();

    private String Nome;
    private String Banco;
    private String Numero;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getBanco() {
        return Banco;
    }
    public void setBanco(String banco) {
        Banco = banco;
    }
    public String getNumero() {
        return Numero;
    }
    public void setNumero(String numero) {
        Numero = numero;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    } 
}
