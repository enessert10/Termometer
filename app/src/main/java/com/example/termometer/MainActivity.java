package com.example.termometer;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etNumber;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        etNumber = findViewById(R.id.etNumber);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);
        formatter = new DecimalFormat("#.0");
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (etNumber.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();

                } else {
                    int number = Integer.parseInt(etNumber.getText().toString().trim());

                    double tempKelvin =(double) number + 273;
                    double tempFahrenheit = (double) (180*number)/100 + 32.0 ;



                    String result = number +" °C = " + formatter.format(tempKelvin) + " K \n" +
                                    number +" °C = " + formatter.format(tempFahrenheit) + " °F";
                    tvResult.setText(result);

                    tvResult.setVisibility(View.VISIBLE);


                }

            }
        });


    }

}
