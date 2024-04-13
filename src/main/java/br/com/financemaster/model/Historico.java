package br.com.financemaster.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Historico {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate DataCompetencia;
    private RendaFixa RendaFixa;
    private RendaVariavel RendaVariavel;
    private GastoFixo GastoFixo;
    private GastoVariavel GastoVariavel;

    public LocalDate getDataCompetencia() {
        return DataCompetencia;
    }
    public GastoVariavel getGastoVariavel() {
        return GastoVariavel;
    }
    public void setGastoVariavel(GastoVariavel gastoVariavel) {
        this.GastoVariavel = gastoVariavel;
    }
    public GastoFixo getGastoFixo() {
        return GastoFixo;
    }
    public void setGastoFixo(GastoFixo gastoFixo) {
        this.GastoFixo = gastoFixo;
    }
    public RendaVariavel getRendaVariavel() {
        return RendaVariavel;
    }
    public void setRendaVariavel(RendaVariavel rendaVariavel) {
        this.RendaVariavel = rendaVariavel;
    }
    public RendaFixa getRendaFixa() {
        return RendaFixa;
    }
    public void setRendaFixa(RendaFixa rendaFixa) {
        this.RendaFixa = rendaFixa;
    }
    public void setDataCompetencia(LocalDate dataCompetencia) {
        this.DataCompetencia = dataCompetencia;
    }

}
