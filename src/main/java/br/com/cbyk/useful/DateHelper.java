package br.com.cbyk.useful;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateHelper {

    private static final ZoneId ZONE_ID = ZoneId.of("Brazil/East");

    private DateHelper() {
    }

    public static LocalDateTime convertToLocalDate(String value, String format) {
        try {
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(format));
        } catch (Exception ex) {
            log.debug("Erro ao formatar data. Texto: {} | Formato: {}", value, format);
            return null;
        }
    }

    public static LocalDateTime nowToTime() {
        return LocalDateTime.now(ZONE_ID);
    }

}
