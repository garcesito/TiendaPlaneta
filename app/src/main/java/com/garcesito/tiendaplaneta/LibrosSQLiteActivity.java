package com.garcesito.tiendaplaneta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class LibrosSQLiteActivity extends BaseDrawerActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText eID, eName, ePhone, eName_user,eAutor;
    BibliotecaSQLiteHelper bibliotecaSQLiteHelper;
    SQLiteDatabase dbBiblioteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_libros_sqlite);

        FrameLayout contentFrameLayaout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_libros_sqlite, contentFrameLayaout); //Inflamos, el contenido de nuestra ac¿tividad lista al contenido del framelayaout

        eID = (EditText) findViewById(R.id.eID);
        eName = (EditText) findViewById(R.id.eName);
        eName_user = (EditText) findViewById(R.id.eName_user);
        eAutor = (EditText) findViewById(R.id.eAutor);
        ePhone = (EditText) findViewById(R.id.ePhone);

        bibliotecaSQLiteHelper = new BibliotecaSQLiteHelper(this, "LibrosBD", null, 1);
        dbBiblioteca = bibliotecaSQLiteHelper.getWritableDatabase(); //Conectar el objeto de base de datos con el gestionador
    }
    public void onClick(View view) {
        int id = view.getId();

        String name, autor, phone,name_user;
        final String uidd;

        name = eName.getText().toString();
        name_user = eName_user.getText().toString();
        autor = eAutor.getText().toString();
        phone = ePhone.getText().toString();

        ContentValues data = new ContentValues(); //Tipo de datos
        //Por fuera del SW para utilizarlo en bCreate y en bUpdate

        switch (id){
            case R.id.bCreate:


                data.put("name",name); //Llave con el mismo nombvre de los campos de la clase AgendaSQLiteActivity
                data.put("phone", phone); //Reconoce mayúsculas y minúsculas
                data.put("autor", autor);
                data.put("name_user", name_user);

                dbBiblioteca.insert("biblioteca",null,data);
                clean();

                break;
            case R.id.bRead:
                // Read from the database

                Cursor c = dbBiblioteca.rawQuery("SELECT * FROM libros WHERE name='"+name+"'",null);//Almacenar las busquedas que se realizan con las bases de datos

                if(c.moveToFirst()){ //c.mo para moverse al primero si existe y asi, retorna un true o un false si esta o no
                    ePhone.setText(c.getString(4));
                    eAutor.setText(c.getString(2));
                    eName_user.setText(c.getString(3));

                }else{
                    Toast.makeText(this, "No Existe", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.bUpdate:

                data.put("phone",phone);
                //data.put("autor",autor);
                data.put("name_user",name_user);

                dbBiblioteca.update("biblioteca",data, "name = '"+name+"'", null);

                clean();

                break;
            case R.id.bDelete:

                dbBiblioteca.delete("biblioteca", "name = '"+name+"'", null);

                clean();

                break;
        }
    }

    private void clean() {
        eAutor.setText("");
        eName.setText("");
        eName_user.setText("");
        eID.setText("");
        ePhone.setText("");
    }
}
