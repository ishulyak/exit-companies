package com.uawar.exit.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
@Slf4j
public class Utils {
    public static Instant parseDate(final String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-M-d", Locale.US))
                    .atStartOfDay().toInstant(ZoneOffset.UTC);
        } catch (Exception e) {
            log.warn("Failed to parse date: " + date);
            return null;
        }
    }

    public static Integer parseInteger(final String value) {
        return Integer.parseInt(value);
    }
}
