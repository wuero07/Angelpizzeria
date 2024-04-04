package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class activity_main_bebidas extends AppCompatActivity {

    private ArrayList<Bebida> selectedBebidas;
    private ArrayList<Pizza> selectedPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bebidas);

        selectedBebidas = new ArrayList<>();
        selectedPizzas = getIntent().getParcelableArrayListExtra("pizzas");


        Button addBebida1Button = findViewById(R.id.addBebida1Button);
        Button addBebida2Button = findViewById(R.id.addBebida2Button);
        Button addBebida3Button = findViewById(R.id.addBebida3Button);


        addBebida1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedBebidas.add(new Bebida("Coca-Cola", 2.0));
            }
        });

        addBebida2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedBebidas.add(new Bebida("Jugo de Naranja", 3.0));
            }
        });

        addBebida3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedBebidas.add(new Bebida("Agua Mineral", 1.0));
            }
        });


        Button backButton = findViewById(R.id.backButton);
        Button payButtonBebidas = findViewById(R.id.payButtonBebidas);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Regresa a la actividad anterior
            }
        });

        payButtonBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPrice = calculateTotalPrice();
                Intent intent = new Intent(activity_main_bebidas.this, Activity_main_pago.class);
                intent.putExtra("pizzas", selectedPizzas);
                intent.putParcelableArrayListExtra("bebidas", selectedBebidas);
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });
    }


    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (Bebida bebida : selectedBebidas) {
            totalPrice += bebida.getPrice();
        }
        return totalPrice;
    }
}

