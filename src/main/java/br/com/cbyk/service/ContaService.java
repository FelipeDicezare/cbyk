package br.com.cbyk.service;

import br.com.cbyk.dto.AlterarContaRequest;
import br.com.cbyk.dto.AlterarSituacaoContaRequest;
import br.com.cbyk.dto.BuscarContasRequest;
import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.dto.CustomPage;
import br.com.cbyk.dto.SomarContasRequest;

import java.math.BigDecimal;
import java.util.UUID;

public interface ContaService {

    ContaResponse findById(UUID id) throws Exception;

    UUID cadastrar(CadastrarContaRequest request) throws Exception;

    void alterar(AlterarContaRequest request) throws Exception;

    void alterarSituacao(AlterarSituacaoContaRequest request) throws Exception;

    CustomPage<ContaResponse> buscarComFiltro(BuscarContasRequest request) throws Exception;

    BigDecimal somarValorPorPeriodo(SomarContasRequest request) throws Exception;

}
