package com.example.ahmspro;

import android.os.AsyncTask;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class fetchdata extends AsyncTask<Void, Void, Void> {

    String data = "";
   static  String data2 = "";
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
            Scan objscan = new Scan();
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length(); i++) {

                JSONObject JO = (JSONObject) JA.get(i);
                if(objscan.rollno == JO.get("student_id")){
                data3 = "Date:-" + JO.get("date") + "\n" +
                        "Faculty Name:-" + JO.get("faculty_name") + "\n" +
                        "First name:-" + JO.get("first_name") + "\n" +
                        "Stayback:-" + JO.get("has_stayback") + "\n" +
                        "Last name:-" + JO.get("last_name") + "\n" +
                        "Reason:-" + JO.get("reason") + "\n" +
                        "id:-" + JO.get("student_id") + "\n" +
                        "time:-" + JO.get("time") + "\n";
                // data2 = data2 + data3;

            }}

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        senddata();
        //MainActivity.data.setText(this.data3);


    }

    public static String senddata() {
        return data2;
    }
}