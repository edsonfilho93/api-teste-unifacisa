package br.com.unifacisa.desafio.servico.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PessoaDTO implements Serializable {

    private Integer idPessoa;

    private String nome;

    @NotNull(message = "O cpf não pode ser nulo")
    private String cpf;

    private String dataNascimento;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
