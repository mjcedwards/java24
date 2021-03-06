package com.java24hours;

import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class FreeSpacePanel extends JPanel {
    JLabel spaceLabel = new JLabel("Disk Space: ");
    JLabel space = new JLabel();
    
    public FreeSpacePanel() {
        super();
        add(spaceLabel);
        add(space);
        try {
            setValue();
        } catch (IOException ioe) {
            space.setText("Error");
        }
    }
    private final void setValue() throws IOException {
        Path current = Paths.get("");
        FileStore store = Files.getFileStore(current);
        long totalSpace = store.getTotalSpace()/1_000_000_000;
        long freeSpace = store.getUsableSpace()/1_000_000_000;
        double percent = ((double)freeSpace / (double)totalSpace) * 100;
        percent = (int)(percent * 100) / (double)100;
        space.setText(freeSpace + "GB free out of " + totalSpace + "GB (" + percent + "%)");
        
        
    }
    
}