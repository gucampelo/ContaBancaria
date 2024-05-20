package com.estudo.contabancaria.model;

public class ContaEspecial extends ContaBancaria{

    private float limite;

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public ContaEspecial(){

        limite = getSaldo() * 1.1f;
    }

    @Override
    public float sacar(float valor) {
        setSaldo(getSaldo() + limite);
        float saldo = getSaldo();
        if(saldo - valor <= 0){
            return 0;
        }else {
            setSaldo(getSaldo() - valor);

            return getSaldo();
        }
    }
}
