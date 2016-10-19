package com.java24hours;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableFrame extends JFrame {
    public TableFrame() {
        super("Table Frame");
        String[] columnLabels = { "High", "Low", "Volume", "Date" };
        Object[][] tableData = {
            //row 1
            {"105.23", "103.44", "400B", "Today"},
            //row 2
            {"105.88", "105.21", "400B", "Yesterday"},
            //row 3
            {"106.34", "105.53", "400B", "The Day Before"},
            //row 4
            {"107.76", "105.98", "400B", "Three days ago"},
            //row 5
            {"109.55", "108.47", "400B", "Four days ago"}
        };
        JTable table = new JTable(tableData, columnLabels);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        add(scrollPane);
        setSize(450,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        TableFrame frame = new TableFrame();
    }
}
