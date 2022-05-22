package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lesson extends AppCompatActivity implements View.OnClickListener {
    Button ch1,ch2,ch3,ch4,ch5,ch6,ch7,ch8,ch9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ch1=findViewById(R.id.ch1);
        ch1.setOnClickListener(this);
        ch2=findViewById(R.id.ch2);
        ch2.setOnClickListener(this);
        ch3=findViewById(R.id.ch3);
        ch3.setOnClickListener(this);
        ch4=findViewById(R.id.ch4);
        ch4.setOnClickListener(this);
        ch5=findViewById(R.id.ch5);
        ch5.setOnClickListener(this);
        ch6=findViewById(R.id.ch6);
        ch6.setOnClickListener(this);
        ch7=findViewById(R.id.ch7);
        ch7.setOnClickListener(this);
        ch8=findViewById(R.id.ch8);
        ch8.setOnClickListener(this);
        ch9=findViewById(R.id.ch9);
        ch9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId( )) {
            case R.id.ch1:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch1.class);
                startActivity(intent);
                break;
            case R.id.ch2:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch2.class);
                startActivity(intent);
                break;
            case R.id.ch3:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch3.class);
                startActivity(intent);
                break;
            case R.id.ch4:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch4.class);
                startActivity(intent);
                break;
            case R.id.ch5:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch5.class);
                startActivity(intent);
                break;
            case R.id.ch6:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch6.class);
                startActivity(intent);
                break;
            case R.id.ch7:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch7.class);
                startActivity(intent);
                break;
            case R.id.ch8:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch8.class);
                startActivity(intent);
                break;
            case R.id.ch9:
                intent =new Intent(Lesson.this, umar.a.kidszone.ch9.class);
                startActivity(intent);
                break;
        }


    }
}