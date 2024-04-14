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
// @DiscriminatorValue("GastoVariavel")
public class GastoVariavel extends Gasto {
    
    private LocalDate DataInicio;
    private LocalDate DataFinal;
    private int Recorrencia;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_gastovariavel",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","gastovariavelId"},
                        name = "unique_usuario_gastovariavel"
                    ),
                    joinColumns = @JoinColumn(
                        name = "gastovariavelId",
                        referencedColumnName = "id",
                        table = "gastovariavel",
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
    @JoinTable (name = "historico_gastovariavel",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "gastovariavelId"},
                    name = "unique_historico_gastovariavel"
                ),
                joinColumns = @JoinColumn
                (
                    name = "gastovariavelId",
                    referencedColumnName = "id",
                    table = "gastovariavel",
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
