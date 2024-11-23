package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    EditText etConvertedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConvertClick(View v) {
        Spinner sp1 = (Spinner) findViewById(R.id.spinner1);
        String choice1 = sp1.getSelectedItem().toString();
        Spinner sp2 = (Spinner) findViewById(R.id.spinner2);
        String choice2 = sp2.getSelectedItem().toString();

        EditText ed1 = (EditText) findViewById(R.id.value1);
        EditText ed2 = (EditText) findViewById(R.id.value2);

        // Check if the input is empty
        if (ed1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
            return;
        }

        double value1 = Double.parseDouble(ed1.getText().toString());
        double value2 = 0;

        // Conversion logic
        switch (choice1) {
            case "Meter":
                switch (choice2) {
                    case "Meter":
                        value2 = value1;
                        break;
                    case "Millimeter":
                        value2 = value1 * 1000;
                        break;
                    case "Mile":
                        value2 = value1 * 0.000621371192;
                        break;
                    case "Foot":
                        value2 = value1 * 3.2808399;
                        break;
                }
                break;
            case "Millimeter":
                switch (choice2) {
                    case "Meter":
                        value2 = value1 / 1000;
                        break;
                    case "Millimeter":
                        value2 = value1;
                        break;
                    case "Mile":
                        value2 = value1 * 0.000000621371192;
                        break;
                    case "Foot":
                        value2 = value1 * 0.0032808399;
                        break;
                }
                break;
            case "Mile":
                switch (choice2) {
                    case "Meter":
                        value2 = value1 / 0.000621371192;
                        break;
                    case "Millimeter":
                        value2 = value1 / 0.000000621371192;
                        break;
                    case "Mile":
                        value2 = value1;
                        break;
                    case "Foot":
                        value2 = value1 * 5280;
                        break;
                }
                break;
            case "Foot":
                switch (choice2) {
                    case "Meter":
                        value2 = value1 / 3.2808399;
                        break;
                    case "Millimeter":
                        value2 = value1 * 304.8;
                        break;
                    case "Mile":
                        value2 = value1 * 0.000189393939;
                        break;
                    case "Foot":
                        value2 = value1;
                        break;
                }
                break;
        }

        // Display the result in the output EditText
        ed2.setText(String.valueOf(value2));
    }
}