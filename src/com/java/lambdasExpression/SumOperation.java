package com.java.lambdasExpression;

public class SumOperation implements MathOperation{
    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}
