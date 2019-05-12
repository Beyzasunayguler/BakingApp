package com.example.bakingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bakingapp.api.ApiClient;
import com.example.bakingapp.api.ApiInterface;
import com.example.bakingapp.models.Cakes;
import com.example.bakingapp.models.Ingredient;

import java.util.List;

import butterknife.BindView;

public class DetailActivity extends AppCompatActivity {
    private TextView cakeNameText;
    private ImageView cakeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        cakeNameText = (TextView) findViewById(R.id.cakeNameText);
        cakeImage = (ImageView) findViewById(R.id.cakeImage);

        if (getIntent().getExtras() == null) {
            Toast.makeText(this, "Something went wrong, check the logs", Toast.LENGTH_LONG).show();
        } else {
            String cakeImage = getIntent().getExtras().getString(IntentConstants.CAKE_IMAGE);
            String cakeName = getIntent().getExtras().getString(IntentConstants.CAKE_NAME);
            cakeNameText.setText(cakeName);


        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent = new Intent(getApplicationContext(), IngredientClass.class);
        startActivity(intent);

        return true;
    }
}
