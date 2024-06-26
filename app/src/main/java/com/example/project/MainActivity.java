package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
    public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

        private ArrayList<Dogs> Breeds = new ArrayList<>();
        private RecyclerViewAdapter adapter;

        private final String JSON_URL = "https://mobprog.webug.se/json-api?login=f23linan";
        private final String JSON_FILE = "dogs.json";

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new JsonFile(this, this).execute(JSON_FILE);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, Breeds, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Dogs item) {
                Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        Button b = findViewById(R.id.knapp1);

        b.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Log.d("==>","Lets go!");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Dogs>>() {
        }.getType();
        Breeds = gson.fromJson(json, type);
        // adapter.notifyDataSetChanged();
    }


    }
