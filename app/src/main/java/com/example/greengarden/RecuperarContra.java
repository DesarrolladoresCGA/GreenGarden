package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecuperarContra extends AppCompatActivity {
    Button btnCancelar, btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        btnEnviar = findViewById(R.id.btnEnviarRecuperarContra);
        btnCancelar = findViewById(R.id.btnCancelarRecuperarContra);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecuperarContra.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecuperarContra.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}