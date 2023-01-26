package br.com.contabancaria.models;

import br.com.contabancaria.utilitarios.Utils;

public class ContaPoupanca extends Conta {
    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo;

    public ContaPoupanca(Pessoa pessoa) {
        setTaxa(0);
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nNumero da Agência: " + this.getNumeroAgencia() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEndereco: " + this.pessoa.getEndereco() +
                "\nProfissao: " + this.pessoa.getProfissao() +
                "\n";
    }
}
