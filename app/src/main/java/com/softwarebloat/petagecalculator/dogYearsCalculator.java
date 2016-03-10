package com.softwarebloat.petagecalculator;

public class dogYearsCalculator extends yearCalculator {

    @Override
    public int calculate(int years) {

        if(years == 0) {
            super.setAge(0);
        }
        else{
            super.setAge(24 + ((years)-2) * 4);
        }

        return super.getAge();

    }
}
