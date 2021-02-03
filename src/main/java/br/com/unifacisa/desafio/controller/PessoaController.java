package br.com.unifacisa.desafio.controller;

import br.com.unifacisa.desafio.dominio.Pessoa;
import br.com.unifacisa.desafio.servico.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServico pessoaServico;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> lista = pessoaServico.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@Valid @RequestBody Pessoa pessoaDTO) throws Exception {
        pessoaServico.salvar(pessoaDTO);
        return ResponseEntity.created(new URI("api/pessoas")).build();
    }
}
