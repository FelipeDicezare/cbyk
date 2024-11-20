package br.com.cbyk.dto;

import br.com.cbyk.enums.SituacaoEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlterarSituacaoContaRequest implements Serializable {

    @NotNull(message = "O id não pode estar nulo")
    @Schema(description = "O identificador único do registro de conta a pagar", example = "c293708b-2e95-458c-8f03-7d5bd997f462", required = true)
    private UUID id;

    @NotNull(message = "A situacao não pode estar nulo")
    @Schema(description = "A situação da conta a pagar", example = "PAGA, AGUARDANDO ou CANCELADA", required = true)
    private SituacaoEnum situacao;

}
