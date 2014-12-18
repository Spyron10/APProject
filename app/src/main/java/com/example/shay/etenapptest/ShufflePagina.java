package com.example.shay.etenapptest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Klasse die verantwoordelijk is voor het tonen van het scherm met drie opties:
 * Shuffle, zoeken op ingrediënt en zoeken op categorie
 */
public class ShufflePagina extends Activity
{
    // varaibele aan tekstvak toe voegen en string aanmaken waar de naam in opgeslagen wordt
    String gerechtnaam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shuffle_pagina);

        shuffleGerechten();

    }

    public void shuffleGerechten()
    {

        SQLiteDatabase db = openOrCreateDatabase("EDB", MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM Gerechten ORDER BY RANDOM() LIMIT 1 ", null);
        if(cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(),
                    "Er zitten geen gerechten in het systeem.", Toast.LENGTH_LONG).show();
        }
        else
        {
            TextView gerechtNaam =  (TextView) findViewById(R.id.shuffle_result);
            cursor.moveToFirst();

            int gerecht_id = cursor.getColumnIndex("naam");
            gerechtnaam = cursor.getString(gerecht_id);
            gerechtNaam.setText(gerechtnaam);
        }

        db.close();
    }

    public void shuffleSearch(View v)
    {
        shuffleGerechten();
    }

    public void toonDetails(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("gerechtnaam", gerechtnaam);
        startActivity(i);
    }
}
