package com.softwarebloat.petagecalculator;

/**
 * Created by Nico on 5/1/16.
 */
public class cowYearsCalculator extends yearCalculator
{
    private int cowAge[] = {0, 14, 18, 22, 26, 30, 34, 38, 42, 46, 50, 54, 58, 62, 66, 70, 74, 78, 82, 86, 90};

    public cowYearsCalculator()
    {
        setType(4);
    }

    @Override
    public int calculate(int humanAge)
    {
        return cowAge[humanAge];
    }
}
