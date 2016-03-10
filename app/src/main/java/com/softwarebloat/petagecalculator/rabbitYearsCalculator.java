package com.softwarebloat.petagecalculator;

public class rabbitYearsCalculator extends yearCalculator
{
    private int rabbitYears[] = {0,21,27,33,39,45,51,57,63,69,75,81,87,93,96,105,111,117,123,129,135};

    @Override
    public int calculate(int humanAge)
    {
        // TODO: This case should be handled by an exception.
        if (humanAge > 20) {
            humanAge = 20;
        }
        
        return rabbitYears[humanAge];
    }
}
