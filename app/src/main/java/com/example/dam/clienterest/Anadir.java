package com.example.dam.clienterest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Clase on 03/03/2016.
 */
public class Anadir extends AppCompatActivity {

    private EditText etidprofesor,ettipo,etfechai,etfechaf,etlugari,etlugarf,etdescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir);

        etidprofesor = (EditText)findViewById(R.id.etidprofesor);
        ettipo = (EditText)findViewById(R.id.ettipo);
        etfechai = (EditText)findViewById(R.id.etfechai);
        etfechaf = (EditText)findViewById(R.id.etfechaf);
        etlugari = (EditText)findViewById(R.id.etlugari);
        etlugarf = (EditText)findViewById(R.id.etlugarf);
        etdescripcion = (EditText)findViewById(R.id.etdescripcion);;

    }
    //------------onclick de los botones-------------------
    public void btanadirnuevas(View v) throws IOException {

        URL url = new URL("http://ieszv.x10.bz/restful/api/actividad");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("PUT");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        OutputStreamWriter out = new OutputStreamWriter(
                con.getOutputStream());
        out.write("{id:85555,idprofesor:1,tipo:excursion," +
                "fechai:2016-11-11 09:11,fechaf:2016-11-11 11:11 " +
                "lugari:555,lugarf:Granada,descripcion:..555., " +
                "alumno:luis}");

        String a="{id:"+"828"+
                     "idprofesor:"+"1"
                     +"tipo:"+"complementaria"+
                "fechai:"+"2016-01-01 00:00:00"+
                "fechaf:"+"2016-01-01 00:00:00"+
                "lugari:"+"Granada" +
                "lugarf:"+"Granada" +
                "descripcion:"+"que perita" +
                "alumno:"+ "luis" +
                "}";
        out.flush();
        out.close();
        BufferedReader in = new BufferedReader(new
                InputStreamReader(con.getInputStream()));
        String linea, todo="";
        while ((linea = in.readLine()) != null){
            todo+=linea;
        }
        in.close();
    }
    public void btsalir(View v){

    }
    //-----------------------------------------------------
}
