package Program.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class initialGUI extends JFrame{

    private boolean buttonPressed = false;
    private JFrame frame;
    public initialGUI(){

    }

    public void closeGUI(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public String[] GUI() {

        String[] output = new String[2];

        GridBagConstraints c = new GridBagConstraints();
        JPanel screen = new JPanel(new GridBagLayout());
        frame = new JFrame();
        frame.setTitle("Import Target CSV");
        frame.setSize(450,275);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton update = new JButton("Update");
        JButton selectFile = new JButton("Select File");
        JTextField fileAddress = new JTextField("Enter file address here:", 20);
        JLabel importTitle = new JLabel("Import Target CSV");
        JLabel importNote = new JLabel("CSV must be downloaded from Dexcom Clarity");
        JButton selectDirectory = new JButton("Select Directory");
        JTextField fileDirectory = new JTextField("Enter output directory here:", 20);
        JLabel outputTitle = new JLabel("Select Output Directory");
        JLabel s1 = new JLabel(" ");
        JLabel s2 = new JLabel(" ");
        JLabel s3 = new JLabel(" ");
        JLabel s4 = new JLabel(" ");


        importTitle.setFont(new Font("TimesRoman", Font.BOLD, 18));

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 2;
        screen.add(importTitle, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 3;
        screen.add(s1, c);

        importNote.setFont(new Font("TimesRoman", Font.ITALIC, 13));

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 4;
        screen.add(importNote, c);

        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 5;
        screen.add(fileAddress, c);

        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 5;
        screen.add(selectFile, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 6;
        screen.add(s2, c);

        outputTitle.setFont(new Font("TimesRoman", Font.BOLD, 18));


        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 7;
        screen.add(outputTitle, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 8;
        screen.add(s3, c);

        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 9;
        screen.add(fileDirectory, c);

        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 9;
        screen.add(selectDirectory, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 10;
        screen.add(s4, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 11;
        screen.add(update, c);

        add(screen);
        frame.getContentPane().add(screen);
        frame.setVisible(true);


        selectFile.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fileAddress.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        selectDirectory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fileDirectory.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        while(!buttonPressed) {
            update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonPressed = true;
                }
            });

        }


        output[0] = fileAddress.getText();
        output[1] = fileDirectory.getText();
        return output;
    }


}
