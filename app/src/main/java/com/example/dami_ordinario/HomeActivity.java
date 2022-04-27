package com.example.dami_ordinario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {


    TextView mensajenombre;
    Button CerrarSesion, Continuar;
    SharedPreferences Preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mensajenombre = (TextView) findViewById(R.id.mensajenombre);
        CerrarSesion = (Button) findViewById(R.id.CerrarSesion);
        Continuar = (Button) findViewById(R.id.Continuar);
        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            String dato1 = extras.getString("Nombre");
            //String dato2 = extras.getString("Telefono");
            if(!dato1.equals("")){
                mensajenombre.setText("Bienvenido "+dato1+" te logueaste correctamente");
            }
            else
                mensajenombre.setText("Los datos que enviaste son incorrectos");

        }
        else {
            mensajenombre.setText("No se envio ningun extra en el intent");
            LeerDatos();
        }



        CerrarSesion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
                //Toast.makeText(HomeActivity.this, "Cierre de sesion exitoso", Toast.LENGTH_SHORT).show();
                }
            }

        );
        Continuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(HomeActivity.this,VentanaMenu.class);
                startActivity(intent);
                //Toast.makeText(HomeActivity.this, "Cierre de sesion exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        );
    }

    private void LeerDatos() {
        Preferencias = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String dato1 = Preferencias.getString("Nombre","Erik");
        //String dato2 = Preferencias.getString("Telefono","No hay dato");
        if(!dato1.equals(""))
            mensajenombre.setText("Hola "+dato1+", te logueaste correctamente.");
        else
            mensajenombre.setText("Los datos que enviaste son incorrectos nombre: "+dato1);
    }
}