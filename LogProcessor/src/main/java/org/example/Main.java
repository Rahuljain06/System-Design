package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

// Chain of Responsibility Pattern
public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter log level (1: INFO, 2: DEBUG, 3: ERROR, 0 to exit): ");
            int logLevel = scanner.nextInt();
            scanner.nextLine();

            if (logLevel == 0) {
                System.out.println("Exiting...");
                break;
            }

            System.out.println("Enter your log message: ");
            String message = scanner.nextLine();

            logProcessor.log(logLevel, message);
        }

        scanner.close();
    }
}