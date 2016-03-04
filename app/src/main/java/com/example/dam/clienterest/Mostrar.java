package com.example.dam.clienterest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class Mostrar extends AppCompatActivity {

    private EditText etidprofesor,ettipo,etfechai,etfechaf,etlugari,etlugarf,etdescripcion;
private int idpro;
    private String tipo,fechai,fechaf,lugari,lugarf,descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar);

        Bundle datos = this.getIntent().getExtras();
        int idpr = datos.getInt("variable_integer");
        tipo = datos.getString("tipo");
        fechai = datos.getString("fechai");
        fechaf = datos.getString("fechaf");
        lugari = datos.getString("lugari");
        lugarf = datos.getString("lugarf");
        descripcion = datos.getString("descripcion");


        etidprofesor = (EditText)findViewById(R.id.etmosidpro);
        ettipo = (EditText)findViewById(R.id.etmostipo);
        etfechai = (EditText)findViewById(R.id.etmosfechi);
        etfechaf = (EditText)findViewById(R.id.etmosfechf);
        etlugari = (EditText)findViewById(R.id.etmoslugi);
        etlugarf = (EditText)findViewById(R.id.etmoslugf);
        etdescripcion = (EditText)findViewById(R.id.etmosdesc);

        this.mostrardatos();
    }
    public void mostrardatos(){
        ettipo.setText(tipo);
        etfechai.setText(fechai);
        etfechaf.setText(fechaf);
        etlugari.setText(lugari);
        etlugarf.setText(lugarf);
        etdescripcion.setText(descripcion);
    }
    public void btmodificar(View v){

    }
    public void btsalir(View v){

    }
}
