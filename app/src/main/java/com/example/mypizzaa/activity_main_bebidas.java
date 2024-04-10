package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class activity_main_bebidas extends AppCompatActivity {

    private ArrayList<Bebida> selectedBebidas;
    private ArrayList<Pizza> selectedPizzas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bebidas);

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        TextView userNameTextView = findViewById(R.id.userNameTextView);
        userNameTextView.setText("Bienvenido, " + nombreUsuario);

        selectedBebidas = new ArrayList<>();
        selectedPizzas = getIntent().getParcelableArrayListExtra("pizzas");

        Button addBebida1Button = findViewById(R.id.addBebida1Button);
        Button addBebida2Button = findViewById(R.id.addBebida2Button);
        Button addBebida3Button = findViewById(R.id.addBebida3Button);

        addBebida1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedBebidas.add(new Bebida("Coca-Cola", 16.0));
                updateSelectedBebidasTextView();
            }
        });

        addBebida2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedBebidas.add(new Bebida("Jugo de Naranja", 20.0));
                updateSelectedBebidasTextView();
            }
        });

        addBebida3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedBebidas.add(new Bebida("Agua Mineral", 10.0));
                updateSelectedBebidasTextView();
            }
        });

        Button backButton = findViewById(R.id.backButton);
        Button payButtonBebidas = findViewById(R.id.payButtonBebidas);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                intent.putExtra("nombreUsuario", nombreUsuario);
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

    private void updateSelectedBebidasTextView() {
        TextView selectedBebidasTextView = findViewById(R.id.selectedBebidasTextView);
        StringBuilder bebidasText = new StringBuilder("Bebidas seleccionadas:\n");
        for (Bebida bebida : selectedBebidas) {
            bebidasText.append(bebida.getName()).append("\n");
        }
        selectedBebidasTextView.setText(bebidasText.toString());
    }
}

