package com.example.mypizzaa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Activity_main_pago extends AppCompatActivity {

    private TextView itemListTextView, totalTextView;
    private Button confirmButton;
    private ArrayList<String> items;
    private double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pago);

        itemListTextView = findViewById(R.id.itemListTextView);
        totalTextView = findViewById(R.id.totalTextView);
        confirmButton = findViewById(R.id.confirmButton);
        items = new ArrayList<>();

        ArrayList<String> pizzas = getIntent().getStringArrayListExtra("pizzas");
        ArrayList<Bebida> bebidas = getIntent().getParcelableArrayListExtra("bebidas");

        if (pizzas != null) {
            items.addAll(pizzas);
        }

        if (bebidas != null) {

            for (Bebida bebida : bebidas) {
                items.add(bebida.getName() + " - $" + bebida.getPrice());
            }
        }

        totalPrice = getIntent().getDoubleExtra("totalPrice", 0.0);


        StringBuilder itemListBuilder = new StringBuilder();
        for (String item : items) {
            itemListBuilder.append(item).append("\n");
        }
        itemListTextView.setText(itemListBuilder.toString());


        totalTextView.setText("Total: $" + totalPrice);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                finish();
            }
        });
    }}
