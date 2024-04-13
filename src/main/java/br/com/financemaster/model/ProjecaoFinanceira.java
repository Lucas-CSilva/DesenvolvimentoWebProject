package br.com.financemaster.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjecaoFinanceira implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate Data;
    private double ValorEsperado;
    private double TaxaJuros; 
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalDate getData() {
        return Data;
    }
    public void setData(LocalDate data) {
        Data = data;
    }
    public double getValorEsperado() {
        return ValorEsperado;
    }
    public void setValorEsperado(double valorEsperado) {
        ValorEsperado = valorEsperado;
    }
    public double getTaxaJuros() {
        return TaxaJuros;
    }
    public void setTaxaJuros(double taxaJuros) {
        TaxaJuros = taxaJuros;
    }
    
}
