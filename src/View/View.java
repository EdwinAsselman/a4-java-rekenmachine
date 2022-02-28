package View;

import Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JFrame implements PropertyChangeListener {
    //props and attributes
    public JTextField oplossingSom;
    public JButton knopText;
    public JPanel panel;
    public JPanel knopPanel;
    //dubbele String array met symbolen
    public static final String[][] buttonText = {
            {"1", "2", "3", "+"},
            {"4", "5", "6", "-"},
            {"7", "8", "9", "*"},
            {"0", ".", "/", "C", "="}
    };

    //define controller zodat wij method kunnen aanroepen met object
    private Controller controller;


    //constructor method
    public View() {
        //Maken van de JPanel Object
        panel = new JPanel();
        this.add(panel);

        oplossingSom = new JTextField(20);
        oplossingSom.setBounds(500, 100, 120, 120);
        oplossingSom.setEditable(false);
        panel.add(oplossingSom);
        //extra JPanel voor de buttons
        knopPanel = new JPanel(new GridLayout(4, 5));
        panel.add(knopPanel);

        //printen jbuttons met text symbolen
        for (int i = 0; i < buttonText.length; i++) {
            for (int j = 0; j < 5; j++) {
                //maken JButton objecten en vul met waarde
                if (j == buttonText[i].length) {
                    knopPanel.add(new JLabel());
                } else {
                    //maak nieuw JButton object en stop text in de jbuttons
                    knopText = new JButton(buttonText[i][j]);
                    //voegen jbuttons aan JPanel
                    knopPanel.add(knopText);
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
    }

    //setter method set controller object
    public void setController(Controller controller) {
        this.controller = controller;
        //abonneer View aan PropertyChangeListener (Hij wil de post in zijn brievenbus krijgen)
        controller.addPropertyChangeListener(this);
    }

    //method die de String in de jtextfield zet
    public void setTextView(String totaal) {
        oplossingSom.setText(totaal);
    }

    //Dit is de brievenbus hier komt de post binnen dat gestuurd is door de Controller
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Brievenbus: " + evt.getPropertyName() + "=" + evt.getNewValue());
        //kijken welke post je hebt gekregen een result of een totaal som
        if (evt.getPropertyName().equals("result")) {
            //geef resultaat aan de setTextView method
            setTextView((String) evt.getNewValue());
        }
        if (evt.getPropertyName().equals("totaal")) {
            setTextView((String) evt.getNewValue());
        }
    }
}
