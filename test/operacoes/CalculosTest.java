package operacoes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculosTest {

    @Test
    void testCalcula_1_sostat() {
        assertEquals(100, Calculos.calcula_1("100"));
    }

    @Test
    void testCalcula_1_2w_no_ts() {
        assertEquals(200, Calculos.calcula_1("10100"));
    }

    @Test
    void testCalcula_1_2w_ts() {
        assertEquals(2248, Calculos.calcula_1("15100"));
    }

    @Test
    void testCalcula_1_4w_ts() {
        assertEquals(4624, Calculos.calcula_1("25008"));
    }

    @Test
    void testCalcula_1_latch_ts() {
        assertEquals(5648, Calculos.calcula_1("36008"));
    }

    @Test
    void testCalcula_1_invalid_input() {
        assertEquals(-1, Calculos.calcula_1("invalid"));
    }

    @Test
    void testCalcula_1_out_of_range() {
        assertEquals(-1, Calculos.calcula_1("40000"));
    }

    @Test
    void testCalcula_2_2w_no_ts() {
        assertEquals(10100, Calculos.calcula_2("200"));
    }

    @Test
    void testCalcula_2_2w_ts() {
        assertEquals(15100, Calculos.calcula_2("2248"));
    }

    @Test
    void testCalcula_2_4w_ts() {
        assertEquals(25008, Calculos.calcula_2("4624"));
    }

    @Test
    void testCalcula_2_latch_ts() {
        assertEquals(36008, Calculos.calcula_2("5648"));
    }

    @Test
    void testCalcula_2_invalid_input() {
        assertEquals(-1, Calculos.calcula_2("invalid"));
    }

    @Test
    void testCalcula_2_out_of_range() {
        assertEquals(-1, Calculos.calcula_2("9000"));
    }

    @Test
    void testCalcula_2_odd_ptno() {
        assertEquals(-1, Calculos.calcula_2("2049"));
    }
}
