package com.betsiq_server.betsiq.APIs;

import android.content.Context;

import com.betsiq_server.betsiq.CoreClasses.Constants;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jacob on 22/02/2017.
 */

public class SongAPI {

    private static String server = "http://192.168.0.49:3000";

    public static String GetTopSongsAPI(Context context){

        HttpURLConnection connection = null;
        try {

            URL url = new URL(server +"/songs");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Language", "en-US");

            connection.connect();

            int test = connection.getResponseCode();

            if (connection.getResponseCode()== HttpURLConnection.HTTP_OK){
                StringBuffer sb = new StringBuffer();
                InputStream is = new BufferedInputStream(connection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String inputLine = "";
                while ((inputLine = br.readLine()) != null) {
                    sb.append(inputLine);
                }
                String result = sb.toString();
                return result;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    public static boolean SelectSongsAPI(Context context, String songs, String userid){

        String parameters = "songs=" + songs;

        HttpURLConnection connection = null;
        try {

            URL url = new URL(server +"/songs/" + userid);
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

            connection.connect();

            return connection.getResponseCode()== HttpURLConnection.HTTP_OK;
        }catch (Exception e){
            return false;
        }
    }
}
