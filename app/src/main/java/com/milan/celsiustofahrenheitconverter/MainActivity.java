package com.milan.celsiustofahrenheitconverter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCelsius;
    private TextView textViewFahrenheit;
    private EditText editTextCelsius;
    private EditText editTextFahrenheit;
    private Button convertButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewCelsius = (TextView) findViewById(R.id.textViewCelsius);
        textViewFahrenheit = (TextView) findViewById(R.id.textViewFahrenheit);
        editTextCelsius = (EditText) findViewById(R.id.editTextCelsius);
        editTextFahrenheit = (EditText) findViewById(R.id.editTextFahrenheit);
        convertButton = (Button) findViewById(R.id.convertButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temperature temperature = new Temperature();

                try {
                    if (editTextFahrenheit.getText().toString().isEmpty()) {
                        temperature.setCelsiusValue(Double.parseDouble(editTextCelsius.getText().toString()));
                        temperature.convertCelsiusToFahrenHeit();
                        editTextFahrenheit.setText(String.valueOf(temperature.getFahrenheitValue()));
                    } else if (editTextCelsius.getText().toString().isEmpty()) {
                        temperature.setFahrenheitValue(Double.parseDouble(editTextFahrenheit.getText().toString()));
                        temperature.convertFahrenheitToCelsius();
                        editTextCelsius.setText(String.valueOf(temperature.getCelsiusValue()));
                    }
                } catch (NumberFormatException e) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("You must enter Celsius or Fahrenheit value!");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Please enter Celsius or Fahrenheit value", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.show();

                }

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCelsius.setText("");
                editTextFahrenheit.setText("");
            }
        });


    }
}
