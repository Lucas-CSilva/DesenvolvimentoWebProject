package br.com.financemaster.model;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("RendaFixa")
public class RendaFixa extends Renda{
 
    private LocalDate DataCompetencia;

    // @JsonIgnore
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinTable( name = "renda_fixa_usuario",
    //             uniqueConstraints = @UniqueConstraint (
    //                 columnNames = {"renda_fixa_id", "usuario_id"},
    //                 name = "unique_user_renda_fixa" 
    //             ),
    //             joinColumns = @JoinColumn (
    //                 name = "renda_fixa_id",
    //                 table = "rendafixa",
    //                 unique = false
    //             ),
    //             inverseJoinColumns = @JoinColumn (
    //                 name = "usuario_id",
    //                 referencedColumnName = "id",
    //                 table = "usuario",
    //                 unique = false
    //             )
    //  )
    // private Usuario usuario;



    // public Usuario getUsuario() {
    //     return usuario;
    // }

    // public void setUsuario(Usuario usuario) {
    //     this.usuario = usuario;
    // }

    public LocalDate getDataCompetencia() {
        return DataCompetencia;
    }

    public void setDataCompetencia(LocalDate dataCompetencia) {
        this.DataCompetencia = dataCompetencia;
    }
}
