package Model;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private String eerste;
    private String tweede;
    private String operator;

    @org.junit.jupiter.api.Test
    void addNums() {
        // Maak nieuwe model aan.
        Model model = new Model();

        // Maak getallen en operator.
        eerste = new String("1");
        tweede = new String("2");
        operator = new String("+");

        // Roep de calculate methode aan en controlleer of addNums wordt aangeroept en daarna het antwoord 3 is.
        model.calculate(eerste, tweede, operator);
        assertEquals(3, model.getCalculationValue());
    }

    @org.junit.jupiter.api.Test
    void minusNums() {
        // Maak nieuwe model aan.
        Model model = new Model();

        // Maak getallen en operator.
        eerste = new String("5");
        tweede = new String("6");
        operator = new String("-");

        // Roep de calculate methode aan en controlleer of NimusNums wordt aangeroept en daarna het antwoord niet -2 is.
        // Kijk daarna of het antwoord -1 is.
        model.calculate(eerste, tweede, operator);
        assertNotEquals(-2, model.getCalculationValue());
        assertEquals(-1, model.getCalculationValue());
    }

    @org.junit.jupiter.api.Test
    void timesNums() {
        // Maak een nieuwe model aan.
        Model model = new Model();

        // Maak getallen en operator.
        eerste = new String("7");
        tweede = new String("2");
        operator = new String("*");

        // Controlleer of het antwoord 14 is.
        model.calculate(eerste, tweede, operator);
        assertEquals(14, model.getCalculationValue());

        // Run een tweede test.
        tweede = new String("0.25");

        // Controlleer of het antwoord 1.75 is.
        model.calculate(eerste, tweede, operator);
        assertEquals(1.75, model.getCalculationValue());

    }

    @org.junit.jupiter.api.Test
    void divideNum() {
        // Maak een nieuwe model.
        Model model = new Model();

        // Zet getallen en operator.
        eerste = tweede = new String("4");
        operator = new String("/");

        // Calculeer en controlleer of het antwoord 1 is.
        model.calculate(eerste, tweede, operator);
        assertEquals(1, model.getCalculationValue());

        // Run een tweede test.
        tweede = new String("0");

        /**
         * Controlleer of het een foutmelding geeft op het scherm van de rekenmachine, bij geen foutmelding
         * faalt de test.
          */
        try {
            model.calculate(eerste, tweede, operator);
            model.getCalculationValue();
        } catch(Exception error) {
            fail(error.getMessage());
        }
    }
}