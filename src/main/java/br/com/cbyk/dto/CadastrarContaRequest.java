package br.com.cbyk.dto;

import br.com.cbyk.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarContaRequest implements Serializable {

    @NotNull(message = "O campo dataVencimento não pode estar nulo")
    @Schema(description = "A data de vencimento (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataVencimento;

    @Schema(description = "A data de pagamento (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataPagamento;

    @NotNull(message = "O campo valor não pode estar nulo")
    @Schema(description = "O valor da conta a pagar")
    private BigDecimal valor;

    @NotBlank(message = "A descricao não pode estar vazia ou nula")
    @Size(min = 2, max = 255, message = "A descrição deve ter pelo menos 2 e no máximo 255 caracteres")
    @Schema(description = "A descrição da conta a pagar")
    private String descricao;

    @NotNull(message = "O campo situacao não pode estar nulo")
    @Schema(description = "A situação da conta a pagar")
    private SituacaoEnum situacao;

}
