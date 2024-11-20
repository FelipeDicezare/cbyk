package br.com.cbyk.controller.impl;

import br.com.cbyk.dto.CadastrarContaRequest;
import br.com.cbyk.enums.SituacaoEnum;
import br.com.cbyk.service.ContaService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ContaControllerImplTest {

    @InjectMocks
    private ContaControllerImpl contaController;

    @Mock
    private ContaService contaService;

    @Test
    public void testCadastrarConta_ComSucesso() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        UUID id = UUID.randomUUID();
        when(contaService.cadastrar(any(CadastrarContaRequest.class))).thenReturn(id);

        CadastrarContaRequest cadastrar = new CadastrarContaRequest(LocalDateTime.now(), null, BigDecimal.TEN, "", SituacaoEnum.AGUARDANDO);
        ResponseEntity responseEntity = contaController.cadastrar(cadastrar);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

}
