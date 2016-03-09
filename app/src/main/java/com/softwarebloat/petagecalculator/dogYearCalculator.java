package com.softwarebloat.petagecalculator;

/**
 * Created by Nico on 3/7/16.
 */
public class dogYearCalculator extends yearCalculator {

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
