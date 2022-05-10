package com.mercado.carteira.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="usuario")
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int identificador;

    @Column(nullable = false)
    private String nome;

    @Column()
    private String sobrenome;

    @Column(nullable = false)
    private String senha;

    @OneToMany
    private List<CarteiraModel> carteiras;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<CarteiraModel> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(List<CarteiraModel> carteiras) {
        this.carteiras = carteiras;
    }
}
