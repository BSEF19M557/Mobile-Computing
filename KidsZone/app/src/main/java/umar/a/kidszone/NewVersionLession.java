package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NewVersionLession extends AppCompatActivity {
    ListView listView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_version_lession);
        ArrayList<String> lessionlist=new ArrayList<>();
        listView=findViewById(R.id.listview);
        lessionlist.add("ABC");
        lessionlist.add("DEF");
        lessionlist.add("GHI");
        lessionlist.add("JKL");
        lessionlist.add("MNO");
        lessionlist.add("PQR");
        lessionlist.add("STU");
        lessionlist.add("VWX");
        lessionlist.add("XZ");

        ArrayAdapter<String> AA=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lessionlist);
        listView.setAdapter(AA);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(NewVersionLession.this,lessionlist.get(position), Toast.LENGTH_SHORT).show();
                intent=new Intent(NewVersionLession.this,NewVersionLessionDetails.class);
                intent.putExtra("chp#" ,position);
                startActivity(intent);
            }
        });
    }
}