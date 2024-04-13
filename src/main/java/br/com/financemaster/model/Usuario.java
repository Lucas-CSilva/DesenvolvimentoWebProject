package br.com.financemaster.model;

import java.io.Serializable;
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

    private String email;
    private String senha;
    private String nome;
    private String CPF;
    private String login;
    private UserRoleEnum role;
    

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
    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY)
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
    // private List<RendaFixa> rendaFixa;
    
    // 
    // @OneToMany(mappedBy = "usuario", orphanRemoval = true, cascade = CascadeType.ALL)
    // private List<Telefone> telefones = new ArrayList<Telefone>();

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
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cPF) {
        this.CPF = cPF;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
        // TODO Auto-generated method stub
        return this.getSenha();
    }
    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return this.getLogin();
    }
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
    
    //TODO LUCASSILVA - remover
    // public List<Telefone> getTelefones() {
    //     return telefones;
    // }
    // public void setTelefones(List<Telefone> telefones) {
    //     this.telefones = telefones;
    // } 
}
