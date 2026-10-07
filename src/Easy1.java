import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Easy1 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta;
    private JTextArea outputArea;
    private JButton submitButton, resetButton, clearButton;
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy1() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Easy1 swingControlDemo = new Easy1();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Text Submission App");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);

        mainFrame.setJMenuBar(mb);

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        ta = new JTextArea();
        ta.setBackground(Color.blue);
        outputArea = new JTextArea();
        outputArea.setBackground(Color.orange);
        outputArea.setEditable(false);
//w3 schools citing
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.yellow);
        resetButton = new JButton("Reset");
        clearButton = new JButton("Clear Last");

        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");
        clearButton.setActionCommand("Clear Last");

        submitButton.addActionListener(new ButtonClickListener());
        resetButton.addActionListener(new ButtonClickListener());
        clearButton.addActionListener(new ButtonClickListener());

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JScrollPane(ta), BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        mainFrame.add(inputPanel, BorderLayout.NORTH);

        mainFrame.add(new JScrollPane(outputArea), BorderLayout.CENTER);
//w3 schools
        controlPanel = new JPanel();
        controlPanel.add(resetButton);
        controlPanel.add(clearButton);
        mainFrame.add(controlPanel, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
//w3 schools
            if (command.equals("Submit")) {
                outputArea.append(ta.getText() + "\n");
                ta.setText("");
            } else if (command.equals("Reset")) {
                ta.setText("");
                outputArea.setText("");
            } else if (command.equals("Clear Last")) {
                String text = outputArea.getText();
                int lastLine = text.lastIndexOf("\n", text.length() - 2);

                if (lastLine >= 0)
                    outputArea.setText(text.substring(0, lastLine + 1));
                else
                    outputArea.setText("");
            }
        }
    }
}
