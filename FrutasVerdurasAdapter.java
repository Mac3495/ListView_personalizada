package com.example.android.listview_simple;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Marcelo Torrez on 06/11/2016.
 * Adaptador para listas personalizadas
 */

public class FrutasVerdurasAdapter extends ArrayAdapter {

    /*Primero creamos el contexto y las variables del layout y el vector del objeto*/

    Context mycontext;
    int my_layout_resuorce_id;
    FrutasVerduras mydata[] = null;

    /*En el constructor seguir estos pasos*/

    public FrutasVerdurasAdapter(Context context, int layout_resuorce_id, FrutasVerduras[] data){
        super(context,layout_resuorce_id,data);
        this.mycontext = context;
        this.my_layout_resuorce_id = layout_resuorce_id;
        this.mydata = data;
    }

    /*getView Hace el trabajo de llenar la lista personalizada*/

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        FrutasVerdurasHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)mycontext).getLayoutInflater();
            row = inflater.inflate(my_layout_resuorce_id,parent,false);

            holder = new FrutasVerdurasHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            holder.textView = (TextView) row.findViewById(R.id.tw);
            row.setTag(holder);

        }else{
            holder = (FrutasVerdurasHolder) row.getTag();
        }

        FrutasVerduras frutasVerduras = mydata[position];
        holder.textView.setText(frutasVerduras.title);
        holder.image.setImageResource(frutasVerduras.icon);

        return row;
    }

    /*Holder = El que se encarga de ordenar y que los datos no se pierdan*/
    static class FrutasVerdurasHolder{
        ImageView image;
        TextView textView;
    }
}
