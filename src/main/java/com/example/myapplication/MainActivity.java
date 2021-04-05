package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNama     = findViewById(R.id.et_nama);
        EditText etNIM      = findViewById(R.id.et_nim);
        EditText etNilai     = findViewById(R.id.et_nilai);
        Button btnSubmit    = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(v -> {
            try {
                String nama    = etNama.getText().toString();
                String nim     = etNIM.getText().toString();
                String score   = etNilai.getText().toString();
                Intent i = new Intent(MainActivity.this, HasilOutput.class);
                i.putExtra("NAMA", nama);
                i.putExtra("NIM", nim);
                double skor   = Double.parseDouble(score);

                if(skor <= 4.00){
                    if(skor > 3.66 && skor <= 4.00){
                        i.putExtra("PREDIKAT", "A");
                    }else if(skor > 3.33 && skor <= 3.66) {
                        i.putExtra("PREDIKAT", "A-");
                    }else if(skor > 3.00 && skor <= 3.33) {
                        i.putExtra("PREDIKAT", "B+");
                    }else if(skor > 2.66 && skor <= 3.00) {
                        i.putExtra("PREDIKAT", "B");
                    }else if(skor > 2.33 && skor <= 2.66) {
                        i.putExtra("PREDIKAT", "B-");
                    }else if(skor > 2.00 && skor <= 2.33) {
                        i.putExtra("PREDIKAT", "C+");
                    }else if(skor > 1.66 && skor <= 2.00) {
                        i.putExtra("PREDIKAT", "C");
                    }else if(skor > 1.33 && skor <= 1.66) {
                        i.putExtra("PREDIKAT", "C-");
                    }else if(skor > 1.00 && skor <= 1.33) {
                        i.putExtra("PREDIKAT", "D+");
                    }else {
                        i.putExtra("PREDIKAT", "D");
                    }
                    startActivity(i);
                }else {
                    Toast.makeText(getApplication(), "Nilai tidak boleh diatas 4.00", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplication(), "Field harus diisi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}