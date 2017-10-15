package com.milan.celsiustofahrenheitconverter;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GuiElements extends Activity {

    private TextView textViewCelsius;
    private TextView textViewFahrenheit;
    private EditText editTextCelsius;
    private EditText editTextFahrenheit;
    private Button convertButton;
    private Button clearButton;
    private Toast toast;

    Temperature temperature = new Temperature();


    public TextView getTextViewCelsius() {
        return textViewCelsius;
    }

    public void setTextViewCelsius(TextView textViewCelsius) {
        this.textViewCelsius = textViewCelsius;
    }

    public TextView getTextViewFahrenheit() {
        return textViewFahrenheit;
    }

    public void setTextViewFahrenheit(TextView textViewFahrenheit) {
        this.textViewFahrenheit = textViewFahrenheit;
    }

    public EditText getEditTextCelsius() {
        return editTextCelsius;
    }

    public void setEditTextCelsius(EditText editTextCelsius) {
        this.editTextCelsius = editTextCelsius;
    }

    public EditText getEditTextFahrenheit() {
        return editTextFahrenheit;
    }

    public void setEditTextFahrenheit(EditText editTextFahrenheit) {
        this.editTextFahrenheit = editTextFahrenheit;
    }

    public Button getConvertButton() {
        return convertButton;
    }

    public void setConvertButton(Button convertButton) {
        this.convertButton = convertButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public void setClearButton(Button clearButton) {
        this.clearButton = clearButton;
    }

    public void onClickButtons() {

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (editTextFahrenheit.getText().toString().isEmpty()) {
                        temperature.setCelsiusValue(Double.parseDouble(editTextCelsius.getText().toString()));
                        temperature.convertCelsiusToFahrenHeit();
                        editTextFahrenheit.setText(String.valueOf(temperature.getFahrenheitValue()));
                    } else if (editTextCelsius.getText().toString().isEmpty()) {
                        temperature.setFahrenheitValue(Double.parseDouble(editTextFahrenheit.getText().toString()));
                        temperature.convertFahrenheitToCelsius();
                        getEditTextCelsius().setText(String.valueOf(temperature.getCelsiusValue()));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
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

