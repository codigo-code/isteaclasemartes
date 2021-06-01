package com.xr.ejemploleanjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View vista = LayoutInflater.from(this).inflate(R.layout.actividad_dos,null);
        LinearLayout layoutDos = (LinearLayout)findViewById(R.id.layoutdos);
        Button mas = (Button) vista.findViewById(R.id.mas);
        layoutDos.addView(vista);
        TextView numero = (TextView)findViewById(R.id.numero) ;

        mas.setOnClickListener(view -> {
            contador++;
            numero.setText(""+contador);

        });


    }


}