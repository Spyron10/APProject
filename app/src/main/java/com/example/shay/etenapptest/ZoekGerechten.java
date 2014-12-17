package com.example.shay.etenapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    public void shuffleSearch(View v)
    {
        Intent z = new Intent(this, ShufflePagina.class);
        startActivity(z);
    }
}
