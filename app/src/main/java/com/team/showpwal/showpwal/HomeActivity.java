package com.team.showpwal.showpwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button loginBtn = (Button) findViewById(R.id.logInBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText username = (EditText) findViewById(R.id.username_edit_text);
                String stringUserName = username.getText().toString();

                EditText password = (EditText) findViewById(R.id.password_edit_text);
                String stringPassword = password.getText().toString();

                if(stringUserName.equals("mgmg") && stringPassword.equals("mgmg123")){
                    startActivity(new Intent(HomeActivity.this,MainActivity.class));
                }else{
                    Toast.makeText(HomeActivity.this,"Invalid !", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button signUpBtn = (Button) findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });

    }
}
