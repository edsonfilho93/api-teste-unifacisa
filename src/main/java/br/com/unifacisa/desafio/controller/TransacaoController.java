package br.com.unifacisa.desafio.controller;

import br.com.unifacisa.desafio.dominio.Conta;
import br.com.unifacisa.desafio.dominio.Transacao;
import br.com.unifacisa.desafio.servico.TransacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoServico transacaoServico;

    @GetMapping
    public ResponseEntity<List<Transacao>> listar() {
        List<Transacao> lista = transacaoServico.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("/depositar")
    public ResponseEntity<Transacao> depositar(@RequestBody Transacao transacao) throws Exception {
        Transacao transacaoAux = transacaoServico.depositar(transacao);
        return ResponseEntity.ok(transacaoAux);
    }

    @PutMapping("/sacar")
    public ResponseEntity<Transacao> sacar(@RequestBody Transacao transacao) throws Exception {
        Transacao transacaoAux = transacaoServico.sacar(transacao);
        return ResponseEntity.ok(transacaoAux);
    }

    @GetMapping("/extrato/{idConta}")
    public ResponseEntity<List<Transacao>> gerarExtratoTransacoes(@PathVariable Integer idConta) throws Exception {
        List<Transacao> lista = transacaoServico.gerarExtrato(idConta);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
