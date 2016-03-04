package com.example.dam.clienterest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dam.clienterest.Adaptadores.AdaptadorActividades;
import com.example.dam.clienterest.Interfaces.Cliente;
import com.example.dam.clienterest.POJO.Actividad;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    AdaptadorActividades ad;
    Retrofit retrofit;
    List<Actividad> listaActividades= new ArrayList<Actividad>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://ieszv.x10.bz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Cliente api = retrofit.create(Cliente.class);
        Call<List<Actividad>> call = api.getActividades();
        call.enqueue(new Callback<List<Actividad>>() {
            @Override
            public void onResponse(Response<List<Actividad>>
                                           response, Retrofit retrofit) {
                for (Actividad a : response.body()) {
                    Log.v("xxx", a.toString());
                    listaActividades.add(a);
                    System.out.println("xxxx222" + listaActividades.toString());
                }

            }

            @Override
            public void onFailure(Throwable t) {
                t.getLocalizedMessage();
            }

        });
        this.init();
    }
    public void init(){
        lv = (ListView) findViewById(R.id.lvActividades);
        ad = new AdaptadorActividades(this, R.layout.item, (ArrayList<Actividad>) listaActividades);
        lv.setAdapter(ad);
        this.registerForContextMenu(lv);
    }
    //------------menu principal--------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_anadir: {

                //añadir nota
                Intent i = new Intent(this,Anadir.class);
                startActivity(i);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    //-----------------------------------------------------------
    //---------Menu ListView-------------------------------------

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = menuInfo.position;
        switch (item.getItemId()) {
            case R.id.menu_Mostar: {
                Intent i = new Intent(this, Mostrar.class);

                i.putExtra("tipo", listaActividades.get(pos).getTipo());
                i.putExtra("fechai", listaActividades.get(pos).getFechai());
                i.putExtra("fechaf", listaActividades.get(pos).getFechaf());
                i.putExtra("lugari", listaActividades.get(pos).getLugari());
                i.putExtra("lugarf", listaActividades.get(pos).getLugarf());
                i.putExtra("descripcion", listaActividades.get(pos).getDescripcion());
                startActivity(i);
                return true;
            }

            default:
                return super.onContextItemSelected(item);
        }
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lisview, menu);
    }
    //-------------------------------------------------------------------
    //--------------onclik de los botones de las activity_main----------------------------
    public void btmostrarActividades(View v){
this.init();
//        Cliente api = retrofit.create(Cliente.class);
//        Call<List<Actividad>> call = api.getActividades();
//        call.enqueue(new Callback<List<Actividad>>() {
//            @Override
//            public void onResponse(Response<List<Actividad>>
//                                           response, Retrofit retrofit) {
//                for (Actividad a : response.body()) {
//                    Log.v("xxx", a.toString());
//                    listaActividades.add(a);
//                    System.out.println("xxxx222" + listaActividades.toString());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                t.getLocalizedMessage();
//            }
//
//        });
    }
    //------------------------------------------------------------------------------------


}
