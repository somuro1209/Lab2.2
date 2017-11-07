package com.example.user.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {


    EditText editTextName;
    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
    }

    public void saveProfile(View view){
        Intent intent = getIntent();

        //Obtain input data from user
        String name,email;
        name = editTextName.getText().toString();
        email = editTextEmail.getText().toString();
        intent.putExtra(MainActivity.PROFILE_NAME,name);
        intent.putExtra(MainActivity.PROFILE_EMAIL,email);

        //Return result to the Main Activity
        setResult(RESULT_OK,intent);
        finish();
    }
}
