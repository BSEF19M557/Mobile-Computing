package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ExpandedMenuView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class NewVersionExam extends AppCompatActivity {
    ListView listView;
    Questions[] questions;
    Questions Q1,Q2,Q3,Q4,Q5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_version_exam);
        Q1=new Questions(R.drawable.q1,"Ant","Aunt","Apple","Ant");
        Q2=new Questions(R.drawable.q2,"Horse","Cat","Dog","Dog");
        Q3=new Questions(R.drawable.q3,"Horse","Cat","Dog","Cat");
        Q4=new Questions(R.drawable.q4,"Dog","Horse","Elephant","Elephant");
        Q5=new Questions(R.drawable.q5,"Rabbit","Duck","Hen","Rabbit");

        questions =new Questions[]{Q1,Q2,Q3,Q4,Q5};

        listView=findViewById(R.id.listviewexam);

        ExamlistviewAdapter elv= new ExamlistviewAdapter(this,questions);
        listView.setAdapter(elv);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewVersionExam.this,questions[position].opt1, Toast.LENGTH_SHORT).show();
            }
        });
    }
}