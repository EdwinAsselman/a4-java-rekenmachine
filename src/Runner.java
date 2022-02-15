import javax.swing.*;
import java.awt.*;

import Controllers.Controller;
import View.View;

//Runner class
public class Runner {
    //Main method
    public static void main(String[] args) {
        //Maak View object
        View frame = new View();
        //new controller object voeg toe aan View
        frame.setController(new Controller(frame));

        // afsluiten op EXIT
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // zetten van lengte en breedte
        frame.setSize(900, 700);
        // zet frame midden in scherm
        frame.setLocationRelativeTo(null);
        frame.setTitle("Calculator");
        //Zet JPanel zichtbaar
        frame.setVisible(true);
    }
}
