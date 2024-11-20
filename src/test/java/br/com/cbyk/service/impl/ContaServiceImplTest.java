package br.com.cbyk.service.impl;

import br.com.cbyk.database.model.Conta;
import br.com.cbyk.database.repository.ContaRepository;
import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.dto.ContaResponse;
import br.com.cbyk.enums.SituacaoEnum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class ContaServiceImplTest {

    @InjectMocks
    private ContaServiceImpl contaService;

    @Mock
    private ContaRepository repository;

    @Test
    void testBuscar_ComSucesso() {
        final UUID id = UUID.randomUUID();
        Optional<Conta> contaOptional = Optional.of(Conta.builder()
                .id(id)
                .descricao("Teste")
                .build());

        when(repository.findById(any())).thenReturn(contaOptional);

        ContaResponse resultado = contaService.findById(UUID.randomUUID());
        assertEquals(id, resultado.getId());
    }

    @Test
    void testCadastrar_ComSucesso() {

        CadastrarContaRequest request = new CadastrarContaRequest(LocalDateTime.now(), LocalDateTime.now(), BigDecimal.TEN, "Descricao", SituacaoEnum.AGUARDANDO);
        UUID uuid = contaService.cadastrar(request);

        assertNotNull(uuid);
    }

    @Test
    void testAlterar_ComErro() {
        boolean thrown = false;
        try {
            contaService.alterar(null);
        } catch (NullPointerException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}
