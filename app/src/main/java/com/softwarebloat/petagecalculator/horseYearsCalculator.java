package com.softwarebloat.petagecalculator;

public class horseYearsCalculator extends yearCalculator
{
    private int horseYears[] = {0, 2, 8, 13, 17, 20};

    public horseYearsCalculator() {
        setType(3);
    }

    @Override
    public int calculate(int humanAge)
    {
        if (humanAge >= 0 && humanAge <= 5) {
            return horseYears[humanAge];
        }
        
        int petAge = humanAge - 4;
        return (int) (petAge * 2.5f + 20);
    }
}
