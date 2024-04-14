package br.com.financemaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_cartao",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","cartaoId"},
                        name = "unique_usuario_cartao"
                    ),
                    joinColumns = @JoinColumn(
                        name = "cartaoId",
                        referencedColumnName = "id",
                        table = "cartao",
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
    
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "conta_cartao",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"contabancariaId", "cartaoId"},
                        name = "unique_conta_cartao"
                    ),
                    joinColumns = @JoinColumn(
                        name = "cartaoId",
                        referencedColumnName = "id",
                        table = "cartao",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "contabancariaId",
                        referencedColumnName = "id",
                        table = "contabancaria",
                        unique = false
                    )
                )
    private ContaBancaria conta = new ContaBancaria();

    private String Nome;
    private String Descricao;
    private double Limite;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    public double getLimite() {
        return Limite;
    }
    public void setLimite(double limite) {
        Limite = limite;
    }
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    public ContaBancaria getConta() {
        return conta;
    }
    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }
    
}
