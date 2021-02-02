package br.com.unifacisa.desafio.servico.mapper;

import br.com.unifacisa.desafio.dominio.Pessoa;
import br.com.unifacisa.desafio.servico.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PessoaMapper extends EntityMapper<PessoaDTO, Pessoa>{
}
