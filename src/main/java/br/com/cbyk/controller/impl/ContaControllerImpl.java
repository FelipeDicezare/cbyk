package br.com.cbyk.controller.impl;

import br.com.cbyk.controller.ContaController;
import br.com.cbyk.dto.AlterarContaRequest;
import br.com.cbyk.dto.AlterarSituacaoContaRequest;
import br.com.cbyk.dto.BuscarContasRequest;
import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.dto.CustomPage;
import br.com.cbyk.dto.SomarContasRequest;
import br.com.cbyk.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/conta")
public class ContaControllerImpl implements ContaController {

    private final ContaService contaService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastrar(@RequestBody CadastrarContaRequest request) throws Exception {
        contaService.cadastrar(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity alterar(@RequestBody AlterarContaRequest request) throws Exception {
        contaService.alterar(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @PatchMapping(value = "/situacao", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity alterarSituacao(@RequestBody AlterarSituacaoContaRequest request) throws Exception {
        contaService.alterarSituacao(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContaResponse> buscar(@PathVariable UUID id) throws Exception {
        return new ResponseEntity(contaService.findById(id), HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/filtros", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomPage<ContaResponse>> buscarComFiltro(@RequestBody BuscarContasRequest request) throws Exception {
        return new ResponseEntity(contaService.buscarComFiltro(request), HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/somatoria", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> somarValorComFiltro(@RequestBody SomarContasRequest request) throws Exception {
        return new ResponseEntity(contaService.somarValorPorPeriodo(request), HttpStatus.OK);
    }

}
