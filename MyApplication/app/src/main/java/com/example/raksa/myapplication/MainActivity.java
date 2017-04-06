package com.example.raksa.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        //attach the Fragment to the container..
        CalculateFragment fragment = new CalculateFragment();
        //Check if there is existed fragment in the container..
        Fragment ifExisted = fragmentManager.findFragmentById(R.id.container);
        if (ifExisted==null){
            fragmentTransaction.add(R.id.container,fragment).commit();
        }

    }

    public void add(int value1, int value2) {
        int sum = value1+value2;
        String result = "Result: "+sum;

        textView.setText(result);
    }
}
