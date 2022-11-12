package com.example.signupapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText loginEmail, loginPassword;
    Button login_btn;
    int counter=2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail= (EditText) findViewById(R.id.Login_ID);
        loginPassword= (EditText) findViewById(R.id.Password_ID);
        login_btn= (Button) findViewById(R.id.login_btn);
        String registerEmail = getIntent().getStringExtra("email");
        String registerPassword = getIntent().getStringExtra("password");
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                if(registerEmail.equals(email) && registerPassword.equals(password))
                {
                    Intent intent= new Intent(loginActivity.this,loginsuccessActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
                counter--;
                if(counter==0){
                    Toast.makeText(getBaseContext(),"failed to login attempts",Toast.LENGTH_SHORT).show();
                            login_btn.setEnabled(false);
                }

            }
        });
    }
}