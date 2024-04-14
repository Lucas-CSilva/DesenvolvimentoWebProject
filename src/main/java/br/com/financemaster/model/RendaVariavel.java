package br.com.financemaster.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
// @DiscriminatorValue("RendaVariavel")
public class RendaVariavel extends Renda{

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_rendavariavel",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","rendavariavelId"},
                        name = "unique_usuario_rendavariavel"
                    ),
                    joinColumns = @JoinColumn(
                        name = "rendavariavelId",
                        referencedColumnName = "id",
                        table = "rendavariavel",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    )
                )
    private Usuario usuario = new Usuario();

    @ManyToMany
    @JoinTable (name = "historico_rendavariavel",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "rendavariavelId"},
                    name = "unique_historico_rendavariavel"
                ),
                joinColumns = @JoinColumn
                (
                    name = "rendavariavelId",
                    referencedColumnName = "id",
                    table = "rendavariavel",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                )
                )
    private List<Historico> historicos = new ArrayList<Historico>();

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
    
    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
