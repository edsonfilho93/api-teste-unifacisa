package br.com.unifacisa.desafio.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @NotNull(message = "O Nome não pode ser nulo")
    @NotEmpty(message = "O Nome não pode ser vazio")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O Cpf não pode ser nulo")
    @NotEmpty(message = "O Cpf não pode ser vazio")
    @Column(name = "cpf")
    private String cpf;

    @NotNull(message = "a data de nascimento não pode ser nula")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
