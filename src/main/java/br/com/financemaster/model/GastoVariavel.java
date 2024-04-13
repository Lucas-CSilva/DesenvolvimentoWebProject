package br.com.financemaster.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GastoVariavel")
public class GastoVariavel extends Gasto {
    
    private LocalDate DataInicio;
    private LocalDate DataFinal;
    private int Recorrencia;
    
    public LocalDate getDataInicio() {
        return DataInicio;
    }
    public int getRecorrencia() {
        return Recorrencia;
    }
    public void setRecorrencia(int recorrencia) {
        this.Recorrencia = recorrencia;
    }
    public LocalDate getDataFinal() {
        return DataFinal;
    }
    public void setDataFinal(LocalDate dataFinal) {
        this.DataFinal = dataFinal;
    }
    public void setDataInicio(LocalDate dataInicio) {
        this.DataInicio = dataInicio;
    }
}
