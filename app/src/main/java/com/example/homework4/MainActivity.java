package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button save;
    private TextView greetings1, greetings2;
    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.lblNombre);
        save = findViewById(R.id.btnSave);

        greetings1 = findViewById(R.id.txtGreetings);
        greetings2 = findViewById(R.id.txtGreetings2);

        properties = new Properties();
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        if(file.exists()){
            Toast.makeText(this, "YA EXISTE EL ARCHIVO", Toast.LENGTH_SHORT).show();
            try{
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            greetings1.setText(properties.getProperty("g1"));
            greetings2.setText(properties.getProperty("g2"));
            nombre.setText(properties.getProperty("nombre"));

        }else{
            Toast.makeText(this,"NO EXISTE EL ARCHIVO",Toast.LENGTH_SHORT).show();
            saveProperties();
            firstTime();
        }


    }

    private void saveProperties(){
        try {
            FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    //  GUARDAMOS SOLO EN MEMORIA
    public void guardarMemoria(View v){
        properties.put("nombre", nombre.getText().toString());
        saveProperties();
    }

    //  SE INSERTAN LOS GREETINGS
    public void firstTime(){
        properties.put("g1","Gustavo");
        properties.put("g2","A01635151");
        saveProperties();
    }

    public void menu(View v){
        Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
    }
}
