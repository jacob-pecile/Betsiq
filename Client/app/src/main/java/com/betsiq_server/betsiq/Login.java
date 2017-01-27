package com.betsiq_server.betsiq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jacob on 20/01/2017.
 */

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void submitLogin(View view){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        if (username.getText().toString().equals("admin") && password.getText().toString().equals("test")){
            Intent startIntent = new Intent(this, TabActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
        }else{
            TextView error = (TextView)findViewById(R.id.errormsg);
            error.setText("Please enter acceptable username and password");
        }
    }
}
