package com.softwarebloat.petagecalculator;

public class horseYearsCalculator extends yearCalculator {

    private int horse_years[] = {2,8,13,17,20};

    @Override
    public int calculate(int years) {

        if(years == 0){
            super.setAge(0);
        }

        if(years > 0 && years <= 5){
            super.setAge(horse_years[years-1]);
        }

        else if(years > 5){
            float adult = 2.5f;
            super.setAge((int) (((years)-4) * adult + 20));
        }

        return super.getAge();
    }

}
