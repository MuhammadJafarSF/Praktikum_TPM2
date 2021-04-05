package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HasilOutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_activity);

        TextView txtNama     = findViewById(R.id.nama);
        TextView txtNim      = findViewById(R.id.nim);
        TextView txtPredikat = findViewById(R.id.predikat);

        Bundle extras = getIntent().getExtras();

        String nama = extras.getString("NAMA");
        txtNama.setText(String.format(": %s", nama));

        String nim = extras.getString("NIM");
        txtNim.setText(String.format(": %s", nim));

        String nilai = extras.getString("PREDIKAT");
        txtPredikat.setText(String.format(": %s", nilai));
    }
}
