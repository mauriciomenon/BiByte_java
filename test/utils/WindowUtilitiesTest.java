package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class WindowUtilitiesTest {

    @Test
    void lookAndFeel_methods_doNotThrow() {
        assertDoesNotThrow(WindowUtilities::setNativeLookAndFeel);
        assertDoesNotThrow(WindowUtilities::setJavaLookAndFeel);
        assertDoesNotThrow(WindowUtilities::setMotifLookAndFeel);
    }
}

