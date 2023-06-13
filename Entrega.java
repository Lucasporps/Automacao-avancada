package com.example.myapplicationjava;

import android.os.Build;

import java.time.LocalDateTime;

public class Entrega {
    private float distanciaRestante;
    private float velocidade;
    private LocalDateTime tempoInicio;
    private LocalDateTime tempoFinal;

    public Entrega(float distancia, float vel, LocalDateTime tempo){
        this.distanciaRestante = distancia;
        this.velocidade = vel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.tempoInicio = LocalDateTime.now();
        }
        this.tempoFinal = tempo;
    }

}
