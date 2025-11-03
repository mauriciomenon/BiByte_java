package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import operacoes.Calculos;

/**
 * Esta classe tem finalidade de agrupar os Listener's dos botoes.
 * obs: Sera preciso criar novos construtores dependendo do tipo funcao a executar
 */

public class MeuListener implements ActionListener {

    private final String opcode;
    private final JTextField inputField;
    private final JTextField outputField;
    private final JLabel errorLabel;

    public MeuListener(String opcode, JTextField inputField, JTextField outputField, JLabel errorLabel) {
        this.opcode = opcode;
        this.inputField = inputField;
        this.outputField = outputField;
        this.errorLabel = errorLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        errorLabel.setText(""); // Clear the error label on each action
        int result;

        switch (opcode) {
            case "btLimparBit":
            case "btLimparPTNO":
            case "btLimparTudo":
                inputField.setText("");
                outputField.setText("");
                break;

            case "btPTNO":
                result = Calculos.calcula_1(inputField.getText());
                if (result >= 0) {
                    outputField.setText(String.valueOf(result));
                } else {
                    errorLabel.setText("Por favor, preencha o campo Bit/Byte com um número válido.");
                }
                break;

            case "btBitByte":
                result = Calculos.calcula_2(inputField.getText());
                if (result >= 0) {
                    outputField.setText(String.valueOf(result));
                } else {
                    errorLabel.setText("Por favor, preencha o campo PTNO com um número válido.");
                }
                break;

            default:
                errorLabel.setText("Este botão ainda não foi configurado.");
                break;
        }
    }
}
