package com.example.shay.etenapptest;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        SQLiteDatabase db = openOrCreateDatabase("EDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Gerechten ('ge_id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'naam' TEXT NOT NULL , 'favoriet' INTEGER DEFAULT 0, 'omschrijving' TEXT );");
        db.execSQL("CREATE TABLE IF NOT EXISTS Categorieen ('ca_id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'naam' TEXT NOT NULL );");
        db.execSQL("CREATE TABLE IF NOT EXISTS Geca ('ge_id' INTEGER NOT NULL , 'ca_id' INTEGER NOT NULL );");
        db.execSQL("CREATE TABLE IF NOT EXISTS Ingredienten ('in_id' INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , 'naam' TEXT NOT NULL );");
        db.execSQL("CREATE TABLE IF NOT EXISTS Gein ('ge_id' INTEGER NOT NULL , 'in_id' INTEGER NOT NULL );");
       // db.execSQL("INSERT INTO Categorieen (naam) VALUES ('Goedkoop')");

        Cursor cursor = db.rawQuery("SELECT * FROM Categorieen", null);
        if(cursor.getCount() == 0)
        {
            db.execSQL("INSERT INTO Categorieen (naam) VALUES ('Goedkoop')");
            db.execSQL("INSERT INTO Categorieen (naam) VALUES ('Snel')");
            db.execSQL("INSERT INTO Categorieen (naam) VALUES ('Gemakkelijk')");
            db.execSQL("INSERT INTO Categorieen (naam) VALUES ('Uitgebreid')");
        }

        Cursor gerechten = db.rawQuery("SELECT * FROM Gerechten", null);
        if(gerechten.getCount() == 0)
        {
            db.execSQL("INSERT INTO Gerechten (naam,favoriet,omschrijving) VALUES ('Testgerecht','1','Dit is een testgerecht om functionaliteit te testen.')");
            db.execSQL("INSERT INTO Gerechten (naam,favoriet,omschrijving) VALUES ('Gerecht2','1','Dit is ook een testgerecht om functionaliteit te testen.')");
        }

        db.close();
    }


    /**
     *  EIGEN TOEGEVOEGDE CODE VANAF HIER
     */
    public void zoekGerecht (View v)
    {
        Toast.makeText(getApplicationContext(),
        "Dit werkt nog even niet.", Toast.LENGTH_LONG).show();
    }

    public void toonFavorieten(View v)
    {
        Intent f = new Intent(this, ToonFavorieten.class);
        startActivity(f);
    }

    public void addGerecht (View v)
    {
        boolean categorieleeg = true;
        Intent i = new Intent(this, AddGerecht.class);
        i.putExtra("categorieboolean", categorieleeg);
        startActivity(i);
    }

}
