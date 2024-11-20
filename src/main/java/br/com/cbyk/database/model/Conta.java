package br.com.cbyk.database.model;

import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.enums.SituacaoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "data_vencimento")
    private LocalDateTime dataVencimento;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private SituacaoEnum situacao;

    public static ContaResponse rowMapper(Conta conta) {
        return ContaResponse.builder()
                .id(conta.getId())
                .dataVencimento(conta.getDataVencimento())
                .dataPagamento(conta.getDataPagamento())
                .valor(conta.getValor())
                .descricao(conta.getDescricao())
                .situacao(conta.getSituacao())
                .build();
    }

}
