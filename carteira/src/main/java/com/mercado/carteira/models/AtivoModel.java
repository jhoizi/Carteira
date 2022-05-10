package com.mercado.carteira.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ativo")
public class AtivoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column
    private int quantidade;

    @Column
    private double gatilho;

    @Column(nullable = false)
    private String posicao;

    @Column
    private double ganho;

    @Column
    private double perca;

    @ManyToOne
    private ListaAcompanhamentoModel lista;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getGatilho() {
        return gatilho;
    }

    public void setGatilho(double gatilho) {
        this.gatilho = gatilho;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getGanho() {
        return ganho;
    }

    public void setGanho(double ganho) {
        this.ganho = ganho;
    }

    public double getPerca() {
        return perca;
    }

    public void setPerca(double perca) {
        this.perca = perca;
    }

    public ListaAcompanhamentoModel getLista() {
        return lista;
    }

    public void setLista(ListaAcompanhamentoModel lista) {
        this.lista = lista;
    }
}
