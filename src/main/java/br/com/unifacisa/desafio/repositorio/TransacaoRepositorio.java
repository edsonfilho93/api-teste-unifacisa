package br.com.unifacisa.desafio.repositorio;

import br.com.unifacisa.desafio.dominio.Conta;
import br.com.unifacisa.desafio.dominio.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Integer> {

    List<Transacao> findByConta(Conta conta);
}
