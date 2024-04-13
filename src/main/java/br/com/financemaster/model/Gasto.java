package br.com.financemaster.model;

import java.io.Serializable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Usuario_Type")
public abstract class Gasto implements Serializable{

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double Valor;
    //private enum Origem;

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        this.Valor = valor;
    }
}
