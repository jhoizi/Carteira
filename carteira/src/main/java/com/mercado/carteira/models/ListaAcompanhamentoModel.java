package com.mercado.carteira.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lista_acompanhamento")
public class ListaAcompanhamentoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private short visibilidade;

    @OneToMany
    private List<AtivoModel> ativos;

    @ManyToOne
    private UsuarioModel usuario;

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

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

    public List<AtivoModel> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<AtivoModel> ativos) {
        this.ativos = ativos;
    }

    public short getVisibilidade() {
        return visibilidade;
    }

    public void setVisibilidade(short visibilidade) {
        this.visibilidade = visibilidade;
    }
}
