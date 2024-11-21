package com.mcas2.misaficiones;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MiInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miinfo);

        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewEdad = findViewById(R.id.textViewEdad);
        TextView textViewFavorito = findViewById(R.id.textViewFavorito);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.gorila);

        textViewNombre.setText("Oscar García");
        textViewEdad.setText("23 años");

        SharedPreferences sharedPreferences = getSharedPreferences("MisAficiones", MODE_PRIVATE);
        String aficionFavorita = sharedPreferences.getString("aficion_favorita", "No definida");

        textViewFavorito.setText("Afición favorita: " + aficionFavorita);
    }
}
