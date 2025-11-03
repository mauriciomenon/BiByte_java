package utils;

import org.junit.jupiter.api.Test;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MeuListenerTest {

    @Test
    void btPTNO_valid_setsOutput() {
        JTextField in = new JTextField("15100"); // PTNO -> BitByte = 2248
        JTextField out = new JTextField();
        JLabel err = new JLabel();
        MeuListener l = new MeuListener("btPTNO", in, out, err);
        l.actionPerformed((ActionEvent) null);
        assertEquals("2248", out.getText());
        assertEquals("", err.getText());
    }

    @Test
    void btPTNO_invalid_setsError() {
        JTextField in = new JTextField("oops");
        JTextField out = new JTextField();
        JLabel err = new JLabel();
        MeuListener l = new MeuListener("btPTNO", in, out, err);
        l.actionPerformed((ActionEvent) null);
        assertTrue(err.getText().toLowerCase().contains("número válido"));
    }

    @Test
    void btBitByte_valid_setsOutput() {
        JTextField in = new JTextField("2248"); // BitByte -> PTNO = 15100
        JTextField out = new JTextField();
        JLabel err = new JLabel();
        MeuListener l = new MeuListener("btBitByte", in, out, err);
        l.actionPerformed((ActionEvent) null);
        assertEquals("15100", out.getText());
        assertEquals("", err.getText());
    }

    @Test
    void btLimparPTNO_clearsFields() {
        JTextField in = new JTextField("123");
        JTextField out = new JTextField("456");
        JLabel err = new JLabel("x");
        MeuListener l = new MeuListener("btLimparPTNO", in, out, err);
        l.actionPerformed((ActionEvent) null);
        assertEquals("", in.getText());
        assertEquals("", out.getText());
    }

    @Test
    void unknown_opcode_setsNotConfigured() {
        JTextField in = new JTextField();
        JTextField out = new JTextField();
        JLabel err = new JLabel();
        MeuListener l = new MeuListener("nope", in, out, err);
        l.actionPerformed((ActionEvent) null);
        assertTrue(err.getText().toLowerCase().contains("não foi configurado"));
    }
}

