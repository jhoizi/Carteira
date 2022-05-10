package com.mercado.carteira.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="carteira")
public class CarteiraModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private short visibilidade;

    @OneToMany
    private List<OperacaoModel> operacoes;

    @ManyToOne
    private UsuarioModel usuario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<OperacaoModel> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<OperacaoModel> operacoes) {
        this.operacoes = operacoes;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public short getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(short visibilidade) {
        this.visibilidade = visibilidade;
    }
}
