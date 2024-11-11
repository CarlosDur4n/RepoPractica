package com.example.practica3;

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
    Button agregar;
    ListView listaUser;
    List<String> mLista = new ArrayList<>();
    ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.txtUser);
        agregar = findViewById(R.id.btnAgregar);
        agregar.setOnClickListener(this);
        listaUser = findViewById(R.id.listaUsuario);
        listaUser.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgregar: String texto = user.getText().toString().trim();
            mLista.add(texto);
            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mLista);
            listaUser.setAdapter(mAdapter);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Usuario"+ i +"Agregado", Toast.LENGTH_SHORT).show();

    }
}