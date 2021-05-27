package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import operacoes.Calculos;

/** Esta classe tem finalidade de agrupar os Listener's dos botoes. 
 *obs: Sera preciso criar novos construtores dependendo do tipo funcao a executar  */

public class MeuListener implements ActionListener {

	private String opcode;
	private JTextField t1, t2;

	/* @param opcode: o switch ira se basear de acordo com o botao clicado. 
	 * @param t1: campo JTextField
	 * @param t2: campo JTextField                                       */
	public MeuListener(String opcode, JTextField t1, JTextField t2) {
		this.opcode = opcode;
		this.t1 = t1;
		this.t2 = t2;
	}
 
    /**
     *
     * @param opcode
     * @param tvmin
     * @param tvmax
     */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int result;
		
		switch (opcode) {
		case "btLimparBit":
			t1.setText("");
			t2.setText("");
			break;
			
		case "btLimparPTNO":
			t1.setText("");
			t2.setText("");
			break;
                    
                    
                case "btLimparTudo":   //usado na novo Frame, anteriores legados do codigo antigo
			t1.setText("");
			t2.setText("");
			break;
			
		case "btPTNO":
			result = Calculos.calcula_1(t1.getText());
			if (result >= 0) {
				t2.setText("" + result);
			} else {
				t2.setText("Preencha Bit/Byte");
			}
			break;
			
		case "btBitByte":
			result = Calculos.calcula_2(t1.getText());
			if (result >= 0) {
				t2.setText("" + result);
			} else {
				t2.setText("Preencha PTNO");
			}
			break;                   

		default:
			JOptionPane.showMessageDialog(null, "Este botao nao foi configurado ainda.");
			break;
		}
	}
}

