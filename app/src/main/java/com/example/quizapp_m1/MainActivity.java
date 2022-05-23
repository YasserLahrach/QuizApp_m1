package com.example.quizapp_m1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogOut, btnQuiz, btnLocation;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();

        btnQuiz = findViewById(R.id.btnQuiz);
        btnLocation = findViewById(R.id.btnLocation);
        btnLogOut = findViewById(R.id.btnLogout);
        btnQuiz.setOnClickListener(view ->{
            Intent intent=new Intent(MainActivity.this,Quiz1.class);
            startActivity(intent);
        });
        btnLocation.setOnClickListener(view ->{
            Intent intent=new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);        });
        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}