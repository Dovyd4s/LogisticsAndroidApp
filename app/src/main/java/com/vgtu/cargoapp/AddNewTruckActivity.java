package com.vgtu.cargoapp;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.gson.Gson;
import com.vgtu.cargoapp.entities.Truck;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.vgtu.cargoapp.Constants.ADD_NEW_TRUCK;
import static java.lang.Float.parseFloat;

public class AddNewTruckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_truck);


    }

    public void addNewTruck(View view) {
        EditText vinField = (findViewById(R.id.VINTextField));
        EditText plateField = (findViewById(R.id.plateField));
        EditText makeField = (findViewById(R.id.makeTextField));
        EditText modelField = (findViewById(R.id.modelTextField));
        EditText weightField = (findViewById(R.id.weightTextField));
        EditText capacityField = (findViewById(R.id.maxCapacityTextField));
        EditText tankSizeField = (findViewById(R.id.tankSizeTextField));
        EditText avgFuelConsumptionField = (findViewById(R.id.avgFuelConsumptionTextField));
        EditText manufacturedDate = (findViewById(R.id.manufacturedDateField));
        EditText lastTechCheckDate = (findViewById(R.id.lastTechnicalStateCheckDateField));

        Truck truck = new Truck();

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            truck.setVIN(String.valueOf(vinField.getText()));
            truck.setPlateNumber(String.valueOf(plateField.getText()));
            truck.setMake(String.valueOf(makeField.getText()));
            truck.setModel(String.valueOf(modelField.getText()));


            if(!weightField.getText().toString().isEmpty()){
                truck.setWeightTonnes(parseFloat(String.valueOf(weightField.getText())));

            }
            if(!capacityField.getText().toString().isEmpty()){
                truck.setMaxCapacityTonnes(parseFloat(String.valueOf(capacityField.getText())));

            }
            if(!tankSizeField.getText().toString().isEmpty()){
                truck.setTankSizeLiters(parseFloat(String.valueOf(tankSizeField.getText())));

            }
            if(!avgFuelConsumptionField.getText().toString().isEmpty()){
                truck.setAverageFuelConsumption(parseFloat(String.valueOf(avgFuelConsumptionField.getText())));
            }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            truck.setManufacturedDate(LocalDate.parse((String.valueOf(manufacturedDate.getText()))));
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            truck.setLastTechnicalStateCheckDate(LocalDate.parse(String.valueOf(lastTechCheckDate.getText())));
//        }

        Gson gson = new Gson();
        String response = gson.toJson(truck);
            try {
                Rest.sendRequestWithBody(ADD_NEW_TRUCK, response, "POST");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            handler.post(()->{
                Toast.makeText(AddNewTruckActivity.this, "VIN: "+ response, Toast.LENGTH_LONG).show();
            });
        });


    }
}