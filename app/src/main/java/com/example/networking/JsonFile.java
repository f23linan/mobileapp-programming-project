package com.example.networking;

import android.util.Log;

import com.example.project.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class JsonFile {

    private final JsonTask.JsonTaskListener listener;
    private final MainActivity activity;

    public JsonFile(MainActivity activity, JsonTask.JsonTaskListener listener) {
        this.activity = activity;
        this.listener = listener;
    }

    public void execute(String file) {
        try (InputStream stream = activity.getAssets().open(file)) {
            Scanner scanner = new Scanner(stream).useDelimiter("\\A");
            listener.onPostExecute(scanner.hasNext() ? scanner.next() : "");
        } catch (IOException exception) {
            Log.d("JsonFile", exception.getMessage());
        }
    }

}