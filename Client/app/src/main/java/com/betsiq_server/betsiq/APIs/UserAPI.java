package com.betsiq_server.betsiq.APIs;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jacob on 11/02/2017.
 */

public class UserAPI{

    private static String server = "https://localhost:3000";
    //TODO: find a way to make this Async
    public static boolean CreateUserAPI(String name, String password){

        String parameters = "name=" + name + "&password=" + password;

        HttpURLConnection connection = null;
        try {

            URL url = new URL(server);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(parameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.connect();

            return connection.getResponseCode() == 200;
//            //Send request
//            DataOutputStream wr = new DataOutputStream (
//                    connection.getOutputStream ());
//            wr.writeBytes (parameters);
//            wr.flush ();
//            wr.close ();
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            String line;
//            StringBuffer response = new StringBuffer();
//            while((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();
        }catch (Exception e){
            return false;
        }
    }

}
