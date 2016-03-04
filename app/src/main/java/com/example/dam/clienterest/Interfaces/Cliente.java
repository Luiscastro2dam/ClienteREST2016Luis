package com.example.dam.clienterest.Interfaces;

import com.example.dam.clienterest.POJO.Actividad;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;


public interface Cliente {


    @GET("restful/api/actividad/luis")
    Call<List<Actividad>> getActividades();

    @POST("restful/api/actividad/luis")
    Call<Actividad> anadiractividadnueva(@Body Actividad actividad);

}
