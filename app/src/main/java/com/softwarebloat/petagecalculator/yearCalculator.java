package com.softwarebloat.petagecalculator;

public abstract class yearCalculator
{
    protected int type;

    public abstract int calculate(int humanAge);

    protected int getType() {
        return type;
    }

    protected void setType(int type) {
        this.type = type;
    }
}
