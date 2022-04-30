package umar.a.linear_layout_with_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkBoxDone, checkBoxPending, checkBoxRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxDone = findViewById(R.id.checkBox4);
        checkBoxDone.setOnClickListener(this);
        checkBoxPending = findViewById(R.id.checkBox5);
        checkBoxPending.setOnClickListener(this);
        checkBoxRead = findViewById(R.id.checkBox3);
        checkBoxRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId( )) {
            case R.id.checkBox4:
                if (checkBoxDone.isChecked())
                    checkBoxDone.setText("Check Box Done");
                break;
            case R.id.checkBox5:
                if (checkBoxPending.isChecked())
                    checkBoxPending.setText("Check Box Pending");
                break;
            case R.id.checkBox3:
                if (checkBoxRead.isChecked())
                    checkBoxRead.setText("Check Box Read");
                break;
        }
    }
}