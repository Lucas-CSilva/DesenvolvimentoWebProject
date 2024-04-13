package br.com.financemaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Nome;
    private String Descricao;
    private double Limite;
    //TODO LUCASSILVA - criar enums de tipo
    
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

    

}
