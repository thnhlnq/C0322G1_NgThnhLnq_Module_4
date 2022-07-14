package calculator.service;

public interface ICalculatorService {

    String checkOperand(float firstOperand, float secondOperand, char operator);

    float calculator(float firstOperand, float secondOperand, char operator);
}
