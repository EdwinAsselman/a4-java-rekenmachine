package Controllers;

import Model.Model;
import View.View;

import java.beans.PropertyChangeSupport;

public class Controller {
	
    // properties
    private Model model;
    public String s0, s1, s2;

    PropertyChangeSupport pcs;

    public Controller() {
        // Nieuwe PropertyChangeSupport object maken van de postbode
        pcs = new PropertyChangeSupport(this);
        
        s0 = s1 = s2 = "";
        
        // Nieuwe model object
        model = new Model();
    }

    // Methode krijgt argument uit View binnen
    public void addClickText(String text) {
        //Text uit View
        System.out.println("text " + text.charAt(0));
        //kijken of waarde uit text een cijfer is
        if (text.charAt(0) >= '0' && text.charAt(0) <= '9' || text.charAt(0) == '.') {
            //als het niet leeg is
            if (!s1.equals("")) {
                //stop text in String s2
                s2 = text;
            } else {
                //stop text in String s0
                s0 = text;
                System.out.println("waardes " + s0 + s1 + s2);
            }

            //Updaten View
            setResult(s0 + s1 + s2);
        } else if (text.charAt(0) == 'C') { //Als text C is maak String leeg
            s0 = s1 = s2 = "";
            //update view
            setResult(s0 + s1 + s2);
        } else if (text.charAt(0) == '=') { // Als text = bereken String
            //Checken welk operator er is String s1 zit
            double te;
            model.calculate(s0, s2, s1);
            te = model.getCalculationValue();
            //updaten som View
            setResult(s0 + s1 + s2);
            setTotaal(te);
            //Bewaren van waarde
            s0 = Double.toString(te);
            System.out.println("Totaal " + s0 + s1 + s2);
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
                model.calculate(s0, s2, s1);
                te = model.getCalculationValue();

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = text;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            System.out.println(s0 + s1 + s2);
            setResult(s0 + s1 + s2);
        }
    }

    //opsturen van de post
    private void setTotaal(double te) {
        //totaal som opsturen
        System.out.println(" Opsturen: totaal: " + te);
        //stuur post door naar elk persoon dat abonnement heeft met naam totaal
        //geef een null waarde mee en de nieuwe waardes
        pcs.firePropertyChange("totaal", 0, Double.toString(te));
    }

    //zelfde methode andere post
    private void setResult(String s) {
        //stuur geklikte text naar brievenbus
        System.out.println(" Opsturen: result: " + s);
        //iedereen met brievenbus result krijg nieuwe waarde
        pcs.firePropertyChange("result", "", s);
    }

    //aangeven dat de VIEW een abonnement heeft op deze PropertyChangeListener
    public void addPropertyChangeListener(View view) {
        System.out.println(" Aanmelden");
        //toevoegen view object aan PropertyChangeListener
        pcs.addPropertyChangeListener(view);
    }

}
