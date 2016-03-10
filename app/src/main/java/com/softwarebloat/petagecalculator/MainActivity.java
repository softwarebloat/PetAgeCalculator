package com.softwarebloat.petagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	String years;
	TextView mTextView, humanAge;
	SeekBar age;
    int type = 0;
    int seekbarValue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//final EditText text = (EditText) findViewById(R.id.editText1);
		//years = text.getText().toString();
		age = (SeekBar) findViewById(R.id.set_age);
		mTextView = (TextView) findViewById(R.id.textView1);
		humanAge = (TextView) findViewById(R.id.human_age);


		
		//Button button = (Button) findViewById(R.id.calc_button);
		
		/*button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		       int seekbarValue = age.getProgress();

		       if(seekbarValue < 1){
		    	   //text.setError(getText(R.string.years_text_error));
		    	   Toast.makeText(getApplicationContext(), R.string.years_text_error, Toast.LENGTH_SHORT).show();
		       }
               //Controllo temporaneo per bypassare errore calcolo coniglio se anni > 20
			   if(seekbarValue > 20 && type == 2){
				   Toast.makeText(getApplicationContext(), R.string.bunny_text_error, Toast.LENGTH_SHORT).show();
			   }

		       else{
		    	   calculateYears(v, type, seekbarValue); //perchè serve la view???
		       }

		    }
		});*/

		
		age.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			int progress = 0;
			@Override
			public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
				// TODO Auto-generated method stub

				humanAge.setText(String.valueOf(progressValue));
                //int seekbarValue = age.getProgress();
                //Toast.makeText(getApplicationContext(), "changing seekbar progress", Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "Touching seekbar", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "stopping seekbar progress", Toast.LENGTH_SHORT).show();
                seekbarValue = age.getProgress();
                calculateYears(type, seekbarValue);
			}
			
		});
				
		
	}

	public void RadioClicked(View view){
		//Is the button checked?
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.radio_dog:
                if(checked)
                    type = 0;
                    //Toast.makeText(getApplicationContext(), String.valueOf(type), Toast.LENGTH_SHORT).show();
                    calculateYears(type, seekbarValue);
                break;

            case R.id.radio_cat:
                if(checked)
                    type = 1;
                    //Toast.makeText(getApplicationContext(), String.valueOf(type), Toast.LENGTH_SHORT).show();
                    calculateYears(type, seekbarValue);
                break;

            case R.id.radio_rabbit:
                if(checked)
                    type = 2;
                    calculateYears(type, seekbarValue);
                break;

            case R.id.radio_horse:
                if(checked)
                    type = 3;
                    calculateYears(type, seekbarValue);
                break;
        }
	}

	public void calculateYears(int animal_type, int years){
        int human_age = 0;

        switch (animal_type){
            case 0: //if is dog
                human_age = new dogYearsCalculator().calculate(years);
                break;

            case 1: //if is cat
                human_age = new catYearsCalculator().calculate(years);
                break;

            case 2: //if is rabbit
                human_age = new rabbitYearsCalculator().calculate(years);
                break;

            case 3: //if is horse
                human_age = new horseYearsCalculator().calculate(years);
                break;
        }


		mTextView.setText(String.valueOf(human_age));
	}
	
}
