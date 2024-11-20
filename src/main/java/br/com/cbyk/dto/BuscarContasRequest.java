package br.com.cbyk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuscarContasRequest implements Serializable {

    @NotNull(message = "O campo dataVencimentoInicial não pode estar nulo")
    @Schema(description = "A data de vencimento inicial para consulta (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataVencimentoInicial;

    @NotNull(message = "O campo dataVencimentoFinal não pode estar nulo")
    @Schema(description = "A data de vencimento final para consulta (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataVencimentoFinal;

    @Schema(description = "A descrição da conta a pagar")
    private String descricao;

    @NotNull(message = "O campo pagina não pode estar nulo")
    @Parameter(description = "A página desejada. A mesma começa com o valor 0.", required = true)
    private Integer pagina;

    @NotNull(message = "O campo limite não pode estar nulo")
    @Parameter(description = "O limite de registros por página", required = true)
    private Integer limite;

}
