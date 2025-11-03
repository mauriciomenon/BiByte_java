package operacoes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculosEdgeTest {

    @ParameterizedTest
    @DisplayName("calcula_1: SOSTAT identity range [0,2047]")
    @ValueSource(strings = {"0", "1", "2047"})
    void testCalcula1_SostatIdentity(String input) {
        int n = Integer.parseInt(input);
        assertEquals(n, Calculos.calcula_1(input));
    }

    @ParameterizedTest
    @DisplayName("calcula_1: invalid PTNO ranges return -1")
    @ValueSource(strings = {"-1", "2050", "12000", "20000", "36070", "999999"})
    void testCalcula1_InvalidRanges(String input) {
        assertEquals(-1, Calculos.calcula_1(input));
    }

    @Test
    @DisplayName("calcula_1: partial latch range [36088,36095]")
    void testCalcula1_PartialLatch() {
        // Use lower bound 36088 to validate mapping
        // Expected: (((36088-36064)/8)*16) + (((36088-36064)%8) + 5760)
        int base = 36088 - 36064;
        int expected = ((base / 8) * 16) + ((base % 8) + 5760);
        assertEquals(expected, Calculos.calcula_1("36088"));
    }

    @Test
    @DisplayName("calcula_2: 2W no timestamp lower bound")
    void testCalcula2_2W_NoTS_LB() {
        assertEquals(10000, Calculos.calcula_2("0"));
    }

    @Test
    @DisplayName("calcula_2: 4W with TS valid and invalid inner slots")
    void testCalcula2_4W_TS_ValidInvalid() {
        // Valid boundary: 4608 -> block 0 -> PTNO 25000
        assertEquals(25000, Calculos.calcula_2("4608"));
        // Invalid: value whose (n2 % 16) > 7 should be -1, e.g., 4616 % 16 = 8
        assertEquals(-1, Calculos.calcula_2("4616"));
    }

    @Test
    @DisplayName("calcula_2: latch with TS for block>=10 special offset (block=10)")
    void testCalcula2_Latch_TS_Block10() {
        int n2 = 5632 + (10 * 16); // within-block index 0
        int block = (n2 - 5632) / 16; // 10
        int offset = (2 * block) + (2 * (block - 9)); // 20 + 2 = 22
        int expected = (n2 + 30368) - offset; // formula from implementation
        assertEquals(expected, Calculos.calcula_2(Integer.toString(n2)));
    }

    @Test
    @DisplayName("calcula_2: negative input and too-large return -1")
    void testCalcula2_OutOfRangeAndNegative() {
        assertEquals(-1, Calculos.calcula_2("-5"));
        assertEquals(-1, Calculos.calcula_2("900000"));
    }

    @Test
    @DisplayName("calcula_raw: valid and invalid")
    void testCalculaRaw() {
        assertEquals(123, Calculos.calcula_raw("123"));
        assertEquals(-1, Calculos.calcula_raw("abc"));
    }
}

