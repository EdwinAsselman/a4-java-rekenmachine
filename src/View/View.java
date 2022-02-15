package View;

import Controllers.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    //props and attributes
    public JTextField oplossingSom;
    public JButton knopText;
    public JPanel panel;

    public static final String[][] buttonText = {
            {"1", "2", "3", "+"},
            {"4", "5", "6", "-"},
            {"7", "8", "9", "*"},
            {"0", ".", "/", "C", "="}
    };

    //define controller zodat wij method kunnen aanroepen met object
    private Controller controller;
    public String s0, s1, s2;
    public double te;

    //constructor method
    public View() {
        //maken JPanel object zetten attributes
        panel = new JPanel();
        this.add(panel);

        oplossingSom = new JTextField(20);
        oplossingSom.setBounds(500, 100, 120, 120);
        oplossingSom.setEditable(false);

        panel.add(oplossingSom);

        //printen jbuttons met text
        for (int i = 0; i < buttonText.length; i++) {
            for (int j = 0; j < buttonText[i].length; j++) {
                //maken JButton objecten en vul met waarde
                knopText = new JButton(buttonText[i][j]);
                //voegen knop aan JPanel
                panel.add(knopText);
                //voeg ActionListener aan knop objecten
                knopText.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Get text uit button
                        knopText = (JButton) e.getSource();
                        //stuur text naar controller method
                        controller.addClickText(knopText.getText());
                    }
                });
            }
        }
    }

    //setter method set controller object
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setTextView(String s0, String s1, String s2) {
        this.s0 = s0;
        this.s1 = s1;
        this.s2 = s2;
        oplossingSom.setText(this.s0 + this.s1 + this.s2);
    }

    public void TotaalSom(double te) {
        this.te = te;
        oplossingSom.setText(String.valueOf(te));
    }
}
