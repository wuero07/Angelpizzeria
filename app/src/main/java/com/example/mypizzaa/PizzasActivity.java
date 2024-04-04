package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class PizzasActivity extends AppCompatActivity {

    private ArrayList<Pizza> selectedPizzas; // Lista para almacenar las pizzas seleccionadas
    private ArrayList<Bebida> selectedBebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pizzas);
        // Dentro de onCreate
        Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPrice = calculateTotalPrice();
                Intent intent = new Intent(PizzasActivity.this, Activity_main_pago.class);
                intent.putStringArrayListExtra("pizzas", getPizzaNames(selectedPizzas)); // Pasar nombres de las pizzas seleccionadas
                intent.putStringArrayListExtra("bebidas", getBebidaNames(selectedBebidas));
                intent.putExtra("totalPrice", totalPrice);
                startActivity(intent);
            }
        });


        selectedPizzas = new ArrayList<>(); // Inicializar la lista de pizzas seleccionadas
        selectedBebidas = new ArrayList<>();


        Button addPizza1Button = findViewById(R.id.addPizza1Button);
        Button addPizza2Button = findViewById(R.id.addPizza2Button);
        Button addPizza3Button = findViewById(R.id.addPizza3Button);


        addPizza1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedPizzas.add(new Pizza("Pizza peperoni", 10.0));
            }
        });

        addPizza2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedPizzas.add(new Pizza("Pizza Hawaiana", 12.0));
            }
        });

        addPizza3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedPizzas.add(new Pizza("Pizza Vegetariana", 11.0));
            }
        });

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pasa a la siguiente actividad
                Intent intent = new Intent(PizzasActivity.this, activity_main_bebidas.class);
                startActivity(intent);
            }
        });


        Button backButton = findViewById(R.id.backButton);
        //Button payButton = findViewById(R.id.payButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double totalPrice = calculateTotalPrice();
                Intent intent = new Intent(PizzasActivity.this, Activity_main_pago.class);
                intent.putStringArrayListExtra("pizzas", getPizzaNames(selectedPizzas)); // Pasar nombres de las pizzas seleccionadas
                intent.putStringArrayListExtra("bebidas", getBebidaNames(selectedBebidas));
                intent.putExtra("totalPrice", totalPrice);
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

    //obtener los nombres de las pizzas seleccionadas
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
}
