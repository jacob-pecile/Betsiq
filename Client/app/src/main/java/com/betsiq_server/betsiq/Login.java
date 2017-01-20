package com.betsiq_server.betsiq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jacob on 20/01/2017.
 */

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        Button login = (Button)findViewById(R.id.login_submit);
//        login.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//            }
//        });
    }

    public void submitLogin(View view){
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        if (username.getText().toString().equals("admin") && password.getText().toString().equals("test")){
            Intent startIntent = new Intent(this, TabActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);
        }
    }
}
