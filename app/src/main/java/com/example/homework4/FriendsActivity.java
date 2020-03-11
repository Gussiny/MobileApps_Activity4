package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {
    private EditText nombre, hobbies;
    private DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        nombre = findViewById(R.id.lblNombre);
        hobbies = findViewById(R.id.lblHobbie);
        db = new DBHelper(this);
    }

    public void guardar(View v){
        db.insertar(nombre.getText().toString(), hobbies.getText().toString());
        nombre.setText("");
        hobbies.setText("");
        Toast.makeText(this, "INSERTADO", Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v){
        String hobbieBuscado = db.buscar(nombre.getText().toString());
        Toast.makeText(this, nombre.getText().toString(), Toast.LENGTH_SHORT).show();
        hobbies.setText(hobbieBuscado);
    }

    public void eliminar(View v){
        int eliminado = db.eliminar(nombre.getText().toString());
        Toast.makeText(this, eliminado + "", Toast.LENGTH_SHORT).show();
    }
}
