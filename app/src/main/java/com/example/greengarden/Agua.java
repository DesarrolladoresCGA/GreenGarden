package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Agua extends AppCompatActivity {
    Button btnRegistroAgua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua);

        btnRegistroAgua = findViewById(R.id.btnRegistrarAgua);

        btnRegistroAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Agua.this, Categorias.class);
                startActivity(intent);
            }
        });
    }
}