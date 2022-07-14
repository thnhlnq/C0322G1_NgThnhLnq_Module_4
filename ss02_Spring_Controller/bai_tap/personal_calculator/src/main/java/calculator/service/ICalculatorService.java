package calculator.service;

public interface ICalculatorService {

    String checkOperand(float firstOperand, float secondOperand, String operator);

    float calculator(float firstOperand, float secondOperand, String operator);
}
