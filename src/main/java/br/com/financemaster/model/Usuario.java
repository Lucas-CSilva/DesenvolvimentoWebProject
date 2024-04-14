package br.com.financemaster.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import br.com.financemaster.model.systemenums.UserRoleEnum;

@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String login;
    private String senha;
    private UserRoleEnum role;
    
    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_cartao",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","cartaoId"},
                        name = "unique_usuario_cartao"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "cartaoId",
                        referencedColumnName = "id",
                        table = "cartao",
                        unique = false
                    )
                )
    private List<Cartao> cartoes = new ArrayList<Cartao>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_conta",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","contabancariaId"},
                        name = "unique_usuario_conta"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "contabancariaId",
                        referencedColumnName = "id",
                        table = "contabancaria",
                        unique = false
                    )
                )
    private List<ContaBancaria> contas = new ArrayList<ContaBancaria>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_gastofixo",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","gastofixoId"},
                        name = "unique_usuario_gastofixo"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "gastofixoId",
                        referencedColumnName = "id",
                        table = "gastofixo",
                        unique = false
                    )
                )
    private List<GastoFixo> gastosFixos = new ArrayList<GastoFixo>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_gastovariavel",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","gastovariavelId"},
                        name = "unique_usuario_gastovariavel"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "gastovariavelId",
                        referencedColumnName = "id",
                        table = "gastovariavel",
                        unique = false
                    )
                )
    private List<GastoVariavel> gastosVariaveis = new ArrayList<GastoVariavel>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_rendafixa",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","rendafixaId"},
                        name = "unique_usuario_rendafixa"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "rendafixaId",
                        referencedColumnName = "id",
                        table = "rendafixa",
                        unique = false
                    )
                )
    private List<RendaFixa> rendasFixas = new ArrayList<RendaFixa>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_rendavariavel",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","rendavariavelId"},
                        name = "unique_usuario_rendavariavel"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "rendavariavelId",
                        referencedColumnName = "id",
                        table = "rendavariavel",
                        unique = false
                    )
                )
    private List<RendaVariavel> rendasVariaveis = new ArrayList<RendaVariavel>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "usuario_historico",
                uniqueConstraints = @UniqueConstraint
                    (
                        columnNames = {"usuarioId","historicoId"},
                        name = "unique_usuario_historico"
                    ),
                    joinColumns = @JoinColumn(
                        name = "usuarioId",
                        referencedColumnName = "id",
                        table = "usuario",
                        unique = false
                    ),
                    inverseJoinColumns = @JoinColumn(
                        name = "historicoId",
                        referencedColumnName = "id",
                        table = "historico",
                        unique = false
                    )
                )
    private List<Historico> historicos = new ArrayList<Historico>();

    public Usuario()
    {

    }

    public Usuario(String login, String senha, UserRoleEnum role)
    {
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(String login, String senha, String nome, UserRoleEnum role)
    {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.role = role;
    }
    public UserRoleEnum getRole() {
        return role;
    }
    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // O Spring Security já tem algumas roles implementadas. Repare que 
        // nesse método o retorno é uma colection, então cada usuário pode ter
        // vários papéis (roles). Por exemplo, um ADMIN é ao mesmo tempo USER
        // norma. Um CHEFE é ao mesmo tempo ADMIN e USER normal, ...
        if (this.role == UserRoleEnum.USER){
            return List.of(            
                new SimpleGrantedAuthority("ROLE_USER")     // é ao mesmo tempo user normal
                );
        }else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getPassword() {
        return this.getSenha();
    }
    @Override
    public String getUsername() {
        return this.getLogin();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
