package com.example.dam.clienterest.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dam.clienterest.POJO.Actividad;
import com.example.dam.clienterest.R;

import java.util.ArrayList;


public class AdaptadorActividades extends ArrayAdapter<Actividad>{

    private int res;
    private LayoutInflater lInflator;
    private ArrayList<Actividad> valores;
    private Context con;

    static class ViewHolder{
        public TextView tvTitulo,tvfecha;

    }


    public AdaptadorActividades(Context context, int resource, ArrayList<Actividad> objects) {
        super(context, resource, objects);
        this.res= resource; // LAYOUT
        this.valores= objects; // LISTA DE VALORES
        this.con= context;
        lInflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder gv= new ViewHolder();
        if(convertView==null){
            convertView= lInflator.inflate(res, null);
            TextView tvTitulo= (TextView)convertView.findViewById(R.id.tvitem1);
            gv.tvTitulo=tvTitulo;
            TextView tvfecha= (TextView)convertView.findViewById(R.id.tvitem2);
            gv.tvfecha=tvfecha;

            convertView.setTag(gv);
        }else{
            gv= (ViewHolder) convertView.getTag();
        }
        gv.tvTitulo.setText(valores.get(position).getTipo());
        gv.tvfecha.setText(valores.get(position).getFechai());
        return convertView;
    }


}
