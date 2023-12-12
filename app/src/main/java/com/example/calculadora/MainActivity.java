package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private EditText editTextN1, editTextN2;
    private int n1, n2;
    private TextView textViewResult;
    private Button calcular1;

    private String total;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);

        radioButton1= (RadioButton) findViewById(R.id.radioButton1);
        radioButton2= (RadioButton) findViewById(R.id.radioButton2);
        radioButton3= (RadioButton) findViewById(R.id.radioButton3);
        radioButton4= (RadioButton) findViewById(R.id.radioButton4);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);

        editTextN1 = findViewById(R.id.editTextN1);
        editTextN2 = findViewById(R.id.editTextN2);

        textViewResult = findViewById(R.id.textViewResult);

        calcular1 = findViewById(R.id.calcular1);

//        calcular1.setOnClickListener(view -> {
//            calcular(view);
//        });
    }

    public void calcular1(View view){
        total = "";
        int selectedId = radioGroup.getCheckedRadioButtonId();
        getNumbers(view);
        if (selectedId == R.id.radioButton1){
            sumar();
        }
        if (selectedId == R.id.radioButton2){
            restar();
        }
        if (selectedId == R.id.radioButton3){
            multiplicar();
        }
        if (selectedId == R.id.radioButton4){
            dividir();
        }
        setResult();
    }

    public void calcular2(View view) {
        total = "";
        getNumbers(view);
        if (checkBox1.isChecked()) {
            sumar();
        }
        if (checkBox2.isChecked()) {
            restar();
        }
        if (checkBox3.isChecked()) {
            multiplicar();
        }
        if (checkBox4.isChecked()) {
            dividir();
        }
        setResult();
    }

    public void limpiar(View view){
        editTextN1.setText("");
        editTextN2.setText("");
        total = "";
        setResult();
    }

    public void getNumbers(View view){
        n1 = Integer.parseInt(editTextN1.getText().toString());
        n2 = Integer.parseInt(editTextN2.getText().toString());
    }

    public void setResult(){
        textViewResult.setText(total);
    }

    public void sumar(){
        int result = n1 + n2;
        total += n1 + " + " + n2 + " = " + result + "\n";
    }

    public void restar() {
        int result = n1 - n2;
        total += n1 + " - " + n2 + " = " + result + "\n";
    }

    public void multiplicar() {
        int result = n1 * n2;
        total += n1 + " * " + n2 + " = " + result + "\n";
    }

    public void dividir() {
        if (n2 != 0) {
            // División por cero no está permitida
            double result = (double) n1 / n2;
            total += n1 + " / " + n2 + " = " + result + "\n";
        } else {
            total += "No se puede dividir por cero" + "\n";
        }
    }
}