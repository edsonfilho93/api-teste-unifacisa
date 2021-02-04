package br.com.unifacisa.desafio.repositorio;

import br.com.unifacisa.desafio.dominio.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Integer> {
}
