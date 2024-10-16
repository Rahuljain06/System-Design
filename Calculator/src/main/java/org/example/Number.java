package org.example;

public class Number implements ArithmeticExpression{

    public int number;

    public Number(int value){
        this.number=value;
    }

    @Override
    public int evaluate() {
        System.out.println("The value is " + number );
        return number;
    }
}
