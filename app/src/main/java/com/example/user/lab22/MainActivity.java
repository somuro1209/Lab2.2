package com.example.user.lab22;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final int REQUEST_PROFILE_UPDATE = 1;
    public static final String PROFILE_NAME = "com.example.user.lab22.name";
    public static final String PROFILE_EMAIL = "com.example.user.lab22.email";


    TextView textViewName;
    TextView textViewEmail;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = (TextView)findViewById(R.id.textViewName);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PROFILE_UPDATE && resultCode == RESULT_OK){
            String name, email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name) + name);
            textViewEmail.setText(getString(R.string.email) + email);

        }
    }

    public void updateProfile(View view){
        //Explicit Intent
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,REQUEST_PROFILE_UPDATE);
    }

    public void visitBAIT(View v){
        String uri = "http://www.youtube.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showDial(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri.parse("tel: "+"0123456789");
        startActivity(intent);

    }

    public void sendMail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "+"angharckleong@hotmail.com"));
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void showMain(View v){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

}
