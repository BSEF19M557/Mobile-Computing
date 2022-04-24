package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    Button button =(Button)  findViewById(R.id.button);
    TextView view =  (TextView)findViewById(R.id.textView);
        final AtomicInteger i = new AtomicInteger(0);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          if(i.get() == 0) {
              view.setText("hehehehehe");
              i.set(1);
          }
          else
          {
              view.setText("umar");
              i.set(0);
          }
        }
    });

    }
}