package com.vgtu.cargoapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import static com.vgtu.cargoapp.Constants.VALIDATE_DRIVER;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void verifyUser(View view) throws InterruptedException, IOException {
        EditText login = findViewById(R.id.loginTextField);
        EditText password = findViewById(R.id.passwordTextField);
        Button loginButton = findViewById(R.id.buttonLogin);
        String data = "{\"login\":\"" + login.getText() + "\", \"password\":\"" + password.getText() + "\"}";

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(()->{
            try{
                String response = Rest.sendRequestWithBody(VALIDATE_DRIVER, data, "POST");
                System.out.println(response);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("response", response);
                startActivity(intent);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}