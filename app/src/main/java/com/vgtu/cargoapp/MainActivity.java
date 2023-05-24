package com.vgtu.cargoapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.vgtu.cargoapp.entities.Driver;
import com.vgtu.cargoapp.entities.Trip;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.vgtu.cargoapp.Constants.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textViewMainpage);
        textView.setText(getIntent().getStringExtra("response"));
        TextView text = findViewById(R.id.editTextTextMultiLine);
        //text.setText(string);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                String response = Rest.sendRequest(GET_ALL_TRIPS,"GET");
                handler.post(()->{
                    try {
                        text.setText(response);
                        if(!response.equals("Error")){
                            //kažkas nejasno. ~32-34minutė pratybų
                            Gson builder = new GsonBuilder().create();

                            Type driverType = new TypeToken <List<Trip>>(){
                            }.getType();
                            final List<Trip> tripsListFromJson = builder.fromJson(response, driverType);

                            ArrayAdapter<Trip> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, tripsListFromJson);

                            ListView driversListView = findViewById(R.id.tripsListView);
                            driversListView.setAdapter(arrayAdapter);

                            driversListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(MainActivity.this, "Selected trip id: " + tripsListFromJson.get(i).getId() + ", Distance: " + tripsListFromJson.get(i).getDistance(), Toast.LENGTH_LONG).show();
                                    Intent intentDriver = new Intent(MainActivity.this, DetailedTrip.class);
                                    intentDriver.putExtra("TripId", String.valueOf(tripsListFromJson.get(i).getId()));
                                    startActivity(intentDriver);
                                }
                            });
                        }
                    } catch (JsonSyntaxException e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addTruck(View view) {
        startActivity(new Intent(MainActivity.this, AddNewTruckActivity.class));
    }

    public void showAllTrucks(View view) {
        startActivity(new Intent(MainActivity.this, AllTrucks.class));

    }
}