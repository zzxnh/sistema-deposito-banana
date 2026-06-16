/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joseproject.a3_paduan.model;

/**
 *
 * @author Usuario
 */
public class TipoDeBanana {
    private int idTipoBanana;
    private String nomeTipoBanana;

    public TipoDeBanana() {
    }

    public TipoDeBanana(int idTipoBanana, String nomeTipoBanana) {
        this.idTipoBanana = idTipoBanana;
        this.nomeTipoBanana = nomeTipoBanana;
    }

    public int getIdTipoBanana() {
        return idTipoBanana;
    }

    public String getNomeTipoBanana() {
        return nomeTipoBanana;
    }

    public void setIdTipoBanana(int idTipoBanana) {
        this.idTipoBanana = idTipoBanana;
    }

    public void setNomeTipoBanana(String nomeTipoBanana) {
        this.nomeTipoBanana = nomeTipoBanana;
    }
    
    @Override
    public String toString() {
        return nomeTipoBanana;
    }

}
