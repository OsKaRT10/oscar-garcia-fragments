package com.mcas2.misaficiones.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mcas2.misaficiones.fr.aficiones.Comer;
import com.mcas2.misaficiones.fr.aficiones.Dormir;
import com.mcas2.misaficiones.fr.aficiones.Jugar;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    public String getAficion(int position) {
        switch (position) {
            case 0:
                return "Comer";
            case 1:
                return "Dormir";
            case 2:
                return "Jugar";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Comer();
            case 1:
                return new Dormir();
            case 2:
                return new Jugar();
            default:
                throw new IllegalStateException("Posición no válida: " + position);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getAficion(position);
    }

}
