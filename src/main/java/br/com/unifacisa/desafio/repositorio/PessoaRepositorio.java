package br.com.unifacisa.desafio.repositorio;

import br.com.unifacisa.desafio.dominio.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer> {

    Pessoa findByCpf(String cpf);
}
