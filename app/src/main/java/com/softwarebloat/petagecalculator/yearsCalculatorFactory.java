package com.softwarebloat.petagecalculator;


public class yearsCalculatorFactory {

    private  yearCalculator animals[] = {new dogYearsCalculator(), new catYearsCalculator(), new horseYearsCalculator(), new rabbitYearsCalculator()};

    public yearCalculator createCalculator(int animal_type)
    {
        for (int i=0; i < animals.length; i++) {
            if (animal_type == animals[i].getType()) {
                return animals[i];
            }
        }

        return null;
    }

}
