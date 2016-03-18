package com.softwarebloat.petagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	TextView mTextView, humanAge;
	SeekBar age;
    int type = 0;
    int seekbarValue;


	@Override
	protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		age = (SeekBar) findViewById(R.id.set_age);
		mTextView = (TextView) findViewById(R.id.textView1);
		humanAge = (TextView) findViewById(R.id.human_age);

		age.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

			@Override
			public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser)
            {
				humanAge.setText(String.valueOf(progressValue));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
            {
                seekbarValue = age.getProgress();
                calculateYears(type, seekbarValue);
			}

		});
	}

    public void RadioClicked(View view)
    {

        RadioGroup radioPets = (RadioGroup) findViewById(R.id.radio_pets);
        int selectedPetId = radioPets.getCheckedRadioButtonId();
        RadioButton selectedPet = (RadioButton) findViewById(selectedPetId);
        int selectedPetType = Integer.parseInt((String) selectedPet.getTag());

        calculateYears(selectedPetType, seekbarValue);
    }


	public void calculateYears(int animal_type, int years)
    {
        int human_age;
        yearsCalculatorFactory calculator = new yearsCalculatorFactory();
        human_age = calculator.createCalculator(animal_type).calculate(years);

        mTextView.setText(String.valueOf(human_age));
	}
	
}
