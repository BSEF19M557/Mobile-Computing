package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class exam extends AppCompatActivity implements View.OnClickListener {
    Button c1;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        c1=findViewById(R.id.back);
        c1.setOnClickListener(this);

        tv =findViewById(R.id.re);
        Intent i=getIntent();
        Bundle extras=i.getExtras();
        tv.setText(extras.getInt("correct")+"/5");

    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent(exam.this,MainActivity.class);
        startActivity(intent);
    }
}