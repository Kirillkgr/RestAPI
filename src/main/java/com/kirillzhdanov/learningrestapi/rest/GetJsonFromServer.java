package com.kirillzhdanov.learningrestapi.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJsonFromServer   {

    public GetJsonFromServer(String s) {
        doInBackground(s);
    }

    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder buffera = new StringBuilder();
            String lineq = "";

           String param = "http://localhost:36/J/GetArchiveMy_Restoran";
            URL urla = new URL(param);
            connection = (HttpURLConnection) urla.openConnection();
            connection.connect();
            InputStream streama = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(streama));
            StringBuilder buffer = new StringBuilder();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
                //  Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
            }
            getData(buffer.toString());
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    protected String getData(String  params) {
        params = "http://localhost:36/J/GetArchiveMy_Restoran";
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder buffer = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line).append("\n");
                //  Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
            }
            String str =buffer.toString();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}