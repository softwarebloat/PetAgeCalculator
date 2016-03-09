package com.softwarebloat.petagecalculator;

/**
 * Created by Nico on 3/9/16.
 */
public class catYearsCalculator extends yearCalculator {

    @Override
    public int calculate(int years) {


        if (years == 0) {
            super.setAge(0);
        }
        else if (years == 1){
            super.setAge(15);
        }
        else if (years == 2){
            super.setAge(25);
        }
        else {
            super.setAge(25 + ((years) - 2) * 4);
        }


        return super.getAge();
    }
}
