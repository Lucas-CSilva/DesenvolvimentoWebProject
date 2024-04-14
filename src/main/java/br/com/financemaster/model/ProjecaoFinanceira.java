package br.com.financemaster.model;

import java.io.Serializable;
import java.time.LocalDate;

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
public class ProjecaoFinanceira implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "historico_projecao",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"historicoId","projecaoFinanceiraId"},
                        name = "unique_historico_projecao"
                    ),
                    joinColumns = @JoinColumn(
                        name = "projecaoFinanceiraId",
                        referencedColumnName = "id",
                        table = "projecaofinanceira",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "historicoId",
                        referencedColumnName = "id",
                        table = "historico",
                        unique = false
                    )
                )
    private Historico historico = new Historico();
    
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
    public Historico getHistorico() {
        return historico;
    }
    public void setHistorico(Historico historico) {
        this.historico = historico;
    }
    
}
