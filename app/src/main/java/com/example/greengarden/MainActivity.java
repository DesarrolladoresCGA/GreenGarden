package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView btnRegistrar, btnRecuperarContra;
    Button btnIngresar;
    EditText txtUsuaro,txtContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRegistrar = findViewById(R.id.lblRegistrarse);
        btnRecuperarContra = findViewById(R.id.lblRecuprarContra);
        btnIngresar = findViewById(R.id.btnIngresar);
        txtUsuaro = findViewById(R.id.txtLogin);
        txtContrasena = findViewById(R.id.txtContrasena);

        DatabaseHelper ddbb = new DatabaseHelper(this, "BBDD.db", null, 1);

        try {
            ddbb.createDataBase();
            ddbb.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            }
        });
        btnRecuperarContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecuperarContra.class);
                startActivity(intent);
            }
        });
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsuaro.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"El campo del Usurio no puede quedar vacio",Toast.LENGTH_SHORT).show();
                }else{
                    if(txtContrasena.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this,"El campo de la Contraseña no puede quedar vacio",Toast.LENGTH_SHORT).show();
                    }else{
                        String usuario = txtUsuaro.getText().toString();
                        String contra = txtContrasena.getText().toString();
                        //boolean login = new ddbb.LoginUsuario(usuario,contra);
                        boolean login = ddbb.LoginUsuario(usuario,contra);
                        if (login){
                            txtUsuaro.setText("");
                            txtContrasena.setText("");
                            Toast.makeText(MainActivity.this,"Bienvenido: " + usuario,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Principal.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,"Error usuario verifque que sus datos esten correctos y si " +
                                    "no se a registrado Por favor registrarse",Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }
        });

    }

}