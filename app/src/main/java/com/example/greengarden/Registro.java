package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class Registro extends AppCompatActivity {
    Button btnRegistrar, btnCancelar;
    EditText txtNombre,txtUsuario,txtCorreo,txtContrasena,txtConContrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnCancelar = findViewById(R.id.btnCancelar);
        txtNombre = findViewById(R.id.txtNombreRegistro);
        txtUsuario = findViewById(R.id.txtUsuarioRegistro);
        txtCorreo = findViewById(R.id.txtCorreoRegistro);
        txtContrasena = findViewById(R.id.txtContraRegistro);
        txtConContrasena = findViewById(R.id.txtConfirmarContraRegistro);

        //DatabaseHelper dbHelper = new DatabaseHelper(this, myDataBase, myContext);
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
                if(txtNombre.getText().toString().isEmpty() & txtUsuario.getText().toString().isEmpty() & txtContrasena.getText().toString().isEmpty()){
                    Toast.makeText(Registro.this,"No puede quedar ningun campo vacio",Toast.LENGTH_SHORT).show();
                }else{
                    if (txtContrasena.getText().toString().equals(txtConContrasena.getText().toString())){
                        SQLiteDatabase db = ddbb.getWritableDatabase();

                        ContentValues values = new ContentValues();
                        values.put("nombre", txtNombre.getText().toString());
                        values.put("usuario", txtUsuario.getText().toString());
                        values.put("correo", txtCorreo.getText().toString());
                        values.put("contrasena", txtContrasena.getText().toString());

                        long resultado = db.insert("usuarios", null, values);
                        if (resultado != -1) {
                            Toast.makeText(Registro.this, "Usuario registrado Correctamente", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Registro.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Registro.this, "Error al guardar los datos", Toast.LENGTH_SHORT).show();
                        }

                        ddbb.close();
                        db.close();
                    }else{
                        Toast.makeText(Registro.this,"Con coincide las Contraseñas",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}