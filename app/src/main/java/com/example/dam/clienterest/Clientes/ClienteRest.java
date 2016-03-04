package com.example.dam.clienterest.Clientes;

import com.example.dam.clienterest.Interfaces.Cliente;
import com.example.dam.clienterest.POJO.Actividad;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;


public class ClienteRest implements Cliente{

    @Override
    public Call<List<Actividad>> getActividades() {
        return null;
    }

    @Override
    public Call<Actividad> anadiractividadnueva(@Body Actividad actividad) {
        return null;
    }

//    @Override
//    public Call<Actividad> anadiractividadnueva(Actividad actividad) {
//        return null;
//    }


}
