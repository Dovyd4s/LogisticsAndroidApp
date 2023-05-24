package com.vgtu.cargoapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vgtu.cargoapp.entities.Trip;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.vgtu.cargoapp.Constants.*;

public class DetailedTrip extends AppCompatActivity {
    private Trip trip;
    TextView distanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_trip);
        TextView idText = findViewById(R.id.TextFieldID);
        idText.setText(getIntent().getStringExtra("TripId"));
        idText.setEnabled(false);
        distanceText = findViewById(R.id.TextFieldDistance);

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                String response = Rest.sendRequest(GET_TRIP_BY_ID+getIntent().getStringExtra("TripId"),"GET");
                handler.post(()->{
                    Gson builder = new GsonBuilder().create();
                    Type tripTyoe = new TypeToken <Trip>(){}.getType();
                    trip = builder.fromJson(response, tripTyoe);
                    distanceText.setText(Float.toString(trip.getDistance()));
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void updateTrip(View view) {
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                String data = "{\"distance\":\""+distanceText.getText() + "\"}";
                String response = Rest.sendRequestWithBody(UPDATE_TRIP_BY_ID+trip.getId(), data,"PUT");
                handler.post(()->{
                    try {
                        Toast.makeText(DetailedTrip.this, "Response: " + response, Toast.LENGTH_LONG).show();
                        finish();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void deleteTrip(View view) {
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try {
                String response = Rest.sendRequest(DELETE_TRIP_BY_ID+trip.getId(),"DELETE");
                handler.post(()->{
                    try {
                        Toast.makeText(DetailedTrip.this, "Response: " + response, Toast.LENGTH_LONG).show();
                        finish();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}