package com.softwarebloat.petagecalculator;

public class rabbitYearsCalculator extends yearCalculator {

    private int bunny_years[] = {21,27,33,39,45,51,57,63,69,75,81,87,93,96,105,111,117,123,129,135};

    @Override
    public int calculate(int years) {

        if(years == 0)
            super.setAge(0);

            //else if(years > 20)
            //Toast.makeText(getApplicationContext(), R.string.bunny_text_error, Toast.LENGTH_SHORT).show();

        else
            super.setAge(bunny_years[years-1]);

        return super.getAge();
    }

}
