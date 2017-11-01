package com.garcesito.tiendaplaneta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaActivity extends BaseDrawerActivity implements NavigationView.OnNavigationItemSelectedListener {

    ListView list;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista);

        FrameLayout contentFrameLayaout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_lista, contentFrameLayaout); //Inflamos, el contenido de nuestra ac¿tividad lista al contenido del framelayaout

        users = new ArrayList<User>();
        list = (ListView) findViewById(R.id.list);

        final Adapter adapter = new Adapter(this, users);
        list.setAdapter(adapter);
    }

    class Adapter extends ArrayAdapter<User> {

        public Adapter(@NonNull Context context, ArrayList<User> user) {
            super(context, R.layout.lista_item, users);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View view = inflater.inflate(R.layout.lista_item, null);

            User user = getItem(position);

            TextView tUid = view.findViewById(R.id.tID);
            tUid.setText(user.getUid());
            TextView tName = view.findViewById(R.id.tName);
            tName.setText(user.getName());
            TextView tName_user = view.findViewById(R.id.tName_user);
            tName.setText(user.getName_user());
            TextView tAutor = view.findViewById(R.id.tAutor);
            tAutor.setText(user.getAutor());
            TextView tPhone = view.findViewById(R.id.tPhone);
            tPhone.setText(user.getPhone());

            return view;
        }
    }
}

