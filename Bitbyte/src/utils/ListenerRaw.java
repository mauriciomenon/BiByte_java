package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import operacoes.Calculos;

/**
 *
 * @author menon
 */
public class ListenerRaw implements ActionListener {

	private String opcode;
	private JTextField tvmin, tbias, tvmax, tscale;

	public ListenerRaw(String opcode, JTextField tvmin, JTextField tbias) {
		this.opcode = opcode;
		this.tvmin = tvmin;
		this.tbias = tbias;
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
		
		case "btRaw":
			result = Calculos.calcula_raw(tvmin.getText());
                        tbias.setText("" + result);
			break;   
                }
        
        
        
        
        
        }
}