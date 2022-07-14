package calculator.service.impl;

import calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String checkOperand(float firstOperand, float secondOperand, String operator) {

        if (secondOperand == 0) {
            return "Can't Divide by Zero";
        } else {
            return String.valueOf(calculator(firstOperand, secondOperand, operator));
        }
    }

    @Override
    public float calculator(float firstOperand, float secondOperand, String operator) {

        switch (operator) {

            case "+":
                return firstOperand + secondOperand;

            case "-":
                return firstOperand - secondOperand;

            case "*":
                return firstOperand * secondOperand;

            case "/":
                return firstOperand / secondOperand;

            default:
                return 0;
        }
    }
}
