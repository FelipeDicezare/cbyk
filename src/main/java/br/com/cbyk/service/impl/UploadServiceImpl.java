package br.com.cbyk.service.impl;

import br.com.cbyk.database.model.Conta;
import br.com.cbyk.database.repository.ContaRepository;
import br.com.cbyk.enums.SituacaoEnum;
import br.com.cbyk.service.UploadService;
import br.com.cbyk.useful.BigDecimalHelper;
import br.com.cbyk.useful.DateHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Scanner;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class UploadServiceImpl implements UploadService {

    private final ContaRepository repository;

    @Override
    public void upload(InputStream inputStream) throws Exception {

        String[] linha;
        Conta conta;

        log.debug("Iniciando o processo de leitura das linhas do arquivo csv.");

        Scanner s = new Scanner(inputStream).useDelimiter("\\r\\n");

        while (s.hasNext()) {
            linha = s.next().split(";");
            conta = Conta.builder()
                    .id(UUID.randomUUID())
                    .dataVencimento(DateHelper.convertToLocalDate(linha[0], "yyyy-MM-dd HH:mm:ss"))
                    .dataPagamento(DateHelper.convertToLocalDate(linha[1], "yyyy-MM-dd HH:mm:ss"))
                    .valor(BigDecimalHelper.format(linha[2]))
                    .descricao(linha[3])
                    .situacao(SituacaoEnum.valueOf(linha[4]))
                    .build();
            repository.save(conta);
        }

        log.debug("Fim do processamento do arquivo csv.");
    }

}
