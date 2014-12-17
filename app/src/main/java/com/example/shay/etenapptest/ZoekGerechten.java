package com.example.shay.etenapptest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Klasse die verantwoordelijk is voor het tonen van het scherm met drie opties:
 * Shuffle, zoeken op ingrediënt en zoeken op categorie
 */
public class ZoekGerechten extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoek_gerechten);
    }
}
