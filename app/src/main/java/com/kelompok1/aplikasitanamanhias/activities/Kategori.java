package com.kelompok1.aplikasitanamanhias.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.kelompok1.tanamanhias.R;

import androidx.appcompat.app.AppCompatActivity;

public class Kategori extends AppCompatActivity {

    private ImageView imageView;
    private Button bunga, daun, buah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori);

        // Inisialisasi elemen-elemen dari XML
        imageView = findViewById(R.id.imageView);
        bunga = findViewById(R.id.btnbunga);
        daun = findViewById(R.id.btndaun);
        buah = findViewById(R.id.btnbuah);


        // Tambahkan listener untuk setiap tombol (jika diperlukan)
        bunga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bunga = new Intent(Kategori.this, KategoriBunga.class);
                startActivity(bunga);
            }
        });

        daun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daun = new Intent(Kategori.this, KategoriDaun.class);
                startActivity(daun);
            }
        });

        buah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buah = new Intent(Kategori.this, KategoriBuah.class);
                startActivity(buah);
            }
        });
    }
}