package com.softwarebloat.petagecalculator;

public class cowYearsCalculator extends yearCalculator
{
    int cowAge = 14;

    public cowYearsCalculator()
    {
        setType(4);
    }

    @Override
    public int calculate(int humanAge)
    {
        if( humanAge == 0 ){
            return 0;
        }

        if( humanAge == 1 ) {
            return cowAge;
        }

        return cowAge + (4 * (humanAge-1));
    }
}
