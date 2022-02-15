package Model;

//Model class does the calculations
public class Model {
    //props
    private Double calculationValue;

    //Methods
    public void addNums(double firstNumber, double secondNumber) {
        calculationValue = firstNumber + secondNumber;
    }


    public void minusNums(double firstNumber, double secondNumber) {
        calculationValue = firstNumber - secondNumber;
    }

    public void timesNums(double firstNumber, double secondNumber) {
        calculationValue = firstNumber * secondNumber;
    }

    public void divideNum(double firstNumber, double secondNumber) {
        calculationValue = firstNumber / secondNumber;
    }

    //getter method
    public double getCalculationValue() {

        return calculationValue;

    }
}
