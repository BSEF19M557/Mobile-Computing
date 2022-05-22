package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class question1 extends AppCompatActivity implements View.OnClickListener {
    ImageView imgQuestion;
    Button c1,c2,c3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quesion1);
        imgQuestion=findViewById(R.id.imageView2);
        imgQuestion.setImageResource(R.drawable.q1);
        c1=findViewById(R.id.ans_a);
        c1.setOnClickListener(this);
        c1.setText(R.string.q1a);
        c2=findViewById(R.id.ans_b);
        c2.setOnClickListener(this);
        c2.setText(R.string.q1b);
        c3=findViewById(R.id.ans_c);
        c3.setOnClickListener(this);
        c3.setText(R.string.q1c);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==c1.getId()){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(question1.this,question2.class);
            intent.putExtra("correct",1);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(question1.this,question2.class);
            intent.putExtra("correct",0);
            startActivity(intent);
        }
    }
}