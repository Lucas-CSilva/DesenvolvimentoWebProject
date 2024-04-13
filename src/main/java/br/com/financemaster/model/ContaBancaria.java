package br.com.financemaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;

@Entity
public class ContaBancaria {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //TODO LUCASSI LVA - criar relacionamento entre tabelas
    // @ManyToOne
    // private Usuario usuario;

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


    
}
