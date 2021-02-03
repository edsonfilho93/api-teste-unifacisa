package br.com.unifacisa.desafio.servico;


import br.com.unifacisa.desafio.dominio.Conta;
import br.com.unifacisa.desafio.repositorio.ContaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServico {

    @Autowired
    ContaRepositorio contaRepositorio;

    public List<Conta> listar() {
        List<Conta> lista = contaRepositorio.findAll();
        return lista;
    }

    public Conta salvar(Conta conta) {
        return contaRepositorio.save(conta);
    }

    public Conta obterPorId(Integer id) {
        return contaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não cadastrada!"));

    }
}
