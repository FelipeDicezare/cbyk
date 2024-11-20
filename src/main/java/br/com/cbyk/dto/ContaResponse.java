package br.com.cbyk.dto;

import br.com.cbyk.enums.SituacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaResponse implements Serializable {

    @Schema(description = "O identificador único do registro de conta a pagar")
    private UUID id;

    @Schema(description = "A data de vencimento (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataVencimento;

    @Schema(description = "A data de pagamento (ANO-MES-DIA HORA:MINUTO:SEGUNDO)", example = "2024-11-01 16:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataPagamento;

    @Schema(description = "O valor da conta a pagar")
    private BigDecimal valor;

    @Schema(description = "A descrição da conta a pagar")
    private String descricao;

    @Schema(description = "A situação da conta a pagar (PAGA, AGUARDANDO ou CANCELADA)")
    private SituacaoEnum situacao;

}
