package br.com.unifacisa.desafio.repositorio;

import br.com.unifacisa.desafio.dominio.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Integer> {
}
