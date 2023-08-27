package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Principal extends AppCompatActivity {

    LinearLayout lnlEstadisticas, lnlCategorias, lnlConsejos, lnlUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lnlEstadisticas = findViewById(R.id.lnlEstadisticas);
        lnlCategorias = findViewById(R.id.lnlCategorias);
        lnlConsejos = findViewById(R.id.lnlConsejos);
        lnlUsuario = findViewById(R.id.lnlUsuarios);

        lnlEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, Estadisticas.class);
                startActivity(intent);
            }
        });
        lnlCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, Categorias.class);
                startActivity(intent);
            }
        });
        lnlConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, Consejos.class);
                startActivity(intent);
            }
        });
        lnlUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Principal.this, usuarios.class);
                startActivity(intent);
            }
        });
    }
}