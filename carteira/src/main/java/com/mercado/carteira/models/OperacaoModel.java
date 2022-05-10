package com.mercado.carteira.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="operacao")
public class OperacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int codigo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String posicao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String dataEntrada;

    @Column
    private String dataZeragem;

    @Column(nullable = false)
    private String ativo;

    @Column(nullable = false)
    private double precoEntrada;

    @Column
    private double precoZeragem;

    @Column(nullable = false)
    private int quantidade;

    @Column
    private double ganho;

    @Column
    private double perca;

    @ManyToOne
    private CarteiraModel carteira;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataZeragem() {
        return dataZeragem;
    }

    public void setDataZeragem(String dataZeragem) {
        this.dataZeragem = dataZeragem;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public double getPrecoEntrada() {
        return precoEntrada;
    }

    public void setPrecoEntrada(double precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    public double getPrecoZeragem() {
        return precoZeragem;
    }

    public void setPrecoZeragem(double precoZeragem) {
        this.precoZeragem = precoZeragem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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

    public CarteiraModel getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraModel carteira) {
        this.carteira = carteira;
    }
}
