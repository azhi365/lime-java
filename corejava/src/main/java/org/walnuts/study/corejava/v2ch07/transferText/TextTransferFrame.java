package org.walnuts.study.corejava.v2ch07.transferText;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This frame has a text area and buttons for copying and pasting text.
 */
public class TextTransferFrame extends JFrame {
    private static final int TEXT_ROWS = 20;
    private static final int TEXT_COLUMNS = 60;
    private JTextArea textArea;

    public TextTransferFrame() {
        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel panel = new JPanel();

        JButton copyButton = new JButton("Copy");
        panel.add(copyButton);
        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                copy();
            }
        });

        JButton pasteButton = new JButton("Paste");
        panel.add(pasteButton);
        pasteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                paste();
            }
        });

        add(panel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Copies the selected text to the system clipboard.
     */
    private void copy() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = textArea.getSelectedText();
        if (text == null)
            text = textArea.getText();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    /**
     * Pastes the text from the system clipboard into the text area.
     */
    private void paste() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
            try {
                String text = (String) clipboard.getData(flavor);
                textArea.replaceSelection(text);
            } catch (UnsupportedFlavorException e) {
                JOptionPane.showMessageDialog(this, e);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }
}
