package br.com.cbyk.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SomarContasRequest implements Serializable {

    @NotNull(message = "O campo dataPagamentoInicial não pode estar nulo")
    @Schema(description = "A data de pagamento inicial para consulta (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataPagamentoInicial;

    @NotNull(message = "O campo dataPagamentoFinal não pode estar nulo")
    @Schema(description = "A data de pagamento final para consulta (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataPagamentoFinal;

}
