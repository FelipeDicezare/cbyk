package br.com.cbyk.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadCsvRequest {

    @Schema(description = "O nome do arquivo", required = true, example = "file.csv")
    private String filename;

    @Schema(description = "O conteúdo do arquivo", required = true)
    private byte[] content;

}
