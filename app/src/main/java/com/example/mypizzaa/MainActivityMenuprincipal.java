package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityMenuprincipal extends AppCompatActivity {

    private Button pizzaButton, bebidaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menuprincipal);

        pizzaButton = findViewById(R.id.btnpizza);
        bebidaButton = findViewById(R.id.btnbebida);

        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenuprincipal.this, PizzasActivity.class);
                startActivity(intent);
            }
        });

        bebidaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenuprincipal.this, activity_main_bebidas.class);
                startActivity(intent);
            }
        });
    }
}