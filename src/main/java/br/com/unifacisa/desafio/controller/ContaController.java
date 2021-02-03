package br.com.unifacisa.desafio.controller;

import br.com.unifacisa.desafio.dominio.Conta;
import br.com.unifacisa.desafio.servico.ContaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaServico contaServico;

    @GetMapping
    public ResponseEntity<List<Conta>> listar() {
        List<Conta> lista = contaServico.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> consultarSaldo(@PathVariable Integer id) {
        Conta conta = contaServico.obterPorId(id);
        return ResponseEntity.ok("O saldo da conta é R$ ".concat(conta.getSaldo().toString()));
    }

    @PostMapping
    public ResponseEntity<Conta> salvar(@RequestBody Conta conta) throws Exception {
        contaServico.salvar(conta);
        return ResponseEntity.created(new URI("/api/contas")).build();
    }

    @PutMapping("/bloquear-conta/{id}")
    public ResponseEntity<Conta> bloquearConta(@PathVariable Integer id) {
        Conta conta = contaServico.bloquearConta(id);
        return ResponseEntity.ok(conta);
    }
}
