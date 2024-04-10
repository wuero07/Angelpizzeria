package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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

        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");

        TextView userNameTextView = findViewById(R.id.userNameTextView);
        userNameTextView.setText("Bienvenido, " + nombreUsuario);

        itemListTextView = findViewById(R.id.itemListTextView);
        totalTextView = findViewById(R.id.totalTextView);
        confirmButton = findViewById(R.id.confirmButton);
        items = new ArrayList<>();

        ArrayList<Pizza> pizzas = getIntent().getParcelableArrayListExtra("pizzas");
        ArrayList<Bebida> bebidas = getIntent().getParcelableArrayListExtra("bebidas");

        double totalPricePizzas = 0.0;
        double totalPriceBebidas = 0.0;

        boolean hasItems = false;

        if (pizzas != null && !pizzas.isEmpty()) {
            for (Pizza pizza : pizzas) {
                items.add(pizza.getName() + " - $" + pizza.getPrice());
                totalPricePizzas += pizza.getPrice();
                hasItems = true;
            }
        }

        if (bebidas != null && !bebidas.isEmpty()) {
            for (Bebida bebida : bebidas) {
                items.add(bebida.getName() + " - $" + bebida.getPrice());
                totalPriceBebidas += bebida.getPrice();
                hasItems = true;
            }
        }

        if (!hasItems) {
            Toast.makeText(Activity_main_pago.this, "Por favor, selecciona al menos un producto", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        totalPrice = totalPricePizzas + totalPriceBebidas;

        StringBuilder itemListBuilder = new StringBuilder();
        for (String item : items) {
            itemListBuilder.append(item).append("\n");
        }
        itemListTextView.setText(itemListBuilder.toString());

        totalTextView.setText("Total: $" + totalPrice);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_main_pago.this, "Gracias por su compra, vuelva pronto", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_main_pago.this, MainActivityMenuprincipal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

