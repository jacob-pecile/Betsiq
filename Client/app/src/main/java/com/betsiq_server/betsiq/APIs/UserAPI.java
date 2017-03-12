package com.betsiq_server.betsiq.APIs;

import android.content.Context;
import android.os.AsyncTask;

import com.betsiq_server.betsiq.CoreClasses.Constants;
import com.betsiq_server.betsiq.R;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jacob on 11/02/2017.
 */

public class UserAPI{

    //TODO: change to correct server name once actually deployed
    private static String server = "http://192.168.0.49:3000";

    public static boolean CreateUserAPI(Context context, String name, String password){

        String parameters = "name=" + name + "&password=" + password;

        HttpURLConnection connection = null;
        try {

            URL url = new URL(server +"/signup");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Language", "en-US");

            //connection.setRequestProperty("Content-Length", "" + Integer.toString(parameters.getBytes().length));
            byte[] outputBytes = parameters.getBytes("UTF-8");
            connection.setRequestProperty("Content-Length", Integer.toString(outputBytes.length));
            OutputStream os = connection.getOutputStream();

            os.write(outputBytes);
            os.close();
            connection.connect();

            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){
                StringBuffer sb = new StringBuffer();
                InputStream is = new BufferedInputStream(connection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                String result = sb.toString();
                Constants.SetSharedPrefrences(context, "user", result);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    public static boolean ConfirmUserAPI(Context context, String name, String password){

        String parameters = "name=" + name + "&password=" + password;

        HttpURLConnection connection = null;
        try {

            URL url = new URL(server +"/login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Language", "en-US");

            //connection.setRequestProperty("Content-Length", "" + Integer.toString(parameters.getBytes().length));
            byte[] outputBytes = parameters.getBytes("UTF-8");
            connection.setRequestProperty("Content-Length", Integer.toString(outputBytes.length));
            OutputStream os = connection.getOutputStream();

            os.write(outputBytes);
            os.close();
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                StringBuffer sb = new StringBuffer();
                InputStream is = new BufferedInputStream(connection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                String result = sb.toString();
                Constants.SetSharedPrefrences(context, "user", result);
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

}