package com.example.shay.etenapptest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The input form of the add dish screen
 */
public class AddGerecht extends Activity
{

    boolean categorieboolean;
    int favoriet = 0;
    ImageButton star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gerecht);

        star = (ImageButton)findViewById(R.id.favorieten_knop);
        star.setOnClickListener(addFavorite);

        checkCategorie();
    }


    View.OnClickListener addFavorite = new View.OnClickListener() {

        public void onClick(View v) {
            favoriet = 1;
            star.setBackgroundResource(R.drawable.favoriet_pressed);
            Toast.makeText(getApplicationContext(),
                    "Toegevoegd aan favorieten", Toast.LENGTH_LONG).show();

        }

    };



    public void checkCategorie()
    {
        categorieboolean = getIntent().getExtras().getBoolean("categorieboolean");
        final Button categorieknop = (Button) findViewById(R.id.categorie_button);

        if(categorieboolean == true)
        {
            categorieknop.setText("Categorie toevoegen");

            // OnClickListener toevoegen zodat er alleen maar een categorie
            // toegevoegd kan worden op het moment dat die nog leeg is.
            OnClickListener categorieButton = new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    categorieknop.setText("Categorie wijzigen");
                    // categorieboolean = false;
                }
            };
            categorieknop.setOnClickListener(categorieButton);
        } // einde van if loop
        else
        {
            /*
            Hier komen de categoriën die zijn meegegeven in het andere scherm.
             */
            categorieknop.setText("Categorie is toegevoegd");
        }
    }



    /* onderste knop die gerecht toe gaat voegen aan database,
    *  en vervolgens de gebruiker doorsturen naar een nieuw scherm.
    */
    public void sendGerecht (View v)
    {

        SQLiteDatabase db = openOrCreateDatabase("EDB", MODE_PRIVATE, null);


        TextView gerechtnaam = (TextView) findViewById(R.id.naamgerecht);
        TextView gerechtomschrijving = (TextView) findViewById(R.id.omschrijvinggerecht);

        String gerecht = gerechtnaam.getText().toString();
        String omschrijving = gerechtnaam.getText().toString();


        db.execSQL("INSERT INTO Gerechten (naam,favoriet,omschrijving) VALUES ('"+ gerecht +"','1','"+ omschrijving +"')");



        Toast.makeText(getApplicationContext(),
        "Gerecht aangemaakt! check je favorieten", Toast.LENGTH_LONG).show();
    }
}
