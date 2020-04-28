package gui;

import backend.onUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class initialGUI extends JFrame{

    private boolean buttonPressed = false;
    private JFrame frame;
    public initialGUI(){

    }

    public void closeGUI(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public String GUI() {

        GridBagConstraints c = new GridBagConstraints();
        JPanel screen = new JPanel(new GridBagLayout());
        frame = new JFrame();
        frame.setTitle("Import Target CSV");
        frame.setSize(450,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton update = new JButton("Update");
        JTextField fileAddress = new JTextField("Enter file address here:", 20);
        JLabel title = new JLabel("Import Target CSV");

        title.setFont(new Font("TimesRoman", Font.BOLD, 18));

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 4;
        screen.add(title, c);

        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 5;
        screen.add(fileAddress, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 6;
        screen.add(update, c);

        add(screen);
        frame.getContentPane().add(screen);
        frame.setVisible(true);

        while(!buttonPressed) {
            update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPressed = true;
                }
            });

        }

        return fileAddress.getText();
    }


}
