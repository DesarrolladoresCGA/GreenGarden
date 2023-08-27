package com.example.greengarden;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;

public class usuarios extends AppCompatActivity {

    TableLayout tableLayout;

    String[] nombresCeldas = {"ID", "Nombre", "Usuario", "Correo", "Contraseña"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        tableLayout = findViewById(R.id.tablaUsuario);

        tableLayout.removeAllViews();

        //DatabaseHelper dbHelper = new DatabaseHelper(this, myDataBase, myContext);
        DatabaseHelper ddbb = new DatabaseHelper(this, "BBDD.db", null, 1);

        try {
            ddbb.createDataBase();
            ddbb.openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SQLiteDatabase db = ddbb.getReadableDatabase();

        String[] columnas = {"id", "nombre", "usuario", "correo"};

        Cursor cursor = db.query("usuarios", columnas, null, null, null, null, null);

        TableRow headerRow = new TableRow(this);


        tableLayout.addView(headerRow);
        GradientDrawable border = new GradientDrawable();
        border.setStroke(1, Color.WHITE); // Establecer el grosor y color del borde
        border.setCornerRadius(1);

        for (String columna : columnas) {
            TextView headerTextView = new TextView(this);
            headerTextView.setText(columna);
            headerTextView.setTextColor(Color.WHITE);
            headerRow.addView(headerTextView);
            headerTextView.setBackground(border);
            headerTextView.setGravity(Gravity.CENTER);
        }

        while (cursor.moveToNext()) {
            TableRow tableRow = new TableRow(this);

            for (int i = 0; i < columnas.length; i++) {
                TextView textView = new TextView(this);
                textView.setText(cursor.getString(i));
                textView.setTextColor(Color.WHITE);
                tableRow.addView(textView);
                textView.setBackground(border);
                textView.setGravity(Gravity.CENTER);
            }

            tableLayout.addView(tableRow);
        }

        cursor.close();
        db.close();
    }
}