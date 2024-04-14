package br.com.financemaster.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

@Entity
public class Historico {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_historico",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","historicoId"},
                        name = "unique_usuario_historico"
                    ),
                    joinColumns = @JoinColumn(
                        name = "historicoId",
                        referencedColumnName = "id",
                        table = "historico",
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

    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "historico_projecao",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId","projecaoId"},
                    name = "unique_historico_projecao"
                ),
                joinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "projecaoId",
                    referencedColumnName = "id",
                    table = "projecaofinanceira",
                    unique = false
                )
                )
    private List<ProjecaoFinanceira> projecoes = new ArrayList<ProjecaoFinanceira>();
    
    @ManyToMany
    @JoinTable (name = "historico_rendafixa",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "rendafixaId"},
                    name = "unique_historico_rendafixa"
                ),
                joinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "rendafixaId",
                    referencedColumnName = "id",
                    table = "rendafixa",
                    unique = false
                )
                )
    private List<RendaFixa> rendasFixas = new ArrayList<RendaFixa>();

    @ManyToMany
    @JoinTable (name = "historico_rendavariavel",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "rendavariavelId"},
                    name = "unique_historico_rendavariavel"
                ),
                joinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "rendavariavelId",
                    referencedColumnName = "id",
                    table = "rendavariavel",
                    unique = false
                )
                )
    private List<RendaVariavel> rendasVariaveis = new ArrayList<RendaVariavel>();

    @ManyToMany
    @JoinTable (name = "historico_gastofixo",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "gastofixoId"},
                    name = "unique_historico_gastofixo"
                ),
                joinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "gastofixoId",
                    referencedColumnName = "id",
                    table = "gastofixo",
                    unique = false
                )
                )
    private List<GastoFixo> gastosFixos = new ArrayList<GastoFixo>();

    @ManyToMany
    @JoinTable (name = "historico_gastovariavel",
                uniqueConstraints = @UniqueConstraint
                (
                    columnNames = {"historicoId", "gastovariavelId"},
                    name = "unique_historico_gastovariavel"
                ),
                joinColumns = @JoinColumn
                (
                    name = "historicoId",
                    referencedColumnName = "id",
                    table = "historico",
                    unique = false
                ),
                inverseJoinColumns = @JoinColumn
                (
                    name = "gastovariavelId",
                    referencedColumnName = "id",
                    table = "gastovariavel",
                    unique = false
                )
                )
    private List<GastoVariavel> gastosVariaveis = new ArrayList<GastoVariavel>();

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
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public List<ProjecaoFinanceira> getProjecoes() {
        return projecoes;
    }
    public void setProjecoes(List<ProjecaoFinanceira> projecoes) {
        this.projecoes = projecoes;
    }
    public List<RendaFixa> getRendasFixas() {
        return rendasFixas;
    }
    public void setRendasFixas(List<RendaFixa> rendasFixas) {
        this.rendasFixas = rendasFixas;
    }
    public List<RendaVariavel> getRendasVariaveis() {
        return rendasVariaveis;
    }
    public void setRendasVariaveis(List<RendaVariavel> rendasVariaveis) {
        this.rendasVariaveis = rendasVariaveis;
    }
    public List<GastoFixo> getGastosFixos() {
        return gastosFixos;
    }
    public void setGastosFixos(List<GastoFixo> gastosFixos) {
        this.gastosFixos = gastosFixos;
    }
    public List<GastoVariavel> getGastosVariaveis() {
        return gastosVariaveis;
    }
    public void setGastosVariaveis(List<GastoVariavel> gastosVariaveis) {
        this.gastosVariaveis = gastosVariaveis;
    }
    
}
