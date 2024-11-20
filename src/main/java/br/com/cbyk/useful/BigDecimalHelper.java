package br.com.cbyk.useful;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class BigDecimalHelper {

    private BigDecimalHelper() {
    }

    public static BigDecimal format(Object obj) {
        try {
            return new BigDecimal(obj.toString());
        } catch (Exception e) {
            log.debug("Erro ao formatar o valor. {}", e.getMessage());
            return BigDecimal.ZERO;
        }
    }

}
