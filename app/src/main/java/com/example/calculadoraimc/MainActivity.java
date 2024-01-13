package com.example.calculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.calculadoraimc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private TextView resultado;

    private TextView classificacao;

    private String valorClassificacao;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resultado = findViewById(R.id.txt_resultado);

        classificacao = findViewById(R.id.txt_classificacao);

        Button botaoCalcular = findViewById(R.id.txt_btn);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }

            private void calcular() {
                EditText altura = findViewById(R.id.txt_altura);
                double valorAltura = Double.parseDouble(altura.getText().toString());
                EditText peso = findViewById(R.id.txt_peso);
                double valorPeso = Double.parseDouble(peso.getText().toString());

                double imc = valorPeso / (valorAltura * valorAltura);

                if (imc < 18.5){
                    valorClassificacao = "Bom";
                } else if (imc < 25) {
                    valorClassificacao = "Ok";
                } else if (imc < 30) {
                    valorClassificacao = "Ruim";
                } else {
                    valorClassificacao = "Péssimo";
                }

                resultado.setText(String.valueOf(imc));
                resultado.setVisibility(View.VISIBLE);

                classificacao.setText(String.valueOf(valorClassificacao));
                classificacao.setVisibility(View.VISIBLE);

            }
        });

    }
}