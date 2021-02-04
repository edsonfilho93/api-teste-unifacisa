package br.com.unifacisa.desafio.servico;

import br.com.unifacisa.desafio.dominio.Conta;
import br.com.unifacisa.desafio.dominio.Transacao;
import br.com.unifacisa.desafio.repositorio.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TransacaoServico {

    @Autowired
    private TransacaoRepositorio transacaoRepositorio;

    @Autowired
    private ContaServico contaServico;

    public List<Transacao> listar() {
        List<Transacao> lista = transacaoRepositorio.findAll();
        return lista;
    }

    public Transacao depositar(Transacao transacao) {
        Conta conta = validarContaCadastrada(transacao.getConta());

        Double novoSaldo = conta.getSaldo() + transacao.getValor();
        conta.setSaldo(novoSaldo);

        contaServico.salvar(conta);

        return transacaoRepositorio.save(transacao);
    }

    public Transacao sacar(Transacao transacao) {
        Conta conta = validarContaCadastrada(transacao.getConta());

        if (conta.getLimiteSaqueDiario() - transacao.getValor() < 0)
            throw new RuntimeException("O valor excede o limite diário para saques!");

        if (conta.getSaldo() - transacao.getValor() < 0)
            throw new RuntimeException("A conta não possui saldo suficiente para o saque!");

        Double novoLimiteSaque = conta.getLimiteSaqueDiario() - transacao.getValor();
        conta.setLimiteSaqueDiario(novoLimiteSaque);

        Double novoSaldo = conta.getSaldo() - transacao.getValor();
        conta.setSaldo(novoSaldo);

        contaServico.salvar(conta);

        return transacaoRepositorio.save(transacao);
    }

    public List<Transacao> gerarExtrato(Integer idConta) {
        Conta conta = contaServico.obterPorId(idConta);
        return transacaoRepositorio.findByConta(conta);
    }

    private Conta validarContaCadastrada(Conta conta) {
        return contaServico.obterPorId(conta.getIdConta());
    }
}
