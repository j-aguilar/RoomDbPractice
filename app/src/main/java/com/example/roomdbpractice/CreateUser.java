package com.example.roomdbpractice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class CreateUser extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText email;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener((view) -> {
           // TODO 11/29/19 Save to database;
            db.userDao().insertAll(new User(firstName.getText().toString(),
                    lastName.getText().toString(), email.getText().toString()));
            startActivity(new Intent(CreateUser.this, MainActivity.class));
        });
    }
}
