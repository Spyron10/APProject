package com.example.shay.etenapptest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Class die de favorieten ophaalt en toont.
 */
public class ToonFavorieten extends ListActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorieten_scherm);
        ArrayList results = new ArrayList();

        SQLiteDatabase db = openOrCreateDatabase("EDB", MODE_PRIVATE, null);

        Cursor cursor = db.rawQuery("SELECT * FROM Gerechten WHERE favoriet='1'", null);
        if(cursor.getCount() == 0)
        {
            // foutmelding plaatsen
            Toast.makeText(getApplicationContext(),
                    "Dit werkt nog even niet.", Toast.LENGTH_LONG).show();
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
