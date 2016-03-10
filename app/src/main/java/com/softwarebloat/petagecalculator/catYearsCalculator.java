package com.softwarebloat.petagecalculator;

public class catYearsCalculator extends yearCalculator
{
    public catYearsCalculator() {
        setType(1);
    }

    @Override
    public int calculate(int humanAge)
    {
        if (humanAge == 0) {
            return 0;
        }
        
        if (humanAge == 1) {
            return 15;   
        }
        
        int petAge = humanAge - 2;
        return petAge * 4 + 25;
    }
}
