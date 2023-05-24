package com.vgtu.cargoapp;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vgtu.cargoapp.entities.Truck;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.vgtu.cargoapp.Constants.GET_ALL_TRUCKS;

public class AllTrucks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trucks);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                String response = Rest.sendRequest(GET_ALL_TRUCKS, "GET");
                handler.post(()->{

                    Gson gson = new GsonBuilder().create();

                    Type truckType = new TypeToken<List<Truck>>(){}.getType();
                    final List<Truck> trucksFromJson = gson.fromJson(response,truckType);
                    ArrayAdapter<Truck> arrayAdapter = new ArrayAdapter<>(AllTrucks.this, android.R.layout.simple_list_item_1, trucksFromJson);

                    ListView trucksListView = findViewById(R.id.alltrucksListView);
                    trucksListView.setAdapter(arrayAdapter);

                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}