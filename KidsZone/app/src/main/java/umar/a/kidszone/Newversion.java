package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Newversion extends AppCompatActivity {
    Button b1,b2,b3;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newversion);
        b1=findViewById(R.id.newversionlessions);
        b2=findViewById(R.id.newversionExam);
        b3=findViewById(R.id.newversionRepo);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Newversion.this,NewVersionLession.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(Newversion.this,NewVersionExam.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri repo= Uri.parse("https://github.com/BSEF19M557/Mobile-Computing");
                intent=new Intent(Intent.ACTION_VIEW,repo);
                startActivity(intent);
            }
        });

    }
}