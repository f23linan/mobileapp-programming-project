package com.example.project;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @SuppressWarnings("FieldCanBeLocal")
    public class MainActivity extends AppCompatActivity implements com.example.networking.JsonTask.JsonTaskListener {

        private ArrayList<Mountain> mountainlist = new ArrayList<>();
        private RecyclerViewAdapter adapter;

        private final String JSON_URL = "https://mobprog.webug.se/json-api?login=f23linan";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new com.example.networking.JsonFile(this, this).execute(JSON_URL);
        Log.d("Hej", " "+mountainlist.size());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mountainlist, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Mountain item) {
                Toast.makeText(MainActivity.this, item.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {
        }.getType();
        mountainlist = gson.fromJson(json, type);
        // adapter.notifyDataSetChanged();
    }
}
