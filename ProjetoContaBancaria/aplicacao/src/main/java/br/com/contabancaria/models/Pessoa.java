package br.com.contabancaria.models;

public class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String profissao;

    public Pessoa(String nome, String cpf, String endereco, String profissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() +
                "\nEndereco: " + this.getEndereco() +
                "\nProfissao: " + this.getProfissao();
    }
}
