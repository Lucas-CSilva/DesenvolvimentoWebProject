package br.com.financemaster.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;

@Entity
// @DiscriminatorValue("RendaFixa")
public class RendaFixa extends Renda{
 
    private LocalDate DataCompetencia;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_rendafixa",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","rendafixaId"},
                        name = "unique_usuario_rendafixa"
                    ),
                    joinColumns = @JoinColumn(
                        name = "rendafixaId",
                        referencedColumnName = "id",
                        table = "rendafixa",
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
    @JoinTable (name = "historico_rendafixa",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "rendafixaId"},
                    name = "unique_historico_rendafixa"
                ),
                joinColumns = @JoinColumn
                (
                    name = "rendafixaId",
                    referencedColumnName = "id",
                    table = "rendafixa",
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

    public LocalDate getDataCompetencia() {
        return DataCompetencia;
    }

    public void setDataCompetencia(LocalDate dataCompetencia) {
        this.DataCompetencia = dataCompetencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    
}
