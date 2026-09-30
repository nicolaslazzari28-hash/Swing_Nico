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
    private JTextArea ta; //typing area
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
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 2));

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
        //end menu at top

        //ta = new JTextArea();
       // ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        mainFrame.add(mb);  //add menu bar
       // mainFrame.add(ta);//add typing area
        mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

       // mainFrame.addWindowListener(new WindowAdapter() {
         //   public void windowClosing(WindowEvent windowEvent) {
            //    System.exit(0);
          //  }
       // });
        //controlPanel = new JPanel();
       // controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel

       // mainFrame.add(controlPanel);
       // mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton oneButton = new JButton("OK");
        JButton twoButton = new JButton("Submit");
        JButton threeButton = new JButton("Cancel");
        JButton fourButton = new JButton("OK");
        JButton fiveButton = new JButton("Submit");


        oneButton.setActionCommand("button 1");
        twoButton.setActionCommand("button 2");
        threeButton.setActionCommand("button 3");
        fourButton.setActionCommand("button 4");
        fiveButton.setActionCommand("button 5");


        oneButton.addActionListener(new ButtonClickListener());
        twoButton.addActionListener(new ButtonClickListener());
        threeButton.addActionListener(new ButtonClickListener());
        fourButton.addActionListener(new ButtonClickListener());
        fiveButton.addActionListener(new ButtonClickListener());


        mainFrame.add(oneButton);
        mainFrame.add(twoButton);
        mainFrame.add(threeButton);
        mainFrame.add(fourButton);
        mainFrame.add(fiveButton);
        

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

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }
        }
    }
}