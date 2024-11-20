package br.com.cbyk.service.impl;

import br.com.cbyk.database.model.Conta;
import br.com.cbyk.database.repository.ContaRepository;
import br.com.cbyk.dto.AlterarContaRequest;
import br.com.cbyk.dto.AlterarSituacaoContaRequest;
import br.com.cbyk.dto.BuscarContasRequest;
import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.dto.CustomPage;
import br.com.cbyk.dto.SomarContasRequest;
import br.com.cbyk.enums.SituacaoEnum;
import br.com.cbyk.service.ContaService;
import br.com.cbyk.useful.DateHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository repository;

    @Override
    public ContaResponse findById(UUID id) {
        Optional<Conta> optionalConta = repository.findById(id);
        if (optionalConta.isPresent()) {
            log.debug("A conta {} foi encontrada.", id);
            return Conta.rowMapper(optionalConta.get());
        }
        // TODO Add Tratamento de Exception com GlobalExceptionHandler por exemplo.
        log.debug("A conta {} não foi encontrada.", id);
        return null;
    }

    @Override
    public UUID cadastrar(CadastrarContaRequest request) {
        Conta conta = Conta.builder()
                .id(UUID.randomUUID())
                .dataVencimento(request.getDataVencimento())
                .dataPagamento(request.getDataPagamento())
                .valor(request.getValor())
                .descricao(request.getDescricao())
                .situacao(request.getSituacao())
                .build();
        repository.save(conta);
        log.debug("A conta {} foi cadastrada com suceso.", conta.getId());
        return conta.getId();
    }

    @Override
    public void alterar(AlterarContaRequest request) {
        Optional<Conta> optionalConta = repository.findById(request.getId());
        if (optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            conta.setDataVencimento(request.getDataVencimento());
            conta.setDataPagamento(request.getDataPagamento());
            conta.setValor(request.getValor());
            conta.setDescricao(request.getDescricao());
            conta.setSituacao(request.getSituacao());
            repository.save(conta);
            log.debug("A conta {} foi atualizada com suceso.", conta.getId());
        }
    }

    @Override
    public void alterarSituacao(AlterarSituacaoContaRequest request) {
        Optional<Conta> optionalConta = repository.findById(request.getId());
        if (optionalConta.isPresent()) {
            Conta conta = optionalConta.get();
            conta.setSituacao(request.getSituacao());
            if (conta.getDataPagamento() == null && request.getSituacao().compareTo(SituacaoEnum.PAGA) == 0) {
                conta.setDataPagamento(DateHelper.nowToTime());
            }
            repository.save(conta);
            log.debug("A conta {} teve a situação atualizada com suceso.", conta.getId());
        }
    }

    @Override
    public CustomPage<ContaResponse> buscarComFiltro(BuscarContasRequest request) {

        Pageable page = PageRequest.of(request.getPagina(), request.getLimite());

        Page<Conta> contas = repository.findByDescricaoAndBetweenDataVencimento(request.getDescricao(), request.getDataVencimentoInicial(), request.getDataVencimentoFinal(), page);
        List<ContaResponse> responses = new ArrayList<>();
        contas.forEach(conta -> responses.add(Conta.rowMapper(conta)));
        return CustomPage.<ContaResponse>builder()
                .registros(responses)
                .paginaAtual(request.getPagina())
                .totalItemsPorPagina(request.getLimite())
                .totalPaginas(contas.getTotalPages())
                .totalItems(contas.getTotalElements())
                .build();
    }

    @Override
    public BigDecimal somarValorPorPeriodo(SomarContasRequest request) {
        return repository.somarValoresDePagamentoPorPeriodo(request.getDataPagamentoInicial(), request.getDataPagamentoFinal());
    }

}
