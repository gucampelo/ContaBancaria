package com.estudo.contabancaria.model;

public class ContaPoupanca extends ContaBancaria {
    private int dia_rendimento;

    public int getDia_rendimento() {
        return dia_rendimento;
    }

    public void setDia_rendimento(int dia_rendimento) {
        this.dia_rendimento = dia_rendimento;
    }

    public ContaPoupanca(){
        super();
    }

    public double calcularNovoSaldo() {
        setSaldo(getSaldo() + (getSaldo() * 1.1f));
        return getSaldo();
    }
}