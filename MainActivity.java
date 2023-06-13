package com.example.myapplicationjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textViewDistPer, textViewDistFalt, textViewVeloMed, textViewTempoEstimado;
    private EditText editTextDist, editTextTempo, editTextVeloAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDistPer = findViewById(R.id.distPercorrida);
        textViewDistFalt = findViewById(R.id.distFalta);
        textViewVeloMed = findViewById(R.id.velocidadeIndicada);
        textViewTempoEstimado = findViewById(R.id.tempoEstimado);
        Button buttonEnviar = findViewById(R.id.enviar);
        Button buttonVelo = findViewById(R.id.velocidade);
        Button buttonStop = findViewById(R.id.stop);
        editTextDist = findViewById(R.id.distancia);
        editTextTempo = findViewById(R.id.tempo);
        editTextVeloAtual = findViewById(R.id.velocidadeAtual);

        final Localizacao[] local = new Localizacao[1];

        // Definindo o listener de clique para o botão enviar
        buttonEnviar.setOnClickListener(v -> {
            local[0] = new Localizacao(editTextDist.getText().toString(), editTextTempo.getText().toString(), textViewDistPer, textViewDistFalt, textViewVeloMed, textViewTempoEstimado);
            local[0].start();
            editTextDist.setEnabled(false);
            editTextTempo.setEnabled(false);
        });

        // Definindo o listener de clique para o botão Velocidade atual
        buttonVelo.setOnClickListener(v -> {
            if(local[0].isAlive() && !editTextVeloAtual.getText().toString().equals("")){
                local[0].setVelocidade(editTextVeloAtual.getText().toString());
            }

        });

        // Definindo o listener de clique para o botão stop
        buttonStop.setOnClickListener(v -> {
            local[0].stopThread();
            editTextDist.setEnabled(true);
            editTextTempo.setEnabled(true);
        });
    }
}

