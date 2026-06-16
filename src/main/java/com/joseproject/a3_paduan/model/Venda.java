/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joseproject.a3_paduan.model;

/**
 *
 * @author Usuario
 */
public class Venda {
    private int idVenda;
    private Cliente cliente;
    private TipoDeBanana tipoDeBanana;
    private int qtdeCaixas;
    private double precoUni;
    private double valorTotal;

    public Venda() {
    }

    public Venda(int idVenda, Cliente cliente, TipoDeBanana tipoDeBanana, int qtdeCaixas, double precoUni) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.tipoDeBanana = tipoDeBanana;
        this.qtdeCaixas = qtdeCaixas;
        this.precoUni = precoUni;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public double getPrecoUni() {
        return precoUni;
    }

    public int getQtdeCaixas() {
        return qtdeCaixas;
    }

    public TipoDeBanana getTipoDeBanana() {
        return tipoDeBanana;
    }

    public double getValorTotal() {
        return qtdeCaixas * precoUni;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setPrecoUni(double precoUni) {
        this.precoUni = precoUni;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setQtdeCaixas(int qtdeCaixas) {
        this.qtdeCaixas = qtdeCaixas;
    }

    public void setTipoDeBanana(TipoDeBanana tipoDeBanana) {
        this.tipoDeBanana = tipoDeBanana;
    }
    
    @Override
    public String toString() {
        return "Venda{" +
            "idVenda=" + idVenda +
            ", cliente=" + cliente +
            ", tipoDeBanana=" + tipoDeBanana +
            ", quantidadeCaixas=" + qtdeCaixas +
            ", precoUnitario=" + precoUni +
            ", valorTotal=" + valorTotal +
            '}';
}
}
