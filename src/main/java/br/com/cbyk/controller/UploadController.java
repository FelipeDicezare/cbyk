package br.com.cbyk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

@Validated
@Tag(name = "ContasAPagarUpload", description = "CBYK - ContasAPagar Upload Controller")
public interface UploadController {

    @Operation(description = "Método responsável pelo upload de um arquivo csv para a importação dos registros para a base de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "HttpStatus 400 = Falha de negocio.", content = @Content),
            @ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
            @ApiResponse(responseCode = "403", description = "Privilégio insuficiente", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno sem causa mapeada", content = @Content)
    })
    ResponseEntity upload(@Parameter(description = "O arquivo para importação dos registros", required = true)
                          @NotNull(message = "csv não pode ser vazio") MultipartFile csv) throws Exception;

}
