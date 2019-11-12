package com.example.appswipe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipe;
    private  final String[] questoes = new String[5];
    private   boolean[] respostas;
    private  boolean[] gabarito ;
    private int cont = 0;
    private int contrespost = 0;
    private int teste = 0;
    private int contacertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questoes[0] = "2+2 = 4 ?";
        questoes[1] = "3-2 = 0 ?";
        questoes[2] = "5-5 = 0 ?";
        questoes[3] = "6-2 = 4 ?";
        questoes[4] = "3-2 = 1 ?";

        gabarito = new boolean[] {true,false,true,true,true};




        cont = 0;
        contrespost = 0;
        contacertos =0;



        // tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);

        tvSwipe = findViewById(R.id.tvSwipe);

        tvSwipe.setText(questoes[0]);


        tela.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvSwipe.setText("Não!!!");
                respostas[contrespost] = true;
                contrespost++;
                if(contrespost == 4){
                    while(teste != 4){
                        if(respostas[teste] == gabarito[teste]){
                            contacertos++;
                        }
                    }
                    tvSwipe.setText("VC ACertou" + contacertos);
                    return;
                }
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                tvSwipe.setText("SIM!!!");
                respostas[contrespost] = true;
                contrespost++;
                if(contrespost == 4){
                    while(teste != 4){
                        if(respostas[teste] == gabarito[teste]){
                                contacertos++;
                        }
                    }
                    tvSwipe.setText("VC ACertou" + contacertos);
                    return;
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if(cont != 0) {
                cont --;
                tvSwipe.setText(questoes[cont]);
                }


            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                if(cont!= 4) {
                    cont++;
                    tvSwipe.setText(questoes[cont]);
                }

            }
        });

    }
}
