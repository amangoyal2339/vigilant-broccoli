package com.example.ahmspro;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Scan extends Fragment  {
    Button scan;
    static TextView data;
   static EditText rollno;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scan2,container,false);
        scan  = (Button) view.findViewById(R.id.Bt);
        rollno = (EditText)view.findViewById(R.id.Et);
        data = (TextView) view.findViewById(R.id.data);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchdata process = new fetchdata();
                process.execute();
            }


        });
        return view;
    }

    public static String text(){
        String s = rollno.getText().toString();
        return s;
    }

}