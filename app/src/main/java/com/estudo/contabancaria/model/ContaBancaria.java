package com.estudo.contabancaria.model;

import java.util.Random;

public abstract class ContaBancaria {
    private String cliente;
    private int num_conta;
    private float saldo;
    Random rnd = new Random();
    public ContaBancaria(){
        super();
        num_conta = rnd.nextInt(10);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float sacar(float valor){
        if((getSaldo() - valor) < 0){
            return 0f;
        } else {
            setSaldo(getSaldo() - valor);
            return getSaldo();
        }

    }

    public float depositar(float valor){
        setSaldo(getSaldo() + valor);
        return getSaldo();
    }
}
