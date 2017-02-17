package com.betsiq_server.betsiq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.betsiq_server.betsiq.APIs.UserAPI.ConfirmUserAPI;
import static com.betsiq_server.betsiq.APIs.UserAPI.CreateUserAPI;

/**
 * Created by Jacob on 20/01/2017.
 */

public class Login extends Activity {

    private boolean signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        signup = getIntent().getBooleanExtra("signup", false);

        Button submit = (Button)findViewById(R.id.login_submit);

        submit.setText(signup ? "Sign Up": "Login");
        if (signup){
            EditText confirm = (EditText)findViewById(R.id.confirm);
            confirm.setVisibility(View.VISIBLE);
        }
    }

    public void submitLogin(View view){
        final String username = ((EditText)findViewById(R.id.username)).getText().toString();
        final String password = ((EditText)findViewById(R.id.password)).getText().toString();
        final boolean[] result = {false};

        TextView error = (TextView)findViewById(R.id.errormsg);

        if (signup){
            String confirm = ((EditText)findViewById(R.id.confirm)).getText().toString();
            if (password.equals(confirm)) {
                //TODO: make CREATE request
                Runnable createUser = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            result[0] = CreateUserAPI(getApplicationContext(), username, password);
                        } catch (Exception ex) {
                            //handle error which cannot be thrown back
                        }
                    }
                };
                Thread create = new Thread(createUser, "ServiceThread");
                create.start();
                try {
                    create.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }else{
                error.setText("Confirm password doesn't match password");
            }
        }else{
            //TODO: make POST request
            Runnable createUser = new Runnable() {
                @Override
                public void run() {
                    try {
                        result[0] = ConfirmUserAPI(getApplicationContext(), username, password);
                    } catch (Exception ex) {
                        //handle error which cannot be thrown back
                    }
                }
            };
            Thread create = new Thread(createUser, "ServiceThread");
            create.start();
            try {
                create.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (result[0]){
            Intent startIntent = new Intent(this, topHundred.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
        }else{

            error.setText(signup ? "That username is already taken": "Please enter an acceptable username and password");
        }
    }
}
