package org.example;

public class Expression implements ArithmeticExpression{

    ArithmeticExpression leftArithmeticExpression;
    ArithmeticExpression rightArithmeticExpression;
    Operator operation;

    public Expression(ArithmeticExpression leftPart, ArithmeticExpression rightPart, Operator operation){
        this.leftArithmeticExpression=leftPart;
        this.rightArithmeticExpression=rightPart;
        this.operation=operation;
    }

    @Override
    public int evaluate() {

        int value = switch (operation) {
            case ADD -> leftArithmeticExpression.evaluate() + rightArithmeticExpression.evaluate();
            case SUBTRACT -> leftArithmeticExpression.evaluate() - rightArithmeticExpression.evaluate();
            case MULTIPLY -> leftArithmeticExpression.evaluate() * rightArithmeticExpression.evaluate();
            case DIVIDE -> divide(leftArithmeticExpression,rightArithmeticExpression);
            default -> throw new IllegalArgumentException("Unknown operator");
        };
        System.out.println("Expression value is " + value);
        return value;
    }


    public int divide(ArithmeticExpression leftValue, ArithmeticExpression rightValue){
         try {
            return leftValue.evaluate()/ rightValue.evaluate();
         }
         catch (ArithmeticException e)
         {
             System.out.println("Error: " + e.getMessage());
             return 0;
         }
    }
}
