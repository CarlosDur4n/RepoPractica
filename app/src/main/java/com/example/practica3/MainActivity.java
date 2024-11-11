package com.example.practica3;

// Importación de clases necesarias para construir la interfaz gráfica y manejar eventos en Android
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    EditText user;
    Button agregar, eliminar;
    ListView listaUser;
    List<String> mLista = new ArrayList<>(); // Lista de datos donde se almacenarán los usuarios
    ArrayAdapter<String> mAdapter; // Adaptador de tipo ArrayAdapter para vincular mLista con el ListView
    int x;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.txtUser);
        agregar = findViewById(R.id.btnAgregar);
        agregar.setOnClickListener(this);
        eliminar = findViewById(R.id.btnEliminar);
        listaUser = findViewById(R.id.listaUsuario);
        listaUser.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgregar:
                String texto = user.getText().toString().trim();
                if (!texto.isEmpty()) { //
                    mLista.add(texto);
                    user.setText("");
                    //Se crea un ArrayList para mostrar el contenido
                    mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mLista);
                    listaUser.setAdapter(mAdapter); // Le hacemos un setAdapter a listaUser para que se actualice con los nuevos datos
                }
                break;
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
        Toast.makeText(this, "Usuario " + posicion + " Agregado", Toast.LENGTH_SHORT).show();
    }
}
