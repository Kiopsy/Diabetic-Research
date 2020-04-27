package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class initialGUI extends JFrame{

    public initialGUI() {

        GridBagConstraints c = new GridBagConstraints();
        JPanel screen = new JPanel(new GridBagLayout());

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

        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 5;
        screen.add(update, c);

        add(screen);
    }
}
