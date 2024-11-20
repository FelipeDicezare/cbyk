package br.com.cbyk.database.repository;

import br.com.cbyk.database.model.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {

    @Query(value = "SELECT e FROM Conta e WHERE e.descricao LIKE CONCAT('%',:descricao,'%') "
            + "AND e.dataVencimento BETWEEN :dataVencimentoInicial AND :dataVencimentoFinal")
    Page<Conta> findByDescricaoAndBetweenDataVencimento(@Param("descricao") String descricao,
                                                        @Param("dataVencimentoInicial") LocalDateTime dataVencimentoInicial,
                                                        @Param("dataVencimentoFinal") LocalDateTime dataVencimentoFinal,
                                                        Pageable page);

    @Query(value = "SELECT SUM(valor) FROM conta e WHERE e.data_pagamento BETWEEN :dataPagamentoInicial AND :dataPagamentoFinal", nativeQuery = true)
    BigDecimal somarValoresDePagamentoPorPeriodo(@Param("dataPagamentoInicial") LocalDateTime dataPagamentoInicial, @Param("dataPagamentoFinal") LocalDateTime dataPagamentoFinal);

}
