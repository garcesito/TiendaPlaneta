package com.garcesito.tiendaplaneta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pepel on 1/11/2017.
 */

public class BibliotecaAdapter extends RecyclerView.Adapter<BibliotecaAdapter.BibliotecaViewHolder> {

    Context context;
    private ArrayList<User> userList;

    public BibliotecaAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public BibliotecaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        BibliotecaViewHolder BibliotecaViewHolder = new BibliotecaViewHolder(itemView);
        return BibliotecaViewHolder;
    }

    @Override
    public void onBindViewHolder(BibliotecaViewHolder holder, int position) { //La posicion del arreglo que el va a cargar, el entra al arreglo n veces dependiendo del tamaño del listview y en la posicion que este, es la que carga
        User item = userList.get(position);
        holder.bindBiblioteca(item, context);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class BibliotecaViewHolder extends RecyclerView.ViewHolder{ //Se encarga de setear los valores en el xml

        private TextView tId, tName_user,tAutor, tPhone, tName;


        public BibliotecaViewHolder(View itemView) {
            super(itemView);
            tId = itemView.findViewById(R.id.tID);
            tName_user = itemView.findViewById(R.id.tName_user);
            tName = itemView.findViewById(R.id.tName);
            tAutor = itemView.findViewById(R.id.tAutor);
            tPhone = itemView.findViewById(R.id.tPhone);
        }

        public void bindBiblioteca(User user, Context context){
            tId.setText(user.getUid());
            tName.setText(user.getName());
            tName_user.setText(user.getName_user());
            tAutor.setText(user.getAutor());
            tPhone.setText(user.getPhone());
        }
    }
}
