package br.com.financemaster.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RendaVariavel")
public class RendaVariavel extends Renda{

    private LocalDate DataInicio;
    private LocalDate DataFinal;
    
    public LocalDate getDataInicio() {
        return DataInicio;
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
