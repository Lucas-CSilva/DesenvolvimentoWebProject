package br.com.financemaster.model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;

// @Entity
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "Usuario_Type")
@MappedSuperclass
public abstract class Renda implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double Valor;
    //private enum Origem;

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        this.Valor = valor;
    }
}
