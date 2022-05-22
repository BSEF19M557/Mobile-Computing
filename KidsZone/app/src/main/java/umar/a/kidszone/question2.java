package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class question2 extends AppCompatActivity implements View.OnClickListener{
    ImageView imgQuestion;
    Button c1,c2,c3;
    Intent i;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        imgQuestion=findViewById(R.id.imageView2);
        imgQuestion.setImageResource(R.drawable.q2);
        c1=findViewById(R.id.ans_a);
        c1.setOnClickListener(this);
        c1.setText(R.string.q2a);
        c2=findViewById(R.id.ans_b);
        c2.setOnClickListener(this);
        c2.setText(R.string.q2b);
        c3=findViewById(R.id.ans_c);
        c3.setOnClickListener(this);
        c3.setText(R.string.q2c);
        i=getIntent();
        extras=i.getExtras();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==c3.getId()){
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(question2.this,question3.class);
            intent.putExtra("correct",extras.getInt("correct")+1);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(question2.this,question3.class);
            intent.putExtra("correct",extras.getInt("correct")+0);
            startActivity(intent);
        }
    }
}