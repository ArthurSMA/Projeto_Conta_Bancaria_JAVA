package br.com.contabancaria.models;

public class Conta {
    private int contadorDeContas = 1;

    private String tipoConta;
    private String nomeCliente;
    private int numero;
    private int numeroAgencia = 90901;
    private int meses = 3;
    private double limite = 0.00;
    private double saldo = 0.00;
    private double juros;

    public int getContadorDeContas() {
        return contadorDeContas;
    }

    public void setContadorDeContas(int contadorDeContas) {
        this.contadorDeContas = contadorDeContas;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com êxito!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado com êxito!");
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }
}
