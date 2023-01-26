package br.com.contabancaria.aplicacao;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.contabancaria.models.Conta;
import br.com.contabancaria.models.ContaCorrente;
import br.com.contabancaria.models.ContaPoupanca;
import br.com.contabancaria.models.Pessoa;
import br.com.contabancaria.utilitarios.Utils;

@SpringBootApplication
public class AplicacaoApplication {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        SpringApplication.run(AplicacaoApplication.class, args);

        int op;
        int oc;
        ContaCorrente cc = null;
        ContaPoupanca cp = null;
        contasBancarias = new ArrayList<Conta>();

        System.out.println("\nSeja bem vindo!\nEscolha uma opção para continuarmos!\n");

        do {
            System.out.println("1 - Criar conta");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Visualizar Saldo");
            System.out.println("5 - Listar Contas");
            System.out.println("6 - Sair do programa");

            op = input.nextInt();

            if (op == 1) {
                // Cria a Conta

                System.out.println("\nQual tipo de conta deseja criar: \n1 - Corrente \n2 - Poupanca \n3 - Cancelar");
                oc = input.nextInt();

                if (oc == 3) {
                    System.exit(0);
                }

                System.out.println("\nNome: ");
                String nome = input.next();

                System.out.println("\nCPF: ");
                String cpf = input.next();

                System.out.println("\nEndereco: ");
                String endereco = input.next();

                System.out.println("\nProfissao: ");
                String profissao = input.next();

                Pessoa pessoa = new Pessoa(nome, cpf, endereco, profissao);

                ContaCorrente contaC = new ContaCorrente(pessoa);
                ContaPoupanca contaP = new ContaPoupanca(pessoa);

                if (oc == 1) {
                    cc = new ContaCorrente(pessoa);
                    contasBancarias.add(contaC);
                    cc.setTipoConta("Conta Corrente");
                    System.out.println("\n*** Parabéns! Sua conta foi criada com sucesso! *** \n");
                } else if (oc == 2) {
                    cp = new ContaPoupanca(pessoa);
                    contasBancarias.add(contaP);
                    cp.setTipoConta("Conta Poupanca");
                    System.out.println("\n*** Parabéns! Sua conta foi criada com sucesso! *** \n");
                }
            } else if (op == 2) {
                // Saca dinheiro da conta corrente ou da conta poupanca

                System.out.println("Deseja sacar da conta \n1 - Corrente \n2 - Poupanca \n3 - Cancelar");
                oc = input.nextInt();
                if (oc == 1) {
                    System.out.println("Qual o valor deseja sacar?");
                    Double valorSaque = input.nextDouble();
                    if (valorSaque > cc.getLimite()) {
                        System.out.println("Não é possível efetuar um saque a cima do limite determinado!");
                    } else {
                        cc.sacar(valorSaque);
                    }
                } else if (oc == 2) {
                    System.out.println("Qual o valor deseja sacar?");
                    Double valorSaque = input.nextDouble();
                    cp.sacar(valorSaque);
                } else if (oc == 3) {
                } else {
                    System.out.println("Opcao onvalida!");
                }
            } else if (op == 3) {
                // Deposita dinheiro na conta corrente ou na conta poupança

                System.out.println("Deseja depositar na conta \n1 - Corrente \n2 - Poupanca \n3 - Cancelar");
                oc = input.nextInt();
                if (oc == 1) {
                    System.out.println("Qual o valor deseja depositar?");
                    Double valorDeposito = input.nextDouble();
                    cc.depositar(valorDeposito);
                } else if (oc == 2) {
                    System.out.println("Qual o valor deseja depositar?");
                    Double valorDeposito = input.nextDouble();
                    cp.depositar(valorDeposito);
                } else if (oc == 3) {
                } else {
                    System.out.println("Não foi possível efetuar o depósito!");
                }

            } else if (op == 4) {
                // Verifica o saldo da conta que foi escolhida

                System.out.println("Digite o número da conta: ");
                System.out.println("Qual tipo da conta? \n1 - Corrente \n2 - Poupanca \n3 - Cancelar");
                oc = input.nextInt();
                if (oc == 1) {
                    System.out.println("Seu saldo da conta corrente é de: " + Utils.doubleToString(cc.getSaldo()));
                } else if (oc == 2) {
                    System.out.println("Seu saldo da poupanca é de: " + Utils.doubleToString(cp.getSaldo()));
                } else {
                    System.out.println("Opcao invalida!");
                }
            } else if (op == 5) {
                // Lista as contas criadas durante a aplicação

                listarContas();
            } else if (op == 6) {
                // Sai da aplicação

                System.out.println("Obrigado por escolher a nossa agência, volte semrpe!");
                System.exit(0);
            }

        } while (op != 6);
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumero() == numeroConta);
                conta = c;
            }
        }
        return conta;
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
    }
}
