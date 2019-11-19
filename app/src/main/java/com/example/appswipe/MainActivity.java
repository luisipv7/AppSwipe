package com.example.appswipe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipe;
    private  final String[] questoes = new String[76];
    private   boolean[] respostas;
    private  boolean[] gabarito ;
    private int cont = 0;
    private int contrespost = 0;
    private int contaerros = 0;
    private int contacertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context contexto = getApplicationContext();
        String texto = "Pra cima SIM pra baixo NÃO";
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, texto,duracao);
        toast.show();

        questoes[0] = "2+2 = 4 ?";
        questoes[1] = "3-2 = 0 ?";
        questoes[2] = "5-5 = 0 ?";
        questoes[3] = "6-2 = 4 ?";
        questoes[4] = "3-2 = 1 ?";


        gabarito = new boolean[] {true,false,true,true,true};
        respostas = new boolean[5] ;



        cont = 0;
        contrespost = 0;
        contacertos= 0;
        contaerros= 0;



        // tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);

        tvSwipe = findViewById(R.id.tvSwipe);

        tvSwipe.setText(questoes[0]);


        tela.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvSwipe.setText("NÃO!!!");
                respostas[cont] = false;
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                tvSwipe.setText("SIM!!!");
                respostas[cont] = true;

            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if(cont < 4) {
                    cont++;
                    tvSwipe.setText(questoes[cont]);


                }else{
                    for(int x=0 ; x<5; x++){
                        Log.i("for", "valor:  "+ x);
                        if(respostas[x]== gabarito[x]){
                            contacertos++;
                        }else{
                            contaerros++;
                        }
                    }
                    tvSwipe.setText("Você acertou " + contacertos + " e errou " + contaerros);
                    cont = -1;
                    contacertos= 0;
                    contaerros= 0;
                    respostas = new boolean[5];
                }
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if(cont != 0) {
                    cont --;
                    tvSwipe.setText(questoes[cont]);
                }

            }
        });

    }
}
