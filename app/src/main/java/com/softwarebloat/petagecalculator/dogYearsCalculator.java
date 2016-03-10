package com.softwarebloat.petagecalculator;

public class dogYearsCalculator extends yearCalculator
{
    public dogYearsCalculator() {
        setType(0);
    }

    @Override
    public int calculate(int humanAge)
    {
        if (humanAge == 0) {
            return 0;
        }
        
        int petAge = humanAge - 2;
        return petAge * 4 + 24;
    }
}
