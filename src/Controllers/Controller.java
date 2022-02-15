package Controllers;

import Model.Model;
import View.View;
import javax.swing.*;


//Controller class
public class Controller extends JPanel {
    //properties
    private Model model;
    private View view;
    public String s0, s1, s2;

    //constructor method
    public Controller(View view) {
        //new model object
        model = new Model();
        this.view = view;
        s0 = s1 = s2 = "";
    }

    //pakken van waarde uit klik
    public void addClickText(String text) {
        //Text uit View
        System.out.println("text " + text.charAt(0));
        //kijken of waarde uit text een cijfer is
        if (text.charAt(0) >= '0' && text.charAt(0) <= '9' || text.charAt(0) == '.') {
            //als het niet leeg is
            if (!s1.equals("")) {
                //stop text in String s2
                s2 = s2 + text;
            } else {
                //stop text in String s0
                s0 = s0 + text;
                System.out.println("waardes " + s0 + s1 + s2);
                //Updaten View
                view.setTextView(s0, s1, s2);
            }
        } else if (text.charAt(0) == 'C') { //Als text C is maak String leeg
            s0 = s1 = s2 = "";
            //update view
            view.setTextView(s0, s1, s2);
        } else if (text.charAt(0) == '=') { // Als text = bereken String
            //Checken welk operator er is String s1 zit
            double te;
            if (s1.equals("+")) {
                //te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                model.addNums(Double.parseDouble(s0), Double.parseDouble(s2));
                te = model.getCalculationValue();
            } else if (s1.equals("-")) {
                //te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                model.minusNums(Double.parseDouble(s0), Double.parseDouble(s2));
                te = model.getCalculationValue();
            } else if (s1.equals("/")) {
                model.divideNum(Double.parseDouble(s0), Double.parseDouble(s2));
                te = model.getCalculationValue();
            } else {
                model.timesNums(Double.parseDouble(s0), Double.parseDouble(s2));
                te = model.getCalculationValue();
            }
            //updaten som View
            view.setTextView(s0, s1, s2);
            view.TotaalSom(te);
            //Bewaren van waarde
            s0 = Double.toString(te);
            System.out.println("Naberekenen " + s0 + s1 + s2);
            //legen van String zodat je nieuwe som kan maken
            s1 = s2 = "";
        } else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = text;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+")) {
                    model.addNums(Double.parseDouble(s0), Double.parseDouble(s2));
                    te = model.getCalculationValue();
                } else if (s1.equals("-")) {
                    model.minusNums(Double.parseDouble(s0), Double.parseDouble(s2));
                    te = model.getCalculationValue();
                } else if (s1.equals("/")) {
                    model.divideNum(Double.parseDouble(s0), Double.parseDouble(s2));
                    te = model.getCalculationValue();
                } else {
                    model.timesNums(Double.parseDouble(s0), Double.parseDouble(s2));
                    te = model.getCalculationValue();
                }

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = text;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            System.out.println(s0 + s1 + s2);
            view.setTextView(s0, s1, s2);
        }
    }


    //setten View
//    public void setView(View view) {
//        this.view = view;
//    }
}
