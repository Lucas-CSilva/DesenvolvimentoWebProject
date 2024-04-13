package br.com.financemaster.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GastoFixo")
public class GastoFixo extends Gasto {
    
    private LocalDate DataCompetencia;

    public LocalDate getDataCompetencia() {
        return DataCompetencia;
    }

    public void setDataCompetencia(LocalDate dataCompetencia) {
        this.DataCompetencia = dataCompetencia;
    }
}
