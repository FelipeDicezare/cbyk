package br.com.cbyk.controller;

import br.com.cbyk.dto.AlterarContaRequest;
import br.com.cbyk.dto.AlterarSituacaoContaRequest;
import br.com.cbyk.dto.BuscarContasRequest;
import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.dto.CustomPage;
import br.com.cbyk.dto.SomarContasRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.UUID;

@Validated
@Tag(name = "ContasAPagar", description = "CBYK - ContasAPagar Controller")
public interface ContaController {

    @Operation(summary = "Cadastrar conta a pagar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "HttpStatus 400 = Falha de negocio.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Se não encontrou dado(s)", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity cadastrar(@NotNull @Valid CadastrarContaRequest request) throws Exception;

    @Operation(summary = "Alterar conta a pagar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "HttpStatus 400 = Falha de negocio.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Se não encontrou dado(s)", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity alterar(@NotNull @Valid AlterarContaRequest request) throws Exception;

    @Operation(summary = "Alterar conta a pagar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "HttpStatus 400 = Falha de negocio.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "404", description = "Se não encontrou dado(s)", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity alterarSituacao(@NotNull @Valid AlterarSituacaoContaRequest request) throws Exception;

    @Operation(description = "Buscar uma conta a pagar específica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve erro na consulta", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity<ContaResponse> buscar(@Parameter(description = "Identificador único do registro de conta a pagar", required = true)
                                         @NotNull(message = "ID may not be empty") UUID id) throws Exception;

    @Operation(description = "Buscar uma lista de contas a pagar, com filtro de data de vencimento e descrição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve erro na consulta", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity<CustomPage<ContaResponse>> buscarComFiltro(@NotNull @Valid BuscarContasRequest request) throws Exception;

    @Operation(description = "Obter valor total pago por período")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve erro na consulta", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity<BigDecimal> somarValorComFiltro(@NotNull @Valid SomarContasRequest request) throws Exception;

}
