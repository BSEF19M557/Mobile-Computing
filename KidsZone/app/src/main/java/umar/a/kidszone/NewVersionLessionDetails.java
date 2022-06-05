package umar.a.kidszone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewVersionLessionDetails extends AppCompatActivity {
    ListView listView;
    Intent intent;
    Bundle extras;
    int[] chp0,chp1,chp2,chp3,chp4,chp5,chp6,chp7,chp8;
    int [] chp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_version_lession_details);

        chp0= new int[]{R.drawable.ant, R.drawable.apple, R.drawable.bed, R.drawable.book, R.drawable.cake, R.drawable.cat};
        chp1= new int[]{R.drawable.duck, R.drawable.dog, R.drawable.elephent, R.drawable.egg, R.drawable.flower, R.drawable.frog};
        chp2= new int[]{R.drawable.grass, R.drawable.got, R.drawable.house, R.drawable.hand, R.drawable.ill, R.drawable.insect};
        chp3= new int[]{R.drawable.jam, R.drawable.juice, R.drawable.king, R.drawable.key, R.drawable.lunch, R.drawable.leave};
        chp4= new int[]{R.drawable.monkey, R.drawable.mouse, R.drawable.nose, R.drawable.nest, R.drawable.orange, R.drawable.otter};
        chp5= new int[]{R.drawable.pencil, R.drawable.piano, R.drawable.queen, R.drawable.qoial, R.drawable.rabbte, R.drawable.rat};
        chp6= new int[]{R.drawable.sun, R.drawable.snail, R.drawable.train, R.drawable.tree, R.drawable.umbralla, R.drawable.up};
        chp7= new int[]{R.drawable.vet, R.drawable.vilon, R.drawable.world, R.drawable.whale, R.drawable.box, R.drawable.fox};
        chp8= new int[]{R.drawable.yacht, R.drawable.yawn, R.drawable.zebra, R.drawable.zip};

        intent=getIntent();
        extras=intent.getExtras();

        int chpvalue=extras.getInt("chp#");
        if(chpvalue==0)
            chp=chp0;
        if(chpvalue==1)
            chp=chp1;
        if(chpvalue==2)
            chp=chp2;
        if(chpvalue==3)
            chp=chp3;
        if(chpvalue==4)
            chp=chp4;
        if(chpvalue==5)
            chp=chp5;
        if(chpvalue==6)
            chp=chp6;
        if(chpvalue==7)
            chp=chp7;
        if(chpvalue==8)
            chp=chp8;

        listView=findViewById(R.id.list);

        ListViewAdapter lva=new ListViewAdapter(this,chp);
        listView.setAdapter(lva);
    }
}