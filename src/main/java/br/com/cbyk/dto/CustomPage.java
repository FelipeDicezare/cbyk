package br.com.cbyk.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomPage<T> {

    @Schema(description = "O conteúdo da consulta com os registros")
    private List<T> registros;

    @Schema(description = "A página atual")
    private int paginaAtual;

    @Schema(description = "O total de registros por consulta")
    private int totalItemsPorPagina;

    @Schema(description = "A quantidade de páginas disponíveis")
    private int totalPaginas;

    @Schema(description = "O total de registros na base de dados")
    private long totalItems;

}
