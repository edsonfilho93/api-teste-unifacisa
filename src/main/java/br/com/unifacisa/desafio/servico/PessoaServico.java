package br.com.unifacisa.desafio.servico;

import br.com.unifacisa.desafio.dominio.Pessoa;
import br.com.unifacisa.desafio.repositorio.PessoaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServico {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;


    public List<Pessoa> listar() {
        List<Pessoa> lista = pessoaRepositorio.findAll();
        return lista;
    }

    public Pessoa salvar(Pessoa pessoa) {
        validarCpf(pessoa);

        Pessoa pessoaAux = pessoaRepositorio.save(pessoa);
        return pessoaAux;
    }

    private void validarCpf(Pessoa pessoa) {
        Pessoa pessoaAux = pessoaRepositorio.findByCpf(pessoa.getCpf());

        if (pessoaAux != null)
            throw new RuntimeException("CPF já cadastrado na base");
    }


}
