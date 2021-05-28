
package rtu_location;       /* alterado de  http://docs.oracle.com/javase/tutorial/uiswing/components/table.html  */

import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import rtu_location.ColumnAutoSizer;
 
public class TableCableColor extends JPanel {
    private boolean DEBUG = false;
 
    public TableCableColor() {
        super(new GridLayout(1,0));
 
        JTable table = new JTable(new TableCableColor.MyTableCableColor());
        table.setPreferredScrollableViewportSize(new Dimension(550, 700));  /*utilizando autosizer*/
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        ColumnAutoSizer.sizeColumnsToFit(table);
 
        JScrollPane scrollPane = new JScrollPane(table);        //Create the scroll pane and add the table to it.
        add(scrollPane);                                        //Add the scroll pane to this panel.
    }
 
    class MyTableCableColor extends AbstractTableModel {
        private String[] columnNames = {" Cor (Colorido)   "," Cor (Preto e Branco)    "," Par   "," Fio " ,"Grupo de Anilha"," Cor da Anilha"};
        
        private Object[][] data = {
            {"Azul","Preto","1","11" ,"I","Rosa"},
            {"Vermelho","Branco","1","12" ,"I","Rosa"},
            {"Cinza","Preto","2","13","I","Rosa"},
            {"Amarelo","Branco","2","14","I","Rosa"},
            {"Verde","Preto","3","15","I","Rosa"},
            {"Marrom","Branco","3","16","I","Rosa"},
            {"Preto","Preto","4","17","I","Rosa"},
            {"Branco","Branco","4","18" ,"I","Rosa"},
            {"Ciano","-","-","19","I","Rosa" },
            {"Azul","Preto","5","21","II","Rosa" },
            {"Vermelho","Branco","5","22","II","Rosa" },
            {"Cinza","Preto","6","23","II","Rosa"},
            {"Amarelo","Branco","6","24","II","Rosa" },
            {"Verde","Preto","7","25" ,"II","Rosa"},
            {"Marrom","Branco","7","26","II","Rosa" },
            {"Preto","Preto","8","27" ,"II","Rosa"},
            {"Branco","Branco","8","28" ,"II","Rosa"},
            {"Ciano","-","-","29","II","Rosa" },
            {"Azul","Preto","9","31" ,"III","Rosa"},
            {"Vermelho","Branco","9","32" ,"III","Rosa"},
            {"Cinza","Preto","10","33","III","Rosa"},
            {"Amarelo","Branco","10","34","III","Rosa"},
            {"Verde","Preto","11","35","III","Rosa"},
            {"Marrom","Branco","11","36","III","Rosa"},
            {"Preto","Preto","12","37","III","Rosa"},
            {"Branco","Branco","12","38" ,"III","Rosa"},
            {"Ciano","-","-","39","III","Rosa" },
            {"Azul","Preto","13","41","IV","Rosa" },
            {"Vermelho","Branco","13","42","IV","Rosa" },
            {"Cinza","Preto","14","43","IV","Rosa"},
            {"Amarelo","Branco","14","44","IV","Rosa" },
            {"Verde","Preto","15","45" ,"IV","Rosa"},
            {"Marrom","Branco","15","46","IV","Rosa" },
            {"Preto","Preto","16","47" ,"IV","Rosa"},
            {"Branco","Branco","16","48" ,"IV","Rosa"},
            {"Ciano","-","-","49","IV","Rosa" },
            {"","-","17-20","51-59","I","Laranja" },
            {"","-","21-24","61-99","II","Laranja" },
            {"","-","25-28","71-79","III","Laranja" },
            {"","-","29-32","81-89","IV","Laranja" },
             {"","-","33-36","91-99","I","Violeta" },
            {"","-","37-40","01-09","II","Violeta" },

        }; 
        
        public int getColumnCount() {
            return columnNames.length;
        }
 
        public int getRowCount() {
            return data.length;
        }
 
        public String getColumnName(int col) {
            return columnNames[col];
        }
 
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
 
        public Class getColumnClass(int c) {        /* JTable uses this method to determine the default renderer*/
            return getValueAt(0, c).getClass();
        }
    }
 
    /* Create the GUI and show it. This method should be invoked from the event-dispatching thread for thread safety,*/
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tabela de Remotas (RTU)");   //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        TableCableColor newContentPane = new TableCableColor();               //Create and set up the content pane.
        newContentPane.setOpaque(true);                         //content panes must be opaque
        frame.setContentPane(newContentPane);
        
 
        frame.pack();                                           //Display the window.
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread: creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
