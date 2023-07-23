package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Luz extends AppCompatActivity {
    Button btnRegistroLuz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        btnRegistroLuz = findViewById(R.id.btnRegistrarLuz);

        btnRegistroLuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Luz.this, Categorias.class);
                startActivity(intent);
            }
        });
    }
}