package gui;

import backend.onUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inputGUI extends JFrame{

    String date = "0";
    Integer day = 0;
    Integer month = 0;
    Integer year = 0;

    //Possibly move to another type?
    private inputGUI() {

        //these are the parts to the GUI
        GridBagConstraints c = new GridBagConstraints();
        JPanel screen = new JPanel(new GridBagLayout());
        JButton update = new JButton("                 Update                 ");

        JTextField bTextTF = new JTextField(10);
        JTextField lTextTF = new JTextField(10);
        JTextField dTextTF = new JTextField(10);
        JTextField nTextTF = new JTextField(10);
        JTextField t1TF = new JTextField(10);
        JTextField t2TF = new JTextField(10);
        JTextField t3TF = new JTextField(10);
        JTextField t4TF = new JTextField(10);
        JTextField am1TF = new JTextField(10);
        JTextField am2TF = new JTextField(10);
        JTextField am3TF = new JTextField(10);
        JTextField am4TF = new JTextField(10);
        JTextField am5TF = new JTextField(10);
        JTextField am6TF = new JTextField(10);
        JTextField am7TF = new JTextField(10);
        JTextField am8TF = new JTextField(10);
        JTextField am9TF = new JTextField(10);
        JTextField am10TF = new JTextField(10);
        JTextField t5TF = new JTextField(10);
        JTextField t6TF = new JTextField(10);
        JTextField t7TF = new JTextField(10);
        JTextField t8TF = new JTextField(10);
        JTextField t9TF = new JTextField(10);
        JTextField t10TF = new JTextField(10);
        JTextField t11TF = new JTextField(10);
        JTextField t12TF = new JTextField(10);
        JTextField t13TF = new JTextField(10);
        JTextField t14TF = new JTextField(10);
        JTextField dateTF = new JTextField(10);

        JLabel title = new JLabel("Daily Dosage Input");
        JLabel dateLabel = new JLabel("Date:");
        JLabel s1 = new JLabel(" ");
        JLabel s2 = new JLabel(" ");
        JLabel s3 = new JLabel(" ");
        JLabel s4 = new JLabel(" ");
        JLabel s5 = new JLabel(" ");
        JLabel s6 = new JLabel(" ");
        JLabel s7 = new JLabel(" ");
        JLabel s8 = new JLabel(" ");
        JLabel s9 = new JLabel(" ");
        JLabel s10 = new JLabel(" ");
        JLabel breakfast = new JLabel("Breakfast Dosage");
        JLabel lunch = new JLabel("Lunch Dosage");
        JLabel dinner = new JLabel("Dinner Dosage");
        JLabel night = new JLabel("Night Dosage");
        JLabel bTime = new JLabel("      Injection backend.Time      ");
        JLabel lTime = new JLabel("      Injection backend.Time      ");
        JLabel dTime = new JLabel("      Injection backend.Time      ");
        JLabel nTime = new JLabel("      Injection backend.Time      ");
        JLabel lbl1 = new JLabel("1.");
        JLabel lbl2 = new JLabel("2.");
        JLabel lbl3 = new JLabel("3.");
        JLabel lbl4 = new JLabel("4.");
        JLabel lbl5 = new JLabel("5.");
        JLabel lbl6 = new JLabel("6.");
        JLabel lbl7 = new JLabel("7.");
        JLabel lbl8 = new JLabel("8.");
        JLabel lbl9 = new JLabel("9.");
        JLabel lbl10 = new JLabel("10.");
        JLabel Time1 = new JLabel("      Injection backend.Time      ");
        JLabel Time2 = new JLabel("      Injection backend.Time      ");
        JLabel Time3 = new JLabel("      Injection backend.Time      ");
        JLabel Time4 = new JLabel("      Injection backend.Time      ");
        JLabel Time5 = new JLabel("      Injection backend.Time      ");
        JLabel Time6 = new JLabel("      Injection backend.Time      ");
        JLabel Time7 = new JLabel("      Injection backend.Time      ");
        JLabel Time8 = new JLabel("      Injection backend.Time      ");
        JLabel Time9 = new JLabel("      Injection backend.Time      ");
        JLabel Time10 = new JLabel("      Injection backend.Time      ");
        JLabel other = new JLabel("Other backend.Injections:");

        JLabel[] labelList = new JLabel[] {breakfast, lunch, dinner, night, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, bTime, lTime, dTime, nTime, Time1, Time2, Time3, Time4,Time5, Time6, Time7, Time8, Time9, Time10, s2, s3, s4, s5};
        String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JTextField[] textList = new JTextField[] {bTextTF, lTextTF, dTextTF, nTextTF, am1TF, am2TF, am3TF, am4TF, am5TF, am6TF, am7TF, am8TF, am9TF, am10TF, t1TF, t2TF, t3TF, t4TF, t5TF, t6TF, t7TF, t8TF, t9TF, t10TF, t11TF, t12TF, t13TF, t14TF};

        JTextField[] intTextList = new JTextField[] {bTextTF, lTextTF, dTextTF, nTextTF, am1TF, am2TF, am3TF, am4TF, am5TF, am6TF, am7TF, am8TF, am9TF, am10TF};
        JTextField[] stringTextList = new JTextField[] {t1TF, t2TF, t3TF, t4TF, t5TF, t6TF, t7TF, t8TF, t9TF, t10TF, t11TF, t12TF, t13TF, t14TF};

        title.setFont(new Font("TimesRoman", Font.BOLD, 18));

        c.gridwidth = 5;
        c.gridx = 1;
        c.gridy = 4;
        screen.add(title, c);

        c.gridx = 1;
        c.gridy = 5;
        screen.add(s1, c);

        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 6;
        screen.add(dateLabel, c);

        c.gridx = 2;
        c.gridy = 6;
        screen.add(dateTF, c);

        c.gridwidth = 4;
        c.gridx = 1;
        c.gridy = 7;
        screen.add(s10, c);


        //adds labels to first column
        c.gridwidth = 1;
        c.gridx = 1;
        int count = 8;
        boolean check = true;


        for(int i = 0; i<14; i++)
        {
            c.gridy = i + count;
            if(i==4 && check==true)
            {
                check = false;
                screen.add(s2, c);
                c.gridy++;
                screen.add(other, c);
                count+=2;
            }
            c.gridy = i + count;
            screen.add(labelList[i], c);
        }

        //adds textboxes to second column
        c.gridx = 2;
        count = 8;
        check = true;

        for(int i = 0; i<14; i++)
        {
            c.gridy = i + count;
            if(i==4 && check==true)
            {
                check = false;
                screen.add(s3, c);
                c.gridy++;
                screen.add(s4, c);
                count+=2;
            }
            c.gridy = i + count;
            screen.add(textList[i], c);
        }

        //adds labels to third column
        c.gridx = 3;
        count = 8;
        check = true;

        for(int i = 0; i<14; i++)
        {
            c.gridy = i + count;
            if(i==4 && check==true)
            {
                check = false;
                screen.add(s5, c);
                c.gridy++;
                screen.add(s6, c);
                count+=2;
            }
            c.gridy = i + count;
            screen.add(labelList[i+14], c);
        }

        //adds textboxes to fourth column
        c.gridx = 4;
        count = 8;
        check = true;

        for(int i = 0; i<14; i++)
        {
            c.gridy = i + count;
            if(i==4 && check==true)
            {
                check = false;
                screen.add(s7, c);
                c.gridy++;
                screen.add(s8, c);
                count+=2;
            }
            c.gridy = i + count;
            screen.add(textList[i+14], c);
        }

        c.gridwidth = 2;
        c.gridx = 2;
        c.gridy = 24;
        screen.add(s9, c);
        c.gridy++;
        screen.add(update, c);
        add(screen);

        //below adds functionality to buttons and textFields
        //Somehow move to main method
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] timeList = new String[14];
                int[] dosageList = new int[14];
                for(int i = 0; i<14; i++)
                {
                    timeList[i] = stringTextList[i].getText();
                    dosageList[i] = Integer.parseInt(intTextList[i].getText());

                }

                onUpdate.updateInsulin(timeList, dosageList);
            }
        });
    }

    /**
    public String[] runGUI()
    {
        inputGUI program = new inputGUI();
        //Move this to the gui.inputGUI class, somehow?
        program.setVisible(true);
        program.setTitle("Data Collection");
        program.setSize(600,700);
        program.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return
    }
     */
}
