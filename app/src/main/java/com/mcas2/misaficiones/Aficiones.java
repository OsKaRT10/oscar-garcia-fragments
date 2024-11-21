package com.mcas2.misaficiones;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.mcas2.misaficiones.databinding.ActivityAficionesBinding;
import com.mcas2.misaficiones.ui.frmanager.Paginador;

public class Aficiones extends AppCompatActivity {

    private ActivityAficionesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAficionesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Paginador paginador = new Paginador(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(paginador);

        TabLayout tabLayout = binding.tabLayout;
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.favButton) {
            int currentItem = binding.viewPager.getCurrentItem();
            String aficionFavorita = ((Paginador) binding.viewPager.getAdapter()).getAficion(currentItem);

            getSharedPreferences("MisAficiones", MODE_PRIVATE)
                    .edit()
                    .putString("aficion_favorita", aficionFavorita)
                    .apply();
            Toast.makeText(this, "Afición favorita guardada: " + aficionFavorita, Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.aboutMeButton) {
            SharedPreferences sharedPreferences = getSharedPreferences("MisAficiones", MODE_PRIVATE);
            String aficionFavorita = sharedPreferences.getString("aficion_favorita", "No definida");

            Bundle bundle = new Bundle();
            bundle.putString("aficion_favorita", aficionFavorita);

            Intent intent = new Intent(this, MiInfoActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);
            return true;
        }

        if (id == R.id.myCodeButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/OsKaRT10/"));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}