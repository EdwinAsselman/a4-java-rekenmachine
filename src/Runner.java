import javax.swing.*;

import Controllers.Controller;
import View.View;

//Runner class
public class Runner {
    //Main method
    public static void main(String[] args) {
        //Maak View object
        View frame = new View();
        //maak Controller object
        Controller controller = new Controller();
        //geef controller object aan method setController in View
        frame.setController(controller);

        // Standaard Setting voor JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Zetten van lengte en breedte
        frame.setSize(250, 300);
        // Zet frame midden in scherm
        frame.setLocationRelativeTo(null);
        // Zet title
        frame.setTitle("Calculator");
        // Zet JPanel zichtbaar
        frame.setVisible(true);

    }
}
