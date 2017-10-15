package com.milan.celsiustofahrenheitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GuiElements guiElements = new GuiElements();
        guiElements.setTextViewCelsius((TextView) findViewById(R.id.textViewCelsius));
        guiElements.setTextViewFahrenheit((TextView) findViewById(R.id.textViewFahrenheit));
        guiElements.setEditTextCelsius((EditText) findViewById(R.id.editTextCelsius));
        guiElements.setEditTextFahrenheit((EditText) findViewById(R.id.editTextFahrenheit));
        guiElements.setConvertButton((Button) findViewById(R.id.convertButton));
        guiElements.setClearButton((Button) findViewById(R.id.clearButton));

        guiElements.onClickButtons();


    }


}
