package com.example.ahmspro;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class fetchdata extends AsyncTask<Void, Void, Void> {

    String data = "";
    String data2 = "";
    String data3 = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://mock-ahms.herokuapp.com/v1/resources/ahms/all");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.get(i);
                data3 = "Date" + JO.get("date") + "\n" +
                        "Faculty Name" + JO.get("faculty_name") + "\n" +
                        "Date" + JO.get("first_name") + "\n" +
                        "Date" + JO.get("has_stayback") + "\n" +
                        "Date" + JO.get("last_name") + "\n" +
                        "Date" + JO.get("reason") + "\n" +
                        "Date" + JO.get("student_id") + "\n" +
                        "Date" + JO.get("time") + "\n";
                data2 = data2 + data3;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


        MainActivity.data.setText(this.data2);

    }

}
