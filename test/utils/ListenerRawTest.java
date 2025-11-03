package utils;

import org.junit.jupiter.api.Test;

import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class ListenerRawTest {

    @Test
    void btRaw_valid_copiesParsedValue() {
        JTextField in = new JTextField("321");
        JTextField out = new JTextField();
        ListenerRaw l = new ListenerRaw("btRaw", in, out);
        l.actionPerformed((ActionEvent) null);
        assertEquals("321", out.getText());
    }

    @Test
    void btRaw_invalid_setsMinusOne() {
        JTextField in = new JTextField("zzz");
        JTextField out = new JTextField();
        ListenerRaw l = new ListenerRaw("btRaw", in, out);
        l.actionPerformed((ActionEvent) null);
        assertEquals("-1", out.getText());
    }
}

