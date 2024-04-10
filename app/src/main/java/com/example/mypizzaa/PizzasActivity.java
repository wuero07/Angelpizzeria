package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PizzasActivity extends AppCompatActivity {

    private ArrayList<Pizza> selectedPizzas;
    private ArrayList<Bebida> selectedBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        TextView userNameTextView = findViewById(R.id.userNameTextView);
        userNameTextView.setText("Bienvenido, " + nombreUsuario);

        selectedPizzas = new ArrayList<>();
        selectedBebidas = new ArrayList<>();

        Button addPizza1Button = findViewById(R.id.addPizza1Button);
        Button addPizza2Button = findViewById(R.id.addPizza2Button);
        Button addPizza3Button = findViewById(R.id.addPizza3Button);

        addPizza1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPizzas.add(new Pizza("Pizza peperoni", 100.0));
                updateSelectedPizzasTextView();
            }
        });

        addPizza2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPizzas.add(new Pizza("Pizza Hawaiana", 120.0));
                updateSelectedPizzasTextView();
            }
        });

        addPizza3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPizzas.add(new Pizza("Pizza mexicana", 110.0));
                updateSelectedPizzasTextView();
            }
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("nombreUsuario", nombreUsuario);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPrice = calculateTotalPrice();
                Intent intent = new Intent(PizzasActivity.this, activity_main_bebidas.class);
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
        for (Pizza pizza : selectedPizzas) {
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }

    private ArrayList<String> getPizzaNames(ArrayList<Pizza> pizzas) {
        ArrayList<String> pizzaNames = new ArrayList<>();
        for (Pizza pizza : pizzas) {
            pizzaNames.add(pizza.getName());
        }
        return pizzaNames;
    }

    private ArrayList<String> getBebidaNames(ArrayList<Bebida> bebidas) {
        ArrayList<String> BebidaNames = new ArrayList<>();
        for (Bebida bebida : bebidas) {
            BebidaNames.add(bebida.getName());
        }
        return BebidaNames;
    }

    private void updateSelectedPizzasTextView() {
        TextView selectedPizzasTextView = findViewById(R.id.selectedPizzasTextView);
        StringBuilder pizzasText = new StringBuilder("Pizzas seleccionadas:\n");
        for (Pizza pizza : selectedPizzas) {
            pizzasText.append(pizza.getName()).append("\n");
        }
        selectedPizzasTextView.setText(pizzasText.toString());
    }
}
