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
		
		int total=0;
		int horse_years[] = {2,8,13,17,20};
		int bunny_years[] = {21,27,33,39,45,51,57,63,69,75,81,87,93,96,105,111,117,123,129,135};
		
		//if is dog
		if(animal_type==0){
            if(years == 0) {
                total = 0;
            }
            else{
                total = 24 + ((years)-2) * 4;
            }
		}
		
		//if is cat
		else if(animal_type==1){
			if(years == 0) {
                total = 0;
            }
            else if(years == 1){
                total  = 15;
            }
            else if(years == 2){
                total = 25;
            }

            else {
                total = 25 + ((years) - 2) * 4;
            }
		}
		
		//if is bunny
		else if(animal_type==2){
			if(years == 0)
                total = 0;

			else if(years > 20)
                Toast.makeText(getApplicationContext(), R.string.bunny_text_error, Toast.LENGTH_SHORT).show();

            else
			    total = bunny_years[years-1];
		}
		
		//if is horse
		else if(animal_type==3){
            if(years == 0){
                total = 0;
            }

			if(years > 0 && years < 5){
				total = horse_years[years-1];
			}
			
			else if(years > 5){
				float adult = 2.5f;
				total = (int) (((years)-4) * adult + 20);
			}
		}
		
		mTextView.setText(String.valueOf(total));
	}
	
}
