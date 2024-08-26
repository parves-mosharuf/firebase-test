package com.example.firebase_test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.firebase_test.model.users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InsertActivity3 extends AppCompatActivity {
    EditText name, number, gmail, age, gerder;
    Button submit;
    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_insert3);

        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        gmail = findViewById(R.id.gmail);
        age = findViewById(R.id.age);
        gerder = findViewById(R.id.gerder);
        submit = findViewById(R.id.submit);
        databaseReference= FirebaseDatabase.getInstance().getReference("users");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(databaseReference.push().getKey()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        /*snapshot.child("name").getRef().setValue(name.getText().toString());
                        snapshot.child("number").getRef().setValue(number.getText().toString());
                        snapshot.child("gmail").getRef().setValue(gmail.getText().toString());
                        snapshot.child("age").getRef().setValue(age.getText().toString());
                        snapshot.child("gerder").getRef().setValue(gerder.getText().toString());*/
                        snapshot.getRef().setValue(new users(name.getText().toString(),number.getText().toString(),gmail.getText().toString(),age.getText().toString(),gerder.getText().toString()));
                        Toast.makeText(InsertActivity3.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(InsertActivity3.this, "Data Added Failed", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}