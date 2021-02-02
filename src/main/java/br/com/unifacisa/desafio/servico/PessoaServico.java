package br.com.unifacisa.desafio.servico;

import br.com.unifacisa.desafio.dominio.Pessoa;
import br.com.unifacisa.desafio.repositorio.PessoaRepositorio;
import br.com.unifacisa.desafio.servico.dto.PessoaDTO;
import br.com.unifacisa.desafio.servico.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServico {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Autowired
    private PessoaMapper pessoaMapper;

    public List<PessoaDTO> listar() {
        List<Pessoa> lista = pessoaRepositorio.findAll();
        return pessoaMapper.toDto(lista);
    }

    public Pessoa salvar(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);

        validarCpf(pessoa);

        Pessoa pessoaAux = pessoaRepositorio.save(pessoa);
        return pessoaAux;
    }

    private void validarCpf(Pessoa pessoa) {
        Pessoa pessoaAux = pessoaRepositorio.findByCpf(pessoa.getCpf());

        if(pessoaAux != null)
            throw new RuntimeException("CPF já cadastrado na base");
    }


}
