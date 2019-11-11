package com.example.appswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipe;
    private  final String[] questoes = new String[4];
    private  final String[] respostasSIM = new String[4];
    private  final String[] respostasNAO = new String[4];
    private int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questoes[0] = "Você tem cancer?";
        questoes[1] = "Você tem pancreatite?";
        questoes[2] = "Você tem peste bubonica?";
        questoes[3] = "Você tem HIV?";
        questoes[4] = "Você tem DST's?";



        cont = 0;



        // tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);

        tvSwipe = findViewById(R.id.tvSwipe);



        tela.setOnTouchListener(new OnSwipeTouchListener(this){
            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvSwipe.setText("para Baixo!!!");

            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                tvSwipe.setText("para Cima!!!");
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                tvSwipe.setText("para Esquerda!!!");
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                while(cont<=0){
                 tvSwipe.setText(questoes[cont]);
                 cont ++;
                }

            }
        });

    }
}
