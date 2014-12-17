package com.example.shay.etenapptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * The input form of the add dish screen
 */
public class AddGerecht extends Activity
{

    boolean categorieboolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_gerecht);

        checkCategorie();
    }

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
                    categorieboolean = false;
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

    public void addFavorite (View v)
    {
        Toast.makeText(getApplicationContext(),
        "Toegevoegd aan Favorieten! (niet echt)", Toast.LENGTH_LONG).show();
    }

    /* onderste knop die gerecht toe gaat voegen aan database,
    *  en vervolgens de gebruiker doorsturen naar een nieuw scherm.
    */
    public void sendGerecht (View v)
    {
        Toast.makeText(getApplicationContext(),
        "Gerecht aangemaakt! (maar niet echt)", Toast.LENGTH_LONG).show();
    }
}
