package com.betsiq_server.betsiq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        TextView error = (TextView)findViewById(R.id.errormsg);

        if (signup){
            EditText confirm = (EditText)findViewById(R.id.confirm);
            if (password.getText().toString().equals(confirm.getText().toString())) {
                //TODO: make CREATE request
                CreateUserAPI(username.getText().toString(), password.getText().toString());
            }else{
                error.setText("Confirm password doesn't match password");
            }
        }else{
            //TODO: make POST request
        }

//        if (username.getText().toString().equals("admin") && password.getText().toString().equals("test")){
//            Intent startIntent = new Intent(this, topHundred.class);
//            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(startIntent);
//        }else{
//
//            error.setText("Please enter acceptable username and password");
//        }
    }
}
