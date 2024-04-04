package com.example.mypizzaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String USUARIO_VALIDO = "Angel";
    private static final String CONTRASENA_VALIDA = "2004";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        final EditText editTextContrasena = findViewById(R.id.editTextContraseña);
        Button buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContrasena.getText().toString();

                if (!usuario.isEmpty() && !contraseña.isEmpty()) {
                    // Aquí se realiza la validación de usuario y contraseña
                    if (usuario.equals(USUARIO_VALIDO) && contraseña.equals(CONTRASENA_VALIDA)) {
                        // Si la validación es exitosa, se muestra un mensaje de inicio de sesión exitoso
                        Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        // Y se inicia MainActivity
                        Intent intent = new Intent(MainActivity.this, MainActivityMenuprincipal.class);
                        startActivity(intent);
                    } else {
                        // Si la validación falla, se muestra un mensaje de error
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Si alguno de los campos está vacío, se muestra un mensaje solicitando completar ambos campos
                    Toast.makeText(MainActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
