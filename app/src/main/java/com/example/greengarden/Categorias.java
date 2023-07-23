package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categorias extends AppCompatActivity {
    Button btnAgua,btnLuz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        btnLuz = findViewById(R.id.btnElectricidad);
        btnAgua = findViewById(R.id.btnAgua);

        btnLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorias.this,Luz.class);
                startActivity(intent);
            }
        });
        btnAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categorias.this,Agua.class);
                startActivity(intent);
            }
        });
    }
}