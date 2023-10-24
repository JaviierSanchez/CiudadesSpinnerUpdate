package com.example.ciudadesspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private TextView tv1;

    private EditText eti1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner);
        tv1 = findViewById(R.id.txt_Resultado);
        eti1 = findViewById(R.id.txt_Comparacion);

        String[] opciones = {"Badajoz", "Caceres", "Don Benito", "Medellin"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = spinner1.getSelectedItem().toString();

                char carac = seleccion.charAt(0);

                String res = String.valueOf(carac);

                for (int i = 1; i < seleccion.length(); i++) {

                    res = res + " _";

                }
                tv1.setText(res);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void comparar(View vista) {
        String seleccion = spinner1.getSelectedItem().toString();

        String textoComparacion = eti1.getText().toString();

        if (seleccion.equals(textoComparacion)) {
            Toast.makeText(this, "La ciudades introducidos son iguales", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "La ciudades introducidos no son iguales", Toast.LENGTH_SHORT).show();
        }

    }


}