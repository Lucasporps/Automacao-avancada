package com.example.myapplicationjava;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Localizacao extends Thread {

    private volatile boolean isRunning = true;
    private float distAtual, distFinal, velocidade, tempoT, tempoD = 0;
    private TextView textView, textView1, textView2, textView3;

    public Localizacao(String distFinal, String tempo, TextView textView, TextView textView1, TextView textView2, TextView textView3) {
        this.distAtual = 0;
        this.velocidade = 60;
        this.tempoT = Float.parseFloat(tempo)*3600000;
        this.textView = textView;
        this.textView1 = textView1;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.distFinal = Float.parseFloat(distFinal);

        this.textView3.setText("Tempo estimado de chegada: " + getHorario((this.distFinal/velocidade)*3600000) + " h");
    }

    @Override
    public void run() {
        while(distAtual < distFinal && isRunning){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distAtual += velocidade*2000/3600000;
            tempoD += 2000;
            textView.setText(distAtual + "km");
            textView1.setText((distFinal-distAtual) + "km");
            textView2.setText(((distFinal-distAtual)/((tempoT-tempoD)/3600000)) + "km/h");

        }
    }

    public synchronized void setVelocidade(String vel) {
        this.velocidade = Float.parseFloat(vel);
        this.textView3.setText("Tempo estimado de chegada: " + getHorario(((distFinal-distAtual)/velocidade)*3600000) + " h");
    }

    public void stopThread() {
        isRunning = false;
    }

    private String getHorario(float tempo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        long horaEstimada = 0;
        String horaAtual = dateFormat.format(Calendar.getInstance().getTime());
        try {
            horaEstimada = dateFormat.parse(horaAtual).getTime() + (long) tempo;
        } catch(Exception e){

        }
        String hora = dateFormat.format(new Date(horaEstimada));
        return hora;
    }

}
