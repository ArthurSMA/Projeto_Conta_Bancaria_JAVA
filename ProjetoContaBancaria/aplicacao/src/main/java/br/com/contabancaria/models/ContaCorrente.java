package br.com.contabancaria.models;

public class ContaCorrente extends Conta {
    private static int contadorDeContas = 1;

    private String tipoConta = "Conta Corrente";
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo;

    public ContaCorrente(Pessoa pessoa) {
        setLimite(1000);
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
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
            System.out.println("\n***Seu depósito foi realizado com êxito!*** \n");
        } else {
            System.out.println("\n***Não foi possível realizar o depósito!\n");
        }
    }

    public void sacar(Double valor) {
        double juros = getSaldo() * 0.10 * getMeses();

        if (valor > getSaldo() + getLimite()) {
            System.out.println("Não foi possível realizar o saque!");
        } else {
            setSaldo(juros - valor);
            System.out.println("Seu saque foi realizado com êxito!");
        }
    }

    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nNumero da Agência: " + this.getNumeroAgencia() +
                "\nTipo da conta: " + this.getTipoConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEndereco: " + this.pessoa.getEndereco() +
                "\nProfissao: " + this.pessoa.getProfissao() +
                "\n";
    }
}
