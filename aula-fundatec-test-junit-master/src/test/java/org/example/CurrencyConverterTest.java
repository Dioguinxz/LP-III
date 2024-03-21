package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyConverterTest {

    CurrencyConverter currencyConverter = new CurrencyConverter();

    @Test
    @DisplayName("Convert Dolar to Real error")
    void convertDolarToReal() {
        // 500 doll = 2500 Reais
        var result = currencyConverter.convertDolarToReal(100);
        assertThat(result).isEqualTo(500);

    }

    @Test
    @DisplayName("Convert Dolar to Euro error")
    void convertDolarToEuro() {
        // 500 doll to Euro = 425 EUR
        var result = currencyConverter.convertDolarToEuro(500);
        assertThat(result).isEqualTo(425);
    }

    @Test
    @DisplayName("Convert Dolar to Libra error")
    void convertDolarToLibra() {
        // 500 doll to Libra = 365 GBP
        var result = currencyConverter.convertDolarToLibra(500);
        assertThat(result).isEqualTo(365);
    }
}