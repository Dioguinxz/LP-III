package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalcIMCTest {

    @Test
    @DisplayName("IMC test error")
    void calcIMC() {
        //height 1,70 weight 60 IMC = 20,76
        CalcIMC calcIMC = new CalcIMC();
        var result = calcIMC.CalculteIMC(60, 1.70);
        assertThat(result).isCloseTo(20.76, Offset.offset(0.01));

    }

}