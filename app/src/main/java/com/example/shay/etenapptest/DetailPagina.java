package com.example.shay.etenapptest;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

/**
 * Toont de details van het gerecht.
 */
public class DetailPagina extends ListActivity
{

    String gerechtnaam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pagina);
        ArrayList results = new ArrayList();

        SQLiteDatabase db = openOrCreateDatabase("EDB", MODE_PRIVATE, null);

       gerechtnaam = getIntent().getExtras().getString("gerechtnaam");

        Cursor cursor = db.rawQuery("SELECT * FROM Gerechten WHERE naam= '+ gerechtnaam +'", null);
        if(cursor.getCount() == 0)
        {
            // foutmelding plaatsen
            Toast.makeText(getApplicationContext(),
                    "Er is iets fout gegaan.", Toast.LENGTH_LONG).show();
        }
        else
        {
            cursor.moveToFirst();
            int gerecht_id = cursor.getColumnIndex("naam");

            if(cursor.isFirst())
            {
                int i = 0;
                do {
                    i++;
                    String gerechtnaam = cursor.getString(gerecht_id);
                    results.add("" + i + ": " + gerechtnaam + "");
                }
                while (cursor.moveToNext());
            }

        }

        db.close();

        this.setListAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, results));
    }
}
