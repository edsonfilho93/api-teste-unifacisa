package br.com.unifacisa.desafio.repositorio;

import br.com.unifacisa.desafio.dominio.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ContaRepositorio extends JpaRepository<Conta, Integer> {
}
