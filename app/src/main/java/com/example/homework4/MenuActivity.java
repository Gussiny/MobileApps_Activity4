package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView hobbie;
    private EditText myHobbie;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        db = new DBHelper(this);
        hobbie = findViewById(R.id.txtHobbie);
        myHobbie = findViewById(R.id.lblHobbie);
        hobbie.setText(db.buscar("Gustavo"));
    }

    public void hobbies(View v){
        Intent hobbieIntent = new Intent(this, HobbiesActivity.class);
        startActivity(hobbieIntent);
    }

    public void friends(View v){
        Intent friendsIntent = new Intent(this, FriendsActivity.class);
        startActivity(friendsIntent);
    }

    public void cambiarHobbie(View v){
        db.eliminar("Gustavo");
        db.insertar("Gustavo", myHobbie.getText().toString());
        Toast.makeText(this,"CAMBIADO EL HOBBIE", Toast.LENGTH_SHORT).show();
        hobbie.setText(db.buscar("Gustavo"));
    }


}
