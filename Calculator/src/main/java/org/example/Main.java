package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // Ask if the user wants to continue or stop
            System.out.print("Type STOP to exit or press Enter to continue: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("STOP")) {
                System.out.println("Exiting...");
                break;
            }

            // Input the number of values
            System.out.print("Enter the number of values: ");
            int n = scanner.nextInt();

            // Input the numbers
            List<Number> numbers = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                System.out.print("Enter number " + (i + 1) + ": ");
                int value = scanner.nextInt();
                numbers.add(new Number(value));
            }

            // Input the operators between numbers
            List<Operator> operators = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                System.out.print("Enter operator (+, -, *, /) between number " + (i + 1) + " and number " + (i + 2) + ": ");
                String operator = scanner.next();
                switch (operator) {
                    case "+":
                        operators.add(Operator.ADD);
                        break;
                    case "-":
                        operators.add(Operator.SUBTRACT);
                        break;
                    case "*":
                        operators.add(Operator.MULTIPLY);
                        break;
                    case "/":
                        operators.add(Operator.DIVIDE);
                        break;
                    default:
                        System.out.println("Invalid operator, try again.");
                        i--;
                }
            }

            // Evaluate the expression step by step
            Number result = numbers.getFirst();
            for (int i = 0; i < operators.size(); i++) {
                Expression expression = new Expression(result, numbers.get(i + 1), operators.get(i));
                result = new Number(expression.evaluate());
            }

            // Output the final result
            System.out.println("The result of the expression is: " + result.evaluate());
            scanner.nextLine();
        }
        scanner.close();
    }
}