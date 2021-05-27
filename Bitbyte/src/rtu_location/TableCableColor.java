
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
        table.setPreferredScrollableViewportSize(new Dimension(215, 265));  /*utilizando autosizer*/
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        ColumnAutoSizer.sizeColumnsToFit(table);
 
        JScrollPane scrollPane = new JScrollPane(table);        //Create the scroll pane and add the table to it.
        add(scrollPane);                                        //Add the scroll pane to this panel.
    }
 
    class MyTableCableColor extends AbstractTableModel {
        private String[] columnNames = {"Cor   ","Cor    ","Par   ","Numero " };
        
        private Object[][] data = {
            {"Azul","Preto","1","11"},
            {"Vermelho","Branco","1","12" },
            {"Cinza","Preto","2","13"},
            {"Amarelo","Branco","2","14"},
            {"Verde","Preto","3","15"},
            {"Marrom","Branco","3","16"},
            {"Preto","Preto","4","17"},
            {"Branco","Branco","4","18" },
            {"","Preto","5","21" },
            {"","Branco","5","22" },
            {"","Preto","6","23"},
            {"","Branco","6","24" },
            {"","Preto","7","25" },
            {"","Branco","7","26" },
            {"","Preto","8","27" },
            {"","Branco","8","28" }
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
