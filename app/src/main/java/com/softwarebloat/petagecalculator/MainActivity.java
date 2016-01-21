package com.softwarebloat.petagecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String years;
	TextView mTextView, humanAge;
	SeekBar age;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//final EditText text = (EditText) findViewById(R.id.editText1);
		//years = text.getText().toString();
		age = (SeekBar) findViewById(R.id.set_age);
		mTextView = (TextView) findViewById(R.id.textView1);
		humanAge = (TextView) findViewById(R.id.human_age);
		
		final Spinner spinner = (Spinner) findViewById(R.id.choose_animal);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.animals, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner		
		spinner.setAdapter(adapter);
		
		Button button = (Button) findViewById(R.id.calc_button);
		
		button.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v) {
		       long type = spinner.getSelectedItemId();
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
		});

		
		age.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			int progress = 0;
			@Override
			public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
				// TODO Auto-generated method stub
				progress = progressValue;
				humanAge.setText(String.valueOf(progress));
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
		});
				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calculateYears(View view, long animal_type, int years){
		
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
