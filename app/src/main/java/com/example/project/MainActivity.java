package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=d22marwi";
    private final String JSON_FILE = "Planets.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);

        Button ToSecondActivity = findViewById(R.id.my_button1);
        ToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Planet>>() {
        }.getType();
        List<Planet> ListOfPlanets = gson.fromJson(json, type);
        ArrayList<Planet> items = new ArrayList<>();


        for (Planet planet : ListOfPlanets) {
            Log.d("Planet", planet.toString());
            items.add(new Planet(planet.getName(), planet.getSize()));
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Planet item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, item.getSize(), Toast.LENGTH_LONG).show();

            }
        });

        RecyclerView recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
    }
}
