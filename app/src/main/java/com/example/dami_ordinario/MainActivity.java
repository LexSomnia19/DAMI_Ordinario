package com.example.dami_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText email, password;
    Button btnIniciarSesion;
    SharedPreferences Preferencias;

    /*private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS= "pass";*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        email  = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _email="";
                String _password="";
                _email = email.getText().toString();
                _password = password.getText().toString();
                GuardarDatos(_email,_password);

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                //Toast.makeText(MainActivity.this, "Inicio de sesion exitoso", Toast.LENGTH_SHORT).show();
            }
        });

        }
    private void GuardarDatos(String email, String password) {
        Preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Preferencias.edit();
        editor.putString("email",email);
        editor.putString("password",password);
        editor.commit();
    }



    }


