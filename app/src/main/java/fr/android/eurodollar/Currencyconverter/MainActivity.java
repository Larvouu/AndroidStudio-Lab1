package fr.android.eurodollar.Currencyconverter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Les éléments de l'activité que l'on doit définir pour pouvoir les traiter
    EditText text;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //On les associe aux éléments de la page .xml via leur id
        text = (EditText) findViewById(R.id.editText1);
        button1 = (Button) findViewById(R.id.button1);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void myClickHandler(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //définition + association des 2 radioButton à ceux du .xml via leur id
                RadioButton euroButton = (RadioButton) findViewById(R.id.radio0);
                RadioButton dollarButton = (RadioButton) findViewById(R.id.radio1);

                //Le message d'erreur
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                float inputValue = Float.parseFloat(text.getText().toString());
                if (euroButton.isChecked()) {
                    text.setText(String
                            .valueOf(convertDollarToEuro(inputValue)));
                    euroButton.setChecked(false);
                    dollarButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(convertEuroToDollar(inputValue)));
                    dollarButton.setChecked(false);
                    euroButton.setChecked(true);
                }
                break;
        }
    }

    // Convertir Dollar à Euro
    private float convertDollarToEuro(float dollar) {
        return dollar*0.9f; // taux actuel
    }

    // Convertir Euro à Dollar
    private float convertEuroToDollar(float euro) {
        return euro*1.1111111f; // taux actuel reverse approximatif
    }
}


